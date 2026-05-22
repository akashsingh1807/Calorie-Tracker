'use client';
import { useEffect, useState, useCallback } from 'react';
import { weightAPI } from '@/lib/api';
import { Scale, Plus, TrendingDown, TrendingUp, Calendar, History } from 'lucide-react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer } from 'recharts';

type WeightEntry = {
  id: number;
  weight: number;
  recordedAt: string;
};

export default function WeightPage() {
  const [history, setHistory] = useState<WeightEntry[]>([]);
  const [newWeight, setNewWeight] = useState('');
  const [loading, setLoading] = useState(true);
  const [submitting, setSubmitting] = useState(false);

  const loadHistory = useCallback(async () => {
    try {
      const res = await weightAPI.getHistory();
      setHistory(res.data || []);
    } catch (err) {
      console.error('Error fetching weight history:', err);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    loadHistory();
  }, [loadHistory]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!newWeight || submitting) return;
    setSubmitting(true);
    try {
      await weightAPI.log(parseFloat(newWeight));
      setNewWeight('');
      await loadHistory();
    } catch (err) {
      console.error('Error logging weight:', err);
    } finally {
      setSubmitting(false);
    }
  };

  const currentWeight = history.length > 0 ? history[0].weight : 0;
  const startWeight = history.length > 0 ? history[history.length - 1].weight : 0;
  const change = currentWeight - startWeight;

  const chartData = [...history].reverse().map(entry => ({
    weight: entry.weight,
    date: new Date(entry.recordedAt).toLocaleDateString('en', { month: 'short', day: 'numeric' })
  }));

  return (
    <div className="page-wrapper">
      <div className="dashboard-main">
        <div style={{ marginBottom: '2rem', display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
          <div>
            <h1 style={{ fontSize: '1.6rem', marginBottom: '0.25rem' }}>Weight Tracking</h1>
            <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Monitor your weight progress over time</p>
          </div>
          <button 
            onClick={() => document.getElementById('weight-input')?.focus()}
            className="btn btn-primary"
          >
            <Plus size={16} /> Log Weight
          </button>
        </div>

        <div className="dashboard-grid grid-cols-3" style={{ marginBottom: '1.5rem' }}>
          <div className="raw-card" style={{ padding: '1.25rem' }}>
            <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Current Weight</span>
            <div style={{ fontSize: '1.5rem', fontWeight: 800, marginTop: '0.5rem' }}>{currentWeight} <span style={{ fontSize: '0.9rem', fontWeight: 400 }}>kg</span></div>
          </div>
          <div className="raw-card" style={{ padding: '1.25rem' }}>
            <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Total Change</span>
            <div style={{ 
              fontSize: '1.5rem', fontWeight: 800, marginTop: '0.5rem',
              color: change < 0 ? 'var(--accent-green)' : change > 0 ? 'var(--accent-orange)' : 'inherit'
            }}>
              {change > 0 ? '+' : ''}{change.toFixed(1)} <span style={{ fontSize: '0.9rem', fontWeight: 400 }}>kg</span>
            </div>
          </div>
          <div className="raw-card" style={{ padding: '1.25rem' }}>
            <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textTransform: 'uppercase' }}>Logs This Month</span>
            <div style={{ fontSize: '1.5rem', fontWeight: 800, marginTop: '0.5rem' }}>{history.length}</div>
          </div>
        </div>

        <div className="dashboard-grid grid-cols-2">
          {/* Chart */}
          <div className="raw-card" style={{ padding: '1.5rem' }}>
            <h3 style={{ fontSize: '1rem', marginBottom: '1.5rem' }}>Weight Trend</h3>
            <div style={{ height: 300 }}>
              <ResponsiveContainer width="100%" height="100%">
                <LineChart data={chartData}>
                  <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.05)" vertical={false} />
                  <XAxis dataKey="date" tick={{ fill: 'var(--text-muted)', fontSize: 12 }} axisLine={false} tickLine={false} />
                  <YAxis domain={['dataMin - 2', 'dataMax + 2']} tick={{ fill: 'var(--text-muted)', fontSize: 12 }} axisLine={false} tickLine={false} />
                  <Tooltip 
                    contentStyle={{ background: 'var(--bg-secondary)', border: '1px solid var(--border-subtle)', borderRadius: 8 }}
                    itemStyle={{ color: 'var(--accent-blue)' }}
                  />
                  <Line type="monotone" dataKey="weight" stroke="var(--accent-blue)" strokeWidth={3} dot={{ fill: 'var(--accent-blue)', r: 4 }} activeDot={{ r: 6 }} />
                </LineChart>
              </ResponsiveContainer>
            </div>
          </div>

          {/* Log & History */}
          <div style={{ display: 'grid', gap: '1.25rem' }}>
            <div className="raw-card" style={{ padding: '1.5rem' }}>
              <h3 style={{ fontSize: '1rem', marginBottom: '1.25rem' }}>Quick Log</h3>
              <form onSubmit={handleSubmit} style={{ display: 'flex', gap: '0.75rem' }}>
                <input 
                  id="weight-input"
                  type="number" 
                  step="0.1"
                  placeholder="Enter weight in kg"
                  value={newWeight}
                  onChange={(e) => setNewWeight(e.target.value)}
                  className="input"
                  style={{ flex: 1 }}
                />
                <button type="submit" disabled={submitting} className="btn btn-primary">
                  {submitting ? 'Logging...' : 'Log'}
                </button>
              </form>
            </div>

            <div className="raw-card" style={{ padding: '1.5rem', maxHeight: '300px', overflowY: 'auto' }}>
              <h3 style={{ fontSize: '1rem', marginBottom: '1.25rem' }}>Recent History</h3>
              <div style={{ display: 'grid', gap: '0.75rem' }}>
                {history.map((entry) => (
                  <div key={entry.id} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', paddingBottom: '0.75rem', borderBottom: '1px solid var(--border-subtle)' }}>
                    <div>
                      <div style={{ fontWeight: 600 }}>{entry.weight} kg</div>
                      <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>
                        {new Date(entry.recordedAt).toLocaleDateString()}
                      </div>
                    </div>
                    {entry.weight < (history[history.indexOf(entry) + 1]?.weight || entry.weight) ? (
                      <TrendingDown size={14} color="var(--accent-green)" />
                    ) : entry.weight > (history[history.indexOf(entry) + 1]?.weight || entry.weight) ? (
                      <TrendingUp size={14} color="var(--accent-orange)" />
                    ) : null}
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
