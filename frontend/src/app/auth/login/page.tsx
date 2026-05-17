'use client';
import { useState } from 'react';
import { useRouter } from 'next/navigation';
import Link from 'next/link';
import { Flame, Mail, Lock, Eye, EyeOff, AlertCircle } from 'lucide-react';
import { authAPI } from '@/lib/api';
import { useAuth } from '@/context/AuthContext';

export default function LoginPage() {
  const router = useRouter();
  const { login } = useAuth();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPw, setShowPw] = useState(false);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError('');
    setLoading(true);
    try {
      const res = await authAPI.login(email, password);
      const { token } = res.data;
      await login(token);
      router.replace('/dashboard');
    } catch (err: unknown) {
      const msg = (err as { response?: { data?: { message?: string } } })?.response?.data?.message;
      setError(msg || 'Invalid email or password. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="page-wrapper" style={{
      minHeight: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center',
      padding: '1.5rem',
    }}>
      <div className="animate-scale-in" style={{ width: '100%', maxWidth: 440 }}>
        {/* Logo */}
        <div style={{ textAlign: 'center', marginBottom: '2.5rem' }}>
          <Link href="/" style={{ display: 'inline-flex', alignItems: 'center', gap: '0.6rem', textDecoration: 'none', color: 'var(--text-primary)', fontWeight: 700, fontSize: '1.3rem', fontFamily: 'var(--font-display)' }}>
            <div className="nav-logo-icon" style={{ width: 40, height: 40 }}>
              <Flame size={22} color="#080d14" strokeWidth={2.5} />
            </div>
            NutriAI
          </Link>
          <div style={{ marginTop: '1.5rem' }}>
            <h1 style={{ fontSize: '1.75rem', marginBottom: '0.4rem' }}>Welcome back</h1>
            <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Sign in to your account to continue</p>
          </div>
        </div>

        {/* Card */}
        <div className="glass-card" style={{ padding: '2rem' }}>
          {error && (
            <div className="alert alert-error" style={{ marginBottom: '1.25rem' }}>
              <AlertCircle size={16} /> {error}
            </div>
          )}

          <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1.1rem' }}>
            <div className="input-group">
              <label className="input-label">Email address</label>
              <div className="input-with-icon">
                <Mail size={16} className="input-icon" />
                <input
                  id="email"
                  type="email"
                  className="input"
                  placeholder="you@example.com"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                  autoComplete="email"
                />
              </div>
            </div>

            <div className="input-group">
              <label className="input-label">Password</label>
              <div className="input-with-icon" style={{ position: 'relative' }}>
                <Lock size={16} className="input-icon" />
                <input
                  id="password"
                  type={showPw ? 'text' : 'password'}
                  className="input"
                  placeholder="Your password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                  autoComplete="current-password"
                  style={{ paddingRight: '3rem' }}
                />
                <button
                  type="button"
                  onClick={() => setShowPw(!showPw)}
                  style={{
                    position: 'absolute', right: '0.9rem', top: '50%', transform: 'translateY(-50%)',
                    background: 'none', border: 'none', cursor: 'pointer', color: 'var(--text-muted)',
                    display: 'flex', alignItems: 'center',
                  }}
                >
                  {showPw ? <EyeOff size={16} /> : <Eye size={16} />}
                </button>
              </div>
            </div>

            <button
              id="login-submit"
              type="submit"
              className="btn btn-primary"
              disabled={loading}
              style={{ width: '100%', marginTop: '0.5rem', padding: '0.9rem' }}
            >
              {loading ? <span className="spinner" /> : 'Sign In'}
            </button>
          </form>

          <div className="divider-text" style={{ margin: '1.5rem 0' }}>or</div>

          <div style={{ textAlign: 'center', fontSize: '0.875rem', color: 'var(--text-secondary)' }}>
            Don&apos;t have an account?{' '}
            <Link href="/auth/register" style={{ fontWeight: 600 }}>Create one free</Link>
          </div>
        </div>

        <div style={{ textAlign: 'center', marginTop: '1.5rem' }}>
          <Link href="/" style={{ color: 'var(--text-muted)', fontSize: '0.85rem' }}>← Back to home</Link>
        </div>
      </div>
    </div>
  );
}
