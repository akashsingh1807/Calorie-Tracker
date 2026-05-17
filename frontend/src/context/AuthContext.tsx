'use client';
import { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import Cookies from 'js-cookie';
import { userAPI } from '@/lib/api';

interface User {
  id: number;
  name: string;
  email: string;
  dailyCalorieGoal: number;
  currentWeight?: number;
  height?: number;
  goal?: string;
  createdAt?: string;
}

interface AuthContextType {
  user: User | null;
  token: string | null;
  loading: boolean;
  login: (token: string) => Promise<void>;
  logout: () => void;
  refreshUser: () => Promise<void>;
}

const AuthContext = createContext<AuthContextType>({
  user: null, token: null, loading: true,
  login: async () => {}, logout: () => {}, refreshUser: async () => {},
});

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<User | null>(null);
  const [token, setToken] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);

  const fetchUser = async () => {
    try {
      const res = await userAPI.getMe();
      setUser(res.data);
    } catch {
      setUser(null);
      setToken(null);
      Cookies.remove('nutriai_token');
    }
  };

  useEffect(() => {
    const savedToken = Cookies.get('nutriai_token');
    if (savedToken) {
      setToken(savedToken);
      fetchUser().finally(() => setLoading(false));
    } else {
      setLoading(false);
    }
  }, []);

  const login = async (newToken: string) => {
    Cookies.set('nutriai_token', newToken, { expires: 1, secure: true, sameSite: 'strict' });
    setToken(newToken);
    await fetchUser();
  };

  const logout = () => {
    Cookies.remove('nutriai_token');
    setToken(null);
    setUser(null);
    window.location.href = '/auth/login';
  };

  const refreshUser = async () => {
    await fetchUser();
  };

  return (
    <AuthContext.Provider value={{ user, token, loading, login, logout, refreshUser }}>
      {children}
    </AuthContext.Provider>
  );
}

export const useAuth = () => useContext(AuthContext);
