'use client';
import { useEffect, useState, useCallback } from 'react';
import { useRouter } from 'next/navigation';
import Link from 'next/link';
import { useAuth } from '@/context/AuthContext';
import { analyticsAPI, mealAPI, waterAPI } from '@/lib/api';
import { PieChart, Pie, Cell, ResponsiveContainer, Tooltip } from 'recharts';
import {
  UtensilsCrossed, Droplets, Flame, Zap, TrendingUp,
  Plus, ChevronRight, ChevronLeft, Target, Coffee, Sun, Moon, Cookie, Calendar
} from 'lucide-react';

interface DailyAnalytics {
  totalCalories: number;
  goalCalories: number;
  protein: number;
  carbs: number;
  fats: number;
}

interface Meal {
  id: number;
  mealType: string;
  totalCalories: number;
  totalProtein: number;
  totalCarbs: number;
  totalFat: number;
  timestamp: string;
  foodItems: Array<{ name: string; calories: number }>;
}

const mealIcons: Record<string, React.ElementType> = {
  BREAKFAST: Coffee, LUNCH: Sun, DINNER: Moon, SNACK: Cookie,
};
const mealColors: Record<string, string> = {
  BREAKFAST: 'var(--accent-yellow)', LUNCH: 'var(--accent-green)',
  DINNER: 'var(--accent-blue)', SNACK: 'var(--accent-purple)',
};

const getLocalDateString = (date: Date) => {
  const yyyy = date.getFullYear();
  const mm = String(date.getMonth() + 1).padStart(2, '0');
  const dd = String(date.getDate()).padStart(2, '0');
  return `${yyyy}-${mm}-${dd}`;
};

export default function DashboardPage() {
  const { user, loading } = useAuth();
  const router = useRouter();
  const [selectedDate, setSelectedDate] = useState<Date>(new Date());
  const [analytics, setAnalytics] = useState<DailyAnalytics | null>(null);
  const [meals, setMeals] = useState<Meal[]>([]);
  const [waterMl, setWaterMl] = useState(0);
  const [dataLoading, setDataLoading] = useState(true);

  const loadData = useCallback(async (date: Date) => {
    setDataLoading(true);
    const dateStr = getLocalDateString(date);
    try {
      const [analyticsRes, mealsRes, waterRes] = await Promise.allSettled([
        analyticsAPI.getDaily(dateStr),
        mealAPI.getMeals(dateStr),
        waterAPI.getToday(),
      ]);
      if (analyticsRes.status === 'fulfilled') setAnalytics(analyticsRes.value.data);
      if (mealsRes.status === 'fulfilled') setMeals(mealsRes.value.data || []);
      if (waterRes.status === 'fulfilled') setWaterMl(waterRes.value.data?.totalMl || 0);
    } finally {
      setDataLoading(false);
    }
  }, []);

  useEffect(() => {
    if (!loading && !user) router.replace('/auth/login');
    if (!loading && user) loadData(selectedDate);
  }, [loading, user, router, loadData, selectedDate]);

  if (loading || !user) {
    return (
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: 'calc(100vh - 64px)' }}>
        <div className="spinner spinner-lg" />
      </div>
    );
  }

  const calories = analytics?.totalCalories ?? 0;
  const goal = analytics?.goalCalories ?? user.dailyCalorieGoal ?? 2000;
  const pct = Math.min((calories / goal) * 100, 100);
  const remaining = Math.max(goal - calories, 0);

  const macroData = [
    { name: 'Protein', value: analytics?.protein ?? 0, color: '#4d9fff' },
    { name: 'Carbs', value: analytics?.carbs ?? 0, color: '#00d68f' },
    { name: 'Fat', value: analytics?.fats ?? 0, color: '#fb923c' },
  ];

  const waterGoal = 2500;
  const waterPct = Math.min((waterMl / waterGoal) * 100, 100);

  const greet = () => {
    const h = new Date().getHours();
    if (h < 12) return 'Good morning';
    if (h < 17) return 'Good afternoon';
    return 'Good evening';
  };

  const formatDateLabel = (date: Date) => {
    const today = new Date();
    const yesterday = new Date();
    yesterday.setDate(today.getDate() - 1);
    const tomorrow = new Date();
    tomorrow.setDate(today.getDate() + 1);

    const dateStr = getLocalDateString(date);
    const todayStr = getLocalDateString(today);
    const yesterdayStr = getLocalDateString(yesterday);
    const tomorrowStr = getLocalDateString(tomorrow);

    if (dateStr === todayStr) return 'Today';
    if (dateStr === yesterdayStr) return 'Yesterday';
    if (dateStr === tomorrowStr) return 'Tomorrow';

    return date.toLocaleDateString('en-IN', { weekday: 'short', month: 'short', day: 'numeric', year: 'numeric' });
  };

  const prevDay = () => {
    const d = new Date(selectedDate);
    d.setDate(d.getDate() - 1);
    setSelectedDate(d);
  };

  const nextDay = () => {
    const d = new Date(selectedDate);
    d.setDate(d.getDate() + 1);
    setSelectedDate(d);
  };

  const progressColor = pct >= 100 ? 'over' : pct >= 85 ? 'warning' : '';

  return (
    <div className="page-wrapper">
      <div className="dashboard-main">
        {/* Header */}
        <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '2rem', flexWrap: 'wrap', gap: '1rem' }}>
          <div>
            <h1 style={{ fontSize: '1.6rem', marginBottom: '0.25rem' }}>
              {greet()}, {user.name.split(' ')[0]} 👋
            </h1>
            <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', marginTop: '0.5rem', background: 'rgba(255,255,255,0.03)', border: '1px solid var(--border-subtle)', borderRadius: 'var(--radius-md)', padding: '0.35rem 0.75rem', width: 'fit-content' }}>
              <button onClick={prevDay} className="btn-icon" style={{ background: 'none', border: 'none', cursor: 'pointer', display: 'flex', alignItems: 'center', color: 'var(--text-secondary)', padding: '2px' }} title="Previous Day">
                <ChevronLeft size={18} />
              </button>
              <div style={{ position: 'relative', display: 'flex', alignItems: 'center', gap: '0.35rem', cursor: 'pointer' }} title="Select date from calendar">
                <Calendar size={15} style={{ color: 'var(--accent-green)' }} />
                <span style={{ fontSize: '0.9rem', fontWeight: 600, minWidth: '110px', textAlign: 'center', color: 'var(--text-primary)' }}>
                  {formatDateLabel(selectedDate)}
                </span>
                <input
                  type="date"
                  value={getLocalDateString(selectedDate)}
                  onChange={(e) => {
                    if (e.target.value) {
                      const [yyyy, mm, dd] = e.target.value.split('-').map(Number);
                      setSelectedDate(new Date(yyyy, mm - 1, dd));
                    }
                  }}
                  style={{
                    position: 'absolute',
                    top: 0,
                    left: 0,
                    width: '100%',
                    height: '100%',
                    opacity: 0,
                    cursor: 'pointer'
                  }}
                />
              </div>
              <button onClick={nextDay} className="btn-icon" style={{ background: 'none', border: 'none', cursor: 'pointer', display: 'flex', alignItems: 'center', color: 'var(--text-secondary)', padding: '2px' }} title="Next Day">
                <ChevronRight size={18} />
              </button>
              {getLocalDateString(selectedDate) !== getLocalDateString(new Date()) && (
                <button onClick={() => setSelectedDate(new Date())} style={{ background: 'rgba(77,159,255,0.15)', border: '1px solid var(--accent-blue)', color: 'var(--accent-blue)', fontSize: '0.7rem', padding: '0.15rem 0.5rem', borderRadius: '12px', cursor: 'pointer', marginLeft: '0.25rem', fontWeight: 600 }}>
                  Today
                </button>
              )}
            </div>
          </div>
          <Link href={`/log-meal?date=${getLocalDateString(selectedDate)}`} className="btn btn-primary">
            <Plus size={16} /> Log Meal
          </Link>
        </div>

        {dataLoading ? (
          <div style={{ display: 'grid', gap: '1.25rem' }}>
            {[1,2,3,4].map(i => (
              <div key={i} className="skeleton" style={{ height: 120, borderRadius: 'var(--radius-lg)' }} />
            ))}
          </div>
        ) : (
          <>
            {/* Top Stats Row */}
            <div className="dashboard-grid grid-cols-4" style={{ marginBottom: '1.25rem' }}>
              {[
                { label: 'Calories Eaten', val: Math.round(calories), unit: 'kcal', icon: Flame, color: 'var(--accent-orange)', bg: 'rgba(251,146,60,0.1)' },
                { label: 'Remaining', val: Math.round(remaining), unit: 'kcal', icon: Target, color: 'var(--accent-green)', bg: 'rgba(0,214,143,0.1)' },
                { label: 'Protein', val: `${Math.round(analytics?.protein ?? 0)}g`, unit: '', icon: Zap, color: 'var(--accent-blue)', bg: 'rgba(77,159,255,0.1)' },
                { label: 'Meals Today', val: meals.length, unit: 'logged', icon: UtensilsCrossed, color: 'var(--accent-purple)', bg: 'rgba(167,139,250,0.1)' },
              ].map(({ label, val, unit, icon: Icon, color, bg }) => (
                <div key={label} className="raw-card" style={{ padding: '1.25rem' }}>
                  <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '0.75rem' }}>
                    <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase', letterSpacing: '0.05em' }}>{label}</span>
                    <div style={{ width: 32, height: 32, borderRadius: 'var(--radius-sm)', background: bg, display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                      <Icon size={16} color={color} />
                    </div>
                  </div>
                  <div style={{ fontSize: '1.6rem', fontWeight: 800, color, lineHeight: 1 }}>{val}</div>
                  {unit && <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', marginTop: '0.25rem' }}>{unit}</div>}
                </div>
              ))}
            </div>

            {/* Calorie Progress + Macro Chart */}
            <div className="dashboard-grid grid-cols-2" style={{ marginBottom: '1.25rem' }}>
              {/* Calorie bar */}
              <div className="raw-card" style={{ padding: '1.5rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1.25rem' }}>
                  <h3 style={{ fontSize: '1rem' }}>Daily Calories</h3>
                  <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>{Math.round(pct)}% of goal</span>
                </div>
                <div style={{ marginBottom: '1rem' }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '0.5rem' }}>
                    <span style={{ fontSize: '2rem', fontWeight: 800, color: 'var(--accent-orange)' }}>{Math.round(calories)}</span>
                    <span style={{ color: 'var(--text-muted)', alignSelf: 'flex-end', marginBottom: '0.4rem' }}>/ {goal} kcal</span>
                  </div>
                  <div className="progress-track">
                    <div className={`progress-fill ${progressColor}`} style={{ width: `${pct}%` }} />
                  </div>
                </div>
                <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '0.75rem' }}>
                  {[
                    { label: 'Protein', val: `${Math.round(analytics?.protein ?? 0)}g`, color: '#4d9fff' },
                    { label: 'Carbs', val: `${Math.round(analytics?.carbs ?? 0)}g`, color: '#00d68f' },
                    { label: 'Fat', val: `${Math.round(analytics?.fats ?? 0)}g`, color: '#fb923c' },
                  ].map(m => (
                    <div key={m.label} className="macro-pill">
                      <span className="macro-val" style={{ color: m.color }}>{m.val}</span>
                      <span className="macro-name">{m.label}</span>
                    </div>
                  ))}
                </div>
              </div>

              {/* Macro Pie */}
              <div className="raw-card" style={{ padding: '1.5rem' }}>
                <h3 style={{ fontSize: '1rem', marginBottom: '1rem' }}>Macros Breakdown</h3>
                {(analytics?.protein ?? 0) + (analytics?.carbs ?? 0) + (analytics?.fats ?? 0) > 0 ? (
                  <div style={{ height: 160 }}>
                    <ResponsiveContainer width="100%" height="100%">
                      <PieChart>
                        <Pie data={macroData} cx="50%" cy="50%" innerRadius={45} outerRadius={70} paddingAngle={3} dataKey="value">
                          {macroData.map((entry, i) => <Cell key={i} fill={entry.color} />)}
                        </Pie>
                        <Tooltip formatter={(val: unknown) => [`${Math.round(Number(val))}g`]} contentStyle={{ background: 'var(--bg-secondary)', border: '1px solid var(--border-subtle)', borderRadius: 8 }} />
                      </PieChart>
                    </ResponsiveContainer>
                  </div>
                ) : (
                  <div style={{ height: 160, display: 'flex', alignItems: 'center', justifyContent: 'center', color: 'var(--text-muted)', fontSize: '0.875rem' }}>
                    No meals logged yet today
                  </div>
                )}
                <div style={{ display: 'flex', gap: '0.75rem', justifyContent: 'center', marginTop: '0.5rem' }}>
                  {macroData.map(m => (
                    <div key={m.name} style={{ display: 'flex', alignItems: 'center', gap: '0.35rem', fontSize: '0.75rem', color: 'var(--text-secondary)' }}>
                      <div style={{ width: 8, height: 8, borderRadius: '50%', background: m.color }} />
                      {m.name}
                    </div>
                  ))}
                </div>
              </div>
            </div>

            {/* Water + Quick Actions */}
            <div className="dashboard-grid grid-cols-2" style={{ marginBottom: '1.25rem' }}>
              {/* Water */}
              <div className="raw-card" style={{ padding: '1.5rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1rem' }}>
                  <h3 style={{ fontSize: '1rem', display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                    <Droplets size={18} color="var(--accent-blue)" /> Hydration
                  </h3>
                  <Link href="/water" className="btn btn-ghost btn-sm">Add</Link>
                </div>
                <div style={{ fontSize: '2rem', fontWeight: 800, color: 'var(--accent-blue)', marginBottom: '0.5rem' }}>
                  {waterMl}
                  <span style={{ fontSize: '1rem', fontWeight: 400, color: 'var(--text-muted)', marginLeft: '0.25rem' }}>ml</span>
                </div>
                <div className="progress-track" style={{ marginBottom: '0.5rem' }}>
                  <div className="progress-fill" style={{ width: `${waterPct}%`, background: 'linear-gradient(90deg, #4d9fff, #00d68f)' }} />
                </div>
                <div style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>{waterMl} / {waterGoal}ml goal</div>
              </div>

              {/* Quick actions */}
              <div className="raw-card" style={{ padding: '1.5rem' }}>
                <h3 style={{ fontSize: '1rem', marginBottom: '1rem' }}>Quick Actions</h3>
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.6rem' }}>
                  {[
                    { href: `/log-meal?date=${getLocalDateString(selectedDate)}`, label: 'Log a meal', icon: UtensilsCrossed, color: 'var(--accent-green)' },
                    { href: '/ai', label: 'AI food scan', icon: Zap, color: 'var(--accent-purple)' },
                    { href: '/analytics', label: 'View analytics', icon: TrendingUp, color: 'var(--accent-blue)' },
                  ].map(({ href, label, icon: Icon, color }) => (
                    <Link key={href} href={href} style={{
                      display: 'flex', alignItems: 'center', gap: '0.75rem', padding: '0.65rem 0.75rem',
                      borderRadius: 'var(--radius-md)', textDecoration: 'none', color: 'var(--text-secondary)',
                      background: 'rgba(255,255,255,0.03)', border: '1px solid var(--border-subtle)',
                      transition: 'all 0.2s', fontSize: '0.875rem', fontWeight: 500,
                    }}>
                      <Icon size={16} color={color} /> {label}
                      <ChevronRight size={14} style={{ marginLeft: 'auto', opacity: 0.5 }} />
                    </Link>
                  ))}
                </div>
              </div>
            </div>

            {/* Meals */}
            <div className="raw-card" style={{ padding: '1.5rem' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1.25rem' }}>
                <h3 style={{ fontSize: '1rem' }}>
                  {getLocalDateString(selectedDate) === getLocalDateString(new Date()) ? "Today's Meals" : `${formatDateLabel(selectedDate)}'s Meals`}
                </h3>
                <Link href={`/log-meal?date=${getLocalDateString(selectedDate)}`} className="btn btn-primary btn-sm">
                  <Plus size={14} /> Add
                </Link>
              </div>
              {meals.length === 0 ? (
                <div style={{ textAlign: 'center', padding: '2.5rem 1rem', color: 'var(--text-muted)' }}>
                  <UtensilsCrossed size={36} style={{ marginBottom: '0.75rem', opacity: 0.4 }} />
                  <p>No meals logged yet on this day</p>
                  <Link href={`/log-meal?date=${getLocalDateString(selectedDate)}`} className="btn btn-primary btn-sm" style={{ marginTop: '1rem' }}>Log your first meal</Link>
                </div>
              ) : (
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.75rem' }}>
                  {meals.map((meal) => {
                    const Icon = mealIcons[meal.mealType] ?? UtensilsCrossed;
                    const color = mealColors[meal.mealType] ?? 'var(--accent-green)';
                    return (
                      <div key={meal.id} style={{
                        display: 'flex', alignItems: 'center', gap: '0.75rem', padding: '0.875rem 1rem',
                        background: 'rgba(255,255,255,0.03)', borderRadius: 'var(--radius-md)',
                        border: '1px solid var(--border-subtle)',
                      }}>
                        <div style={{ width: 36, height: 36, borderRadius: 'var(--radius-sm)', background: `${color}1a`, display: 'flex', alignItems: 'center', justifyContent: 'center', flexShrink: 0 }}>
                          <Icon size={18} color={color} />
                        </div>
                        <div style={{ flex: 1 }}>
                          <div style={{ fontWeight: 600, fontSize: '0.875rem', textTransform: 'capitalize', color }}>
                            {meal.mealType.charAt(0) + meal.mealType.slice(1).toLowerCase()}
                          </div>
                          <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>
                            {meal.foodItems?.slice(0, 3).map(f => f.name).join(', ')}
                          </div>
                        </div>
                        <div style={{ textAlign: 'right' }}>
                          <div style={{ fontWeight: 700, fontSize: '0.9rem' }}>{Math.round(meal.totalCalories)} kcal</div>
                          <div style={{ fontSize: '0.72rem', color: 'var(--text-muted)' }}>P:{Math.round(meal.totalProtein)}g C:{Math.round(meal.totalCarbs)}g F:{Math.round(meal.totalFat)}g</div>
                        </div>
                      </div>
                    );
                  })}
                </div>
              )}
            </div>
          </>
        )}
      </div>
    </div>
  );
}
