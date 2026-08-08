package com.simats.endo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }

    val gradientColors = listOf(
        Color(0xFF2470B2), // Top blue
        Color(0xFF0F2C4C)  // Bottom dark blue
    )
    val accentGreen = Color(0xFF1DD258)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(gradientColors)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Icon container with badge
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                // Main glassmorphism box
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.White.copy(alpha = 0.15f))
                        .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(32.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = getToothIcon(),
                        contentDescription = "Tooth Icon",
                        tint = Color.White,
                        modifier = Modifier.size(56.dp)
                    )
                }

                // Green sparkle badge
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 12.dp, y = (-12).dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(accentGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.AutoAwesome,
                        contentDescription = "AI Sparkle",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Title: EndoAI
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Endo")
                    }
                    withStyle(style = SpanStyle(color = accentGreen)) {
                        append("AI")
                    }
                },
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Subtitle
            Text(
                text = "AI Powered Endodontic Monitoring",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 48.dp)
            )

            // Progress bar
            Box(
                modifier = Modifier
                    .width(220.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Loading text
            Text(
                text = "INITIALISING CLINICAL MODELS",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp
            )
        }
    }
}

// A custom ImageVector for the tooth icon
private fun getToothIcon(): ImageVector {
    return ImageVector.Builder(
        name = "Tooth",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            fill = SolidColor(Color.White),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            // A simplified tooth shape
            moveTo(12f, 2f)
            curveTo(7f, 2f, 4f, 5f, 4f, 10f)
            curveTo(4f, 14f, 7f, 16f, 8f, 20f)
            curveTo(8.5f, 22f, 10f, 22f, 11f, 20f)
            lineTo(12f, 17f)
            lineTo(13f, 20f)
            curveTo(14f, 22f, 15.5f, 22f, 16f, 20f)
            curveTo(17f, 16f, 20f, 14f, 20f, 10f)
            curveTo(20f, 5f, 17f, 2f, 12f, 2f)
            close()
        }
        // Draw the medical cross in the middle of the tooth
        path(
            fill = SolidColor(Color(0xFF2470B2)), // same as top blue to look transparent
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(13f, 7f)
            lineTo(11f, 7f)
            lineTo(11f, 10f)
            lineTo(8f, 10f)
            lineTo(8f, 12f)
            lineTo(11f, 12f)
            lineTo(11f, 15f)
            lineTo(13f, 15f)
            lineTo(13f, 12f)
            lineTo(16f, 12f)
            lineTo(16f, 10f)
            lineTo(13f, 10f)
            close()
        }
    }.build()
}
