'use client';
import Link from 'next/link';
import { Leaf, Activity, Sparkles, Camera, ArrowRight, CheckCircle2 } from 'lucide-react';

const features = [
  {
    icon: Camera,
    title: 'AI Food Tracking',
    description: 'Instantly identify and log meals with precise calorie and macro breakdown using advanced vision AI.',
    color: 'var(--primary-color)',
    bg: '#E0F2FE',
  },
  {
    icon: Activity,
    title: 'Smart Analytics',
    description: 'Monitor your progress with beautiful, intuitive charts for weight, hydration, and nutrition goals.',
    color: 'var(--accent-green)',
    bg: '#D1FAE5',
  },
  {
    icon: Sparkles,
    title: 'Goal-Based Guidance',
    description: 'Receive tailored daily calorie targets and meal suggestions whether you want to lose fat or build muscle.',
    color: 'var(--warning)',
    bg: '#FEF3C7',
  },
];

const benefits = [
  'Log meals in seconds with photo analysis',
  'Automatic protein, carbs, and fat tracking',
  'Water intake and hydration monitoring',
  'Visual weight progress and trend charts',
  'Clean, distraction-free materialistic UI',
];

export default function LandingPage() {
  return (
    <div className="page-wrapper">
      {/* ── Nav ── */}
      <nav className="nav">
        <div className="nav-inner">
          <Link href="/" className="nav-logo" style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
            <Leaf size={24} color="var(--primary-color)" />
            Caloriyaan
          </Link>
          <div style={{ display: 'flex', gap: '12px', alignItems: 'center' }}>
            <Link href="/auth/login" className="btn btn-ghost btn-sm">Log In</Link>
            <Link href="/auth/register" className="btn btn-primary btn-sm">Sign Up</Link>
          </div>
        </div>
      </nav>

      {/* ── Hero ── */}
      <section style={{ padding: '80px 24px 60px', textAlign: 'center', maxWidth: 900, margin: '0 auto' }}>
        <div>
          <div className="status-chip success" style={{ marginBottom: '24px', display: 'inline-flex', alignItems: 'center', gap: '6px' }}>
            <Sparkles size={14} />
            Powered by Gemini AI
          </div>
          <h1 style={{ marginBottom: '24px' }}>
            Nutrition tracking, <br />
            <span style={{ color: 'var(--primary-color)' }}>made beautiful.</span>
          </h1>
          <p style={{
            fontSize: '18px', color: 'var(--text-secondary)', maxWidth: 600,
            margin: '0 auto 40px', lineHeight: 1.7,
          }}>
            Snap a photo. Let AI calculate the calories and macros. Caloriyaan makes achieving your fitness goals effortless and visually stunning.
          </p>
          <div style={{ display: 'flex', gap: '16px', justifyContent: 'center', flexWrap: 'wrap' }}>
            <Link href="/auth/register" className="btn btn-primary btn-lg">
              Start Tracking <ArrowRight size={18} />
            </Link>
          </div>
        </div>

        {/* Hero Visual */}
        <div style={{ marginTop: '64px', position: 'relative' }}>
          <div style={{
            background: 'var(--surface-color)',
            border: 'var(--border-light)',
            borderRadius: '24px',
            padding: '24px',
            boxShadow: 'var(--shadow-lg)',
            maxWidth: 720,
            margin: '0 auto',
          }}>
            {/* Mock Dashboard Preview */}
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '12px', marginBottom: '16px' }}>
              {[
                { label: 'Calories', val: '1,842', unit: '/ 2,000 kcal', color: 'var(--primary-color)' },
                { label: 'Protein', val: '132g', unit: '/ 150g', color: 'var(--accent-green)' },
                { label: 'Streak', val: '14', unit: 'Days', color: 'var(--warning)' },
              ].map((s) => (
                <div key={s.label} style={{
                  padding: '16px', textAlign: 'center', background: 'var(--bg-color)', borderRadius: '16px',
                }}>
                  <div style={{ fontSize: '12px', color: 'var(--text-secondary)', fontWeight: 600, marginBottom: '8px' }}>{s.label}</div>
                  <div style={{ fontSize: '24px', fontWeight: 700, color: s.color }}>{s.val}</div>
                  <div style={{ fontSize: '12px', color: 'var(--text-muted)' }}>{s.unit}</div>
                </div>
              ))}
            </div>
            
            <div style={{ 
              padding: '20px', display: 'flex', alignItems: 'center', gap: '16px', 
              background: 'var(--bg-color)', borderRadius: '16px' 
            }}>
              <div style={{
                width: 48, height: 48, borderRadius: '12px',
                background: '#E0F2FE', display: 'flex', alignItems: 'center', justifyContent: 'center',
              }}>
                <Camera size={24} color="var(--primary-color)" />
              </div>
              <div style={{ flex: 1, textAlign: 'left' }}>
                <div style={{ fontWeight: 600, fontSize: '15px', color: 'var(--text-primary)', marginBottom: '4px' }}>AI Match: Grilled Chicken Salad</div>
                <div style={{ fontSize: '13px', color: 'var(--text-secondary)' }}>487 kcal · 32g protein · 12g carbs · 14g fat</div>
              </div>
              <div className="status-chip success">Logged</div>
            </div>
          </div>
        </div>
      </section>

      {/* ── Features ── */}
      <section style={{ padding: '80px 24px', maxWidth: 1100, margin: '0 auto' }}>
        <div style={{ textAlign: 'center', marginBottom: '48px' }}>
          <h2 style={{ marginBottom: '12px' }}>Intelligent Tools</h2>
          <p style={{ color: 'var(--text-secondary)', fontSize: '18px' }}>
            Everything you need to succeed, designed with clarity.
          </p>
        </div>
        <div className="dashboard-grid grid-cols-3">
          {features.map((f) => {
            const Icon = f.icon;
            return (
              <div key={f.title} className="raw-card" style={{ padding: '32px' }}>
                <div style={{
                  width: 56, height: 56, borderRadius: '16px',
                  background: f.bg, display: 'flex', alignItems: 'center', justifyContent: 'center',
                  marginBottom: '24px',
                }}>
                  <Icon size={28} color={f.color} />
                </div>
                <h3 style={{ fontSize: '20px', marginBottom: '12px' }}>{f.title}</h3>
                <p style={{ color: 'var(--text-secondary)', fontSize: '15px', lineHeight: 1.6 }}>{f.description}</p>
              </div>
            );
          })}
        </div>
      </section>

      {/* ── Benefits ── */}
      <section style={{ padding: '60px 24px', maxWidth: 1000, margin: '0 auto' }}>
        <div style={{
          display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '48px', alignItems: 'center',
        }}>
          <div>
            <h2 style={{ marginBottom: '24px' }}>
              Built for real people.
            </h2>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '16px' }}>
              {benefits.map((b) => (
                <div key={b} style={{ display: 'flex', alignItems: 'center', gap: '12px', color: 'var(--text-secondary)', fontSize: '16px' }}>
                  <CheckCircle2 size={20} color="var(--primary-color)" strokeWidth={2} style={{ flexShrink: 0 }} />
                  {b}
                </div>
              ))}
            </div>
          </div>
          <div className="raw-card-elevated" style={{ padding: '40px', textAlign: 'center' }}>
            <div style={{ fontSize: '48px', marginBottom: '16px' }}>🎯</div>
            <div style={{ fontSize: '32px', fontWeight: 700, color: 'var(--primary-color)', marginBottom: '8px' }}>95%</div>
            <div style={{ color: 'var(--text-secondary)', fontSize: '14px' }}>AI food detection accuracy</div>
            <div className="divider" style={{ margin: '32px 0' }} />
            <div style={{ fontSize: '48px', marginBottom: '16px' }}>⚡</div>
            <div style={{ fontSize: '32px', fontWeight: 700, color: 'var(--accent-green)', marginBottom: '8px' }}>&lt; 3s</div>
            <div style={{ color: 'var(--text-secondary)', fontSize: '14px' }}>Average photo analysis time</div>
          </div>
        </div>
      </section>

      {/* ── CTA ── */}
      <section style={{ padding: '80px 24px', textAlign: 'center' }}>
        <div className="raw-card-elevated" style={{ maxWidth: 700, margin: '0 auto', padding: '56px 32px' }}>
          <h2 style={{ marginBottom: '16px' }}>Ready to transform your habits?</h2>
          <p style={{ color: 'var(--text-secondary)', marginBottom: '32px', fontSize: '16px' }}>
            Join thousands already tracking smarter with Caloriyaan.
          </p>
          <Link href="/auth/register" className="btn btn-primary btn-lg">
            Create Free Account
          </Link>
        </div>
      </section>

      {/* ── Footer ── */}
      <footer style={{
        padding: '32px 24px',
        textAlign: 'center',
        borderTop: 'var(--border-light)',
        color: 'var(--text-muted)',
        fontSize: '14px',
      }}>
        <p>© 2026 Caloriyaan · Minimalistic & Materialistic Tracker</p>
      </footer>
    </div>
  );
}
