'use client';
import Link from 'next/link';
import { Flame, Zap, BarChart3, Camera, ChevronRight, CheckCircle2, ArrowRight } from 'lucide-react';

const features = [
  {
    icon: Camera,
    title: 'AI Food Recognition',
    description: 'Snap a photo of any meal and our Gemini 2.5 Flash AI identifies every ingredient instantly.',
    color: 'var(--accent-green)',
    bg: 'rgba(0,214,143,0.1)',
  },
  {
    icon: BarChart3,
    title: 'Smart Analytics',
    description: 'Beautiful charts tracking calories, macros, weight, and hydration over time.',
    color: 'var(--accent-blue)',
    bg: 'rgba(77,159,255,0.1)',
  },
  {
    icon: Zap,
    title: 'Goal-Based Plans',
    description: 'AI tailors daily calorie goals and meal suggestions for fat loss, muscle gain, or maintenance.',
    color: 'var(--accent-purple)',
    bg: 'rgba(167,139,250,0.1)',
  },
];

const benefits = [
  'Log meals in seconds with AI photo analysis',
  'Track protein, carbs, and fat automatically',
  'Monitor hydration and fasting windows',
  'Weight progress charts and trend analysis',
  'Personalised AI meal recommendations',
  'Works seamlessly on mobile and desktop',
];

export default function LandingPage() {
  return (
    <div className="page-wrapper">
      {/* ── Hero Nav ── */}
      <nav className="nav">
        <div className="nav-inner">
          <Link href="/" className="nav-logo">
            <div className="nav-logo-icon">
              <Flame size={18} color="#080d14" strokeWidth={2.5} />
            </div>
            NutriAI
          </Link>
          <div style={{ display: 'flex', gap: '0.75rem', alignItems: 'center' }}>
            <Link href="/auth/login" className="btn btn-ghost btn-sm">Sign In</Link>
            <Link href="/auth/register" className="btn btn-primary btn-sm">Get Started</Link>
          </div>
        </div>
      </nav>

      {/* ── Hero ── */}
      <section style={{ padding: '6rem 1.5rem 4rem', textAlign: 'center', maxWidth: 900, margin: '0 auto' }}>
        <div className="animate-slide-up">
          <div className="badge badge-green" style={{ marginBottom: '1.5rem', fontSize: '0.8rem' }}>
            <Zap size={12} />
            Powered by Google Gemini 2.5 Flash
          </div>
          <h1 style={{
            fontSize: 'clamp(2.5rem, 6vw, 4.5rem)',
            fontWeight: 900,
            lineHeight: 1.1,
            marginBottom: '1.5rem',
            letterSpacing: '-0.02em',
          }}>
            Track Nutrition with{' '}
            <span style={{
              background: 'var(--gradient-primary)',
              WebkitBackgroundClip: 'text',
              WebkitTextFillColor: 'transparent',
              backgroundClip: 'text',
            }}>
              AI Precision
            </span>
          </h1>
          <p style={{
            fontSize: '1.2rem', color: 'var(--text-secondary)', maxWidth: 600,
            margin: '0 auto 2.5rem', lineHeight: 1.7,
          }}>
            Snap a photo of your meal, and NutriAI identifies every food item,
            calculates macros, and helps you hit your fitness goals — effortlessly.
          </p>
          <div style={{ display: 'flex', gap: '1rem', justifyContent: 'center', flexWrap: 'wrap' }}>
            <Link href="/auth/register" className="btn btn-primary btn-lg">
              Start Free <ArrowRight size={18} />
            </Link>
            <Link href="/auth/login" className="btn btn-secondary btn-lg">
              Sign In
            </Link>
          </div>
        </div>

        {/* Hero Visual */}
        <div className="animate-slide-up" style={{ marginTop: '4rem', position: 'relative' }}>
          <div style={{
            background: 'var(--bg-secondary)',
            border: '1px solid var(--border-subtle)',
            borderRadius: 'var(--radius-xl)',
            padding: '1.5rem',
            boxShadow: '0 40px 80px rgba(0,0,0,0.5), 0 0 60px rgba(0,214,143,0.05)',
            maxWidth: 760,
            margin: '0 auto',
          }}>
            {/* Mock Dashboard Preview */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '0.75rem', marginBottom: '1rem' }}>
              {[
                { label: 'Calories', val: '1,842', unit: '/ 2,000', color: 'var(--accent-green)' },
                { label: 'Protein', val: '132g', unit: '/ 150g', color: 'var(--accent-blue)' },
                { label: 'Streak', val: '14', unit: 'days', color: 'var(--accent-purple)' },
              ].map((s) => (
                <div key={s.label} className="glass-card" style={{ padding: '1rem', textAlign: 'center' }}>
                  <div style={{ fontSize: '0.7rem', color: 'var(--text-muted)', textTransform: 'uppercase', letterSpacing: '0.05em', marginBottom: '0.4rem' }}>{s.label}</div>
                  <div style={{ fontSize: '1.4rem', fontWeight: 800, color: s.color }}>{s.val}</div>
                  <div style={{ fontSize: '0.7rem', color: 'var(--text-muted)' }}>{s.unit}</div>
                </div>
              ))}
            </div>
            <div className="glass-card" style={{ padding: '1.25rem', display: 'flex', alignItems: 'center', gap: '1rem' }}>
              <div style={{
                width: 48, height: 48, borderRadius: 'var(--radius-md)',
                background: 'rgba(0,214,143,0.15)', display: 'flex', alignItems: 'center', justifyContent: 'center',
              }}>
                <Camera size={22} color="var(--accent-green)" />
              </div>
              <div style={{ flex: 1, textAlign: 'left' }}>
                <div style={{ fontWeight: 600, marginBottom: '0.2rem' }}>AI detected: Dal Tadka, Roti, Raita</div>
                <div style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>487 kcal · 18g protein · 62g carbs · 14g fat</div>
              </div>
              <div className="badge badge-green">✓ Logged</div>
            </div>
          </div>
        </div>
      </section>

      {/* ── Features ── */}
      <section style={{ padding: '5rem 1.5rem', maxWidth: 1100, margin: '0 auto' }}>
        <div style={{ textAlign: 'center', marginBottom: '3rem' }}>
          <h2 style={{ fontSize: '2.2rem', marginBottom: '0.75rem' }}>Everything you need to succeed</h2>
          <p style={{ color: 'var(--text-secondary)', fontSize: '1.05rem' }}>
            Intelligent tools that make healthy eating simple
          </p>
        </div>
        <div className="dashboard-grid grid-cols-3">
          {features.map((f) => {
            const Icon = f.icon;
            return (
              <div key={f.title} className="glass-card" style={{ padding: '2rem' }}>
                <div style={{
                  width: 52, height: 52, borderRadius: 'var(--radius-md)',
                  background: f.bg, display: 'flex', alignItems: 'center', justifyContent: 'center',
                  marginBottom: '1.25rem',
                }}>
                  <Icon size={24} color={f.color} />
                </div>
                <h3 style={{ fontSize: '1.1rem', marginBottom: '0.6rem' }}>{f.title}</h3>
                <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem', lineHeight: 1.6 }}>{f.description}</p>
              </div>
            );
          })}
        </div>
      </section>

      {/* ── Benefits ── */}
      <section style={{ padding: '4rem 1.5rem', maxWidth: 900, margin: '0 auto' }}>
        <div style={{
          display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '3rem', alignItems: 'center',
        }}>
          <div>
            <h2 style={{ fontSize: '2rem', marginBottom: '1.5rem', lineHeight: 1.2 }}>
              Built for real people,<br />not just fitness nerds
            </h2>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.85rem' }}>
              {benefits.map((b) => (
                <div key={b} style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', color: 'var(--text-secondary)', fontSize: '0.92rem' }}>
                  <CheckCircle2 size={18} color="var(--accent-green)" strokeWidth={2} style={{ flexShrink: 0 }} />
                  {b}
                </div>
              ))}
            </div>
          </div>
          <div className="glass-card-accent animate-float" style={{ padding: '2rem', textAlign: 'center' }}>
            <div style={{ fontSize: '3.5rem', marginBottom: '0.5rem' }}>🎯</div>
            <div style={{ fontSize: '1.5rem', fontWeight: 800, color: 'var(--accent-green)', marginBottom: '0.25rem' }}>95%</div>
            <div style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>AI food detection accuracy</div>
            <div className="divider" style={{ margin: '1.25rem 0' }} />
            <div style={{ fontSize: '2.5rem', marginBottom: '0.5rem' }}>⚡</div>
            <div style={{ fontSize: '1.5rem', fontWeight: 800, color: 'var(--accent-blue)', marginBottom: '0.25rem' }}>&lt; 3s</div>
            <div style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Average analysis time</div>
          </div>
        </div>
      </section>

      {/* ── CTA ── */}
      <section style={{ padding: '5rem 1.5rem', textAlign: 'center' }}>
        <div className="glass-card-accent" style={{ maxWidth: 700, margin: '0 auto', padding: '3.5rem 2rem' }}>
          <h2 style={{ fontSize: '2rem', marginBottom: '1rem' }}>Ready to transform your nutrition?</h2>
          <p style={{ color: 'var(--text-secondary)', marginBottom: '2rem' }}>
            Join thousands already tracking smarter with AI-powered insights.
          </p>
          <Link href="/auth/register" className="btn btn-primary btn-lg">
            Get Started Free <ChevronRight size={18} />
          </Link>
        </div>
      </section>

      {/* ── Footer ── */}
      <footer style={{
        padding: '2rem 1.5rem',
        textAlign: 'center',
        borderTop: '1px solid var(--border-subtle)',
        color: 'var(--text-muted)',
        fontSize: '0.85rem',
      }}>
        <p>© 2025 NutriAI · Built by Akash Singh · Powered by Gemini AI</p>
      </footer>
    </div>
  );
}
