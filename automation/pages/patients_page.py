from selenium.webdriver.common.by import By
from .base_page import BasePage

class PatientsPage(BasePage):
    NEW_PATIENT_BTN = (By.XPATH, "//button[contains(., 'New Patient')]")
    SEARCH_INPUT = (By.CSS_SELECTOR, ".search-box input")
    
    # Form elements inside modal
    NAME_INPUT = (By.CSS_SELECTOR, "input[placeholder*='John Doe']")
    AGE_INPUT = (By.CSS_SELECTOR, "input[type='number']")
    GENDER_SELECT = (By.XPATH, "//select[contains(option/text(), 'Male')]")
    DIAGNOSIS_SELECT = (By.XPATH, "//select[contains(option/text(), 'Root Fracture')]")
    TEETH_INPUT = (By.CSS_SELECTOR, "input[placeholder*='14']")
    CONDITIONS_INPUT = (By.CSS_SELECTOR, "input[placeholder*='Asthma']")
    SMOKING_CHECKBOX = (By.XPATH, "//input[@type='checkbox'][1]")
    ALCOHOL_CHECKBOX = (By.XPATH, "//input[@type='checkbox'][2]")
    SAVE_BTN = (By.XPATH, "//button[contains(., 'Save Record')]")
    
    # Actions inside table row
    EDIT_ROW_BTN = (By.CLASS_NAME, "btn-edit")
    DELETE_ROW_BTN = (By.CLASS_NAME, "btn-delete")
    RUN_AI_BTN = (By.CLASS_NAME, "btn-ai")

    def open_new_patient_form(self):
        self.click(self.NEW_PATIENT_BTN)

    def create_patient(self, name, age, gender, diagnosis, teeth, conditions, smoking=False, alcohol=False):
        self.send_keys(self.NAME_INPUT, name)
        self.send_keys(self.AGE_INPUT, str(age))
        
        # Selection of gender
        gender_el = self.wait_for_visible(self.GENDER_SELECT)
        gender_el.send_keys(gender)

        # Selection of diagnosis
        diag_el = self.wait_for_visible(self.DIAGNOSIS_SELECT)
        diag_el.send_keys(diagnosis)

        self.send_keys(self.TEETH_INPUT, teeth)
        self.send_keys(self.CONDITIONS_INPUT, conditions)

        # Handle checkboxes
        smoke_el = self.wait_for_visible(self.SMOKING_CHECKBOX)
        if smoke_el.is_selected() != smoking:
            smoke_el.click()

        alcohol_el = self.wait_for_visible(self.ALCOHOL_CHECKBOX)
        if alcohol_el.is_selected() != alcohol:
            alcohol_el.click()

        self.click(self.SAVE_BTN)

    def search_patient(self, query):
        self.send_keys(self.SEARCH_INPUT, query)

    def click_run_ai_first_row(self):
        self.click(self.RUN_AI_BTN)
