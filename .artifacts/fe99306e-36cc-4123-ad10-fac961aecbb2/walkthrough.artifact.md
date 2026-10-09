# Walkthrough - Amber CRT Terminal Hacker Style IMC Calculator

Successfully implemented an alternative **Amber CRT Terminal / Pip-Boy (Fallout)** style for the IMC Calculator app.

## Changes

### Theme & Colors (`org.insbaixcamp.imca2.ui.theme`)
- **[Color.kt](file:///C:/Users/Usuario/AndroidStudioProjects/imcA2/app/src/main/java/org/insbaixcamp/imca2/ui/theme/Color.kt)**: Defined Amber phosphor palette (`AmberBlack`, `AmberGold`, `AmberDark`, `AmberDim`, `AmberSurface`).
- **[Theme.kt](file:///C:/Users/Usuario/AndroidStudioProjects/imcA2/app/src/main/java/org/insbaixcamp/imca2/ui/theme/Theme.kt)**: Configured `AmberCRTColorScheme` with warm golden/amber glow on deep charcoal background.

### UI Implementation (`org.insbaixcamp.imca2`)
- **[MainActivity.kt](file:///C:/Users/Usuario/AndroidStudioProjects/imcA2/app/src/main/java/org/insbaixcamp/imca2/MainActivity.kt)**: Redesigned `BMIscreen` with retro-futuristic terminal aesthetics:
  - Header: `> PIP-BOY OS v3000 // TERMINAL ACTIVE`
  - Subject ID input: `> ENTER_SUBJECT_ID`
  - Weight & Height controls: `> MASS` and `> STATURE` with amber borders and buttons (`[-] DECREASE`, `[+] INCREASE`).
  - Calculation button: `> COMPUTE_ANALYSIS`.
  - Output results: `> SUBJECT`, `> CALCULATED_BMI`, and `[DIAGNOSTIC: ...]`.

## Verification Results

### Automated Tests
- Executed gradle build (`app:assembleDebug`): **BUILD SUCCESSFUL**.
