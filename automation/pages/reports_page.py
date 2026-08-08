from selenium.webdriver.common.by import By
from .base_page import BasePage

class ReportsPage(BasePage):
    VIEW_REPORT_BTN = (By.XPATH, "//button[contains(., 'View Report')]")
    BACK_TO_LIST_BTN = (By.XPATH, "//button[contains(., 'Back to List')]")
    AI_INSIGHT_TEXT = (By.CLASS_NAME, "ai-insight-text")
    REPORT_CARDS = (By.CLASS_NAME, "report-card")

    def view_first_report(self):
        self.click(self.VIEW_REPORT_BTN)

    def back_to_list(self):
        self.click(self.BACK_TO_LIST_BTN)

    def get_report_count(self):
        try:
            return len(self.driver.find_elements(*self.REPORT_CARDS))
        except Exception:
            return 0

    def get_first_ai_insight(self):
        try:
            element = self.wait_for_visible(self.AI_INSIGHT_TEXT)
            return element.text
        except Exception:
            return ""
