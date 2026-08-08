import os

# Configs for automation tests
BASE_URL = os.getenv("BASE_URL", "http://localhost:5173")
BACKEND_URL = os.getenv("BACKEND_URL", "https://rylfoslxaitwocputbzq.supabase.co")
SUPABASE_KEY = os.getenv("SUPABASE_KEY", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJ5bGZvc2x4YWl0d29jcHV0YnpxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3ODUzMTM0NjksImV4cCI6MjEwMDg4OTQ2OX0.spCejSe31jqrrZGD_wFJPc2JLirsxZCTQ9mAy1f-JCM")
GEMINI_API_KEY = os.getenv("GEMINI_API_KEY", "")

# Selenium Settings
HEADLESS = True
TIMEOUT = 10
RETRY_COUNT = 3
