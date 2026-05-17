'use client';
import { AuthProvider } from '@/context/AuthContext';
import Navbar from '@/components/Navbar';
import { usePathname } from 'next/navigation';

const publicPaths = ['/', '/auth/login', '/auth/register'];

export default function ClientLayout({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();
  const isPublic = publicPaths.includes(pathname);

  return (
    <AuthProvider>
      {!isPublic && <Navbar />}
      {children}
    </AuthProvider>
  );
}
