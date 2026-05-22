'use client';
import { useState } from 'react';
import { aiAPI, mediaAPI } from '@/lib/api';
import { Zap, Camera, Send, Loader2, Apple, Info, Sparkles } from 'lucide-react';

export default function AIPage() {
  const [text, setText] = useState('');
  const [analyzing, setAnalyzing] = useState(false);
  const [result, setResult] = useState<any>(null);
  const [file, setFile] = useState<File | null>(null);
  const [preview, setPreview] = useState<string | null>(null);

  const handleTextAnalyze = async () => {
    if (!text) return;
    setAnalyzing(true);
    try {
      const res = await aiAPI.analyzeText(text);
      setResult(res.data);
    } catch (err) {
      console.error('AI Analysis failed:', err);
    } finally {
      setAnalyzing(false);
    }
  };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const selected = e.target.files?.[0];
    if (selected) {
      setFile(selected);
      setPreview(URL.createObjectURL(selected));
    }
  };

  const handleImageAnalyze = async () => {
    if (!file) return;
    setAnalyzing(true);
    try {
      // 1. Upload
      const uploadRes = await mediaAPI.upload(file);
      const imageUrl = uploadRes.data.imageUrl || uploadRes.data.url;
      
      // 2. Analyze
      const analyzeRes = await aiAPI.analyzeImage(imageUrl);
      setResult(analyzeRes.data);
    } catch (err) {
      console.error('Image analysis failed:', err);
    } finally {
      setAnalyzing(false);
    }
  };

  return (
    <div className="page-wrapper">
      <div className="dashboard-main">
        <div style={{ marginBottom: '2rem' }}>
          <h1 style={{ fontSize: '1.6rem', marginBottom: '0.25rem' }}>AI Insights</h1>
          <p style={{ color: 'var(--text-secondary)', fontSize: '0.9rem' }}>Powered by Gemini for precision nutrition</p>
        </div>

        <div className="dashboard-grid grid-cols-2">
          {/* Input Section */}
          <div style={{ display: 'grid', gap: '1.5rem' }}>
            <div className="raw-card" style={{ padding: '1.5rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', marginBottom: '1.25rem' }}>
                <Zap size={18} color="var(--accent-blue)" />
                <h3 style={{ fontSize: '1rem' }}>Smart Text Analysis</h3>
              </div>
              <textarea
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder="Example: I had 2 scrambled eggs with toast and a coffee"
                className="input"
                style={{ width: '100%', minHeight: '100px', marginBottom: '1rem', resize: 'none' }}
              />
              <button 
                onClick={handleTextAnalyze} 
                disabled={analyzing || !text}
                className="btn btn-primary w-full"
              >
                {analyzing ? <Loader2 className="animate-spin" size={18} /> : <Sparkles size={18} />}
                Analyze Text
              </button>
            </div>

            <div className="raw-card" style={{ padding: '1.5rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', marginBottom: '1.25rem' }}>
                <Camera size={18} color="var(--accent-orange)" />
                <h3 style={{ fontSize: '1rem' }}>Visual Recognition</h3>
              </div>
              
              {preview ? (
                <div style={{ position: 'relative', width: '100%', height: '160px', borderRadius: 'var(--radius-md)', overflow: 'hidden', marginBottom: '1rem' }}>
                  <img src={preview} alt="Preview" style={{ width: '100%', height: '100%', objectFit: 'cover' }} />
                  <button 
                    onClick={() => {setFile(null); setPreview(null);}} 
                    className="btn btn-sm" 
                    style={{ position: 'absolute', top: 8, right: 8, background: 'rgba(0,0,0,0.5)', border: 'none' }}
                  >
                    Change
                  </button>
                </div>
              ) : (
                <div 
                  onClick={() => document.getElementById('ai-file')?.click()}
                  style={{ 
                    width: '100%', height: '160px', border: '2px dashed var(--border-subtle)', 
                    borderRadius: 'var(--radius-md)', display: 'flex', flexDirection: 'column',
                    alignItems: 'center', justifyContent: 'center', cursor: 'pointer',
                    color: 'var(--text-muted)', marginBottom: '1rem'
                  }}
                >
                  <Camera size={32} style={{ marginBottom: '0.5rem' }} />
                  <span>Upload meal photo</span>
                </div>
              )}
              
              <input type="file" id="ai-file" hidden accept="image/*" onChange={handleFileChange} />
              
              <button 
                onClick={handleImageAnalyze} 
                disabled={analyzing || !file}
                className="btn btn-secondary w-full"
              >
                {analyzing ? <Loader2 className="animate-spin" size={18} /> : 'Scan Food'}
              </button>
            </div>
          </div>

          {/* Results Section */}
          <div className="raw-card" style={{ padding: '2rem', display: 'flex', flexDirection: 'column' }}>
            <h3 style={{ fontSize: '1.1rem', marginBottom: '1.5rem', display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
              <Info size={18} /> Analysis Results
            </h3>
            
            {result ? (
              <div style={{ animation: 'fadeIn 0.3s ease' }}>
                <div style={{ fontSize: '1.25rem', fontWeight: 700, marginBottom: '1rem', color: 'var(--accent-green)' }}>
                  Estimated Calories: {result.totalCalories || 0} kcal
                </div>
                
                <div style={{ display: 'grid', gap: '1rem' }}>
                  {result.foodItems?.map((item: any, idx: number) => (
                    <div key={idx} style={{ padding: '1rem', background: 'rgba(255,255,255,0.02)', borderRadius: 'var(--radius-md)' }}>
                      <div style={{ fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                        <Apple size={14} /> {item.name}
                      </div>
                      <div style={{ fontSize: '0.8rem', color: 'var(--text-muted)', marginTop: '0.25rem' }}>
                        {item.calories} cal • P: {item.protein}g • C: {item.carbs}g • F: {item.fats}g
                      </div>
                    </div>
                  ))}
                </div>

                <div style={{ marginTop: '2rem', padding: '1rem', border: '1px solid rgba(77,159,255,0.2)', borderRadius: 'var(--radius-md)', background: 'rgba(77,159,255,0.05)' }}>
                  <p style={{ fontSize: '0.85rem', color: 'var(--text-secondary)' }}>
                    <strong>Note:</strong> These are AI-generated estimates. Actual nutritional values may vary based on ingredients and preparation.
                  </p>
                </div>
              </div>
            ) : analyzing ? (
              <div style={{ flex: 1, display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', color: 'var(--text-muted)' }}>
                <Loader2 className="animate-spin" size={40} style={{ marginBottom: '1rem' }} />
                <p>Gemini is thinking...</p>
              </div>
            ) : (
              <div style={{ flex: 1, display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', color: 'var(--text-muted)', textAlign: 'center' }}>
                <Sparkles size={40} style={{ marginBottom: '1rem', opacity: 0.2 }} />
                <p>Analyze text or scan an image to see nutritional insights</p>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}
