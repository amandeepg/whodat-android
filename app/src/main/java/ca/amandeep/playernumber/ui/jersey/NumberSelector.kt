@file:OptIn(ExperimentalTextApi::class)

package ca.amandeep.playernumber.ui.jersey

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.amandeep.playernumber.R
import ca.amandeep.playernumber.ui.adaptive.SizeBucket
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import ca.amandeep.playernumber.ui.utils.SingleLineHeightStyle
import ca.amandeep.playernumber.ui.utils.SquircleShape

@Composable
internal fun rememberNumberEntryTextStyle(): TextStyle {
    val baseStyle = MaterialTheme.typography.displayMedium
    val color = MaterialTheme.colorScheme.onSurface
    return remember(baseStyle, color) {
        baseStyle.copy(
            textAlign = TextAlign.Center,
            color = color,
            fontWeight = FontWeight.Black,
            fontSize = 48.sp,
            lineHeight = 48.sp,
            letterSpacing = (-0.5).sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false),
            lineHeightStyle = SingleLineHeightStyle,
            fontFeatureSettings = "tnum",
        )
    }
}

@Composable
internal fun rememberNumberEntryDiameter(
    textStyle: TextStyle,
    innerPadding: Dp,
): Dp {
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()

    // Measure a fixed sample string instead of the actual value
    val sampleLayout =
        remember(textMeasurer, density, textStyle) {
            textMeasurer.measure(
                text = AnnotatedString("99"),
                style = textStyle,
                maxLines = 1,
                softWrap = false,
            )
        }

    val sampleW = with(density) { sampleLayout.size.width.toDp() }
    val sampleH = with(density) { sampleLayout.size.height.toDp() }
    val sampleSquare = maxOf(sampleW, sampleH)

    return sampleSquare + innerPadding * 2
}

@Composable
internal fun rememberNumberEntryDiameter(
    textStyle: TextStyle,
    heightBucket: SizeBucket,
): Dp {
    val innerPadding =
        when (heightBucket) {
            SizeBucket.Small -> 10.dp
            SizeBucket.Medium -> 14.dp
            SizeBucket.Large -> 20.dp
        }
    return rememberNumberEntryDiameter(textStyle = textStyle, innerPadding = innerPadding)
}

@Composable
internal fun NumberEntryCircle(
    value: String,
    onValueChange: (String) -> Unit,
    diameter: Dp,
    textStyle: TextStyle,
    heightBucket: SizeBucket,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester? = null,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val contentDescription = stringResource(R.string.enter_jersey_number)
    val dialBackground = MaterialTheme.colorScheme.surfaceContainerHighest
    val shape =
        remember(heightBucket) {
            if (heightBucket == SizeBucket.Small) {
                NumberEntrySquircleShape
            } else {
                CircleShape
            }
        }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier.size(diameter),
            shape = shape,
            color = dialBackground,
            tonalElevation = 6.dp,
            shadowElevation = 0.dp,
            border = BorderStroke(1.dp, textStyle.color.copy(alpha = 0.6f)),
        ) {
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                ),
            keyboardActions =
                KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    },
                ),
            textStyle = textStyle,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),
            modifier =
                Modifier
                    .widthIn(max = diameter + 5.dp)
                    .heightIn(max = diameter + 5.dp)
                    .semantics { this.contentDescription = contentDescription }
                    .then(focusRequester?.let { Modifier.focusRequester(it) } ?: Modifier),
        )
    }
}

internal val NumberEntrySquircleShape = SquircleShape(exponent = 3.4f)

@PreviewLightDark
@Composable
private fun NumberSelectorPreview(
    @PreviewParameter(SizeBucketPreviewProvider::class) heightBucket: SizeBucket,
) {
    PlayerNumberTheme {
        Box(modifier = Modifier.wrapContentSize()) {
            val textStyle = rememberNumberEntryTextStyle()
            val diameter = rememberNumberEntryDiameter(textStyle = textStyle, heightBucket = heightBucket)
            NumberEntryCircle(
                value = "27",
                onValueChange = {},
                diameter = diameter,
                textStyle = textStyle,
                heightBucket = heightBucket,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

private class SizeBucketPreviewProvider : PreviewParameterProvider<SizeBucket> {
    private val previewValues =
        listOf(
            SizeBucket.Small,
            SizeBucket.Medium,
            SizeBucket.Large,
        )

    override val values: Sequence<SizeBucket> = previewValues.asSequence()

    override fun getDisplayName(index: Int): String? {
        val value = previewValues.getOrNull(index) ?: return null
        return value.name.lowercase()
    }
}
