# New Hacker Style Variation: Amber CRT Terminal (Pip-Boy / Fallout Aesthetic)

Create a brand new hacker style variant for the IMC Calculator: an **Amber CRT Terminal** (inspired by retro amber phosphors and Fallout Pip-Boy displays), replacing the previous Matrix green with warm amber/gold text (`#FFB000`), deep charcoal/black background, and retro terminal aesthetics.

## User Review Required

> [!IMPORTANT]
> This will switch the hacker theme color palette from Matrix Green (`#00FF66`) to **Amber Phosphor CRT (`#FFB000`)**, giving it a classic retro-futuristic Fallout / mainframe terminal look.

## Proposed Changes

### Theme & Colors (`org.insbaixcamp.imca2.ui.theme`)

#### [MODIFY] [Color.kt](file:///C:/Users/Usuario/AndroidStudioProjects/imcA2/app/src/main/java/org/insbaixcamp/imca2/ui/theme/Color.kt)
- Define amber color palette: `AmberBlack`, `AmberGold`, `AmberDim`, `AmberSurface`.

#### [MODIFY] [Theme.kt](file:///C:/Users/Usuario/AndroidStudioProjects/imcA2/app/src/main/java/org/insbaixcamp/imca2/ui/theme/Theme.kt)
- Update `HackerColorScheme` to use amber phosphor colors.

### UI Implementation (`org.insbaixcamp.imca2`)

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Usuario/AndroidStudioProjects/imcA2/app/src/main/java/org/insbaixcamp/imca2/MainActivity.kt)
- Update `BMIscreen` text and borders to reflect amber terminal styling:
  - Header: `> PIP-BOY_OS v3000 // STATUS: OPTIMAL`
  - Amber glowing text, buttons, and slider accents.

## Verification Plan

### Automated Tests
- Build project using gradle (`app:assembleDebug`).
