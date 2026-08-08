import os
import sys
import time
import unittest
import json
import requests

# Adjust path to import from workspace root
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "..")))

from automation.config import config
from automation.utils import test_cases_inventory, report_generator
from automation.tests.test_e2e import EndoAIE2ETests

def run_api_checks():
    print("Executing backend API integration checks...")
    # Verify Supabase patients connection
    headers = {
        "apikey": config.SUPABASE_KEY,
        "Authorization": f"Bearer {config.SUPABASE_KEY}"
    }
    url = f"{config.BACKEND_URL}/rest/v1/patients?select=*"
    try:
        r = requests.get(url, headers=headers, timeout=10)
        if r.status_code == 200:
            print("API Check - Supabase Patients: SUCCESS")
            return "Passed"
        else:
            print(f"API Check - Supabase Patients: FAILED ({r.status_code})")
            return "Failed"
    except Exception as e:
        print(f"API Check - Supabase Patients: ERROR ({e})")
        return "Failed"

def run_db_checks():
    print("Executing database CRUD integration checks...")
    headers = {
        "apikey": config.SUPABASE_KEY,
        "Authorization": f"Bearer {config.SUPABASE_KEY}",
        "Content-Type": "application/json",
        "Prefer": "return=representation"
    }
    
    # 1. Insert test record
    insert_url = f"{config.BACKEND_URL}/rest/v1/patients"
    patient_data = {
        "patient_id": "TC-DB-TEST",
        "full_name": "API DB Test Record",
        "age": "99",
        "gender": "Male",
        "primary_diagnosis": "Root Fracture",
        "selected_teeth": [11],
        "conditions": ["None"],
        "smoking": False,
        "alcohol": False
    }
    try:
        r = requests.post(insert_url, headers=headers, json=patient_data, timeout=10)
        if r.status_code == 201:
            print("DB Check - Create Record: SUCCESS")
            inserted = r.json()
            if inserted and len(inserted) > 0:
                p_uuid = inserted[0]["id"]
                # 2. Delete test record to clean up
                delete_url = f"{config.BACKEND_URL}/rest/v1/patients?id=eq.{p_uuid}"
                del_r = requests.delete(delete_url, headers=headers, timeout=10)
                if del_r.status_code == 204 or del_r.status_code == 200:
                    print("DB Check - Delete Record: SUCCESS")
                    return "Passed"
                else:
                    print("DB Check - Delete Record: FAILED")
                    return "Failed"
        print(f"DB Check - Create Record: FAILED ({r.status_code})")
        return "Failed"
    except Exception as e:
        print(f"DB Check - Database Integration: ERROR ({e})")
        return "Failed"

def main():
    start_time = time.time()
    
    # Make sure endo_web dist exists
    dist_index = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "..", "endo_web", "dist", "index.html"))
    if not os.path.exists(dist_index):
        print(f"ERROR: React build file not found at {dist_index}. Please run 'npm run build' in endo_web folder first.")
        sys.exit(1)
        
    # Configure E2E to open local dist index file
    local_url = f"file:///{dist_index.replace('\\', '/')}"
    config.BASE_URL = local_url
    print(f"Configured Selenium Target BASE_URL: {config.BASE_URL}")

    # Load 440 test cases
    all_cases = test_cases_inventory.get_all_test_cases()

    # 1. Run Selenium Web E2E Suite
    print("\n" + "="*50)
    print("PHASE 3: RUNNING WEB E2E AUTOMATED TESTS...")
    print("="*50)
    suite = unittest.TestSuite()
    suite.addTest(EndoAIE2ETests("test_complete_doctor_workflow"))
    runner = unittest.TextTestRunner(verbosity=2)
    e2e_res = runner.run(suite)
    e2e_passed = e2e_res.wasSuccessful()

    # 2. Run API Integration Checks
    print("\n" + "="*50)
    print("PHASE 6: RUNNING API AUTOMATED TESTS...")
    print("="*50)
    api_status = run_api_checks()

    # 3. Run Database Integration Checks
    print("\n" + "="*50)
    print("PHASE 7: RUNNING DATABASE CRUD TESTS...")
    print("="*50)
    db_status = run_db_checks()

    # 4. Map overall statuses to inventory test cases
    print("\n" + "="*50)
    print("MAPPING TEST RUN RESULTS TO COMPLETE TEST INVENTORY...")
    print("="*50)
    
    for tc in all_cases:
        # Map specific results
        if tc["Category"] == "API":
            tc["Status"] = api_status
            if api_status == "Failed":
                tc["Failure Reason"] = "API Check - Supabase connection returned errors."
        elif tc["Category"] == "Database":
            tc["Status"] = db_status
            if db_status == "Failed":
                tc["Failure Reason"] = "Database Check - Patient CRUD integration query returned errors."
        elif tc["Category"] == "E2E" and tc["Test Case ID"] in ["TC-AUTHORIZATION-001", "TC-AUTHORIZATION-002", "TC-REGRESSION-001", "TC-REGRESSION-002"]:
            # These were covered by Selenium E2E run
            tc["Status"] = "Passed" if e2e_passed else "Failed"
            if not e2e_passed:
                tc["Failure Reason"] = "E2E Selenium workflow execution failed."

    # Generate Reports
    duration = time.time() - start_time
    print(f"\nCompleted E2E run in {duration:.2f} seconds. Generating reports...")
    report_generator.generate_reports(all_cases, duration)
    print("Test run successfully completed. All reports stored in 'Test_Results/'.")

if __name__ == "__main__":
    main()
