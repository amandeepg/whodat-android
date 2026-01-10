# nameWidthPercent

This document explains how `nameWidthPercent` is calculated for each team in the data model. The value is a normalized percentage of the rendered text width for the team name, using the app’s font and sizing rules.

## What it represents

`nameWidthPercent` is the team name’s rendered width divided by the longest team name width across **all leagues**, multiplied by 100. The longest team name is always 100.0, and every other team scales proportionally.

Formula:

```
nameWidthPercent = (teamNameWidthPx / maxTeamNameWidthPx) * 100.0
```

The value is stored as a `Float` and written with one decimal place (e.g., `67.6f`).

## Measurement rules

Measure widths using the same font and typography settings used by the UI:

- Font file: `app/src/main/res/font/google_sans_flex_variable.ttf`
- Font size: 24px
- Weight: 600 (SemiBold)
- Width axis: 100 (normal width)
- Optical size axis: 24
- Other axes: grade=0, roundness=0, slant=0
- Measurement: use the font’s glyph advance width (`getlength` in Pillow), not a bounding box.

These settings match how team names are styled in the app (Material3 headline/title styles using Google Sans Flex).

## When to recompute

Recompute `nameWidthPercent` whenever **any** of the following changes:

- A team name changes or a team is added/removed in any league.
- The font file changes or the typography settings change (size, weight, width axis).
- A new league is added (because the max width is across all leagues).

## Where values live

Team name widths are stored in each league data file:

- `app/src/main/java/ca/amandeep/playernumber/data/NbaTeams.kt`
- `app/src/main/java/ca/amandeep/playernumber/data/NhlTeams.kt`
- `app/src/main/java/ca/amandeep/playernumber/data/NflTeams.kt`
- `app/src/main/java/ca/amandeep/playernumber/data/MlbTeams.kt`
- `app/src/main/java/ca/amandeep/playernumber/data/MlsTeams.kt`

## Recommended recompute process (Python + Pillow)

1. Collect all team names from the league files above.
2. Load the variable font and set variation axes to the values listed in **Measurement rules**.
3. Measure each name’s width with `getlength`.
4. Compute the maximum width across all teams.
5. Write `nameWidthPercent` for every team using the formula above and one decimal place.

Pseudo-code:

```
font = load("google_sans_flex_variable.ttf", size=24)
font.set_variation_by_axes([opsz=24, wdth=100, wght=600, grad=0, round=0, slnt=0])

widths = { name: font.getlength(name) for name in all_team_names }
max_width = max(widths.values())

nameWidthPercent = round((width / max_width) * 100.0, 1)
```

Keep the normalization global (across all leagues), not per-league.
