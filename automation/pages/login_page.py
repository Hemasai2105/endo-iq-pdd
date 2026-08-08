from selenium.webdriver.common.by import By
from .base_page import BasePage

class LoginPage(BasePage):
    EMAIL_INPUT = (By.CSS_SELECTOR, "input[type='email']")
    PASSWORD_INPUT = (By.CSS_SELECTOR, "input[type='password']")
    FULL_NAME_INPUT = (By.CSS_SELECTOR, "input[placeholder*='John']")
    SUBMIT_BUTTON = (By.CSS_SELECTOR, "button[type='submit']")
    TOGGLE_MODE_BTN = (By.CSS_SELECTOR, ".btn-link")
    ERROR_MESSAGE = (By.CSS_SELECTOR, ".auth-error-msg")

    def login(self, email, password):
        self.send_keys(self.EMAIL_INPUT, email)
        self.send_keys(self.PASSWORD_INPUT, password)
        self.click(self.SUBMIT_BUTTON)

    def signup(self, name, email, password):
        # Click toggle if not already in signup
        if not self.is_visible(self.FULL_NAME_INPUT):
            self.click(self.TOGGLE_MODE_BTN)
        self.send_keys(self.FULL_NAME_INPUT, name)
        self.send_keys(self.EMAIL_INPUT, email)
        self.send_keys(self.PASSWORD_INPUT, password)
        self.click(self.SUBMIT_BUTTON)

    def is_logged_in(self):
        # Check if logout button or sidebar brand exists
        from selenium.webdriver.common.by import By
        return self.is_visible((By.CSS_SELECTOR, ".logout-btn"))

    def get_error_message(self):
        if self.is_visible(self.ERROR_MESSAGE):
            return self.wait_for_visible(self.ERROR_MESSAGE).text
        return ""
