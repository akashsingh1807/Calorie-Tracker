'use client';
import { useEffect, useState, useCallback } from 'react';
import { waterAPI } from '@/lib/api';
import { Droplets, Plus, Minus, History, TrendingUp, Info } from 'lucide-react';

export default function WaterPage() {
  const [amountMl, setAmountMl] = useState(0);
  const [goalMl] = useState(2500); // Default goal
  const [loading, setLoading] = useState(true);
  const [lastLogged, setLastLogged] = useState<string | null>(null);

  const loadToday = useCallback(async () => {
    try {
      const res = await waterAPI.getToday();
      setAmountMl(res.data.amountMl || 0);
      setLastLogged(res.data.lastLoggedAt);
    } catch (err) {
      console.error('Error fetching water intake:', err);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    loadToday();
  }, [loadToday]);

  const addWater = async (ml: number) => {
    try {
      await waterAPI.log(ml);
      setAmountMl(prev => prev + ml);
      setLastLogged(new Date().toISOString());
    } catch (err) {
      console.error('Error logging water:', err);
    }
  };

  const progress = Math.min((amountMl / goalMl) * 100, 100);
  const remaining = Math.max(goalMl - amountMl, 0);

  return (
    <div className="page-wrapper">
      <div className="dashboard-main">
        <div style={{ marginBottom: '2rem' }}>
          <h1 style={{ fontSize: '1.6rem', marginBottom: '0.25rem' }}>Hydration Tracker</h1>
          <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Stay hydrated for optimal health and performance</p>
        </div>

        <div className="dashboard-grid grid-cols-2">
          {/* Main Controls */}
          <div className="glass-card" style={{ padding: '2rem', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', textAlign: 'center' }}>
            <div style={{ position: 'relative', width: 200, height: 200, marginBottom: '2rem' }}>
              {/* Circular Progress (Simplified) */}
              <div style={{
                position: 'absolute', inset: 0, borderRadius: '50%',
                border: '8px solid rgba(77,159,255,0.1)',
              }} />
              <div style={{
                position: 'absolute', inset: 0, borderRadius: '50%',
                border: '8px solid var(--accent-blue)',
                clipPath: `inset(${100 - progress}% 0 0 0)`,
                transition: 'clip-path 0.5s ease-out'
              }} />
              <div style={{
                position: 'absolute', inset: 0, display: 'flex', flexDirection: 'column',
                alignItems: 'center', justifyContent: 'center'
              }}>
                <Droplets size={32} color="var(--accent-blue)" style={{ marginBottom: '0.5rem' }} />
                <div style={{ fontSize: '2rem', fontWeight: 800 }}>{amountMl}</div>
                <div style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>/ {goalMl} ml</div>
              </div>
            </div>

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '1rem', width: '100%' }}>
              {[250, 500, 750].map(ml => (
                <button
                  key={ml}
                  onClick={() => addWater(ml)}
                  className="btn btn-ghost"
                  style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem', padding: '1rem' }}
                >
                  <Plus size={16} />
                  <span>{ml}ml</span>
                </button>
              ))}
            </div>
          </div>

          {/* Stats & Info */}
          <div style={{ display: 'grid', gap: '1.25rem' }}>
            <div className="glass-card" style={{ padding: '1.5rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', marginBottom: '1.25rem' }}>
                <div style={{ width: 32, height: 32, borderRadius: 'var(--radius-sm)', background: 'rgba(77,159,255,0.1)', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                  <TrendingUp size={16} color="var(--accent-blue)" />
                </div>
                <h3 style={{ fontSize: '1rem' }}>Today's Progress</h3>
              </div>
              
              <div style={{ marginBottom: '1.5rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '0.5rem', fontSize: '0.85rem' }}>
                  <span style={{ color: 'var(--text-secondary)' }}>Goal Progress</span>
                  <span style={{ fontWeight: 600 }}>{Math.round(progress)}%</span>
                </div>
                <div style={{ height: 8, background: 'rgba(255,255,255,0.05)', borderRadius: 4, overflow: 'hidden' }}>
                  <div style={{ height: '100%', width: `${progress}%`, background: 'var(--accent-blue)', borderRadius: 4 }} />
                </div>
              </div>

              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                <div style={{ padding: '1rem', background: 'rgba(255,255,255,0.02)', borderRadius: 'var(--radius-md)' }}>
                  <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', marginBottom: '0.25rem' }}>Remaining</div>
                  <div style={{ fontSize: '1.1rem', fontWeight: 700 }}>{remaining} ml</div>
                </div>
                <div style={{ padding: '1rem', background: 'rgba(255,255,255,0.02)', borderRadius: 'var(--radius-md)' }}>
                  <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)', marginBottom: '0.25rem' }}>Last Entry</div>
                  <div style={{ fontSize: '1.1rem', fontWeight: 700 }}>
                    {lastLogged ? new Date(lastLogged).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }) : '--:--'}
                  </div>
                </div>
              </div>
            </div>

            <div className="glass-card" style={{ padding: '1.5rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', marginBottom: '1rem' }}>
                <Info size={16} color="var(--text-muted)" />
                <h3 style={{ fontSize: '1rem' }}>Hydration Tip</h3>
              </div>
              <p style={{ fontSize: '0.85rem', color: 'var(--text-secondary)', lineHeight: 1.6 }}>
                Drinking water before meals can help with weight management by promoting satiety. Aim for at least 8 glasses (2L) a day.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
