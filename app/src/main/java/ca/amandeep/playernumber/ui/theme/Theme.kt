@file:OptIn(ExperimentalTextApi::class)

package ca.amandeep.playernumber.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.R

// Sportsy red/blue brand accents + premium gold (kept punchy), with colorful tinted neutrals.
private val ACCENT_RED = Color(0xFFD62839)
private val ACCENT_BLUE = Color(0xFF1D63D5)
private val ACCENT_GOLD = Color(0xFFE0B24A)

// Colorful backgrounds (farther from pure white/black)
private val LIGHT_BG = Color(0xFFEAF0FF) // airy periwinkle paper
private val DARK_BG = Color(0xFF111A2A) // deep navy (not black)

val PlayerNumberLightColorScheme =
    lightColorScheme(
        primary = ACCENT_RED,
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFFFDADB),
        onPrimaryContainer = Color(0xFF41000A),
        inversePrimary = Color(0xFFFFB3B8),
        secondary = ACCENT_BLUE,
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFDCE2FF),
        onSecondaryContainer = Color(0xFF001A43),
        tertiary = ACCENT_GOLD,
        onTertiary = Color(0xFF2D1D00),
        tertiaryContainer = Color(0xFFFFE8C7),
        onTertiaryContainer = Color(0xFF2A1700),
        background = LIGHT_BG,
        onBackground = Color(0xFF141B2B),
        surface = LIGHT_BG,
        onSurface = Color(0xFF141B2B),
        // Slightly stronger tint for dividers, chips, secondary surfaces
        surfaceVariant = Color(0xFFD2DAF0),
        onSurfaceVariant = Color(0xFF3F475E),
        surfaceTint = ACCENT_RED,
        inverseSurface = Color(0xFF2A3144),
        inverseOnSurface = Color(0xFFF0F3FF),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        outline = Color(0xFF6E768D),
        outlineVariant = Color(0xFFB8C1DA),
        scrim = Color(0xFF000000),
        // Tone-based surface containers (colorful, clearly not white)
        surfaceBright = Color(0xFFF3F6FF),
        surfaceDim = Color(0xFFD7DEF2),
        surfaceContainerLowest = Color(0xFFF7F9FF),
        surfaceContainerLow = Color(0xFFE6EEFF),
        surfaceContainer = Color(0xFFDEE7FA),
        surfaceContainerHigh = Color(0xFFD6E0F4),
        surfaceContainerHighest = Color(0xFFCED9EE),
    )

val PlayerNumberDarkColorScheme =
    darkColorScheme(
        primary = Color(0xFFFFB3B8),
        onPrimary = Color(0xFF6D0011),
        primaryContainer = Color(0xFF9A1B2B),
        onPrimaryContainer = Color(0xFFFFDADB),
        inversePrimary = ACCENT_RED,
        secondary = Color(0xFFB4C7FF),
        onSecondary = Color(0xFF00306E),
        secondaryContainer = Color(0xFF1A4A99),
        onSecondaryContainer = Color(0xFFDCE2FF),
        tertiary = Color(0xFFFFD188),
        onTertiary = Color(0xFF432C00),
        tertiaryContainer = Color(0xFF634400),
        onTertiaryContainer = Color(0xFFFFE8C7),
        background = DARK_BG,
        onBackground = Color(0xFFE6EBFF),
        surface = DARK_BG,
        onSurface = Color(0xFFE6EBFF),
        surfaceVariant = Color(0xFF3D4A69),
        onSurfaceVariant = Color(0xFFD0D9F0),
        surfaceTint = Color(0xFFFFB3B8),
        inverseSurface = Color(0xFFE6EBFF),
        inverseOnSurface = Color(0xFF2A3144),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        outline = Color(0xFF9EACC9),
        outlineVariant = Color(0xFF3D4A69),
        scrim = Color(0xFF000000),
        // Tone-based surface containers (navy-tinted, clearly away from black)
        surfaceBright = Color(0xFF2B3B61),
        surfaceDim = Color(0xFF0D1421),
        surfaceContainerLowest = Color(0xFF0D1421),
        surfaceContainerLow = Color(0xFF111A2A),
        surfaceContainer = Color(0xFF152036),
        surfaceContainerHigh = Color(0xFF1A2742),
        surfaceContainerHighest = Color(0xFF213152),
    )

// Expressive vibe: bigger headlines, punchier labels
private val BaseTypography = Typography()
private val GoogleSansFlexWeights =
    listOf(
        FontWeight.Thin,
        FontWeight.ExtraLight,
        FontWeight.Light,
        FontWeight.Normal,
        FontWeight.Medium,
        FontWeight.SemiBold,
        FontWeight.Bold,
        FontWeight.ExtraBold,
        FontWeight.Black,
    )

internal fun googleSansFlexFamily(width: FontWidth? = null): FontFamily {
    val fonts =
        GoogleSansFlexWeights.map { weight ->
            val settings =
                mutableListOf(
                    FontVariation.weight(weight.weight),
                )
            if (width != null) {
                settings.add(FontVariation.width(width.axisValue))
            }
            Font(
                R.font.google_sans_flex_variable,
                weight = weight,
                variationSettings = FontVariation.Settings(*settings.toTypedArray()),
            )
        }
    return FontFamily(*fonts.toTypedArray())
}

private val GoogleSansFlex = googleSansFlexFamily()
private val GoogleSansFlexSuperCondensed = googleSansFlexFamily(FontWidth.SuperCondensed)
private val GoogleSansFlexUltraCondensed = googleSansFlexFamily(FontWidth.UltraCondensed)
private val GoogleSansFlexExtraCondensed = googleSansFlexFamily(FontWidth.ExtraCondensed)
private val GoogleSansFlexCondensed = googleSansFlexFamily(FontWidth.Condensed)
private val GoogleSansFlexSemiCondensed = googleSansFlexFamily(FontWidth.SemiCondensed)

enum class FontWidth(
    val axisValue: Float,
) {
    SuperCondensed(25f),
    UltraCondensed(50f),
    ExtraCondensed(62.5f),
    Condensed(75f),
    SemiCondensed(87.5f),
}

private fun googleSansFlexFamilyFor(width: FontWidth): FontFamily =
    when (width) {
        FontWidth.SuperCondensed -> GoogleSansFlexSuperCondensed
        FontWidth.UltraCondensed -> GoogleSansFlexUltraCondensed
        FontWidth.ExtraCondensed -> GoogleSansFlexExtraCondensed
        FontWidth.Condensed -> GoogleSansFlexCondensed
        FontWidth.SemiCondensed -> GoogleSansFlexSemiCondensed
    }

fun TextStyle.withFontWidth(width: FontWidth?): TextStyle = width?.let { copy(fontFamily = googleSansFlexFamilyFor(it)) } ?: this

val PlayerNumberTypography =
    Typography(
        displayLarge =
            BaseTypography.displayLarge.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.Black,
                fontSize = 64.sp,
                lineHeight = 72.sp,
                letterSpacing = (-0.25).sp,
            ),
        displayMedium =
            BaseTypography.displayMedium.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 52.sp,
                lineHeight = 60.sp,
                letterSpacing = 0.sp,
            ),
        displaySmall =
            BaseTypography.displaySmall.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 44.sp,
                lineHeight = 52.sp,
                letterSpacing = 0.sp,
            ),
        headlineLarge =
            BaseTypography.headlineLarge.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                lineHeight = 44.sp,
                letterSpacing = 0.sp,
            ),
        headlineMedium =
            BaseTypography.headlineMedium.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                letterSpacing = 0.sp,
            ),
        headlineSmall =
            BaseTypography.headlineSmall.copy(
                fontFamily = GoogleSansFlex,
                letterSpacing = 0.sp,
            ),
        titleLarge =
            BaseTypography.titleLarge.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
        titleMedium =
            BaseTypography.titleMedium.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.15.sp,
            ),
        titleSmall =
            BaseTypography.titleSmall.copy(
                fontFamily = GoogleSansFlex,
                letterSpacing = 0.1.sp,
            ),
        bodyLarge =
            BaseTypography.bodyLarge.copy(
                fontFamily = GoogleSansFlex,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
        bodyMedium =
            BaseTypography.bodyMedium.copy(
                fontFamily = GoogleSansFlex,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
            ),
        bodySmall =
            BaseTypography.bodySmall.copy(
                fontFamily = GoogleSansFlex,
                letterSpacing = 0.4.sp,
            ),
        labelLarge =
            BaseTypography.labelLarge.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                letterSpacing = 0.1.sp,
            ),
        labelMedium =
            BaseTypography.labelMedium.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp,
            ),
        labelSmall =
            BaseTypography.labelSmall.copy(
                fontFamily = GoogleSansFlex,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.5.sp,
            ),
    )

// Expressive vibe: rounder corners (cards/sheets/buttons feel friendlier)
val PlayerNumberShapes =
    Shapes(
        extraSmall = RoundedCornerShape(8.dp),
        small = RoundedCornerShape(12.dp),
        medium = RoundedCornerShape(18.dp),
        large = RoundedCornerShape(26.dp),
        extraLarge = RoundedCornerShape(34.dp),
    )

@Composable
fun PlayerNumberTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors =
        when {
            darkTheme -> PlayerNumberDarkColorScheme
            else -> PlayerNumberLightColorScheme
        }

    MaterialTheme(
        colorScheme = colors,
        typography = PlayerNumberTypography,
        shapes = PlayerNumberShapes,
        content = content,
    )
}
