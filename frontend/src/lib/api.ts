import axios from 'axios';
import Cookies from 'js-cookie';

const API_BASE = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080';

const api = axios.create({
  baseURL: API_BASE,
  headers: { 'Content-Type': 'application/json' },
});

// Attach JWT to every request
api.interceptors.request.use((config) => {
  const token = Cookies.get('nutriai_token');
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

// Redirect to login on 401
api.interceptors.response.use(
  (res) => res,
  (error) => {
    if (error.response?.status === 401 && typeof window !== 'undefined') {
      Cookies.remove('nutriai_token');
      window.location.href = '/auth/login';
    }
    return Promise.reject(error);
  }
);

/* ─── Auth ─── */
export const authAPI = {
  login: (email: string, password: string) =>
    api.post('/api/v1/auth/login', { email, password }),
  register: (data: {
    name: string; email: string; password: string;
    height?: number; weight?: number; goal?: string;
  }) => api.post('/api/v1/auth/register', data),
  logout: () => api.post('/api/v1/auth/logout'),
};

/* ─── User ─── */
export const userAPI = {
  getMe: () => api.get('/api/v1/users/me'),
  updateMe: (data: Partial<{
    name: string; dailyCalorieGoal: number; currentWeight: number;
    height: number; goal: string;
  }>) => api.patch('/api/v1/users/me', data),
  getStats: () => api.get('/api/v1/users/me/stats'),
};

/* ─── Meals ─── */
export const mealAPI = {
  logMeal: (data: {
    mealType: string;
    imageUrl?: string;
    foodItems: Array<{
      name: string; calories: number; protein: number;
      carbs: number; fat: number; servingSize?: string;
    }>;
  }) => api.post('/api/v1/meals', data),
  getMeals: (date?: string) =>
    api.get('/api/v1/meals', { params: date ? { date } : {} }),
  getMeal: (id: number) => api.get(`/api/v1/meals/${id}`),
  deleteMeal: (id: number) => api.delete(`/api/v1/meals/${id}`),
};

/* ─── AI ─── */
export const aiAPI = {
  analyzeImage: (imageUrl: string) =>
    api.post('/api/v1/ai/detect-food', { imageUrl }),
  analyzeText: (text: string) =>
    api.post('/api/v1/ai/analyze-text', { text }),
  getSuggestions: () =>
    api.get('/api/v1/ai/suggestions'),
};

/* ─── Media ─── */
export const mediaAPI = {
  upload: (file: File) => {
    const form = new FormData();
    form.append('file', file);
    return api.post('/api/v1/media/upload', form, {
      headers: { 'Content-Type': 'multipart/form-data' },
    });
  },
};

/* ─── Analytics ─── */
export const analyticsAPI = {
  getDaily: (date?: string) =>
    api.get('/api/v1/analytics/daily', { params: date ? { date } : {} }),
  getWeekly: () => api.get('/api/v1/analytics/weekly'),
  getProgress: () => api.get('/api/v1/analytics/progress'),
};

/* ─── Water ─── */
export const waterAPI = {
  log: (amountMl: number) =>
    api.post('/api/v1/water/log', { amountMl }),
  getToday: () => api.get('/api/v1/water/today'),
};

/* ─── Weight ─── */
export const weightAPI = {
  log: (weight: number) =>
    api.post('/api/v1/weight', { weight }),
  getHistory: () => api.get('/api/v1/weight/history'),
};

/* ─── Nutrition lookup (USDA/Calorie Ninjas public estimate) ─── */
export async function estimateNutrition(foodName: string) {
  // Ask our backend AI for text analysis as nutrition lookup
  const res = await aiAPI.analyzeText(foodName);
  return res.data;
}

export default api;
