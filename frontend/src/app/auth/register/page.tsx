'use client';
import { useState } from 'react';
import { useRouter } from 'next/navigation';
import Link from 'next/link';
import { Flame, Mail, Lock, User, AlertCircle, CheckCircle2 } from 'lucide-react';
import { authAPI } from '@/lib/api';
import { useAuth } from '@/context/AuthContext';

const goals = [
  { value: 'FAT_LOSS', label: '🔥 Fat Loss', desc: '1,800 kcal/day' },
  { value: 'MUSCLE_GAIN', label: '💪 Muscle Gain', desc: '2,500 kcal/day' },
  { value: 'MAINTENANCE', label: '⚖️ Maintenance', desc: '2,000 kcal/day' },
];

export default function RegisterPage() {
  const router = useRouter();
  const { login } = useAuth();
  const [step, setStep] = useState(1);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [form, setForm] = useState({
    name: '', email: '', password: '',
    height: '', weight: '', goal: 'MAINTENANCE',
  });

  const set = (k: string, v: string) => setForm((f) => ({ ...f, [k]: v }));

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (step === 1) { setStep(2); return; }
    setError('');
    setLoading(true);
    try {
      await authAPI.register({
        name: form.name, email: form.email, password: form.password,
        height: form.height ? parseFloat(form.height) : undefined,
        weight: form.weight ? parseFloat(form.weight) : undefined,
        goal: form.goal,
      });
      const loginRes = await authAPI.login(form.email, form.password);
      await login(loginRes.data.token);
      router.replace('/dashboard');
    } catch (err: unknown) {
      const msg = (err as { response?: { data?: { message?: string } } })?.response?.data?.message;
      setError(msg || 'Registration failed. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="page-wrapper" style={{
      minHeight: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center', padding: '1.5rem',
    }}>
      <div className="animate-scale-in" style={{ width: '100%', maxWidth: 460 }}>
        {/* Logo */}
        <div style={{ textAlign: 'center', marginBottom: '2rem' }}>
          <Link href="/" style={{ display: 'inline-flex', alignItems: 'center', gap: '0.6rem', textDecoration: 'none', color: 'var(--text-primary)', fontWeight: 700, fontSize: '1.3rem', fontFamily: 'var(--font-display)' }}>
            <div className="nav-logo-icon" style={{ width: 40, height: 40 }}>
              <Flame size={22} color="#080d14" strokeWidth={2.5} />
            </div>
            NutriAI
          </Link>
          <div style={{ marginTop: '1.25rem' }}>
            <h1 style={{ fontSize: '1.6rem', marginBottom: '0.4rem' }}>Create your account</h1>
            <p style={{ color: 'var(--text-secondary)', fontSize: '0.875rem' }}>Start your nutrition journey today</p>
          </div>
        </div>

        {/* Step indicator */}
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', marginBottom: '1.5rem', justifyContent: 'center' }}>
          {[1, 2].map((s) => (
            <div key={s} style={{ display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
              <div style={{
                width: 28, height: 28, borderRadius: '50%', display: 'flex', alignItems: 'center', justifyContent: 'center',
                fontWeight: 700, fontSize: '0.8rem',
                background: step >= s ? 'var(--gradient-primary)' : 'rgba(255,255,255,0.08)',
                color: step >= s ? '#080d14' : 'var(--text-muted)',
                transition: 'all 0.3s',
              }}>{s}</div>
              {s < 2 && <div style={{ width: 40, height: 2, background: step > s ? 'var(--accent-green)' : 'var(--border-subtle)', transition: 'all 0.3s' }} />}
            </div>
          ))}
        </div>

        <div className="glass-card" style={{ padding: '2rem' }}>
          {error && (
            <div className="alert alert-error" style={{ marginBottom: '1.25rem' }}>
              <AlertCircle size={16} /> {error}
            </div>
          )}

          <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
            {step === 1 ? (
              <>
                <div className="input-group">
                  <label className="input-label">Full name</label>
                  <div className="input-with-icon">
                    <User size={16} className="input-icon" />
                    <input id="name" type="text" className="input" placeholder="Akash Singh" value={form.name} onChange={(e) => set('name', e.target.value)} required />
                  </div>
                </div>
                <div className="input-group">
                  <label className="input-label">Email address</label>
                  <div className="input-with-icon">
                    <Mail size={16} className="input-icon" />
                    <input id="reg-email" type="email" className="input" placeholder="you@example.com" value={form.email} onChange={(e) => set('email', e.target.value)} required />
                  </div>
                </div>
                <div className="input-group">
                  <label className="input-label">Password</label>
                  <div className="input-with-icon">
                    <Lock size={16} className="input-icon" />
                    <input id="reg-password" type="password" className="input" placeholder="Min 8 characters" value={form.password} onChange={(e) => set('password', e.target.value)} required minLength={8} />
                  </div>
                </div>
                <button id="step1-next" type="submit" className="btn btn-primary" style={{ width: '100%', marginTop: '0.5rem', padding: '0.9rem' }}>
                  Continue →
                </button>
              </>
            ) : (
              <>
                <p style={{ color: 'var(--text-secondary)', fontSize: '0.875rem', marginBottom: '0.5rem' }}>
                  Help us personalise your experience (optional)
                </p>
                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                  <div className="input-group">
                    <label className="input-label">Height (cm)</label>
                    <input id="height" type="number" className="input" placeholder="175" value={form.height} onChange={(e) => set('height', e.target.value)} min={100} max={250} />
                  </div>
                  <div className="input-group">
                    <label className="input-label">Weight (kg)</label>
                    <input id="weight" type="number" className="input" placeholder="70" value={form.weight} onChange={(e) => set('weight', e.target.value)} min={30} max={300} />
                  </div>
                </div>
                <div className="input-group">
                  <label className="input-label">Your Goal</label>
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '0.6rem' }}>
                    {goals.map((g) => (
                      <label key={g.value} style={{
                        display: 'flex', alignItems: 'center', gap: '0.75rem',
                        padding: '0.875rem 1rem',
                        borderRadius: 'var(--radius-md)',
                        cursor: 'pointer',
                        border: `1px solid ${form.goal === g.value ? 'var(--accent-green)' : 'var(--border-subtle)'}`,
                        background: form.goal === g.value ? 'rgba(0,214,143,0.08)' : 'rgba(255,255,255,0.03)',
                        transition: 'all 0.2s',
                      }}>
                        <input type="radio" name="goal" value={g.value} checked={form.goal === g.value} onChange={() => set('goal', g.value)} style={{ display: 'none' }} />
                        <div style={{ flex: 1 }}>
                          <div style={{ fontWeight: 600, fontSize: '0.9rem' }}>{g.label}</div>
                          <div style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>{g.desc}</div>
                        </div>
                        {form.goal === g.value && <CheckCircle2 size={18} color="var(--accent-green)" />}
                      </label>
                    ))}
                  </div>
                </div>
                <div style={{ display: 'flex', gap: '0.75rem', marginTop: '0.5rem' }}>
                  <button type="button" className="btn btn-ghost" style={{ flex: 1 }} onClick={() => setStep(1)}>← Back</button>
                  <button id="register-submit" type="submit" className="btn btn-primary" style={{ flex: 2 }} disabled={loading}>
                    {loading ? <span className="spinner" /> : 'Create Account 🎉'}
                  </button>
                </div>
              </>
            )}
          </form>

          <div style={{ textAlign: 'center', marginTop: '1.5rem', fontSize: '0.875rem', color: 'var(--text-secondary)' }}>
            Already have an account?{' '}
            <Link href="/auth/login" style={{ fontWeight: 600 }}>Sign in</Link>
          </div>
        </div>
      </div>
    </div>
  );
}
