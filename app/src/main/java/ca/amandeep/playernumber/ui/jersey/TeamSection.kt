@file:OptIn(ExperimentalTextApi::class)

package ca.amandeep.playernumber.ui.jersey

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.data.AnyPlayer
import ca.amandeep.playernumber.data.AnyTeam
import ca.amandeep.playernumber.data.MlbTeamRefs
import ca.amandeep.playernumber.data.NbaTeamRefs
import ca.amandeep.playernumber.data.NflTeamRefs
import ca.amandeep.playernumber.ui.adaptive.SizeBucket
import ca.amandeep.playernumber.ui.theme.FontWidth
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.theme.withFontWidth
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import ca.amandeep.playernumber.ui.utils.legibleBlendToward
import ca.amandeep.playernumber.ui.utils.themedTeamBackground
import java.util.Locale
import java.util.Locale.ROOT

@Composable
internal fun TeamSection(
    player: AnyPlayer?,
    jerseyNumber: String,
    team: AnyTeam,
    heightBucket: SizeBucket,
    contentPadding: PaddingValues,
    centerBiasTopWeight: Float,
    modifier: Modifier = Modifier,
    chipSpacing: Dp = 12.dp,
) {
    val centerBiasBottomWeight = CENTER_BIAS_TOTAL_WEIGHT - centerBiasTopWeight
    val isDarkTheme = isSystemInDarkTheme()
    val backgroundColor =
        remember(team.colors.primary, isDarkTheme) {
            themedTeamBackground(team.colors.primary, isDarkTheme)
        }
    val nameAccent = team.colors.nameAccent
    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .background(backgroundColor),
    ) {
        val shortTeamName = remember(team.name) { team.nickname() }
        AnimatedContent(
            targetState = TeamSectionContent(player = player, jerseyNumber = jerseyNumber),
            transitionSpec = {
                val fadeInSpec = tween<Float>(durationMillis = 220, delayMillis = 80)
                val fadeOutSpec = tween<Float>(durationMillis = 140)
                val scaleInSpec = tween<Float>(durationMillis = 220, delayMillis = 80)
                val scaleOutSpec = tween<Float>(durationMillis = 140)
                (
                    fadeIn(animationSpec = fadeInSpec) +
                        scaleIn(
                            initialScale = 0.98f,
                            animationSpec = scaleInSpec,
                        )
                ) togetherWith (
                    fadeOut(animationSpec = fadeOutSpec) +
                        scaleOut(
                            targetScale = 0.98f,
                            animationSpec = scaleOutSpec,
                        )
                )
            },
            label = "playerContent",
        ) { content ->
            val displayPlayer = content.player
            val positionLabel = displayPlayer?.position?.longName
            val (firstNameMinSize, firstNameMaxSize) =
                when (heightBucket) {
                    SizeBucket.Small -> 6.sp to 12.sp
                    SizeBucket.Medium -> 6.sp to 16.sp
                    SizeBucket.Large -> 8.sp to 18.sp
                }
            val firstNameAutoSize =
                remember(heightBucket) {
                    TextAutoSize.StepBased(
                        minFontSize = firstNameMinSize,
                        maxFontSize = firstNameMaxSize,
                    )
                }
            val (lastNameMinSize, lastNameMaxSize) =
                when (heightBucket) {
                    SizeBucket.Small -> 14.sp to 28.sp
                    SizeBucket.Medium -> 16.sp to 42.sp
                    SizeBucket.Large -> 20.sp to 64.sp
                }
            val lastNameAutoSize =
                remember(heightBucket) {
                    TextAutoSize.StepBased(
                        minFontSize = lastNameMinSize,
                        maxFontSize = lastNameMaxSize,
                    )
                }

            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp)
                        .padding(contentPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(centerBiasTopWeight, fill = true))

                if (displayPlayer == null) {
                    val displayNumber = content.jerseyNumber
                    if (displayNumber.isNotEmpty()) {
                        Text(
                            text =
                                stringResource(
                                    R.string.no_team_number,
                                    shortTeamName,
                                    displayNumber,
                                ),
                            style =
                                MaterialTheme.typography.titleLarge.copy(
                                    letterSpacing = 1.5.sp,
                                    lineHeightStyle = SingleLineHeightStyle,
                                ),
                            color =
                                legibleBlendToward(
                                    background = backgroundColor,
                                    desiredTextColor = nameAccent.copy(alpha = 0.8f),
                                    minContrast = 2.5,
                                ),
                            fontWeight = FontWeight.Medium,
                        )
                    }
                } else {
                    Text(
                        text = displayPlayer.firstNameWithSuffix.uppercase(Locale.ROOT),
                        style =
                            MaterialTheme.typography.titleMedium.copy(
                                letterSpacing = 3.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = firstNameMaxSize,
                                lineHeight = firstNameMaxSize,
                                platformStyle = PlatformTextStyle(includeFontPadding = false),
                                lineHeightStyle = SingleLineHeightStyle,
                            ),
                        color =
                            legibleBlendToward(
                                background = backgroundColor,
                                onBackground = MaterialTheme.colorScheme.onSurface,
                                desiredTextColor = nameAccent.copy(alpha = 0.75f),
                                minContrast = 5.5,
                            ),
                        maxLines = 1,
                        autoSize = firstNameAutoSize,
                    )
                    Text(
                        text = displayPlayer.lastName.uppercase(ROOT),
                        style =
                            MaterialTheme.typography.displayLarge.copy(
                                letterSpacing = (-0.3).sp,
                                fontWeight = FontWeight.Black,
                                fontSize = lastNameMaxSize,
                                lineHeight = lastNameMaxSize,
                                platformStyle = PlatformTextStyle(includeFontPadding = false),
                                lineHeightStyle = SingleLineHeightStyle,
                            ),
                        color =
                            legibleBlendToward(
                                background = backgroundColor,
                                desiredTextColor = nameAccent,
                                minContrast = 4.0,
                            ),
                        maxLines = 1,
                        autoSize = lastNameAutoSize,
                    )
                }

                if (positionLabel != null) {
                    Spacer(modifier = Modifier.height(chipSpacing))
                    PositionLabel(
                        positionLabel = positionLabel,
                        heightBucket = heightBucket,
                    )
                }

                Spacer(modifier = Modifier.weight(centerBiasBottomWeight, fill = true))
            }
        }
    }
}

@Composable
private fun PositionLabel(
    positionLabel: String,
    heightBucket: SizeBucket,
) {
    val positionalLabelUpper = positionLabel.uppercase(ROOT)
    if (heightBucket == SizeBucket.Small) {
        val labelStyle = MaterialTheme.typography.labelSmall
        Text(
            text = positionalLabelUpper,
            color = MaterialTheme.colorScheme.onSurface,
            letterSpacing = 5.sp,
            fontWeight = FontWeight.Normal,
            style =
                labelStyle.copy(
                    lineHeight = labelStyle.fontSize,
                    lineHeightStyle = SingleLineHeightStyle,
                ),
            maxLines = 1,
        )
    } else {
        Surface(
            color = Color.White.copy(alpha = if (isSystemInDarkTheme()) 0.10f else 0.45f),
            contentColor =
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = if (isSystemInDarkTheme()) 0.92f else 0.90f,
                ),
            shape = CircleShape,
            border =
                BorderStroke(
                    width = 1.dp,
                    color = Color.White.copy(alpha = if (isSystemInDarkTheme()) 0.1f else 0.3f),
                ),
        ) {
            Text(
                text = positionalLabelUpper,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                style =
                    MaterialTheme.typography.labelSmall.copy(
                        lineHeightStyle = SingleLineHeightStyle,
                    ),
            )
        }
    }
}

private data class TeamSectionContent(
    val player: AnyPlayer?,
    val jerseyNumber: String,
)

@PreviewLightDark
@Composable
private fun TeamSectionWithPlayerPreview(
    @PreviewParameter(TeamSectionWithPlayerPreviewProvider::class) team: AnyTeam,
) {
    PlayerNumberTheme {
        val previewPlayer = team.roster.firstOrNull()
        Box(
            modifier = Modifier.size(320.dp, 220.dp),
        ) {
            TeamSection(
                player = previewPlayer,
                jerseyNumber = previewPlayer?.jerseyNumber.orEmpty(),
                team = team,
                heightBucket = SizeBucket.Medium,
                contentPadding = PaddingValues(),
                centerBiasTopWeight = 1f,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun TeamSectionEmptyPreview(
    @PreviewParameter(TeamSectionWithPlayerPreviewProvider::class) team: AnyTeam,
) {
    PlayerNumberTheme {
        Box(
            modifier = Modifier.size(320.dp, 220.dp),
        ) {
            TeamSection(
                player = null,
                jerseyNumber = team.roster[team.roster.size / 2].jerseyNumber,
                team = team,
                heightBucket = SizeBucket.Medium,
                contentPadding = PaddingValues(),
                centerBiasTopWeight = 1f,
            )
        }
    }
}

private class TeamSectionWithPlayerPreviewProvider : PreviewParameterProvider<AnyTeam> {
    private val previewValues =
        listOf(
            MlbTeamRefs.TOR,
            MlbTeamRefs.NYM,
            MlbTeamRefs.PHI,
            NflTeamRefs.MIN,
            NbaTeamRefs.BOS,
            MlbTeamRefs.SD,
        )

    override val values: Sequence<AnyTeam> = previewValues.asSequence()

    override fun getDisplayName(index: Int): String? {
        val value = previewValues.getOrNull(index) ?: return null
        return value.abbreviation
    }
}

internal const val CENTER_BIAS_TOTAL_WEIGHT = 2f
