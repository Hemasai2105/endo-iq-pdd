import { createClient } from '@supabase/supabase-js';

const SUPABASE_URL = "https://rylfoslxaitwocputbzq.supabase.co";
const SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJ5bGZvc2x4YWl0d29jcHV0YnpxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3ODUzMTM0NjksImV4cCI6MjEwMDg4OTQ2OX0.spCejSe31jqrrZGD_wFJPc2JLirsxZCTQ9mAy1f-JCM";

export const supabase = createClient(SUPABASE_URL, SUPABASE_ANON_KEY);
