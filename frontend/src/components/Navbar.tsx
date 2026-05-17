'use client';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { useAuth } from '@/context/AuthContext';
import {
  Flame, LayoutDashboard, UtensilsCrossed, BarChart3,
  Droplets, Scale, User, LogOut, Zap, Menu, X
} from 'lucide-react';
import { useState } from 'react';

const navItems = [
  { href: '/dashboard', icon: LayoutDashboard, label: 'Dashboard' },
  { href: '/log-meal', icon: UtensilsCrossed, label: 'Log Meal' },
  { href: '/analytics', icon: BarChart3, label: 'Analytics' },
  { href: '/water', icon: Droplets, label: 'Hydration' },
  { href: '/weight', icon: Scale, label: 'Weight' },
  { href: '/ai', icon: Zap, label: 'AI Tools' },
  { href: '/profile', icon: User, label: 'Profile' },
];

export default function Navbar() {
  const pathname = usePathname();
  const { user, logout } = useAuth();
  const [mobileOpen, setMobileOpen] = useState(false);

  const initials = user?.name
    ? user.name.split(' ').map((n) => n[0]).join('').toUpperCase().slice(0, 2)
    : 'U';

  return (
    <>
      <nav className="nav">
        <div className="nav-inner">
          {/* Logo */}
          <Link href="/dashboard" className="nav-logo">
            <div className="nav-logo-icon">
              <Flame size={18} color="#080d14" strokeWidth={2.5} />
            </div>
            NutriAI
          </Link>

          {/* Desktop Nav Links */}
          <div className="nav-links" style={{ display: 'flex' }}>
            {navItems.map(({ href, icon: Icon, label }) => (
              <Link
                key={href}
                href={href}
                className={`nav-link ${pathname === href || pathname.startsWith(href + '/') ? 'active' : ''}`}
              >
                <Icon size={15} />
                <span className="hide-mobile">{label}</span>
              </Link>
            ))}
          </div>

          {/* Right side */}
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
            {user && (
              <Link href="/profile" style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', textDecoration: 'none' }}>
                <div className="avatar" style={{ width: 32, height: 32, fontSize: '0.75rem' }}>{initials}</div>
                <span className="hide-mobile" style={{ fontSize: '0.85rem', color: 'var(--text-secondary)', fontWeight: 500 }}>
                  {user.name.split(' ')[0]}
                </span>
              </Link>
            )}
            <button onClick={logout} className="btn btn-ghost btn-sm" title="Logout">
              <LogOut size={15} />
              <span className="hide-mobile">Logout</span>
            </button>
            <button
              className="btn btn-ghost btn-sm btn-icon show-mobile"
              onClick={() => setMobileOpen(!mobileOpen)}
            >
              {mobileOpen ? <X size={18} /> : <Menu size={18} />}
            </button>
          </div>
        </div>
      </nav>

      {/* Mobile Menu */}
      {mobileOpen && (
        <div style={{
          position: 'fixed', top: 64, left: 0, right: 0, bottom: 0,
          background: 'rgba(8,13,20,0.98)', zIndex: 99, backdropFilter: 'blur(20px)',
          padding: '1.5rem', display: 'flex', flexDirection: 'column', gap: '0.5rem',
          animation: 'slideDown 0.2s ease'
        }}>
          {navItems.map(({ href, icon: Icon, label }) => (
            <Link
              key={href}
              href={href}
              onClick={() => setMobileOpen(false)}
              style={{
                display: 'flex', alignItems: 'center', gap: '1rem',
                padding: '1rem 1.25rem',
                borderRadius: 'var(--radius-md)',
                color: pathname === href ? 'var(--accent-green)' : 'var(--text-secondary)',
                background: pathname === href ? 'rgba(0,214,143,0.1)' : 'transparent',
                textDecoration: 'none', fontSize: '1rem', fontWeight: 500,
                border: pathname === href ? '1px solid rgba(0,214,143,0.2)' : '1px solid transparent',
              }}
            >
              <Icon size={20} />
              {label}
            </Link>
          ))}
        </div>
      )}

      <style>{`
        @media (max-width: 768px) { .hide-mobile { display: none !important; } }
        @media (min-width: 769px) { .show-mobile { display: none !important; } }
      `}</style>
    </>
  );
}
