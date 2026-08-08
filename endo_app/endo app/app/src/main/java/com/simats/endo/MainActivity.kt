package com.simats.endo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simats.endo.ui.theme.AppTheme
// TODO: Replace with your actual Supabase URL
const val SUPABASE_URL = "https://YOUR_PROJECT_ID.supabase.co"
const val SUPABASE_KEY = "sb_publishable_8c1OCiQ7Mx-mP7Bva3HyyQ_gcajQpfL"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val endoViewModel: EndoViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
            val isDarkMode by endoViewModel.isDarkMode.collectAsState()

            AppTheme(useDarkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(onTimeout = {
                                navController.navigate("login") {
                                    popUpTo("splash") { inclusive = true }
                                }
                            })
                        }
                        composable("login") {
                            LoginScreen(
                                viewModel = endoViewModel,
                                onLoginSuccess = {
                                    navController.navigate("dashboard") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                },
                                onCreateAccountClick = {
                                    navController.navigate("signup")
                                },
                                onForgotPasswordClick = {
                                    navController.navigate("forgot_password")
                                }
                            )
                        }
                        composable("signup") {
                            SignupScreen(
                                viewModel = endoViewModel,
                                onSignupSuccess = {
                                    navController.navigate("login") {
                                        popUpTo("signup") { inclusive = true }
                                    }
                                },
                                onLoginClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("forgot_password") {
                            ForgotPasswordScreen(
                                viewModel = endoViewModel,
                                onBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("dashboard") {
                            LaunchedEffect(Unit) {
                                endoViewModel.fetchDashboardStats()
                            }
                            DashboardScreen(
                                viewModel = endoViewModel,
                                onNewPatientClick = {
                                    endoViewModel.updatePersonalData("", "", "") // clear previous
                                    navController.navigate("new_patient")
                                },
                                onPatientsClick = {
                                    navController.navigate("patients")
                                },
                                onReportsClick = {
                                    navController.navigate("reports")
                                },
                                onSettingsClick = {
                                    navController.navigate("settings")
                                }
                            )
                        }
                        composable("patients") {
                            PatientListScreen(
                                viewModel = endoViewModel,
                                onBack = { navController.popBackStack() },
                                onViewPatient = { reportId ->
                                    navController.navigate("report_detail/$reportId")
                                },
                                onEditPatient = { reportId ->
                                    endoViewModel.loadPatientForEdit(reportId)
                                    navController.navigate("new_patient")
                                }
                            )
                        }
                        composable("reports") {
                            ReportListScreen(
                                viewModel = endoViewModel,
                                onBack = { navController.popBackStack() },
                                onViewReport = { reportId ->
                                    navController.navigate("report_detail/$reportId")
                                }
                            )
                        }
                        composable("report_detail/{reportId}") { backStackEntry ->
                            val reportId = backStackEntry.arguments?.getString("reportId")
                            val report = endoViewModel.savedReports.value.find { it.id == reportId }
                            if (report != null) {
                                ReportDetailScreen(
                                    report = report,
                                    onBack = { navController.popBackStack() }
                                )
                            }
                        }
                        composable("new_patient") {
                            NewPatientScreen(
                                viewModel = endoViewModel,
                                onBack = {
                                    navController.popBackStack()
                                },
                                onSave = {
                                    navController.navigate("treatment_stages") {
                                        popUpTo("dashboard") { inclusive = false }
                                    }
                                }
                            )
                        }
                        composable("treatment_stages") {
                            TreatmentStagesScreen(
                                viewModel = endoViewModel,
                                onBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("settings") {
                            SettingsScreen(
                                viewModel = endoViewModel,
                                onDashboardClick = {
                                    navController.navigate("dashboard") {
                                        popUpTo("dashboard") { inclusive = true }
                                    }
                                },
                                onPatientsClick = {
                                    navController.navigate("patients")
                                },
                                onReportsClick = {
                                    navController.navigate("reports")
                                },
                                onLogoutClick = {
                                    navController.navigate("login") {
                                        popUpTo("dashboard") { inclusive = true }
                                    }
                                },
                                onEditProfileClick = {
                                    navController.navigate("edit_profile")
                                },
                                onPrivacyClick = {
                                    navController.navigate("privacy_security")
                                }
                            )
                        }
                        composable("edit_profile") {
                            EditProfileScreen(
                                viewModel = endoViewModel,
                                onBack = { navController.popBackStack() }
                            )
                        }
                        composable("privacy_security") {
                            PrivacySecurityScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}