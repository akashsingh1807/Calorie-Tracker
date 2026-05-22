'use client';
import { useEffect, useState, useCallback } from 'react';
import { analyticsAPI } from '@/lib/api';
import { useAuth } from '@/context/AuthContext';
import {
  LineChart, Line, AreaChart, Area, BarChart, Bar,
  XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, Legend
} from 'recharts';
import { TrendingUp, Flame, Zap, Apple, Droplets, BarChart3 } from 'lucide-react';

type WeekDay = {
  date: string;
  totalCalories: number;
  protein: number;
  carbs: number;
  fats: number;
};

export default function AnalyticsPage() {
  const { user } = useAuth();
  const [weekly, setWeekly] = useState<WeekDay[]>([]);
  const [loading, setLoading] = useState(true);
  const [range, setRange] = useState<7 | 14 | 30>(7);

  const load = useCallback(async () => {
    setLoading(true);
    try {
      const res = range === 7 ? await analyticsAPI.getWeekly() : await analyticsAPI.getMonthly();
      let data = Array.isArray(res.data) ? res.data : [];
      if (range === 14) {
        data = data.slice(16); // Since monthly returns 30 days, get the last 14 days (30 - 14 = 16)
      }
      setWeekly(data);
    } catch {
      setWeekly([]);
    } finally {
      setLoading(false);
    }
  }, [range]);

  useEffect(() => { load(); }, [load]);

  const tooltipStyle = {
    contentStyle: { background: 'var(--bg-secondary)', border: '1px solid var(--border-subtle)', borderRadius: 8, color: 'var(--text-primary)' },
    labelStyle: { color: 'var(--text-muted)' },
  };

  const safeWeekly = Array.isArray(weekly) ? weekly : [];

  const avgCalories = safeWeekly.length ? Math.round(safeWeekly.reduce((s, d) => s + (d.totalCalories || 0), 0) / safeWeekly.length) : 0;
  const avgProtein = safeWeekly.length ? Math.round(safeWeekly.reduce((s, d) => s + (d.protein || 0), 0) / safeWeekly.length) : 0;
  const totalCalories = Math.round(safeWeekly.reduce((s, d) => s + (d.totalCalories || 0), 0));

  const formatted = safeWeekly.map(d => ({
    ...d,
    day: d.date ? new Date(d.date).toLocaleDateString('en', { weekday: 'short' }) : 'Unknown',
  }));

  const goal = user?.dailyCalorieGoal ?? 2000;

  return (
    <div className="page-wrapper">
      <div className="dashboard-main">
        <div style={{ marginBottom: '2rem', display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', flexWrap: 'wrap', gap: '1rem' }}>
          <div>
            <h1 style={{ fontSize: '1.6rem', marginBottom: '0.25rem' }}>Analytics</h1>
            <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Your nutrition trends and insights</p>
          </div>
          <div style={{ display: 'flex', gap: '0.5rem' }}>
            {([7, 14, 30] as const).map(r => (
              <button key={r} onClick={() => setRange(r)} className={`btn btn-sm ${range === r ? 'btn-primary' : 'btn-ghost'}`}>
                {r}d
              </button>
            ))}
          </div>
        </div>

        {/* Summary Stats */}
        <div className="dashboard-grid grid-cols-3" style={{ marginBottom: '1.5rem' }}>
          {[
            { label: 'Avg Daily Calories', val: `${avgCalories} kcal`, icon: Flame, color: 'var(--accent-orange)', bg: 'rgba(251,146,60,0.1)' },
            { label: 'Avg Daily Protein', val: `${avgProtein}g`, icon: Zap, color: 'var(--accent-blue)', bg: 'rgba(77,159,255,0.1)' },
            { label: `Total (${weekly.length} days)`, val: `${totalCalories} kcal`, icon: TrendingUp, color: 'var(--accent-green)', bg: 'rgba(0,214,143,0.1)' },
          ].map(({ label, val, icon: Icon, color, bg }) => (
            <div key={label} className="raw-card" style={{ padding: '1.25rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '0.75rem' }}>
                <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase', letterSpacing: '0.05em' }}>{label}</span>
                <div style={{ width: 32, height: 32, borderRadius: 'var(--radius-sm)', background: bg, display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                  <Icon size={16} color={color} />
                </div>
              </div>
              <div style={{ fontSize: '1.5rem', fontWeight: 800, color }}>{val}</div>
            </div>
          ))}
        </div>

        {loading ? (
          <div style={{ display: 'grid', gap: '1.25rem' }}>
            {[1,2,3].map(i => <div key={i} className="skeleton" style={{ height: 280, borderRadius: 'var(--radius-lg)' }} />)}
          </div>
        ) : weekly.length === 0 ? (
          <div className="raw-card" style={{ padding: '4rem', textAlign: 'center' }}>
            <BarChart3 size={48} color="var(--text-muted)" style={{ marginBottom: '1rem' }} />
            <p style={{ color: 'var(--text-muted)' }}>Start logging meals to see your analytics</p>
          </div>
        ) : (
          <>
            {/* Calorie Trend */}
            <div className="raw-card" style={{ padding: '1.5rem', marginBottom: '1.25rem' }}>
              <h3 style={{ fontSize: '1rem', marginBottom: '0.25rem' }}>Calorie Trend</h3>
              <p style={{ color: 'var(--text-muted)', fontSize: '0.8rem', marginBottom: '1.25rem' }}>Daily intake vs. your {goal} kcal goal</p>
              <div style={{ height: 240 }}>
                <ResponsiveContainer width="100%" height="100%">
                  <AreaChart data={formatted}>
                    <defs>
                      <linearGradient id="calGrad" x1="0" y1="0" x2="0" y2="1">
                        <stop offset="5%" stopColor="#fb923c" stopOpacity={0.3} />
                        <stop offset="95%" stopColor="#fb923c" stopOpacity={0} />
                      </linearGradient>
                    </defs>
                    <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.05)" />
                    <XAxis dataKey="day" tick={{ fill: 'var(--text-muted)', fontSize: 12 }} axisLine={false} tickLine={false} />
                    <YAxis tick={{ fill: 'var(--text-muted)', fontSize: 11 }} axisLine={false} tickLine={false} />
                    <Tooltip {...tooltipStyle} formatter={(v: unknown) => [`${Math.round(Number(v))} kcal`, 'Calories']} />
                    <Area type="monotone" dataKey="totalCalories" stroke="#fb923c" strokeWidth={2.5} fill="url(#calGrad)" dot={{ fill: '#fb923c', r: 4 }} activeDot={{ r: 6 }} />
                  </AreaChart>
                </ResponsiveContainer>
              </div>
            </div>

            {/* Macro Breakdown */}
            <div className="raw-card" style={{ padding: '1.5rem', marginBottom: '1.25rem' }}>
              <h3 style={{ fontSize: '1rem', marginBottom: '0.25rem' }}>Macro Breakdown</h3>
              <p style={{ color: 'var(--text-muted)', fontSize: '0.8rem', marginBottom: '1.25rem' }}>Protein, carbs and fat per day</p>
              <div style={{ height: 240 }}>
                <ResponsiveContainer width="100%" height="100%">
                  <BarChart data={formatted} barSize={10} barGap={2}>
                    <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.05)" />
                    <XAxis dataKey="day" tick={{ fill: 'var(--text-muted)', fontSize: 12 }} axisLine={false} tickLine={false} />
                    <YAxis tick={{ fill: 'var(--text-muted)', fontSize: 11 }} axisLine={false} tickLine={false} />
                    <Tooltip {...tooltipStyle} formatter={(v: unknown, name: unknown) => [`${Math.round(Number(v))}g`, String(name)]} />
                    <Legend wrapperStyle={{ fontSize: '0.8rem', color: 'var(--text-secondary)' }} />
                    <Bar dataKey="protein" fill="#4d9fff" radius={[4, 4, 0, 0]} />
                    <Bar dataKey="carbs" fill="#00d68f" radius={[4, 4, 0, 0]} />
                    <Bar dataKey="fats" fill="#fb923c" radius={[4, 4, 0, 0]} />
                  </BarChart>
                </ResponsiveContainer>
              </div>
            </div>

            {/* Protein Trend Line */}
            <div className="raw-card" style={{ padding: '1.5rem' }}>
              <h3 style={{ fontSize: '1rem', marginBottom: '0.25rem' }}>Protein Intake</h3>
              <p style={{ color: 'var(--text-muted)', fontSize: '0.8rem', marginBottom: '1.25rem' }}>Daily protein consumption (g)</p>
              <div style={{ height: 200 }}>
                <ResponsiveContainer width="100%" height="100%">
                  <LineChart data={formatted}>
                    <defs>
                      <linearGradient id="protGrad" x1="0" y1="0" x2="0" y2="1">
                        <stop offset="5%" stopColor="#4d9fff" stopOpacity={0.3} />
                        <stop offset="95%" stopColor="#4d9fff" stopOpacity={0} />
                      </linearGradient>
                    </defs>
                    <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.05)" />
                    <XAxis dataKey="day" tick={{ fill: 'var(--text-muted)', fontSize: 12 }} axisLine={false} tickLine={false} />
                    <YAxis tick={{ fill: 'var(--text-muted)', fontSize: 11 }} axisLine={false} tickLine={false} />
                    <Tooltip {...tooltipStyle} formatter={(v: unknown) => [`${Math.round(Number(v))}g`, 'Protein']} />
                    <Line type="monotone" dataKey="protein" stroke="#4d9fff" strokeWidth={2.5} dot={{ fill: '#4d9fff', r: 4 }} activeDot={{ r: 6 }} />
                  </LineChart>
                </ResponsiveContainer>
              </div>
            </div>
          </>
        )}
      </div>
    </div>
  );
}
