-- Supabase Schema for Endo App

-- Patients Table
CREATE TABLE public.patients (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
    patient_id VARCHAR(50) NOT NULL, -- The "EN-1043" string
    full_name VARCHAR(255) NOT NULL,
    age VARCHAR(10) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    primary_diagnosis TEXT NOT NULL,
    selected_teeth INT[] DEFAULT '{}',
    conditions TEXT[] DEFAULT '{}',
    smoking BOOLEAN DEFAULT FALSE,
    alcohol BOOLEAN DEFAULT FALSE
);

-- Reports Table
CREATE TABLE public.reports (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
    patient_uuid UUID REFERENCES public.patients(id) ON DELETE CASCADE,
    report_data JSONB NOT NULL -- Stores the full array of TreatmentStage objects
);
