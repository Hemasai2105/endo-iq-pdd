import unittest
import time
from appium import webdriver
from appium.webdriver.common.appiumby import AppiumBy
from appium.options.android import UiAutomator2Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class EndoAppiumE2ETests(unittest.TestCase):
    driver = None

    @classmethod
    def setUpClass(cls):
        """Set up Appium connection capabilities."""
        print("Initializing Appium UiAutomator2 driver...")
        
        # Modern Appium 2.x capabilities config using UiAutomator2Options
        options = UiAutomator2Options()
        options.platform_name = "Android"
        options.automation_name = "UiAutomator2"
        options.device_name = "Android Emulator"
        
        # Package and activity for com.simats.endo
        options.app_package = "com.simats.endo"
        options.app_activity = ".MainActivity"
        
        # Prevents app data reset between tests
        options.no_reset = True
        options.new_command_timeout = 300
        
        try:
            # Connect to default Appium server (v2.x standard port 4723)
            cls.driver = webdriver.Remote("http://127.0.0.1:4723", options=options)
            print("Appium session created successfully.")
        except Exception as e:
            print(f"CRITICAL: Failed to connect to Appium server: {e}")
            print("Make sure Appium server is running ('appium') and an emulator/device is connected.")
            raise e

    @classmethod
    def tearDownClass(cls):
        """Quit the Appium driver session."""
        if cls.driver:
            print("Terminating Appium driver session...")
            cls.driver.quit()

    def setUp(self):
        # Reset app state to starting activity if already launched
        if self.driver:
            self.driver.activate_app("com.simats.endo")
            time.sleep(2)

    def test_01_verify_splash_screen_transition(self):
        """Verify splash screen loads and transitions automatically to auth page."""
        print("Starting Test 01: Splash Screen Transition...")
        
        # Wait for the email input field to load (indicating splash screen transition finished)
        wait = WebDriverWait(self.driver, 10)
        email_field = wait.until(
            EC.presence_of_element_located((AppiumBy.XPATH, "//*[contains(@text, 'doctor@clinic.com')]"))
        )
        self.assertIsNotNone(email_field, "Login Screen did not load after splash.")
        print("Test 01 passed: Login screen successfully loaded.")

    def test_02_verify_login_validation_errors(self):
        """Verify empty email and password trigger validation prompts."""
        print("Starting Test 02: Login Validation Checks...")
        
        wait = WebDriverWait(self.driver, 5)
        
        # 1. Test empty fields by clicking sign in button directly
        signin_button = wait.until(
            EC.element_to_be_clickable((AppiumBy.XPATH, "//*[contains(@text, 'Sign in securely')]"))
        )
        signin_button.click()
        time.sleep(1)
        
        # Check validation text error prompts in Jetpack Compose layout
        email_error = self.driver.find_element(AppiumBy.XPATH, "//*[contains(@text, 'Email cannot be empty')]")
        self.assertIsNotNone(email_error, "Email validation prompt was not displayed.")
        
        password_error = self.driver.find_element(AppiumBy.XPATH, "//*[contains(@text, 'Password cannot be empty')]")
        self.assertIsNotNone(password_error, "Password validation prompt was not displayed.")
        print("Test 02 passed: Validation warnings triggered successfully.")

    def test_03_verify_doctor_login_logout_workflow(self):
        """Verify doctor can sign in with valid credentials, inspect dashboard, and logout."""
        print("Starting Test 03: Complete Doctor Sign In & Sign Out Flow...")
        
        wait = WebDriverWait(self.driver, 10)
        
        # Find Inputs
        email_field = wait.until(
            EC.presence_of_element_located((AppiumBy.XPATH, "//*[contains(@text, 'doctor@clinic.com')]"))
        )
        # In Android Appium, we send keys to the EditText placeholder/field
        email_field.click()
        email_field.send_keys("dr.test.appium@endo.com")
        
        # Find Password field (marked with standard •••• characters placeholder)
        password_field = self.driver.find_element(AppiumBy.XPATH, "//*[contains(@text, '••••••••')]")
        password_field.click()
        password_field.send_keys("SecurePass123!")
        
        # Tap login
        signin_button = self.driver.find_element(AppiumBy.XPATH, "//*[contains(@text, 'Sign in securely')]")
        signin_button.click()
        
        # Wait for redirect to Dashboard screen
        # Let's verify dashboard title, patients count, or navigation bar presence
        dashboard_header = wait.until(
            EC.presence_of_element_located((AppiumBy.XPATH, "//*[contains(@text, 'Total Patients')]"))
        )
        self.assertIsNotNone(dashboard_header, "Failed to navigate to dashboard screen after login.")
        print("Dashboard screen successfully loaded. Login confirmed.")
        
        # Tap on Settings Screen link/icon (which contains the sign out)
        settings_tab = self.driver.find_element(AppiumBy.XPATH, "//*[contains(@text, 'Settings')]")
        settings_tab.click()
        time.sleep(1)
        
        # Tap Sign Out button
        signout_button = wait.until(
            EC.element_to_be_clickable((AppiumBy.XPATH, "//*[contains(@text, 'Logout')]"))
        )
        signout_button.click()
        
        # Verify redirect back to Login screen
        re_login_button = wait.until(
            EC.presence_of_element_located((AppiumBy.XPATH, "//*[contains(@text, 'Sign in securely')]"))
        )
        self.assertIsNotNone(re_login_button, "Logout did not redirect user to login page.")
        print("Test 03 passed: Doctor login and logout E2E sequence completed.")

if __name__ == '__main__':
    unittest.main()
