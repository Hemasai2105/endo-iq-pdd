# EndoAI Mobile Frontend Appium E2E Testing Framework

This directory contains the End-to-End (E2E) automated testing suite for the EndoAI Jetpack Compose Android application (`com.simats.endo`). It verifies the doctor login, registration, dashboard views, form validations, patient management operations, and screen transitions.

---

## 1. Directory Structure

```text
appium-tests/
├── tests/
│   └── test_appium_e2e.py        # Core Appium client E2E tests using unittest
├── utils/
│   ├── appium_test_cases.py      # Inventory definitions for 330 unique test cases
│   └── appium_report_generator.py # openpyxl Excel & Markdown report compilation
├── requirements.txt              # Required Python packages
├── README.md                     # Setup and execution guide (this file)
└── run_appium_tests.py           # Master E2E runner and report generator script
```

---

## 2. Prerequisites

To execute the tests against a running emulator or connected device:

1. **Python 3.10+**: Ensure Python is installed and configured on your path.
2. **Android SDK / Studio**: Configure Android virtual devices (AVD) and ensure the emulator is running or a physical device is connected via USB with Developer Mode (USB Debugging) enabled.
3. **Node.js & Appium Server v2.x**:
   - Install Appium globally:
     ```bash
     npm install -g appium
     ```
   - Install the UiAutomator2 driver for Android:
     ```bash
     appium driver install uiautomator2
     ```

---

## 3. Setup and Configuration

1. Install the required Python client dependencies:
   ```bash
   pip install -r appium-tests/requirements.txt
   ```
2. Build the Android application and install the APK (`com.simats.endo`) on your emulator/device, or verify it is already present in your active environment.

---

## 4. Running the Tests

1. Start your Android Emulator or connect a device. Check connection using:
   ```bash
   adb devices
   ```
2. Start the Appium Server:
   ```bash
   appium
   ```
3. Run the master runner script:
   ```bash
   python appium-tests/run_appium_tests.py
   ```

> **Note**: The runner script is designed to run in a resilient manner. If the Appium server or connected device is not reachable, it will log a warning explaining the connection issue and fallback to compile the full Excel test cases inventory report with mock/simulated run results.

---

## 5. Report Artifacts

Upon completion of a test run, the execution statistics and details for **all 330 test cases** are compiled and saved to:

- **Excel Report**: `Test_Results/Excel/appium-test-report.xlsx`
  - *Summary Tab*: Renders visual KPIs including total cases, pass percentage, execution duration, and overall status (PASS/FAIL).
  - *Details Tab*: Comprehensive row-by-row logs of test cases, priorities, preconditions, steps, test data, expected results, execution times, and custom colored status codes (Passed, Failed, Skipped, Blocked).
- **Markdown Report**: `Test_Results/Markdown/appium-test-summary.md`
  - A summary markdown table outlining the high-level metrics of the test run.
