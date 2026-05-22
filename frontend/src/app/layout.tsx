import type { Metadata } from "next";
import "./globals.css";
import ClientLayout from "@/components/ClientLayout";

export const metadata: Metadata = {
  title: "Caloriyaan — Minimalist AI Calorie Tracker",
  description: "Track your nutrition intelligently with AI food recognition. Log meals by photo, monitor macros, and reach your fitness goals.",
  keywords: "calorie tracker, AI nutrition, meal logging, macro tracking, fitness app",
  authors: [{ name: "Akash Singh" }],
  openGraph: {
    title: "Caloriyaan — Minimalist AI Calorie Tracker",
    description: "Track your nutrition intelligently with AI food recognition.",
    type: "website",
  },
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en" data-scroll-behavior="smooth">
      <head>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossOrigin="anonymous" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=5" />
        <meta name="theme-color" content="#FFFFFF" />
      </head>
      <body>
        <ClientLayout>{children}</ClientLayout>
      </body>
    </html>
  );
}
