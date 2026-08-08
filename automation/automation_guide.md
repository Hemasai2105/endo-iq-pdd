# Endo AI Test Automation Guide

This guide provides instructions on how to configure, execute, and troubleshoot the automated test suite for the **Endo AI Dental Hospital Management System**.

---

## 1. Local Execution Guide

### Prerequisites
- Python 3.10+
- Google Chrome installed
- Node.js v18+

### Setup
1. Clone the repository and navigate to the project root directory.
2. Build the React web frontend:
   ```bash
   cd endo_web
   npm install
   npm run build
   cd ..
   ```
3. Install Python requirements:
   ```bash
   pip install openpyxl requests jinja2 selenium
   ```

### Execution
Run the master test runner script:
```bash
python automation/tests/run_e2e_tests.py
```
This script will:
1. Run E2E Selenium tests against the compiled web assets in headless Chrome.
2. Query Supabase REST API endpoints to verify CRUD and authorization.
3. Validate AI analysis parsing models.
4. Process all 440 unique test cases and generate HTML/Excel report artifacts under `Test_Results/`.

---

## 2. CI/CD Execution Guide

The test suite is integrated with GitHub Actions under `.github/workflows/deploy-and-test.yml`.

### Pipeline Flow
1. **Trigger:** Fires on every `push`, `pull_request`, or manual `workflow_dispatch`.
2. **Checkout:** Clones the repository.
3. **Build:** Installs npm dependencies and compiles `endo_web` to `dist/`.
4. **Deploy:** Deploys compiled assets to GitHub Pages.
5. **Wait and Verify:** Assures the live page returns HTTP 200 OK.
6. **E2E Testing:** Sets up Python, Chrome, and executes Selenium WebDriver tests against the LIVE deployment URL.
7. **Report Generation:** Generates execution metrics, HTML dashboards, Excel sheets, and logs.
8. **Artifact Upload:** Uploads all generated reports to the GitHub Actions run summary with a 30-day retention period.

### Repository Permissions
To allow automated deployments, configure the repository:
1. Under **Settings > Actions > General**, select **Read and write permissions** for Workflow permissions.
2. Ensure GitHub Pages is set to build from the **gh-pages** branch or configured for actions deployment.

---

## 3. Troubleshooting Guide

### Issue 1: `chromedriver` not found or path issues
- **Reason:** Selenium couldn't locate chromedriver on your system path.
- **Solution:** Starting with Selenium 4.x, the library manages drivers automatically via Selenium Manager. Ensure you are using the latest version:
  ```bash
  pip install --upgrade selenium
  ```

### Issue 2: Supabase connection timeout or authentication failures
- **Reason:** The active API keys in `local.properties` or environment variables are expired or restricted.
- **Solution:** Check `local.properties` and verify if the keys match the active Supabase project dashboard. You can test your keys using:
  ```bash
  curl -H "apikey: YOUR_KEY" https://YOUR_PROJECT.supabase.co/rest/v1/patients
  ```

### Issue 3: E2E tests fail on component selection
- **Reason:** Chrome window size or responsiveness pushed sidebar items to drawer view.
- **Solution:** The driver is configured to window size `1280x800` by default. If running on smaller displays, adjust `chrome_options.add_argument("--window-size=1280,800")` inside [test_e2e.py](file:///c:/Users/hemas/OneDrive/Desktop/endo%20app%20final/automation/tests/test_e2e.py).
