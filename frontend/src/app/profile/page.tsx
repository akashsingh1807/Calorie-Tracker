'use client';
import { useState, useEffect } from 'react';
import { useAuth } from '@/context/AuthContext';
import { userAPI } from '@/lib/api';
import { User, Settings, Shield, Bell, Save, Loader2, Camera } from 'lucide-react';

export default function ProfilePage() {
  const { user, login } = useAuth();
  const [loading, setLoading] = useState(false);
  const [formData, setFormData] = useState({
    name: '',
    dailyCalorieGoal: 2000,
    currentWeight: 0,
    height: 0,
    goal: 'MAINTAIN'
  });

  useEffect(() => {
    if (user) {
      setFormData({
        name: user.name || '',
        dailyCalorieGoal: user.dailyCalorieGoal || 2000,
        currentWeight: user.currentWeight || 0,
        height: user.height || 0,
        goal: user.goal || 'MAINTAIN'
      });
    }
  }, [user]);

  const handleUpdate = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    try {
      await userAPI.updateMe(formData);
      // Refresh user context if possible, or show success
      alert('Profile updated successfully!');
    } catch (err) {
      console.error('Update failed:', err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="page-wrapper">
      <div className="dashboard-main">
        <div style={{ marginBottom: '2rem' }}>
          <h1 style={{ fontSize: '1.6rem', marginBottom: '0.25rem' }}>Profile Settings</h1>
          <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Manage your personal details and fitness goals</p>
        </div>

        <div className="dashboard-grid grid-cols-3">
          {/* Sidebar */}
          <div className="raw-card" style={{ height: 'fit-content' }}>
            <div style={{ padding: '1.5rem', textAlign: 'center', borderBottom: '1px solid var(--border-subtle)' }}>
              <div style={{ position: 'relative', width: 80, height: 80, margin: '0 auto 1rem' }}>
                <div className="avatar" style={{ width: '100%', height: '100%', fontSize: '1.5rem' }}>
                  {formData.name.slice(0, 2).toUpperCase()}
                </div>
                <button style={{ position: 'absolute', bottom: 0, right: 0, background: 'var(--accent-blue)', borderRadius: '50%', padding: '0.4rem', border: 'none', color: 'white' }}>
                  <Camera size={14} />
                </button>
              </div>
              <h3 style={{ fontSize: '1.1rem', marginBottom: '0.25rem' }}>{formData.name}</h3>
              <p style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>{user?.email}</p>
            </div>
            <div style={{ padding: '0.75rem' }}>
              {[
                { icon: User, label: 'Personal Info', active: true },
                { icon: Settings, label: 'Preferences' },
                { icon: Shield, label: 'Security' },
                { icon: Bell, label: 'Notifications' },
              ].map(({ icon: Icon, label, active }) => (
                <button key={label} className={`btn btn-ghost w-full`} style={{ justifyContent: 'flex-start', gap: '0.75rem', color: active ? 'var(--accent-blue)' : 'inherit' }}>
                  <Icon size={16} /> {label}
                </button>
              ))}
            </div>
          </div>

          {/* Form */}
          <div className="raw-card col-span-2" style={{ padding: '2rem' }}>
            <form onSubmit={handleUpdate}>
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1.5rem', marginBottom: '1.5rem' }}>
                <div className="form-group">
                  <label>Full Name</label>
                  <input 
                    type="text" 
                    value={formData.name} 
                    onChange={e => setFormData({...formData, name: e.target.value})}
                    className="input" 
                  />
                </div>
                <div className="form-group">
                  <label>Daily Calorie Goal</label>
                  <input 
                    type="number" 
                    value={formData.dailyCalorieGoal} 
                    onChange={e => setFormData({...formData, dailyCalorieGoal: parseInt(e.target.value)})}
                    className="input" 
                  />
                </div>
                <div className="form-group">
                  <label>Current Weight (kg)</label>
                  <input 
                    type="number" 
                    step="0.1"
                    value={formData.currentWeight} 
                    onChange={e => setFormData({...formData, currentWeight: parseFloat(e.target.value)})}
                    className="input" 
                  />
                </div>
                <div className="form-group">
                  <label>Height (cm)</label>
                  <input 
                    type="number" 
                    value={formData.height} 
                    onChange={e => setFormData({...formData, height: parseInt(e.target.value)})}
                    className="input" 
                  />
                </div>
                <div className="form-group col-span-2">
                  <label>Fitness Goal</label>
                  <select 
                    value={formData.goal} 
                    onChange={e => setFormData({...formData, goal: e.target.value})}
                    className="input"
                  >
                    <option value="LOSE_WEIGHT">Lose Weight</option>
                    <option value="MAINTAIN">Maintain Weight</option>
                    <option value="GAIN_MUSCLE">Gain Muscle</option>
                  </select>
                </div>
              </div>
              
              <div style={{ display: 'flex', justifyContent: 'flex-end', gap: '1rem', marginTop: '2rem', paddingTop: '1.5rem', borderTop: '1px solid var(--border-subtle)' }}>
                <button type="button" className="btn btn-ghost">Cancel</button>
                <button type="submit" disabled={loading} className="btn btn-primary">
                  {loading ? <Loader2 className="animate-spin" size={18} /> : <Save size={18} />}
                  Save Changes
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
