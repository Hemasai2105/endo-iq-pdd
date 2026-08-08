from selenium.webdriver.common.by import By
from .base_page import BasePage

class DashboardPage(BasePage):
    DASHBOARD_TAB = (By.XPATH, "//button[contains(., 'Dashboard')]")
    PATIENTS_TAB = (By.XPATH, "//button[contains(., 'Patients')]")
    REPORTS_TAB = (By.XPATH, "//button[contains(., 'Reports')]")
    APPOINTMENTS_TAB = (By.XPATH, "//button[contains(., 'Appointments')]")
    SETTINGS_TAB = (By.XPATH, "//button[contains(., 'Security & System') or contains(., 'Settings')]")
    
    STAT_VALUES = (By.CLASS_NAME, "stat-value")
    THEME_TOGGLE = (By.CLASS_NAME, "theme-toggle")
    LOGOUT_BTN = (By.CLASS_NAME, "logout-btn")

    def navigate_to_patients(self):
        self.click(self.PATIENTS_TAB)

    def navigate_to_reports(self):
        self.click(self.REPORTS_TAB)

    def navigate_to_appointments(self):
        self.click(self.APPOINTMENTS_TAB)

    def navigate_to_settings(self):
        self.click(self.SETTINGS_TAB)

    def toggle_theme(self):
        self.click(self.THEME_TOGGLE)

    def logout(self):
        self.click(self.LOGOUT_BTN)

    def get_stats(self):
        elements = self.driver.find_elements(*self.STAT_VALUES)
        return [el.text for el in elements]
