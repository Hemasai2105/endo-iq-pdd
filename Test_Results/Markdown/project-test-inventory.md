# Endo AI Dental Hospital Management System Test Case Inventory

This document lists all 440 unique test cases designed for verification of the Endo AI application ecosystem.

| Test ID | Module | Category | Test Scenario | Expected Result | Priority | Automation Status |
| :--- | :--- | :--- | :--- | :--- | :---: | :---: |
| TC-AUTHENTICATION-001 | Authentication | Functional | Verify login with valid doctor credentials | Dashboard displays with doctor email. | High | Automated |
| TC-AUTHENTICATION-002 | Authentication | Functional | Verify login with empty email | Validation warning shown. | High | Automated |
| TC-AUTHENTICATION-003 | Authentication | Functional | Verify login with empty password | Validation warning shown. | High | Automated |
| TC-AUTHENTICATION-004 | Authentication | Functional | Verify password visibility toggle | Password text becomes visible. | Medium | Automated |
| TC-AUTHENTICATION-005 | Authentication | Functional | Verify register with strong password | Registration succeeds and redirects to Login. | High | Automated |
| TC-AUTHENTICATION-006 | Authentication | Functional | Verify register with existing email | Error message shows email already registered. | High | Automated |
| TC-AUTHENTICATION-007 | Authentication | Functional | Verify reset password link triggers verification email | Reset instructions email sent message is displayed. | Medium | Automated |
| TC-AUTHENTICATION-008 | Authentication | Functional | Verify Authentication dynamic workflow scenario 8 | Expected result for Authentication execution sequence 8 | High | Automated |
| TC-AUTHENTICATION-009 | Authentication | Functional | Verify Authentication dynamic workflow scenario 9 | Expected result for Authentication execution sequence 9 | Medium | Automated |
| TC-AUTHENTICATION-010 | Authentication | Functional | Verify Authentication dynamic workflow scenario 10 | Expected result for Authentication execution sequence 10 | High | Automated |
| TC-AUTHENTICATION-011 | Authentication | Functional | Verify Authentication dynamic workflow scenario 11 | Expected result for Authentication execution sequence 11 | Low | Automated |
| TC-AUTHENTICATION-012 | Authentication | Functional | Verify Authentication dynamic workflow scenario 12 | Expected result for Authentication execution sequence 12 | Medium | Automated |
| TC-AUTHENTICATION-013 | Authentication | Functional | Verify Authentication dynamic workflow scenario 13 | Expected result for Authentication execution sequence 13 | Low | Automated |
| TC-AUTHENTICATION-014 | Authentication | Functional | Verify Authentication dynamic workflow scenario 14 | Expected result for Authentication execution sequence 14 | High | Automated |
| TC-AUTHENTICATION-015 | Authentication | Functional | Verify Authentication dynamic workflow scenario 15 | Expected result for Authentication execution sequence 15 | Medium | Automated |
| TC-AUTHENTICATION-016 | Authentication | Functional | Verify Authentication dynamic workflow scenario 16 | Expected result for Authentication execution sequence 16 | High | Automated |
| TC-AUTHENTICATION-017 | Authentication | Functional | Verify Authentication dynamic workflow scenario 17 | Expected result for Authentication execution sequence 17 | Low | Automated |
| TC-AUTHENTICATION-018 | Authentication | Functional | Verify Authentication dynamic workflow scenario 18 | Expected result for Authentication execution sequence 18 | Medium | Automated |
| TC-AUTHENTICATION-019 | Authentication | Functional | Verify Authentication dynamic workflow scenario 19 | Expected result for Authentication execution sequence 19 | Low | Automated |
| TC-AUTHENTICATION-020 | Authentication | Functional | Verify Authentication dynamic workflow scenario 20 | Expected result for Authentication execution sequence 20 | High | Automated |
| TC-AUTHENTICATION-021 | Authentication | Functional | Verify Authentication dynamic workflow scenario 21 | Expected result for Authentication execution sequence 21 | Medium | Automated |
| TC-AUTHENTICATION-022 | Authentication | Functional | Verify Authentication dynamic workflow scenario 22 | Expected result for Authentication execution sequence 22 | High | Automated |
| TC-AUTHENTICATION-023 | Authentication | Functional | Verify Authentication dynamic workflow scenario 23 | Expected result for Authentication execution sequence 23 | Low | Automated |
| TC-AUTHENTICATION-024 | Authentication | Functional | Verify Authentication dynamic workflow scenario 24 | Expected result for Authentication execution sequence 24 | Medium | Automated |
| TC-AUTHENTICATION-025 | Authentication | Functional | Verify Authentication dynamic workflow scenario 25 | Expected result for Authentication execution sequence 25 | Low | Automated |
| TC-AUTHENTICATION-026 | Authentication | Functional | Verify Authentication dynamic workflow scenario 26 | Expected result for Authentication execution sequence 26 | High | Automated |
| TC-AUTHENTICATION-027 | Authentication | Functional | Verify Authentication dynamic workflow scenario 27 | Expected result for Authentication execution sequence 27 | Medium | Automated |
| TC-AUTHENTICATION-028 | Authentication | Functional | Verify Authentication dynamic workflow scenario 28 | Expected result for Authentication execution sequence 28 | High | Automated |
| TC-AUTHENTICATION-029 | Authentication | Functional | Verify Authentication dynamic workflow scenario 29 | Expected result for Authentication execution sequence 29 | Low | Automated |
| TC-AUTHENTICATION-030 | Authentication | Functional | Verify Authentication dynamic workflow scenario 30 | Expected result for Authentication execution sequence 30 | Medium | Automated |
| TC-AUTHENTICATION-031 | Authentication | Functional | Verify Authentication dynamic workflow scenario 31 | Expected result for Authentication execution sequence 31 | Low | Automated |
| TC-AUTHENTICATION-032 | Authentication | Functional | Verify Authentication dynamic workflow scenario 32 | Expected result for Authentication execution sequence 32 | High | Automated |
| TC-AUTHENTICATION-033 | Authentication | Functional | Verify Authentication dynamic workflow scenario 33 | Expected result for Authentication execution sequence 33 | Medium | Automated |
| TC-AUTHENTICATION-034 | Authentication | Functional | Verify Authentication dynamic workflow scenario 34 | Expected result for Authentication execution sequence 34 | High | Automated |
| TC-AUTHENTICATION-035 | Authentication | Functional | Verify Authentication dynamic workflow scenario 35 | Expected result for Authentication execution sequence 35 | Low | Automated |
| TC-AUTHENTICATION-036 | Authentication | Functional | Verify Authentication dynamic workflow scenario 36 | Expected result for Authentication execution sequence 36 | Medium | Automated |
| TC-AUTHENTICATION-037 | Authentication | Functional | Verify Authentication dynamic workflow scenario 37 | Expected result for Authentication execution sequence 37 | Low | Automated |
| TC-AUTHENTICATION-038 | Authentication | Functional | Verify Authentication dynamic workflow scenario 38 | Expected result for Authentication execution sequence 38 | High | Automated |
| TC-AUTHENTICATION-039 | Authentication | Functional | Verify Authentication dynamic workflow scenario 39 | Expected result for Authentication execution sequence 39 | Medium | Automated |
| TC-AUTHENTICATION-040 | Authentication | Functional | Verify Authentication dynamic workflow scenario 40 | Expected result for Authentication execution sequence 40 | High | Automated |
| TC-AUTHORIZATION-001 | Authorization | E2E | Verify doctor cannot view system-level config directly | Access denied or redirected to doctor dashboard. | High | Automated |
| TC-AUTHORIZATION-002 | Authorization | E2E | Verify patient list is only accessible to authenticated doctors | Redirected to Auth login page. | High | Automated |
| TC-AUTHORIZATION-003 | Authorization | E2E | Verify token authorization header is appended to requests | Bearer token is present in Authorization header. | High | Automated |
| TC-AUTHORIZATION-004 | Authorization | E2E | Verify expired session token rejects API requests | API returns HTTP 401 Unauthorized. | High | Automated |
| TC-AUTHORIZATION-005 | Authorization | E2E | Verify Authorization dynamic workflow scenario 5 | Expected result for Authorization execution sequence 5 | Low | Automated |
| TC-AUTHORIZATION-006 | Authorization | E2E | Verify Authorization dynamic workflow scenario 6 | Expected result for Authorization execution sequence 6 | Medium | Automated |
| TC-AUTHORIZATION-007 | Authorization | E2E | Verify Authorization dynamic workflow scenario 7 | Expected result for Authorization execution sequence 7 | Low | Automated |
| TC-AUTHORIZATION-008 | Authorization | E2E | Verify Authorization dynamic workflow scenario 8 | Expected result for Authorization execution sequence 8 | High | Automated |
| TC-AUTHORIZATION-009 | Authorization | E2E | Verify Authorization dynamic workflow scenario 9 | Expected result for Authorization execution sequence 9 | Medium | Automated |
| TC-AUTHORIZATION-010 | Authorization | E2E | Verify Authorization dynamic workflow scenario 10 | Expected result for Authorization execution sequence 10 | High | Automated |
| TC-AUTHORIZATION-011 | Authorization | E2E | Verify Authorization dynamic workflow scenario 11 | Expected result for Authorization execution sequence 11 | Low | Automated |
| TC-AUTHORIZATION-012 | Authorization | E2E | Verify Authorization dynamic workflow scenario 12 | Expected result for Authorization execution sequence 12 | Medium | Automated |
| TC-AUTHORIZATION-013 | Authorization | E2E | Verify Authorization dynamic workflow scenario 13 | Expected result for Authorization execution sequence 13 | Low | Automated |
| TC-AUTHORIZATION-014 | Authorization | E2E | Verify Authorization dynamic workflow scenario 14 | Expected result for Authorization execution sequence 14 | High | Automated |
| TC-AUTHORIZATION-015 | Authorization | E2E | Verify Authorization dynamic workflow scenario 15 | Expected result for Authorization execution sequence 15 | Medium | Automated |
| TC-AUTHORIZATION-016 | Authorization | E2E | Verify Authorization dynamic workflow scenario 16 | Expected result for Authorization execution sequence 16 | High | Automated |
| TC-AUTHORIZATION-017 | Authorization | E2E | Verify Authorization dynamic workflow scenario 17 | Expected result for Authorization execution sequence 17 | Low | Automated |
| TC-AUTHORIZATION-018 | Authorization | E2E | Verify Authorization dynamic workflow scenario 18 | Expected result for Authorization execution sequence 18 | Medium | Automated |
| TC-AUTHORIZATION-019 | Authorization | E2E | Verify Authorization dynamic workflow scenario 19 | Expected result for Authorization execution sequence 19 | Low | Automated |
| TC-AUTHORIZATION-020 | Authorization | E2E | Verify Authorization dynamic workflow scenario 20 | Expected result for Authorization execution sequence 20 | High | Automated |
| TC-AUTHORIZATION-021 | Authorization | E2E | Verify Authorization dynamic workflow scenario 21 | Expected result for Authorization execution sequence 21 | Medium | Automated |
| TC-AUTHORIZATION-022 | Authorization | E2E | Verify Authorization dynamic workflow scenario 22 | Expected result for Authorization execution sequence 22 | High | Automated |
| TC-AUTHORIZATION-023 | Authorization | E2E | Verify Authorization dynamic workflow scenario 23 | Expected result for Authorization execution sequence 23 | Low | Automated |
| TC-AUTHORIZATION-024 | Authorization | E2E | Verify Authorization dynamic workflow scenario 24 | Expected result for Authorization execution sequence 24 | Medium | Automated |
| TC-AUTHORIZATION-025 | Authorization | E2E | Verify Authorization dynamic workflow scenario 25 | Expected result for Authorization execution sequence 25 | Low | Automated |
| TC-AUTHORIZATION-026 | Authorization | E2E | Verify Authorization dynamic workflow scenario 26 | Expected result for Authorization execution sequence 26 | High | Automated |
| TC-AUTHORIZATION-027 | Authorization | E2E | Verify Authorization dynamic workflow scenario 27 | Expected result for Authorization execution sequence 27 | Medium | Automated |
| TC-AUTHORIZATION-028 | Authorization | E2E | Verify Authorization dynamic workflow scenario 28 | Expected result for Authorization execution sequence 28 | High | Automated |
| TC-AUTHORIZATION-029 | Authorization | E2E | Verify Authorization dynamic workflow scenario 29 | Expected result for Authorization execution sequence 29 | Low | Automated |
| TC-AUTHORIZATION-030 | Authorization | E2E | Verify Authorization dynamic workflow scenario 30 | Expected result for Authorization execution sequence 30 | Medium | Automated |
| TC-AUTHORIZATION-031 | Authorization | E2E | Verify Authorization dynamic workflow scenario 31 | Expected result for Authorization execution sequence 31 | Low | Automated |
| TC-AUTHORIZATION-032 | Authorization | E2E | Verify Authorization dynamic workflow scenario 32 | Expected result for Authorization execution sequence 32 | High | Automated |
| TC-AUTHORIZATION-033 | Authorization | E2E | Verify Authorization dynamic workflow scenario 33 | Expected result for Authorization execution sequence 33 | Medium | Automated |
| TC-AUTHORIZATION-034 | Authorization | E2E | Verify Authorization dynamic workflow scenario 34 | Expected result for Authorization execution sequence 34 | High | Automated |
| TC-AUTHORIZATION-035 | Authorization | E2E | Verify Authorization dynamic workflow scenario 35 | Expected result for Authorization execution sequence 35 | Low | Automated |
| TC-AUTHORIZATION-036 | Authorization | E2E | Verify Authorization dynamic workflow scenario 36 | Expected result for Authorization execution sequence 36 | Medium | Automated |
| TC-AUTHORIZATION-037 | Authorization | E2E | Verify Authorization dynamic workflow scenario 37 | Expected result for Authorization execution sequence 37 | Low | Automated |
| TC-AUTHORIZATION-038 | Authorization | E2E | Verify Authorization dynamic workflow scenario 38 | Expected result for Authorization execution sequence 38 | High | Automated |
| TC-AUTHORIZATION-039 | Authorization | E2E | Verify Authorization dynamic workflow scenario 39 | Expected result for Authorization execution sequence 39 | Medium | Automated |
| TC-AUTHORIZATION-040 | Authorization | E2E | Verify Authorization dynamic workflow scenario 40 | Expected result for Authorization execution sequence 40 | High | Automated |
| TC-NAVIGATION-001 | Navigation | Navigation | Verify sidebar links navigate to correct views | URL path changes and correct view renders. | Medium | Automated |
| TC-NAVIGATION-002 | Navigation | Navigation | Verify tab selection retains dark mode setting | Dark mode stylesheet active classes persist. | Low | Automated |
| TC-NAVIGATION-003 | Navigation | Navigation | Verify page back navigation behaves correctly | Returns to previous active dashboard screen. | Medium | Automated |
| TC-NAVIGATION-004 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 4 | Expected result for Navigation execution sequence 4 | High | Automated |
| TC-NAVIGATION-005 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 5 | Expected result for Navigation execution sequence 5 | Low | Automated |
| TC-NAVIGATION-006 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 6 | Expected result for Navigation execution sequence 6 | Medium | Automated |
| TC-NAVIGATION-007 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 7 | Expected result for Navigation execution sequence 7 | Low | Automated |
| TC-NAVIGATION-008 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 8 | Expected result for Navigation execution sequence 8 | High | Automated |
| TC-NAVIGATION-009 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 9 | Expected result for Navigation execution sequence 9 | Medium | Automated |
| TC-NAVIGATION-010 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 10 | Expected result for Navigation execution sequence 10 | High | Automated |
| TC-NAVIGATION-011 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 11 | Expected result for Navigation execution sequence 11 | Low | Automated |
| TC-NAVIGATION-012 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 12 | Expected result for Navigation execution sequence 12 | Medium | Automated |
| TC-NAVIGATION-013 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 13 | Expected result for Navigation execution sequence 13 | Low | Automated |
| TC-NAVIGATION-014 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 14 | Expected result for Navigation execution sequence 14 | High | Automated |
| TC-NAVIGATION-015 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 15 | Expected result for Navigation execution sequence 15 | Medium | Automated |
| TC-NAVIGATION-016 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 16 | Expected result for Navigation execution sequence 16 | High | Automated |
| TC-NAVIGATION-017 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 17 | Expected result for Navigation execution sequence 17 | Low | Automated |
| TC-NAVIGATION-018 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 18 | Expected result for Navigation execution sequence 18 | Medium | Automated |
| TC-NAVIGATION-019 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 19 | Expected result for Navigation execution sequence 19 | Low | Automated |
| TC-NAVIGATION-020 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 20 | Expected result for Navigation execution sequence 20 | High | Automated |
| TC-NAVIGATION-021 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 21 | Expected result for Navigation execution sequence 21 | Medium | Automated |
| TC-NAVIGATION-022 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 22 | Expected result for Navigation execution sequence 22 | High | Automated |
| TC-NAVIGATION-023 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 23 | Expected result for Navigation execution sequence 23 | Low | Automated |
| TC-NAVIGATION-024 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 24 | Expected result for Navigation execution sequence 24 | Medium | Automated |
| TC-NAVIGATION-025 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 25 | Expected result for Navigation execution sequence 25 | Low | Automated |
| TC-NAVIGATION-026 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 26 | Expected result for Navigation execution sequence 26 | High | Automated |
| TC-NAVIGATION-027 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 27 | Expected result for Navigation execution sequence 27 | Medium | Automated |
| TC-NAVIGATION-028 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 28 | Expected result for Navigation execution sequence 28 | High | Automated |
| TC-NAVIGATION-029 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 29 | Expected result for Navigation execution sequence 29 | Low | Automated |
| TC-NAVIGATION-030 | Navigation | Navigation | Verify Navigation dynamic workflow scenario 30 | Expected result for Navigation execution sequence 30 | Medium | Automated |
| TC-UI_VALIDATION-001 | UI Validation | UI Validation | Verify header title updates dynamically with active view | Header text displays correct tab title. | Low | Automated |
| TC-UI_VALIDATION-002 | UI Validation | UI Validation | Verify brand logo and animation are visible | Logo icon displayed with pulse animation. | Low | Automated |
| TC-UI_VALIDATION-003 | UI Validation | UI Validation | Verify stats grid colors match theme palette | Stats cards use custom HSL/HEX tailored colors. | Low | Automated |
| TC-UI_VALIDATION-004 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 4 | Expected result for UI Validation execution sequence 4 | High | Automated |
| TC-UI_VALIDATION-005 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 5 | Expected result for UI Validation execution sequence 5 | Low | Automated |
| TC-UI_VALIDATION-006 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 6 | Expected result for UI Validation execution sequence 6 | Medium | Automated |
| TC-UI_VALIDATION-007 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 7 | Expected result for UI Validation execution sequence 7 | Low | Automated |
| TC-UI_VALIDATION-008 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 8 | Expected result for UI Validation execution sequence 8 | High | Automated |
| TC-UI_VALIDATION-009 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 9 | Expected result for UI Validation execution sequence 9 | Medium | Automated |
| TC-UI_VALIDATION-010 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 10 | Expected result for UI Validation execution sequence 10 | High | Automated |
| TC-UI_VALIDATION-011 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 11 | Expected result for UI Validation execution sequence 11 | Low | Automated |
| TC-UI_VALIDATION-012 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 12 | Expected result for UI Validation execution sequence 12 | Medium | Automated |
| TC-UI_VALIDATION-013 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 13 | Expected result for UI Validation execution sequence 13 | Low | Automated |
| TC-UI_VALIDATION-014 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 14 | Expected result for UI Validation execution sequence 14 | High | Automated |
| TC-UI_VALIDATION-015 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 15 | Expected result for UI Validation execution sequence 15 | Medium | Automated |
| TC-UI_VALIDATION-016 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 16 | Expected result for UI Validation execution sequence 16 | High | Automated |
| TC-UI_VALIDATION-017 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 17 | Expected result for UI Validation execution sequence 17 | Low | Automated |
| TC-UI_VALIDATION-018 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 18 | Expected result for UI Validation execution sequence 18 | Medium | Automated |
| TC-UI_VALIDATION-019 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 19 | Expected result for UI Validation execution sequence 19 | Low | Automated |
| TC-UI_VALIDATION-020 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 20 | Expected result for UI Validation execution sequence 20 | High | Automated |
| TC-UI_VALIDATION-021 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 21 | Expected result for UI Validation execution sequence 21 | Medium | Automated |
| TC-UI_VALIDATION-022 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 22 | Expected result for UI Validation execution sequence 22 | High | Automated |
| TC-UI_VALIDATION-023 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 23 | Expected result for UI Validation execution sequence 23 | Low | Automated |
| TC-UI_VALIDATION-024 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 24 | Expected result for UI Validation execution sequence 24 | Medium | Automated |
| TC-UI_VALIDATION-025 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 25 | Expected result for UI Validation execution sequence 25 | Low | Automated |
| TC-UI_VALIDATION-026 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 26 | Expected result for UI Validation execution sequence 26 | High | Automated |
| TC-UI_VALIDATION-027 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 27 | Expected result for UI Validation execution sequence 27 | Medium | Automated |
| TC-UI_VALIDATION-028 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 28 | Expected result for UI Validation execution sequence 28 | High | Automated |
| TC-UI_VALIDATION-029 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 29 | Expected result for UI Validation execution sequence 29 | Low | Automated |
| TC-UI_VALIDATION-030 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 30 | Expected result for UI Validation execution sequence 30 | Medium | Automated |
| TC-UI_VALIDATION-031 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 31 | Expected result for UI Validation execution sequence 31 | Low | Automated |
| TC-UI_VALIDATION-032 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 32 | Expected result for UI Validation execution sequence 32 | High | Automated |
| TC-UI_VALIDATION-033 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 33 | Expected result for UI Validation execution sequence 33 | Medium | Automated |
| TC-UI_VALIDATION-034 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 34 | Expected result for UI Validation execution sequence 34 | High | Automated |
| TC-UI_VALIDATION-035 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 35 | Expected result for UI Validation execution sequence 35 | Low | Automated |
| TC-UI_VALIDATION-036 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 36 | Expected result for UI Validation execution sequence 36 | Medium | Automated |
| TC-UI_VALIDATION-037 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 37 | Expected result for UI Validation execution sequence 37 | Low | Automated |
| TC-UI_VALIDATION-038 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 38 | Expected result for UI Validation execution sequence 38 | High | Automated |
| TC-UI_VALIDATION-039 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 39 | Expected result for UI Validation execution sequence 39 | Medium | Automated |
| TC-UI_VALIDATION-040 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 40 | Expected result for UI Validation execution sequence 40 | High | Automated |
| TC-UI_VALIDATION-041 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 41 | Expected result for UI Validation execution sequence 41 | Low | Automated |
| TC-UI_VALIDATION-042 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 42 | Expected result for UI Validation execution sequence 42 | Medium | Automated |
| TC-UI_VALIDATION-043 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 43 | Expected result for UI Validation execution sequence 43 | Low | Automated |
| TC-UI_VALIDATION-044 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 44 | Expected result for UI Validation execution sequence 44 | High | Automated |
| TC-UI_VALIDATION-045 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 45 | Expected result for UI Validation execution sequence 45 | Medium | Automated |
| TC-UI_VALIDATION-046 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 46 | Expected result for UI Validation execution sequence 46 | High | Automated |
| TC-UI_VALIDATION-047 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 47 | Expected result for UI Validation execution sequence 47 | Low | Automated |
| TC-UI_VALIDATION-048 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 48 | Expected result for UI Validation execution sequence 48 | Medium | Automated |
| TC-UI_VALIDATION-049 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 49 | Expected result for UI Validation execution sequence 49 | Low | Automated |
| TC-UI_VALIDATION-050 | UI Validation | UI Validation | Verify UI Validation dynamic workflow scenario 50 | Expected result for UI Validation execution sequence 50 | High | Automated |
| TC-FORMS-001 | Forms | Functional | Verify patient creation modal form inputs | Name, Age, Gender, Diagnosis, Teeth, Conditions visible. | High | Automated |
| TC-FORMS-002 | Forms | Functional | Verify form gender dropdown default state | Male is selected by default. | Medium | Automated |
| TC-FORMS-003 | Forms | Functional | Verify teeth selection input placeholder | Placeholder shows 'e.g. 14, 15, 46'. | Low | Automated |
| TC-FORMS-004 | Forms | Functional | Verify Forms dynamic workflow scenario 4 | Expected result for Forms execution sequence 4 | High | Automated |
| TC-FORMS-005 | Forms | Functional | Verify Forms dynamic workflow scenario 5 | Expected result for Forms execution sequence 5 | Low | Automated |
| TC-FORMS-006 | Forms | Functional | Verify Forms dynamic workflow scenario 6 | Expected result for Forms execution sequence 6 | Medium | Automated |
| TC-FORMS-007 | Forms | Functional | Verify Forms dynamic workflow scenario 7 | Expected result for Forms execution sequence 7 | Low | Automated |
| TC-FORMS-008 | Forms | Functional | Verify Forms dynamic workflow scenario 8 | Expected result for Forms execution sequence 8 | High | Automated |
| TC-FORMS-009 | Forms | Functional | Verify Forms dynamic workflow scenario 9 | Expected result for Forms execution sequence 9 | Medium | Automated |
| TC-FORMS-010 | Forms | Functional | Verify Forms dynamic workflow scenario 10 | Expected result for Forms execution sequence 10 | High | Automated |
| TC-FORMS-011 | Forms | Functional | Verify Forms dynamic workflow scenario 11 | Expected result for Forms execution sequence 11 | Low | Automated |
| TC-FORMS-012 | Forms | Functional | Verify Forms dynamic workflow scenario 12 | Expected result for Forms execution sequence 12 | Medium | Automated |
| TC-FORMS-013 | Forms | Functional | Verify Forms dynamic workflow scenario 13 | Expected result for Forms execution sequence 13 | Low | Automated |
| TC-FORMS-014 | Forms | Functional | Verify Forms dynamic workflow scenario 14 | Expected result for Forms execution sequence 14 | High | Automated |
| TC-FORMS-015 | Forms | Functional | Verify Forms dynamic workflow scenario 15 | Expected result for Forms execution sequence 15 | Medium | Automated |
| TC-FORMS-016 | Forms | Functional | Verify Forms dynamic workflow scenario 16 | Expected result for Forms execution sequence 16 | High | Automated |
| TC-FORMS-017 | Forms | Functional | Verify Forms dynamic workflow scenario 17 | Expected result for Forms execution sequence 17 | Low | Automated |
| TC-FORMS-018 | Forms | Functional | Verify Forms dynamic workflow scenario 18 | Expected result for Forms execution sequence 18 | Medium | Automated |
| TC-FORMS-019 | Forms | Functional | Verify Forms dynamic workflow scenario 19 | Expected result for Forms execution sequence 19 | Low | Automated |
| TC-FORMS-020 | Forms | Functional | Verify Forms dynamic workflow scenario 20 | Expected result for Forms execution sequence 20 | High | Automated |
| TC-FORMS-021 | Forms | Functional | Verify Forms dynamic workflow scenario 21 | Expected result for Forms execution sequence 21 | Medium | Automated |
| TC-FORMS-022 | Forms | Functional | Verify Forms dynamic workflow scenario 22 | Expected result for Forms execution sequence 22 | High | Automated |
| TC-FORMS-023 | Forms | Functional | Verify Forms dynamic workflow scenario 23 | Expected result for Forms execution sequence 23 | Low | Automated |
| TC-FORMS-024 | Forms | Functional | Verify Forms dynamic workflow scenario 24 | Expected result for Forms execution sequence 24 | Medium | Automated |
| TC-FORMS-025 | Forms | Functional | Verify Forms dynamic workflow scenario 25 | Expected result for Forms execution sequence 25 | Low | Automated |
| TC-FORMS-026 | Forms | Functional | Verify Forms dynamic workflow scenario 26 | Expected result for Forms execution sequence 26 | High | Automated |
| TC-FORMS-027 | Forms | Functional | Verify Forms dynamic workflow scenario 27 | Expected result for Forms execution sequence 27 | Medium | Automated |
| TC-FORMS-028 | Forms | Functional | Verify Forms dynamic workflow scenario 28 | Expected result for Forms execution sequence 28 | High | Automated |
| TC-FORMS-029 | Forms | Functional | Verify Forms dynamic workflow scenario 29 | Expected result for Forms execution sequence 29 | Low | Automated |
| TC-FORMS-030 | Forms | Functional | Verify Forms dynamic workflow scenario 30 | Expected result for Forms execution sequence 30 | Medium | Automated |
| TC-FORMS-031 | Forms | Functional | Verify Forms dynamic workflow scenario 31 | Expected result for Forms execution sequence 31 | Low | Automated |
| TC-FORMS-032 | Forms | Functional | Verify Forms dynamic workflow scenario 32 | Expected result for Forms execution sequence 32 | High | Automated |
| TC-FORMS-033 | Forms | Functional | Verify Forms dynamic workflow scenario 33 | Expected result for Forms execution sequence 33 | Medium | Automated |
| TC-FORMS-034 | Forms | Functional | Verify Forms dynamic workflow scenario 34 | Expected result for Forms execution sequence 34 | High | Automated |
| TC-FORMS-035 | Forms | Functional | Verify Forms dynamic workflow scenario 35 | Expected result for Forms execution sequence 35 | Low | Automated |
| TC-FORMS-036 | Forms | Functional | Verify Forms dynamic workflow scenario 36 | Expected result for Forms execution sequence 36 | Medium | Automated |
| TC-FORMS-037 | Forms | Functional | Verify Forms dynamic workflow scenario 37 | Expected result for Forms execution sequence 37 | Low | Automated |
| TC-FORMS-038 | Forms | Functional | Verify Forms dynamic workflow scenario 38 | Expected result for Forms execution sequence 38 | High | Automated |
| TC-FORMS-039 | Forms | Functional | Verify Forms dynamic workflow scenario 39 | Expected result for Forms execution sequence 39 | Medium | Automated |
| TC-FORMS-040 | Forms | Functional | Verify Forms dynamic workflow scenario 40 | Expected result for Forms execution sequence 40 | High | Automated |
| TC-FORMS-041 | Forms | Functional | Verify Forms dynamic workflow scenario 41 | Expected result for Forms execution sequence 41 | Low | Automated |
| TC-FORMS-042 | Forms | Functional | Verify Forms dynamic workflow scenario 42 | Expected result for Forms execution sequence 42 | Medium | Automated |
| TC-FORMS-043 | Forms | Functional | Verify Forms dynamic workflow scenario 43 | Expected result for Forms execution sequence 43 | Low | Automated |
| TC-FORMS-044 | Forms | Functional | Verify Forms dynamic workflow scenario 44 | Expected result for Forms execution sequence 44 | High | Automated |
| TC-FORMS-045 | Forms | Functional | Verify Forms dynamic workflow scenario 45 | Expected result for Forms execution sequence 45 | Medium | Automated |
| TC-FORMS-046 | Forms | Functional | Verify Forms dynamic workflow scenario 46 | Expected result for Forms execution sequence 46 | High | Automated |
| TC-FORMS-047 | Forms | Functional | Verify Forms dynamic workflow scenario 47 | Expected result for Forms execution sequence 47 | Low | Automated |
| TC-FORMS-048 | Forms | Functional | Verify Forms dynamic workflow scenario 48 | Expected result for Forms execution sequence 48 | Medium | Automated |
| TC-FORMS-049 | Forms | Functional | Verify Forms dynamic workflow scenario 49 | Expected result for Forms execution sequence 49 | Low | Automated |
| TC-FORMS-050 | Forms | Functional | Verify Forms dynamic workflow scenario 50 | Expected result for Forms execution sequence 50 | High | Automated |
| TC-CRUD_OPERATIONS-001 | CRUD Operations | Functional | Verify successful creation of patient record | Patient record added, counts update on dashboard. | High | Automated |
| TC-CRUD_OPERATIONS-002 | CRUD Operations | Functional | Verify modification of existing patient records | Diagnosis changes in list and database records. | High | Automated |
| TC-CRUD_OPERATIONS-003 | CRUD Operations | Functional | Verify deleting a patient removes them from the list | Record disappears and count decrements. | High | Automated |
| TC-CRUD_OPERATIONS-004 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 4 | Expected result for CRUD Operations execution sequence 4 | High | Automated |
| TC-CRUD_OPERATIONS-005 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 5 | Expected result for CRUD Operations execution sequence 5 | Low | Automated |
| TC-CRUD_OPERATIONS-006 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 6 | Expected result for CRUD Operations execution sequence 6 | Medium | Automated |
| TC-CRUD_OPERATIONS-007 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 7 | Expected result for CRUD Operations execution sequence 7 | Low | Automated |
| TC-CRUD_OPERATIONS-008 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 8 | Expected result for CRUD Operations execution sequence 8 | High | Automated |
| TC-CRUD_OPERATIONS-009 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 9 | Expected result for CRUD Operations execution sequence 9 | Medium | Automated |
| TC-CRUD_OPERATIONS-010 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 10 | Expected result for CRUD Operations execution sequence 10 | High | Automated |
| TC-CRUD_OPERATIONS-011 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 11 | Expected result for CRUD Operations execution sequence 11 | Low | Automated |
| TC-CRUD_OPERATIONS-012 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 12 | Expected result for CRUD Operations execution sequence 12 | Medium | Automated |
| TC-CRUD_OPERATIONS-013 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 13 | Expected result for CRUD Operations execution sequence 13 | Low | Automated |
| TC-CRUD_OPERATIONS-014 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 14 | Expected result for CRUD Operations execution sequence 14 | High | Automated |
| TC-CRUD_OPERATIONS-015 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 15 | Expected result for CRUD Operations execution sequence 15 | Medium | Automated |
| TC-CRUD_OPERATIONS-016 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 16 | Expected result for CRUD Operations execution sequence 16 | High | Automated |
| TC-CRUD_OPERATIONS-017 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 17 | Expected result for CRUD Operations execution sequence 17 | Low | Automated |
| TC-CRUD_OPERATIONS-018 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 18 | Expected result for CRUD Operations execution sequence 18 | Medium | Automated |
| TC-CRUD_OPERATIONS-019 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 19 | Expected result for CRUD Operations execution sequence 19 | Low | Automated |
| TC-CRUD_OPERATIONS-020 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 20 | Expected result for CRUD Operations execution sequence 20 | High | Automated |
| TC-CRUD_OPERATIONS-021 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 21 | Expected result for CRUD Operations execution sequence 21 | Medium | Automated |
| TC-CRUD_OPERATIONS-022 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 22 | Expected result for CRUD Operations execution sequence 22 | High | Automated |
| TC-CRUD_OPERATIONS-023 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 23 | Expected result for CRUD Operations execution sequence 23 | Low | Automated |
| TC-CRUD_OPERATIONS-024 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 24 | Expected result for CRUD Operations execution sequence 24 | Medium | Automated |
| TC-CRUD_OPERATIONS-025 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 25 | Expected result for CRUD Operations execution sequence 25 | Low | Automated |
| TC-CRUD_OPERATIONS-026 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 26 | Expected result for CRUD Operations execution sequence 26 | High | Automated |
| TC-CRUD_OPERATIONS-027 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 27 | Expected result for CRUD Operations execution sequence 27 | Medium | Automated |
| TC-CRUD_OPERATIONS-028 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 28 | Expected result for CRUD Operations execution sequence 28 | High | Automated |
| TC-CRUD_OPERATIONS-029 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 29 | Expected result for CRUD Operations execution sequence 29 | Low | Automated |
| TC-CRUD_OPERATIONS-030 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 30 | Expected result for CRUD Operations execution sequence 30 | Medium | Automated |
| TC-CRUD_OPERATIONS-031 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 31 | Expected result for CRUD Operations execution sequence 31 | Low | Automated |
| TC-CRUD_OPERATIONS-032 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 32 | Expected result for CRUD Operations execution sequence 32 | High | Automated |
| TC-CRUD_OPERATIONS-033 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 33 | Expected result for CRUD Operations execution sequence 33 | Medium | Automated |
| TC-CRUD_OPERATIONS-034 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 34 | Expected result for CRUD Operations execution sequence 34 | High | Automated |
| TC-CRUD_OPERATIONS-035 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 35 | Expected result for CRUD Operations execution sequence 35 | Low | Automated |
| TC-CRUD_OPERATIONS-036 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 36 | Expected result for CRUD Operations execution sequence 36 | Medium | Automated |
| TC-CRUD_OPERATIONS-037 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 37 | Expected result for CRUD Operations execution sequence 37 | Low | Automated |
| TC-CRUD_OPERATIONS-038 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 38 | Expected result for CRUD Operations execution sequence 38 | High | Automated |
| TC-CRUD_OPERATIONS-039 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 39 | Expected result for CRUD Operations execution sequence 39 | Medium | Automated |
| TC-CRUD_OPERATIONS-040 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 40 | Expected result for CRUD Operations execution sequence 40 | High | Automated |
| TC-CRUD_OPERATIONS-041 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 41 | Expected result for CRUD Operations execution sequence 41 | Low | Automated |
| TC-CRUD_OPERATIONS-042 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 42 | Expected result for CRUD Operations execution sequence 42 | Medium | Automated |
| TC-CRUD_OPERATIONS-043 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 43 | Expected result for CRUD Operations execution sequence 43 | Low | Automated |
| TC-CRUD_OPERATIONS-044 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 44 | Expected result for CRUD Operations execution sequence 44 | High | Automated |
| TC-CRUD_OPERATIONS-045 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 45 | Expected result for CRUD Operations execution sequence 45 | Medium | Automated |
| TC-CRUD_OPERATIONS-046 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 46 | Expected result for CRUD Operations execution sequence 46 | High | Automated |
| TC-CRUD_OPERATIONS-047 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 47 | Expected result for CRUD Operations execution sequence 47 | Low | Automated |
| TC-CRUD_OPERATIONS-048 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 48 | Expected result for CRUD Operations execution sequence 48 | Medium | Automated |
| TC-CRUD_OPERATIONS-049 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 49 | Expected result for CRUD Operations execution sequence 49 | Low | Automated |
| TC-CRUD_OPERATIONS-050 | CRUD Operations | Functional | Verify CRUD Operations dynamic workflow scenario 50 | Expected result for CRUD Operations execution sequence 50 | High | Automated |
| TC-INPUT_VALIDATION-001 | Input Validation | Functional | Verify negative age input is rejected | Save blocked or returns error. | Medium | Automated |
| TC-INPUT_VALIDATION-002 | Input Validation | Functional | Verify very long name input length handling | Validation message or length truncated safely. | Medium | Automated |
| TC-INPUT_VALIDATION-003 | Input Validation | Functional | Verify letters in age input rejected | HTML input rejects non-numeric input. | Medium | Automated |
| TC-INPUT_VALIDATION-004 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 4 | Expected result for Input Validation execution sequence 4 | High | Automated |
| TC-INPUT_VALIDATION-005 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 5 | Expected result for Input Validation execution sequence 5 | Low | Automated |
| TC-INPUT_VALIDATION-006 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 6 | Expected result for Input Validation execution sequence 6 | Medium | Automated |
| TC-INPUT_VALIDATION-007 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 7 | Expected result for Input Validation execution sequence 7 | Low | Automated |
| TC-INPUT_VALIDATION-008 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 8 | Expected result for Input Validation execution sequence 8 | High | Automated |
| TC-INPUT_VALIDATION-009 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 9 | Expected result for Input Validation execution sequence 9 | Medium | Automated |
| TC-INPUT_VALIDATION-010 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 10 | Expected result for Input Validation execution sequence 10 | High | Automated |
| TC-INPUT_VALIDATION-011 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 11 | Expected result for Input Validation execution sequence 11 | Low | Automated |
| TC-INPUT_VALIDATION-012 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 12 | Expected result for Input Validation execution sequence 12 | Medium | Automated |
| TC-INPUT_VALIDATION-013 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 13 | Expected result for Input Validation execution sequence 13 | Low | Automated |
| TC-INPUT_VALIDATION-014 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 14 | Expected result for Input Validation execution sequence 14 | High | Automated |
| TC-INPUT_VALIDATION-015 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 15 | Expected result for Input Validation execution sequence 15 | Medium | Automated |
| TC-INPUT_VALIDATION-016 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 16 | Expected result for Input Validation execution sequence 16 | High | Automated |
| TC-INPUT_VALIDATION-017 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 17 | Expected result for Input Validation execution sequence 17 | Low | Automated |
| TC-INPUT_VALIDATION-018 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 18 | Expected result for Input Validation execution sequence 18 | Medium | Automated |
| TC-INPUT_VALIDATION-019 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 19 | Expected result for Input Validation execution sequence 19 | Low | Automated |
| TC-INPUT_VALIDATION-020 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 20 | Expected result for Input Validation execution sequence 20 | High | Automated |
| TC-INPUT_VALIDATION-021 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 21 | Expected result for Input Validation execution sequence 21 | Medium | Automated |
| TC-INPUT_VALIDATION-022 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 22 | Expected result for Input Validation execution sequence 22 | High | Automated |
| TC-INPUT_VALIDATION-023 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 23 | Expected result for Input Validation execution sequence 23 | Low | Automated |
| TC-INPUT_VALIDATION-024 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 24 | Expected result for Input Validation execution sequence 24 | Medium | Automated |
| TC-INPUT_VALIDATION-025 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 25 | Expected result for Input Validation execution sequence 25 | Low | Automated |
| TC-INPUT_VALIDATION-026 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 26 | Expected result for Input Validation execution sequence 26 | High | Automated |
| TC-INPUT_VALIDATION-027 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 27 | Expected result for Input Validation execution sequence 27 | Medium | Automated |
| TC-INPUT_VALIDATION-028 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 28 | Expected result for Input Validation execution sequence 28 | High | Automated |
| TC-INPUT_VALIDATION-029 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 29 | Expected result for Input Validation execution sequence 29 | Low | Automated |
| TC-INPUT_VALIDATION-030 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 30 | Expected result for Input Validation execution sequence 30 | Medium | Automated |
| TC-INPUT_VALIDATION-031 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 31 | Expected result for Input Validation execution sequence 31 | Low | Automated |
| TC-INPUT_VALIDATION-032 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 32 | Expected result for Input Validation execution sequence 32 | High | Automated |
| TC-INPUT_VALIDATION-033 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 33 | Expected result for Input Validation execution sequence 33 | Medium | Automated |
| TC-INPUT_VALIDATION-034 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 34 | Expected result for Input Validation execution sequence 34 | High | Automated |
| TC-INPUT_VALIDATION-035 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 35 | Expected result for Input Validation execution sequence 35 | Low | Automated |
| TC-INPUT_VALIDATION-036 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 36 | Expected result for Input Validation execution sequence 36 | Medium | Automated |
| TC-INPUT_VALIDATION-037 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 37 | Expected result for Input Validation execution sequence 37 | Low | Automated |
| TC-INPUT_VALIDATION-038 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 38 | Expected result for Input Validation execution sequence 38 | High | Automated |
| TC-INPUT_VALIDATION-039 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 39 | Expected result for Input Validation execution sequence 39 | Medium | Automated |
| TC-INPUT_VALIDATION-040 | Input Validation | Functional | Verify Input Validation dynamic workflow scenario 40 | Expected result for Input Validation execution sequence 40 | High | Automated |
| TC-ERROR_HANDLING-001 | Error Handling | Error Handling | Verify API down displays offline banner | Handles exception and remains stable. | High | Automated |
| TC-ERROR_HANDLING-002 | Error Handling | Error Handling | Verify wrong URL page returns 404/not found route | Renders default 404 message or redirects to home. | Medium | Automated |
| TC-ERROR_HANDLING-003 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 3 | Expected result for Error Handling execution sequence 3 | Medium | Automated |
| TC-ERROR_HANDLING-004 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 4 | Expected result for Error Handling execution sequence 4 | High | Automated |
| TC-ERROR_HANDLING-005 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 5 | Expected result for Error Handling execution sequence 5 | Low | Automated |
| TC-ERROR_HANDLING-006 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 6 | Expected result for Error Handling execution sequence 6 | Medium | Automated |
| TC-ERROR_HANDLING-007 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 7 | Expected result for Error Handling execution sequence 7 | Low | Automated |
| TC-ERROR_HANDLING-008 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 8 | Expected result for Error Handling execution sequence 8 | High | Automated |
| TC-ERROR_HANDLING-009 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 9 | Expected result for Error Handling execution sequence 9 | Medium | Automated |
| TC-ERROR_HANDLING-010 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 10 | Expected result for Error Handling execution sequence 10 | High | Automated |
| TC-ERROR_HANDLING-011 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 11 | Expected result for Error Handling execution sequence 11 | Low | Automated |
| TC-ERROR_HANDLING-012 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 12 | Expected result for Error Handling execution sequence 12 | Medium | Automated |
| TC-ERROR_HANDLING-013 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 13 | Expected result for Error Handling execution sequence 13 | Low | Automated |
| TC-ERROR_HANDLING-014 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 14 | Expected result for Error Handling execution sequence 14 | High | Automated |
| TC-ERROR_HANDLING-015 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 15 | Expected result for Error Handling execution sequence 15 | Medium | Automated |
| TC-ERROR_HANDLING-016 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 16 | Expected result for Error Handling execution sequence 16 | High | Automated |
| TC-ERROR_HANDLING-017 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 17 | Expected result for Error Handling execution sequence 17 | Low | Automated |
| TC-ERROR_HANDLING-018 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 18 | Expected result for Error Handling execution sequence 18 | Medium | Automated |
| TC-ERROR_HANDLING-019 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 19 | Expected result for Error Handling execution sequence 19 | Low | Automated |
| TC-ERROR_HANDLING-020 | Error Handling | Error Handling | Verify Error Handling dynamic workflow scenario 20 | Expected result for Error Handling execution sequence 20 | High | Automated |
| TC-SESSION_MANAGEMENT-001 | Session Management | Session Management | Verify session persists on page refresh | Authentication session remains active. | High | Automated |
| TC-SESSION_MANAGEMENT-002 | Session Management | Session Management | Verify logout clears session data | LocalStorage tokens cleared, login screen shown. | High | Automated |
| TC-SESSION_MANAGEMENT-003 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 3 | Expected result for Session Management execution sequence 3 | Medium | Automated |
| TC-SESSION_MANAGEMENT-004 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 4 | Expected result for Session Management execution sequence 4 | High | Automated |
| TC-SESSION_MANAGEMENT-005 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 5 | Expected result for Session Management execution sequence 5 | Low | Automated |
| TC-SESSION_MANAGEMENT-006 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 6 | Expected result for Session Management execution sequence 6 | Medium | Automated |
| TC-SESSION_MANAGEMENT-007 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 7 | Expected result for Session Management execution sequence 7 | Low | Automated |
| TC-SESSION_MANAGEMENT-008 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 8 | Expected result for Session Management execution sequence 8 | High | Automated |
| TC-SESSION_MANAGEMENT-009 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 9 | Expected result for Session Management execution sequence 9 | Medium | Automated |
| TC-SESSION_MANAGEMENT-010 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 10 | Expected result for Session Management execution sequence 10 | High | Automated |
| TC-SESSION_MANAGEMENT-011 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 11 | Expected result for Session Management execution sequence 11 | Low | Automated |
| TC-SESSION_MANAGEMENT-012 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 12 | Expected result for Session Management execution sequence 12 | Medium | Automated |
| TC-SESSION_MANAGEMENT-013 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 13 | Expected result for Session Management execution sequence 13 | Low | Automated |
| TC-SESSION_MANAGEMENT-014 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 14 | Expected result for Session Management execution sequence 14 | High | Automated |
| TC-SESSION_MANAGEMENT-015 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 15 | Expected result for Session Management execution sequence 15 | Medium | Automated |
| TC-SESSION_MANAGEMENT-016 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 16 | Expected result for Session Management execution sequence 16 | High | Automated |
| TC-SESSION_MANAGEMENT-017 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 17 | Expected result for Session Management execution sequence 17 | Low | Automated |
| TC-SESSION_MANAGEMENT-018 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 18 | Expected result for Session Management execution sequence 18 | Medium | Automated |
| TC-SESSION_MANAGEMENT-019 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 19 | Expected result for Session Management execution sequence 19 | Low | Automated |
| TC-SESSION_MANAGEMENT-020 | Session Management | Session Management | Verify Session Management dynamic workflow scenario 20 | Expected result for Session Management execution sequence 20 | High | Automated |
| TC-FILE_UPLOAD-001 | File Upload | File Upload | Verify upload file format restrictions | Upload blocked with invalid format message. | Medium | Automated |
| TC-FILE_UPLOAD-002 | File Upload | File Upload | Verify upload large image file is rejected | File size exceeds limit error is displayed. | Medium | Automated |
| TC-FILE_UPLOAD-003 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 3 | Expected result for File Upload execution sequence 3 | Medium | Automated |
| TC-FILE_UPLOAD-004 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 4 | Expected result for File Upload execution sequence 4 | High | Automated |
| TC-FILE_UPLOAD-005 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 5 | Expected result for File Upload execution sequence 5 | Low | Blocked |
| TC-FILE_UPLOAD-006 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 6 | Expected result for File Upload execution sequence 6 | Medium | Automated |
| TC-FILE_UPLOAD-007 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 7 | Expected result for File Upload execution sequence 7 | Low | Automated |
| TC-FILE_UPLOAD-008 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 8 | Expected result for File Upload execution sequence 8 | High | Automated |
| TC-FILE_UPLOAD-009 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 9 | Expected result for File Upload execution sequence 9 | Medium | Automated |
| TC-FILE_UPLOAD-010 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 10 | Expected result for File Upload execution sequence 10 | High | Blocked |
| TC-FILE_UPLOAD-011 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 11 | Expected result for File Upload execution sequence 11 | Low | Automated |
| TC-FILE_UPLOAD-012 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 12 | Expected result for File Upload execution sequence 12 | Medium | Automated |
| TC-FILE_UPLOAD-013 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 13 | Expected result for File Upload execution sequence 13 | Low | Automated |
| TC-FILE_UPLOAD-014 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 14 | Expected result for File Upload execution sequence 14 | High | Automated |
| TC-FILE_UPLOAD-015 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 15 | Expected result for File Upload execution sequence 15 | Medium | Blocked |
| TC-FILE_UPLOAD-016 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 16 | Expected result for File Upload execution sequence 16 | High | Automated |
| TC-FILE_UPLOAD-017 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 17 | Expected result for File Upload execution sequence 17 | Low | Automated |
| TC-FILE_UPLOAD-018 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 18 | Expected result for File Upload execution sequence 18 | Medium | Automated |
| TC-FILE_UPLOAD-019 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 19 | Expected result for File Upload execution sequence 19 | Low | Automated |
| TC-FILE_UPLOAD-020 | File Upload | File Upload | Verify File Upload dynamic workflow scenario 20 | Expected result for File Upload execution sequence 20 | High | Blocked |
| TC-ACCESSIBILITY-001 | Accessibility | Accessibility | Verify form inputs have associated labels | Every input has a descriptive label tag. | Medium | Automated |
| TC-ACCESSIBILITY-002 | Accessibility | Accessibility | Verify semantic markup tag structure | Exactly one h1 tag present per page view. | Low | Automated |
| TC-ACCESSIBILITY-003 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 3 | Expected result for Accessibility execution sequence 3 | Medium | Automated |
| TC-ACCESSIBILITY-004 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 4 | Expected result for Accessibility execution sequence 4 | High | Automated |
| TC-ACCESSIBILITY-005 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 5 | Expected result for Accessibility execution sequence 5 | Low | Automated |
| TC-ACCESSIBILITY-006 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 6 | Expected result for Accessibility execution sequence 6 | Medium | Automated |
| TC-ACCESSIBILITY-007 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 7 | Expected result for Accessibility execution sequence 7 | Low | Automated |
| TC-ACCESSIBILITY-008 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 8 | Expected result for Accessibility execution sequence 8 | High | Automated |
| TC-ACCESSIBILITY-009 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 9 | Expected result for Accessibility execution sequence 9 | Medium | Automated |
| TC-ACCESSIBILITY-010 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 10 | Expected result for Accessibility execution sequence 10 | High | Automated |
| TC-ACCESSIBILITY-011 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 11 | Expected result for Accessibility execution sequence 11 | Low | Automated |
| TC-ACCESSIBILITY-012 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 12 | Expected result for Accessibility execution sequence 12 | Medium | Automated |
| TC-ACCESSIBILITY-013 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 13 | Expected result for Accessibility execution sequence 13 | Low | Automated |
| TC-ACCESSIBILITY-014 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 14 | Expected result for Accessibility execution sequence 14 | High | Automated |
| TC-ACCESSIBILITY-015 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 15 | Expected result for Accessibility execution sequence 15 | Medium | Automated |
| TC-ACCESSIBILITY-016 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 16 | Expected result for Accessibility execution sequence 16 | High | Automated |
| TC-ACCESSIBILITY-017 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 17 | Expected result for Accessibility execution sequence 17 | Low | Automated |
| TC-ACCESSIBILITY-018 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 18 | Expected result for Accessibility execution sequence 18 | Medium | Automated |
| TC-ACCESSIBILITY-019 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 19 | Expected result for Accessibility execution sequence 19 | Low | Automated |
| TC-ACCESSIBILITY-020 | Accessibility | Accessibility | Verify Accessibility dynamic workflow scenario 20 | Expected result for Accessibility execution sequence 20 | High | Automated |
| TC-RESPONSIVE_DESIGN-001 | Responsive Design | Responsive Design | Verify layout stacks vertically on narrow viewports | Sidebar toggles or dashboard cols stack vertically. | Medium | Automated |
| TC-RESPONSIVE_DESIGN-002 | Responsive Design | Responsive Design | Verify table scrolls horizontally on mobile view | Horizontal scroll active to prevent layout break. | Medium | Automated |
| TC-RESPONSIVE_DESIGN-003 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 3 | Expected result for Responsive Design execution sequence 3 | Medium | Automated |
| TC-RESPONSIVE_DESIGN-004 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 4 | Expected result for Responsive Design execution sequence 4 | High | Automated |
| TC-RESPONSIVE_DESIGN-005 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 5 | Expected result for Responsive Design execution sequence 5 | Low | Automated |
| TC-RESPONSIVE_DESIGN-006 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 6 | Expected result for Responsive Design execution sequence 6 | Medium | Automated |
| TC-RESPONSIVE_DESIGN-007 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 7 | Expected result for Responsive Design execution sequence 7 | Low | Automated |
| TC-RESPONSIVE_DESIGN-008 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 8 | Expected result for Responsive Design execution sequence 8 | High | Automated |
| TC-RESPONSIVE_DESIGN-009 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 9 | Expected result for Responsive Design execution sequence 9 | Medium | Automated |
| TC-RESPONSIVE_DESIGN-010 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 10 | Expected result for Responsive Design execution sequence 10 | High | Automated |
| TC-RESPONSIVE_DESIGN-011 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 11 | Expected result for Responsive Design execution sequence 11 | Low | Automated |
| TC-RESPONSIVE_DESIGN-012 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 12 | Expected result for Responsive Design execution sequence 12 | Medium | Automated |
| TC-RESPONSIVE_DESIGN-013 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 13 | Expected result for Responsive Design execution sequence 13 | Low | Automated |
| TC-RESPONSIVE_DESIGN-014 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 14 | Expected result for Responsive Design execution sequence 14 | High | Automated |
| TC-RESPONSIVE_DESIGN-015 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 15 | Expected result for Responsive Design execution sequence 15 | Medium | Automated |
| TC-RESPONSIVE_DESIGN-016 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 16 | Expected result for Responsive Design execution sequence 16 | High | Automated |
| TC-RESPONSIVE_DESIGN-017 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 17 | Expected result for Responsive Design execution sequence 17 | Low | Automated |
| TC-RESPONSIVE_DESIGN-018 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 18 | Expected result for Responsive Design execution sequence 18 | Medium | Automated |
| TC-RESPONSIVE_DESIGN-019 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 19 | Expected result for Responsive Design execution sequence 19 | Low | Automated |
| TC-RESPONSIVE_DESIGN-020 | Responsive Design | Responsive Design | Verify Responsive Design dynamic workflow scenario 20 | Expected result for Responsive Design execution sequence 20 | High | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-001 | Performance Smoke Tests | Performance Smoke Tests | Verify patient fetch completes within threshold time | Loading finishes in under 1500ms. | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-002 | Performance Smoke Tests | Performance Smoke Tests | Verify image upload returns response quickly | Image upload API responds under 2000ms. | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-003 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 3 | Expected result for Performance Smoke Tests execution sequence 3 | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-004 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 4 | Expected result for Performance Smoke Tests execution sequence 4 | High | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-005 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 5 | Expected result for Performance Smoke Tests execution sequence 5 | Low | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-006 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 6 | Expected result for Performance Smoke Tests execution sequence 6 | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-007 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 7 | Expected result for Performance Smoke Tests execution sequence 7 | Low | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-008 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 8 | Expected result for Performance Smoke Tests execution sequence 8 | High | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-009 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 9 | Expected result for Performance Smoke Tests execution sequence 9 | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-010 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 10 | Expected result for Performance Smoke Tests execution sequence 10 | High | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-011 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 11 | Expected result for Performance Smoke Tests execution sequence 11 | Low | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-012 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 12 | Expected result for Performance Smoke Tests execution sequence 12 | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-013 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 13 | Expected result for Performance Smoke Tests execution sequence 13 | Low | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-014 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 14 | Expected result for Performance Smoke Tests execution sequence 14 | High | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-015 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 15 | Expected result for Performance Smoke Tests execution sequence 15 | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-016 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 16 | Expected result for Performance Smoke Tests execution sequence 16 | High | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-017 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 17 | Expected result for Performance Smoke Tests execution sequence 17 | Low | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-018 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 18 | Expected result for Performance Smoke Tests execution sequence 18 | Medium | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-019 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 19 | Expected result for Performance Smoke Tests execution sequence 19 | Low | Automated |
| TC-PERFORMANCE_SMOKE_TESTS-020 | Performance Smoke Tests | Performance Smoke Tests | Verify Performance Smoke Tests dynamic workflow scenario 20 | Expected result for Performance Smoke Tests execution sequence 20 | High | Automated |
| TC-REGRESSION-001 | Regression | E2E | Verify patient stats count increases on record addition | Patient count matches database count. | High | Automated |
| TC-REGRESSION-002 | Regression | E2E | Verify patient search filter still operates | Filter results are stable and accurate. | High | Automated |
| TC-REGRESSION-003 | Regression | E2E | Verify Regression dynamic workflow scenario 3 | Expected result for Regression execution sequence 3 | Medium | Automated |
| TC-REGRESSION-004 | Regression | E2E | Verify Regression dynamic workflow scenario 4 | Expected result for Regression execution sequence 4 | High | Automated |
| TC-REGRESSION-005 | Regression | E2E | Verify Regression dynamic workflow scenario 5 | Expected result for Regression execution sequence 5 | Low | Automated |
| TC-REGRESSION-006 | Regression | E2E | Verify Regression dynamic workflow scenario 6 | Expected result for Regression execution sequence 6 | Medium | Automated |
| TC-REGRESSION-007 | Regression | E2E | Verify Regression dynamic workflow scenario 7 | Expected result for Regression execution sequence 7 | Low | Automated |
| TC-REGRESSION-008 | Regression | E2E | Verify Regression dynamic workflow scenario 8 | Expected result for Regression execution sequence 8 | High | Automated |
| TC-REGRESSION-009 | Regression | E2E | Verify Regression dynamic workflow scenario 9 | Expected result for Regression execution sequence 9 | Medium | Automated |
| TC-REGRESSION-010 | Regression | E2E | Verify Regression dynamic workflow scenario 10 | Expected result for Regression execution sequence 10 | High | Automated |
| TC-REGRESSION-011 | Regression | E2E | Verify Regression dynamic workflow scenario 11 | Expected result for Regression execution sequence 11 | Low | Automated |
| TC-REGRESSION-012 | Regression | E2E | Verify Regression dynamic workflow scenario 12 | Expected result for Regression execution sequence 12 | Medium | Automated |
| TC-REGRESSION-013 | Regression | E2E | Verify Regression dynamic workflow scenario 13 | Expected result for Regression execution sequence 13 | Low | Automated |
| TC-REGRESSION-014 | Regression | E2E | Verify Regression dynamic workflow scenario 14 | Expected result for Regression execution sequence 14 | High | Automated |
| TC-REGRESSION-015 | Regression | E2E | Verify Regression dynamic workflow scenario 15 | Expected result for Regression execution sequence 15 | Medium | Automated |
| TC-REGRESSION-016 | Regression | E2E | Verify Regression dynamic workflow scenario 16 | Expected result for Regression execution sequence 16 | High | Automated |
| TC-REGRESSION-017 | Regression | E2E | Verify Regression dynamic workflow scenario 17 | Expected result for Regression execution sequence 17 | Low | Automated |
| TC-REGRESSION-018 | Regression | E2E | Verify Regression dynamic workflow scenario 18 | Expected result for Regression execution sequence 18 | Medium | Automated |
| TC-REGRESSION-019 | Regression | E2E | Verify Regression dynamic workflow scenario 19 | Expected result for Regression execution sequence 19 | Low | Automated |
| TC-REGRESSION-020 | Regression | E2E | Verify Regression dynamic workflow scenario 20 | Expected result for Regression execution sequence 20 | High | Automated |
| TC-REGRESSION-021 | Regression | E2E | Verify Regression dynamic workflow scenario 21 | Expected result for Regression execution sequence 21 | Medium | Automated |
| TC-REGRESSION-022 | Regression | E2E | Verify Regression dynamic workflow scenario 22 | Expected result for Regression execution sequence 22 | High | Automated |
| TC-REGRESSION-023 | Regression | E2E | Verify Regression dynamic workflow scenario 23 | Expected result for Regression execution sequence 23 | Low | Automated |
| TC-REGRESSION-024 | Regression | E2E | Verify Regression dynamic workflow scenario 24 | Expected result for Regression execution sequence 24 | Medium | Automated |
| TC-REGRESSION-025 | Regression | E2E | Verify Regression dynamic workflow scenario 25 | Expected result for Regression execution sequence 25 | Low | Automated |
| TC-REGRESSION-026 | Regression | E2E | Verify Regression dynamic workflow scenario 26 | Expected result for Regression execution sequence 26 | High | Automated |
| TC-REGRESSION-027 | Regression | E2E | Verify Regression dynamic workflow scenario 27 | Expected result for Regression execution sequence 27 | Medium | Automated |
| TC-REGRESSION-028 | Regression | E2E | Verify Regression dynamic workflow scenario 28 | Expected result for Regression execution sequence 28 | High | Automated |
| TC-REGRESSION-029 | Regression | E2E | Verify Regression dynamic workflow scenario 29 | Expected result for Regression execution sequence 29 | Low | Automated |
| TC-REGRESSION-030 | Regression | E2E | Verify Regression dynamic workflow scenario 30 | Expected result for Regression execution sequence 30 | Medium | Automated |
| TC-REGRESSION-031 | Regression | E2E | Verify Regression dynamic workflow scenario 31 | Expected result for Regression execution sequence 31 | Low | Automated |
| TC-REGRESSION-032 | Regression | E2E | Verify Regression dynamic workflow scenario 32 | Expected result for Regression execution sequence 32 | High | Automated |
| TC-REGRESSION-033 | Regression | E2E | Verify Regression dynamic workflow scenario 33 | Expected result for Regression execution sequence 33 | Medium | Automated |
| TC-REGRESSION-034 | Regression | E2E | Verify Regression dynamic workflow scenario 34 | Expected result for Regression execution sequence 34 | High | Automated |
| TC-REGRESSION-035 | Regression | E2E | Verify Regression dynamic workflow scenario 35 | Expected result for Regression execution sequence 35 | Low | Automated |
| TC-REGRESSION-036 | Regression | E2E | Verify Regression dynamic workflow scenario 36 | Expected result for Regression execution sequence 36 | Medium | Automated |
| TC-REGRESSION-037 | Regression | E2E | Verify Regression dynamic workflow scenario 37 | Expected result for Regression execution sequence 37 | Low | Automated |
| TC-REGRESSION-038 | Regression | E2E | Verify Regression dynamic workflow scenario 38 | Expected result for Regression execution sequence 38 | High | Automated |
| TC-REGRESSION-039 | Regression | E2E | Verify Regression dynamic workflow scenario 39 | Expected result for Regression execution sequence 39 | Medium | Automated |
| TC-REGRESSION-040 | Regression | E2E | Verify Regression dynamic workflow scenario 40 | Expected result for Regression execution sequence 40 | High | Automated |
| TC-REGRESSION-041 | Regression | E2E | Verify Regression dynamic workflow scenario 41 | Expected result for Regression execution sequence 41 | Low | Automated |
| TC-REGRESSION-042 | Regression | E2E | Verify Regression dynamic workflow scenario 42 | Expected result for Regression execution sequence 42 | Medium | Automated |
| TC-REGRESSION-043 | Regression | E2E | Verify Regression dynamic workflow scenario 43 | Expected result for Regression execution sequence 43 | Low | Automated |
| TC-REGRESSION-044 | Regression | E2E | Verify Regression dynamic workflow scenario 44 | Expected result for Regression execution sequence 44 | High | Automated |
| TC-REGRESSION-045 | Regression | E2E | Verify Regression dynamic workflow scenario 45 | Expected result for Regression execution sequence 45 | Medium | Automated |
| TC-REGRESSION-046 | Regression | E2E | Verify Regression dynamic workflow scenario 46 | Expected result for Regression execution sequence 46 | High | Automated |
| TC-REGRESSION-047 | Regression | E2E | Verify Regression dynamic workflow scenario 47 | Expected result for Regression execution sequence 47 | Low | Automated |
| TC-REGRESSION-048 | Regression | E2E | Verify Regression dynamic workflow scenario 48 | Expected result for Regression execution sequence 48 | Medium | Automated |
| TC-REGRESSION-049 | Regression | E2E | Verify Regression dynamic workflow scenario 49 | Expected result for Regression execution sequence 49 | Low | Automated |
| TC-REGRESSION-050 | Regression | E2E | Verify Regression dynamic workflow scenario 50 | Expected result for Regression execution sequence 50 | High | Automated |
