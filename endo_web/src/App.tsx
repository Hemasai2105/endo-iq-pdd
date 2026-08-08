import React, { useState, useEffect } from 'react';
import { supabase } from './SupabaseClient';
import { 
  Activity, Users, FileText, Calendar, LogOut, Moon, Sun, 
  Plus, Search, Edit2, Trash2, CheckCircle2, ChevronRight, User, Key, Eye, Shield, Lock, Clock, FileDown, RefreshCw
} from 'lucide-react';

interface Patient {
  id?: string;
  doctor_id?: string;
  patient_id: string;
  full_name: string;
  age: string;
  gender: string;
  primary_diagnosis: string;
  selected_teeth: number[];
  conditions: string[];
  smoking: boolean;
  alcohol: boolean;
  created_at?: string;
}

interface Report {
  id?: string;
  doctor_id?: string;
  patient_uuid: string;
  report_data: TreatmentStage[];
  created_at?: string;
}

interface TreatmentStage {
  id: number;
  title: string;
  description: string;
  aiText: string;
  durationMin: number;
}

interface Appointment {
  id?: string;
  doctor_id?: string;
  patient_uuid: string;
  appointment_date: string;
  status: string;
  created_at?: string;
}

export default function App() {
  const [user, setUser] = useState<any>(null);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [fullName, setFullName] = useState('');
  const [isSignUp, setIsSignUp] = useState(false);
  const [authError, setAuthError] = useState('');
  const [authLoading, setAuthLoading] = useState(false);

  // Navigation and active states
  const [currentTab, setCurrentTab] = useState<'dashboard' | 'patients' | 'reports' | 'appointments' | 'settings'>('dashboard');
  const [darkMode, setDarkMode] = useState(false);

  // Data states
  const [patients, setPatients] = useState<Patient[]>([]);
  const [reports, setReports] = useState<Report[]>([]);
  const [appointments, setAppointments] = useState<Appointment[]>([]);
  const [loading, setLoading] = useState(false);

  // Dashboard metrics
  const [stats, setStats] = useState({
    todayPatients: 0,
    weekPatients: 0,
    totalReports: 0,
    totalAppointments: 0
  });

  // CRUD States
  const [searchQuery, setSearchQuery] = useState('');
  const [isPatientFormOpen, setIsPatientFormOpen] = useState(false);
  const [editingPatient, setEditingPatient] = useState<Patient | null>(null);
  const [selectedPatientForReport, setSelectedPatientForReport] = useState<Patient | null>(null);
  const [activeReportDetail, setActiveReportDetail] = useState<Report | null>(null);

  // Form states
  const [patientForm, setPatientForm] = useState({
    fullName: '',
    age: '',
    gender: 'Male',
    primaryDiagnosis: 'Root Fracture',
    selectedTeeth: [] as number[],
    conditions: [] as string[],
    smoking: false,
    alcohol: false
  });

  // Check auth state on launch
  useEffect(() => {
    supabase.auth.getSession().then(({ data: { session } }) => {
      setUser(session?.user ?? null);
    });

    const { data: { subscription } } = supabase.auth.onAuthStateChange((_event, session) => {
      setUser(session?.user ?? null);
    });

    return () => subscription.unsubscribe();
  }, []);

  // Fetch data when user logs in
  useEffect(() => {
    if (user) {
      fetchData();
    }
  }, [user]);

  const fetchData = async () => {
    setLoading(true);
    try {
      // 1. Fetch Patients
      const { data: patientsData, error: pError } = await supabase
        .from('patients')
        .select('*')
        .order('created_at', { ascending: false });

      if (pError) throw pError;
      const loadedPatients = patientsData || [];
      setPatients(loadedPatients);

      // 2. Fetch Reports
      const { data: reportsData, error: rError } = await supabase
        .from('reports')
        .select('*')
        .order('created_at', { ascending: false });

      if (rError) throw rError;
      setReports(reportsData || []);

      // 3. Fetch Appointments
      const { data: appData, error: aError } = await supabase
        .from('appointments')
        .select('*')
        .order('created_at', { ascending: false });

      if (aError) throw aError;
      const loadedApps = appData || [];
      setAppointments(loadedApps);

      // Calculate Stats
      const today = new Date().toISOString().split('T')[0];
      const oneWeekAgo = new Date();
      oneWeekAgo.setDate(oneWeekAgo.getDate() - 7);

      const todayP = loadedPatients.filter((p: any) => p.created_at && p.created_at.startsWith(today)).length;
      const weekP = loadedPatients.filter((p: any) => p.created_at && new Date(p.created_at) >= oneWeekAgo).length;

      setStats({
        todayPatients: todayP,
        weekPatients: weekP,
        totalReports: reportsData?.length || 0,
        totalAppointments: loadedApps.length
      });
    } catch (e: any) {
      console.error(e);
    } finally {
      setLoading(false);
    }
  };

  const handleAuth = async (e: React.FormEvent) => {
    e.preventDefault();
    setAuthError('');
    setAuthLoading(true);

    try {
      if (isSignUp) {
        const { data, error } = await supabase.auth.signUp({
          email,
          password,
          options: {
            data: {
              full_name: fullName
            }
          }
        });
        if (error) throw error;
        alert('Signup successful! Check your email for verification link.');
        setIsSignUp(false);
      } else {
        const { data, error } = await supabase.auth.signInWithPassword({
          email,
          password
        });
        if (error) throw error;
      }
    } catch (e: any) {
      setAuthError(e.message || 'An error occurred during authentication.');
    } finally {
      setAuthLoading(false);
    }
  };

  const handleLogout = async () => {
    await supabase.auth.signOut();
    setUser(null);
  };

  const savePatient = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!patientForm.fullName.trim() || !patientForm.age) {
      alert('Please fill out Name and Age.');
      return;
    }

    setLoading(true);
    try {
      if (editingPatient) {
        // Update
        const { error } = await supabase
          .from('patients')
          .update({
            full_name: patientForm.fullName,
            age: patientForm.age,
            gender: patientForm.gender,
            primary_diagnosis: patientForm.primaryDiagnosis,
            selected_teeth: patientForm.selectedTeeth,
            conditions: patientForm.conditions,
            smoking: patientForm.smoking,
            alcohol: patientForm.alcohol
          })
          .eq('id', editingPatient.id);

        if (error) throw error;
      } else {
        // Insert new
        const patientId = "EN-" + Math.floor(1000 + Math.random() * 9000);
        const { error } = await supabase
          .from('patients')
          .insert({
            doctor_id: user?.id,
            patient_id: patientId,
            full_name: patientForm.fullName,
            age: patientForm.age,
            gender: patientForm.gender,
            primary_diagnosis: patientForm.primaryDiagnosis,
            selected_teeth: patientForm.selectedTeeth,
            conditions: patientForm.conditions,
            smoking: patientForm.smoking,
            alcohol: patientForm.alcohol
          });

        if (error) throw error;
      }

      setIsPatientFormOpen(false);
      setEditingPatient(null);
      resetPatientForm();
      fetchData();
    } catch (e: any) {
      alert(e.message || 'Error saving patient.');
    } finally {
      setLoading(false);
    }
  };

  const resetPatientForm = () => {
    setPatientForm({
      fullName: '',
      age: '',
      gender: 'Male',
      primaryDiagnosis: 'Root Fracture',
      selectedTeeth: [],
      conditions: [],
      smoking: false,
      alcohol: false
    });
  };

  const startEditPatient = (p: Patient) => {
    setEditingPatient(p);
    setPatientForm({
      fullName: p.full_name,
      age: p.age,
      gender: p.gender,
      primaryDiagnosis: p.primary_diagnosis,
      selectedTeeth: p.selected_teeth,
      conditions: p.conditions,
      smoking: p.smoking,
      alcohol: p.alcohol
    });
    setIsPatientFormOpen(true);
  };

  const deletePatient = async (id: string) => {
    if (!confirm('Are you sure you want to delete this patient record?')) return;
    setLoading(true);
    try {
      const { error } = await supabase.from('patients').delete().eq('id', id);
      if (error) throw error;
      fetchData();
    } catch (e: any) {
      alert(e.message || 'Error deleting patient.');
    } finally {
      setLoading(false);
    }
  };

  // Endo AI Report generation simulation (mocked parser client-side)
  const generateAiReport = async (p: Patient) => {
    setLoading(true);
    try {
      const conditionsText = p.conditions.length > 0 ? `Considering patient's ${p.conditions.join(', ')}, ` : "";
      const teethText = p.selected_teeth.length > 0 ? `for Tooth ${p.selected_teeth.join(', ')}` : "for the affected tooth";
      const diagnosisText = p.primary_diagnosis ? `based on ${p.primary_diagnosis}` : "based on diagnosis";

      const stages: TreatmentStage[] = [
        {
          id: 1,
          title: "AI Medicine Suggestion",
          description: "Dynamic analysis generated based on patient profile and diagnosis.",
          aiText: `${conditionsText}prescribe Amoxicillin 500mg and Ibuprofen 400mg PRN.`,
          durationMin: 15
        },
        {
          id: 2,
          title: "AI Equipment Recognition",
          description: "Dynamic analysis generated based on patient profile and diagnosis.",
          aiText: `Apex locator, rotary files, and digital radiography required ${teethText}.`,
          durationMin: 30
        },
        {
          id: 3,
          title: "AI Treatment Guidance",
          description: "Dynamic analysis generated based on patient profile and diagnosis.",
          aiText: `Proceed with standard root canal therapy ${diagnosisText}. Ensure isolation.`,
          durationMin: 45
        },
        {
          id: 4,
          title: "Material Usage Recording",
          description: "Dynamic analysis generated based on patient profile and diagnosis.",
          aiText: "NaOCl 5%, EDTA 17%, gutta-percha points, and AH Plus sealer used.",
          durationMin: 10
        }
      ];

      const { error } = await supabase.from('reports').insert({
        doctor_id: user?.id,
        patient_uuid: p.id,
        report_data: stages
      });

      if (error) throw error;
      alert('Endo AI Report generated and saved successfully!');
      fetchData();
      setCurrentTab('reports');
    } catch (e: any) {
      alert(e.message || 'Error generating AI report.');
    } finally {
      setLoading(false);
    }
  };

  const getPatientName = (uuid: string) => {
    return patients.find(p => p.id === uuid)?.full_name || 'Unknown Patient';
  };

  const filteredPatients = patients.filter(p => 
    p.full_name.toLowerCase().includes(searchQuery.toLowerCase()) ||
    p.patient_id.toLowerCase().includes(searchQuery.toLowerCase()) ||
    p.primary_diagnosis.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div className={`app-container ${darkMode ? 'dark-mode' : ''}`}>
      {/* AUTH SCREEN */}
      {!user ? (
        <div className="auth-wrapper">
          <div className="auth-card">
            <div className="auth-header">
              <div className="logo-badge">
                <Activity size={32} className="pulse-icon" />
              </div>
              <h1>Endo AI Portal</h1>
              <p>Dental Hospital Management & Analysis System</p>
            </div>
            
            <form onSubmit={handleAuth} className="auth-form">
              {isSignUp && (
                <div className="input-group">
                  <label><User size={16} /> Full Name</label>
                  <input 
                    type="text" 
                    value={fullName} 
                    onChange={e => setFullName(e.target.value)} 
                    placeholder="Dr. John Doe"
                    required
                  />
                </div>
              )}

              <div className="input-group">
                <label><FileText size={16} /> Email Address</label>
                <input 
                  type="email" 
                  value={email} 
                  onChange={e => setEmail(e.target.value)} 
                  placeholder="doctor@endoai.com"
                  required
                />
              </div>

              <div className="input-group">
                <label><Key size={16} /> Password</label>
                <input 
                  type="password" 
                  value={password} 
                  onChange={e => setPassword(e.target.value)} 
                  placeholder="••••••••"
                  required
                />
              </div>

              {authError && <div className="auth-error-msg">{authError}</div>}

              <button type="submit" className="btn-primary auth-submit" disabled={authLoading}>
                {authLoading ? 'Please wait...' : isSignUp ? 'Sign Up' : 'Sign In'}
              </button>
            </form>

            <div className="auth-footer">
              <button onClick={() => setIsSignUp(!isSignUp)} className="btn-link">
                {isSignUp ? 'Already have an account? Sign In' : "Don't have an account? Sign Up"}
              </button>
            </div>
          </div>
        </div>
      ) : (
        /* MAIN APPLICATION LAYOUT */
        <div className="main-layout">
          {/* Sidebar */}
          <aside className="sidebar">
            <div className="sidebar-brand">
              <Activity size={24} className="accent-color" />
              <span>Endo AI</span>
            </div>

            <div className="doctor-profile-summary">
              <div className="profile-avatar">
                {user.email?.[0].toUpperCase()}
              </div>
              <div className="profile-info">
                <h4>{user.user_metadata?.full_name || 'Dr. Specialist'}</h4>
                <p>{user.email}</p>
              </div>
            </div>

            <nav className="sidebar-nav">
              <button 
                className={`nav-item ${currentTab === 'dashboard' ? 'active' : ''}`}
                onClick={() => setCurrentTab('dashboard')}
              >
                <Users size={18} /> Dashboard
              </button>
              <button 
                className={`nav-item ${currentTab === 'patients' ? 'active' : ''}`}
                onClick={() => setCurrentTab('patients')}
              >
                <Users size={18} /> Patients
              </button>
              <button 
                className={`nav-item ${currentTab === 'reports' ? 'active' : ''}`}
                onClick={() => { setCurrentTab('reports'); setActiveReportDetail(null); }}
              >
                <FileText size={18} /> AI Reports
              </button>
              <button 
                className={`nav-item ${currentTab === 'appointments' ? 'active' : ''}`}
                onClick={() => setCurrentTab('appointments')}
              >
                <Calendar size={18} /> Appointments
              </button>
              <button 
                className={`nav-item ${currentTab === 'settings' ? 'active' : ''}`}
                onClick={() => setCurrentTab('settings')}
              >
                <Shield size={18} /> Security & System
              </button>
            </nav>

            <div className="sidebar-footer">
              <button onClick={() => setDarkMode(!darkMode)} className="theme-toggle">
                {darkMode ? <Sun size={18} /> : <Moon size={18} />} {darkMode ? 'Light Mode' : 'Dark Mode'}
              </button>
              <button onClick={handleLogout} className="logout-btn">
                <LogOut size={18} /> Logout
              </button>
            </div>
          </aside>

          {/* Main Workspace Area */}
          <main className="workspace-area">
            {/* Header */}
            <header className="workspace-header">
              <h2>{currentTab.charAt(0).toUpperCase() + currentTab.slice(1)} Workspace</h2>
              <div className="header-actions">
                <button onClick={fetchData} className="btn-secondary" title="Sync Database">
                  <RefreshCw size={16} /> Sync
                </button>
                <button 
                  onClick={() => { resetPatientForm(); setEditingPatient(null); setIsPatientFormOpen(true); }}
                  className="btn-primary"
                >
                  <Plus size={16} /> New Patient
                </button>
              </div>
            </header>

            {/* Inner Dashboard Tabs */}
            {currentTab === 'dashboard' && (
              <div className="dashboard-view animate-fade-in">
                {/* Stats Grid */}
                <div className="stats-grid">
                  <div className="stat-card">
                    <div className="stat-icon-wrapper user-blue">
                      <Users size={24} />
                    </div>
                    <div className="stat-value">{stats.todayPatients}</div>
                    <div className="stat-label">Today's Patients</div>
                  </div>
                  <div className="stat-card">
                    <div className="stat-icon-wrapper user-green">
                      <Users size={24} />
                    </div>
                    <div className="stat-value">{stats.weekPatients}</div>
                    <div className="stat-label">Patients This Week</div>
                  </div>
                  <div className="stat-card">
                    <div className="stat-icon-wrapper report-purple">
                      <FileText size={24} />
                    </div>
                    <div className="stat-value">{stats.totalReports}</div>
                    <div className="stat-label">Generated AI Reports</div>
                  </div>
                  <div className="stat-card">
                    <div className="stat-icon-wrapper app-yellow">
                      <Calendar size={24} />
                    </div>
                    <div className="stat-value">{stats.totalAppointments}</div>
                    <div className="stat-label">Pending Appointments</div>
                  </div>
                </div>

                {/* Dashboard Lists */}
                <div className="dashboard-content-split">
                  <div className="recent-card">
                    <h3>Recent Patients</h3>
                    <div className="table-responsive">
                      <table>
                        <thead>
                          <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Diagnosis</th>
                          </tr>
                        </thead>
                        <tbody>
                          {patients.slice(0, 5).map(p => (
                            <tr key={p.id}>
                              <td className="bold-id">{p.patient_id}</td>
                              <td>{p.full_name}</td>
                              <td>{p.age} yrs</td>
                              <td><span className="badge-tag">{p.primary_diagnosis}</span></td>
                            </tr>
                          ))}
                          {patients.length === 0 && (
                            <tr>
                              <td colSpan={4} className="text-center">No patients found. Create one to begin.</td>
                            </tr>
                          )}
                        </tbody>
                      </table>
                    </div>
                  </div>

                  <div className="recent-card">
                    <h3>AI Treatment Pipeline</h3>
                    <div className="pipeline-list">
                      {reports.slice(0, 4).map(rep => (
                        <div key={rep.id} className="pipeline-item">
                          <div className="pipeline-indicator"></div>
                          <div className="pipeline-details">
                            <div className="pipeline-name">{getPatientName(rep.patient_uuid)}</div>
                            <div className="pipeline-stages-count">
                              {rep.report_data.length} analysis stages ready
                            </div>
                          </div>
                          <button 
                            onClick={() => { setActiveReportDetail(rep); setCurrentTab('reports'); }}
                            className="btn-icon"
                          >
                            <ChevronRight size={18} />
                          </button>
                        </div>
                      ))}
                      {reports.length === 0 && (
                        <div className="text-center pad-20 text-muted">No generated reports.</div>
                      )}
                    </div>
                  </div>
                </div>
              </div>
            )}

            {currentTab === 'patients' && (
              <div className="patients-view animate-fade-in">
                {/* Search / Filter Toolbar */}
                <div className="toolbar">
                  <div className="search-box">
                    <Search size={18} />
                    <input 
                      type="text" 
                      placeholder="Search patients by name, ID or diagnosis..." 
                      value={searchQuery}
                      onChange={e => setSearchQuery(e.target.value)}
                    />
                  </div>
                </div>

                {/* Patient List */}
                <div className="table-card">
                  <div className="table-responsive">
                    <table>
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Full Name</th>
                          <th>Age / Gender</th>
                          <th>Diagnosis</th>
                          <th>Teeth</th>
                          <th>Conditions</th>
                          <th>Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                        {filteredPatients.map(p => (
                          <tr key={p.id}>
                            <td className="bold-id">{p.patient_id}</td>
                            <td>
                              <div className="patient-name-cell">{p.full_name}</div>
                            </td>
                            <td>{p.age} / {p.gender}</td>
                            <td><span className="badge-tag">{p.primary_diagnosis}</span></td>
                            <td>{p.selected_teeth.join(', ') || 'None'}</td>
                            <td>
                              {p.conditions.map((c, i) => (
                                <span key={i} className="mini-tag">{c}</span>
                              ))}
                              {p.smoking && <span className="mini-tag warning">Smoking</span>}
                              {p.alcohol && <span className="mini-tag warning">Alcohol</span>}
                              {p.conditions.length === 0 && !p.smoking && !p.alcohol && 'None'}
                            </td>
                            <td>
                              <div className="action-buttons-group">
                                <button 
                                  onClick={() => generateAiReport(p)}
                                  className="btn-ai"
                                  title="Run Endo AI Analysis"
                                >
                                  Run AI
                                </button>
                                <button 
                                  onClick={() => startEditPatient(p)}
                                  className="btn-edit"
                                  title="Edit Patient"
                                >
                                  <Edit2 size={14} />
                                </button>
                                <button 
                                  onClick={() => p.id && deletePatient(p.id)}
                                  className="btn-delete"
                                  title="Delete Patient"
                                >
                                  <Trash2 size={14} />
                                </button>
                              </div>
                            </td>
                          </tr>
                        ))}
                        {filteredPatients.length === 0 && (
                          <tr>
                            <td colSpan={7} className="text-center text-muted pad-20">
                              No matching patients found.
                            </td>
                          </tr>
                        )}
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            )}

            {currentTab === 'reports' && (
              <div className="reports-view animate-fade-in">
                {activeReportDetail ? (
                  /* REPORT DETAIL VIEW */
                  <div className="report-detail-card">
                    <div className="report-detail-header">
                      <div>
                        <h3>AI Dental Report Summary</h3>
                        <p className="patient-ref-label">
                          Patient: <strong>{getPatientName(activeReportDetail.patient_uuid)}</strong>
                        </p>
                      </div>
                      <button onClick={() => setActiveReportDetail(null)} className="btn-secondary">
                        Back to List
                      </button>
                    </div>

                    <div className="report-stages-container">
                      {activeReportDetail.report_data.map(stage => (
                        <div key={stage.id} className="report-stage-item">
                          <div className="stage-header-line">
                            <span className="stage-num">#{stage.id}</span>
                            <h4>{stage.title}</h4>
                            <span className="stage-duration"><Clock size={12} /> {stage.durationMin} mins</span>
                          </div>
                          <p className="stage-desc">{stage.description}</p>
                          <div className="ai-insight-box">
                            <div className="ai-insight-label">AI Diagnostic Output:</div>
                            <p className="ai-insight-text">{stage.aiText}</p>
                          </div>
                        </div>
                      ))}
                    </div>
                  </div>
                ) : (
                  /* LIST OF REPORTS */
                  <div className="reports-list-grid">
                    {reports.map(rep => (
                      <div key={rep.id} className="report-card">
                        <div className="report-card-header">
                          <FileText className="accent-color" size={24} />
                          <div>
                            <h4>{getPatientName(rep.patient_uuid)}</h4>
                            <span className="report-date">
                              {rep.created_at ? new Date(rep.created_at).toLocaleDateString() : 'Just now'}
                            </span>
                          </div>
                        </div>
                        <div className="report-card-body">
                          <p>{rep.report_data.length} analysis sections generated.</p>
                          <div className="preview-insights">
                            <strong>Key Suggestion:</strong> {rep.report_data[0]?.aiText.substring(0, 60)}...
                          </div>
                        </div>
                        <div className="report-card-actions">
                          <button onClick={() => setActiveReportDetail(rep)} className="btn-primary btn-sm">
                            <Eye size={14} /> View Report
                          </button>
                        </div>
                      </div>
                    ))}
                    {reports.length === 0 && (
                      <div className="full-width text-center text-muted pad-40">
                        No AI Reports found. Run analysis from the Patients tab.
                      </div>
                    )}
                  </div>
                )}
              </div>
            )}

            {currentTab === 'appointments' && (
              <div className="appointments-view animate-fade-in">
                <div className="table-card">
                  <div className="table-responsive">
                    <table>
                      <thead>
                        <tr>
                          <th>Appointment ID</th>
                          <th>Patient Name</th>
                          <th>Schedule Date & Time</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        {appointments.map(app => (
                          <tr key={app.id}>
                            <td className="bold-id">{app.id?.substring(0, 8)}</td>
                            <td>{getPatientName(app.patient_uuid)}</td>
                            <td>{app.appointment_date}</td>
                            <td>
                              <span className={`status-badge ${app.status.toLowerCase()}`}>
                                {app.status}
                              </span>
                            </td>
                          </tr>
                        ))}
                        {appointments.length === 0 && (
                          <tr>
                            <td colSpan={4} className="text-center text-muted pad-20">
                              No appointments scheduled.
                            </td>
                          </tr>
                        )}
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            )}

            {currentTab === 'settings' && (
              <div className="settings-view animate-fade-in">
                <div className="settings-sections">
                  {/* Security Section */}
                  <div className="settings-card">
                    <h3><Shield size={20} className="accent-color" /> Security Audit Configuration</h3>
                    <p className="card-sub">Review system encryption and security policies.</p>
                    <div className="settings-rows">
                      <div className="settings-row">
                        <div>
                          <strong>Database Connection Protection</strong>
                          <p>Supabase uses SSL/TLS encryption for all data transit.</p>
                        </div>
                        <span className="badge-tag success">ACTIVE</span>
                      </div>
                      <div className="settings-row">
                        <div>
                          <strong>Authentication JWT Timeout</strong>
                          <p>Tokens automatically refresh every hour.</p>
                        </div>
                        <span className="badge-tag">3600s</span>
                      </div>
                    </div>
                  </div>

                  {/* System Environment Section */}
                  <div className="settings-card">
                    <h3><Lock size={20} className="accent-color" /> Environment Constants</h3>
                    <div className="settings-rows">
                      <div className="settings-row">
                        <div>
                          <strong>Connected Endpoint</strong>
                          <p className="code-font">https://rylfoslxaitwocputbzq.supabase.co</p>
                        </div>
                      </div>
                      <div className="settings-row">
                        <div>
                          <strong>Client SDK Version</strong>
                          <p>JavaScript Web SDK v2</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            )}
          </main>

          {/* PATIENT CREATION / EDIT MODAL */}
          {isPatientFormOpen && (
            <div className="modal-overlay">
              <div className="modal-card">
                <div className="modal-header">
                  <h3>{editingPatient ? 'Edit Patient Record' : 'Create Patient Record'}</h3>
                  <button onClick={() => { setIsPatientFormOpen(false); setEditingPatient(null); }} className="btn-close">&times;</button>
                </div>
                <form onSubmit={savePatient} className="modal-form">
                  <div className="form-group">
                    <label>Full Name</label>
                    <input 
                      type="text"
                      value={patientForm.fullName}
                      onChange={e => setPatientForm({...patientForm, fullName: e.target.value})}
                      placeholder="e.g. John Doe"
                      required
                    />
                  </div>

                  <div className="form-row">
                    <div className="form-group">
                      <label>Age</label>
                      <input 
                        type="number"
                        value={patientForm.age}
                        onChange={e => setPatientForm({...patientForm, age: e.target.value})}
                        placeholder="e.g. 35"
                        required
                      />
                    </div>
                    <div className="form-group">
                      <label>Gender</label>
                      <select 
                        value={patientForm.gender}
                        onChange={e => setPatientForm({...patientForm, gender: e.target.value})}
                      >
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                        <option value="Not specified">Not specified</option>
                      </select>
                    </div>
                  </div>

                  <div className="form-group">
                    <label>Primary Diagnosis</label>
                    <select 
                      value={patientForm.primaryDiagnosis}
                      onChange={e => setPatientForm({...patientForm, primaryDiagnosis: e.target.value})}
                    >
                      <option value="Root Fracture">Root Fracture</option>
                      <option value="Cracked Tooth">Cracked Tooth</option>
                      <option value="Necrotic Pulp">Necrotic Pulp</option>
                      <option value="Reversible pulpitis">Reversible pulpitis</option>
                      <option value="Failed Root Canal">Failed Root Canal</option>
                    </select>
                  </div>

                  <div className="form-group">
                    <label>Selected Teeth (separated by commas)</label>
                    <input 
                      type="text"
                      placeholder="e.g. 14, 15, 46"
                      value={patientForm.selectedTeeth.join(', ')}
                      onChange={e => {
                        const teeth = e.target.value.split(',')
                          .map(t => parseInt(t.trim()))
                          .filter(t => !isNaN(t));
                        setPatientForm({...patientForm, selectedTeeth: teeth});
                      }}
                    />
                  </div>

                  <div className="form-group">
                    <label>Systemic Conditions (separated by commas)</label>
                    <input 
                      type="text"
                      placeholder="e.g. Asthma, Diabetes"
                      value={patientForm.conditions.join(', ')}
                      onChange={e => {
                        const conds = e.target.value.split(',')
                          .map(c => c.trim())
                          .filter(c => c.length > 0);
                        setPatientForm({...patientForm, conditions: conds});
                      }}
                    />
                  </div>

                  <div className="form-checkbox-row">
                    <label className="checkbox-container">
                      <input 
                        type="checkbox"
                        checked={patientForm.smoking}
                        onChange={e => setPatientForm({...patientForm, smoking: e.target.checked})}
                      />
                      Smoking Habits
                    </label>
                    <label className="checkbox-container">
                      <input 
                        type="checkbox"
                        checked={patientForm.alcohol}
                        onChange={e => setPatientForm({...patientForm, alcohol: e.target.checked})}
                      />
                      Alcohol Intake
                    </label>
                  </div>

                  <div className="modal-actions">
                    <button type="button" onClick={() => { setIsPatientFormOpen(false); setEditingPatient(null); }} className="btn-secondary">
                      Cancel
                    </button>
                    <button type="submit" className="btn-primary">
                      {loading ? 'Saving...' : 'Save Record'}
                    </button>
                  </div>
                </form>
              </div>
            </div>
          )}
        </div>
      )}
    </div>
  );
}
