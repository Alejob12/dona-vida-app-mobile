# Dona Vida — App móvil para donantes

Aplicación Android nativa del proyecto **Dona Vida**, maquetada a partir de
los mockups de Figma *Dona Vida · Mockups Mobile* (43 pantallas de 375×812 dp).
Acompaña al sitio web de donantes y comparte con él paleta, flujos y
nomenclatura de pantallas.

**Autores:** Alejandro Bernal López y Jerónimo Vásquez

---

## 1. Stack y versiones

| Tecnología | Versión | Rol |
| --- | --- | --- |
| Android Gradle Plugin | 9.4.0 | Sistema de compilación |
| Material Components for Android | 1.10.0 | UI kit (botones, campos, tarjetas) |
| AndroidX AppCompat | 1.6.1 | Compatibilidad de temas y actividades |
| AndroidX ConstraintLayout | 2.1.4 | Layouts de las 43 pantallas |
| AndroidX RecyclerView | 1.3.2 | Listas |
| AndroidX CardView | 1.0.0 | Tarjetas |
| AndroidX Core | 1.12.0 | Utilidades base |
| JUnit | 4.13.2 | Pruebas unitarias |
| Espresso | 3.5.1 | Pruebas de interfaz |
| Inter | — | Tipografía del diseño (embebida, SIL OFL 1.1) |

**Configuración del módulo**

| Parámetro | Valor |
| --- | --- |
| `applicationId` | `com.equipo.donavida` |
| `minSdk` | 28 (Android 9) |
| `targetSdk` / `compileSdk` | 37 |
| Java | 11 |

Interfaz construida con **XML Views** (no Jetpack Compose).

---

## 2. Cómo ejecutarlo

**Requisitos:** Android Studio (incluye su propio JDK), un JDK 17 o superior
si se compila por consola, y el SDK de Android con la plataforma 37.

### Desde Android Studio
1. `File › Open` y seleccionar la carpeta del proyecto.
2. Esperar a que Gradle sincronice.
3. Elegir un emulador o dispositivo y pulsar **Run**.

### Desde la línea de comandos

```bash
git clone https://github.com/Alejob12/dona-vida-app-mobile.git
cd dona-vida-app-mobile

# Indicar dónde está el SDK (si no existe local.properties)
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties   # macOS
# echo "sdk.dir=$HOME/Android/Sdk" > local.properties          # Linux

./gradlew assembleDebug          # genera app/build/outputs/apk/debug/app-debug.apk
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

| Comando | Qué hace |
| --- | --- |
| `./gradlew assembleDebug` | Compila el APK de depuración |
| `./gradlew installDebug` | Compila e instala en el dispositivo conectado |
| `./gradlew test` | Pruebas unitarias |
| `./gradlew clean` | Limpia los artefactos de compilación |

> El emulador que reproduce fielmente los mockups es uno de **375×812 dp**.
> Para forzar esa geometría: `adb shell wm size 750x1624` y
> `adb shell wm density 320`.

---

## 3. Sistema de diseño

### 3.1 Base: Material Components, personalizado

Las pantallas se construyen con los componentes reales de
**Material Components for Android** —`MaterialButton`, `TextInputLayout`,
`MaterialCardView`, `RecyclerView`— y se personalizan mediante estilos
propios en `res/values/styles.xml`. **No se usa ninguna imagen para
representar un componente**: los 38 drawables del proyecto son vectores y
formas XML.

El archivo de Figma no vincula ninguna librería externa: define componentes
locales construidos como equivalentes de Material, que aquí se reproducen con
los widgets nativos equivalentes.

| Estilo del proyecto | Componente Material |
| --- | --- |
| `Widget.DonaVida.Button.Primary` | `Widget.MaterialComponents.Button` |
| `Widget.DonaVida.Button.Secondary` | `…Button.OutlinedButton` |
| `Widget.DonaVida.TextInputLayout` | `…TextInputLayout.OutlinedBox` |
| `Widget.DonaVida.CardView` | `Widget.MaterialComponents.CardView` |
| `Widget.DonaVida.Banner` | `Widget.MaterialComponents.CardView` |

### 3.2 Paleta (`res/values/colors.xml`)

| Recurso | Valor | Variable en Figma |
| --- | --- | --- |
| `colorPrimary` | `#7A1734` | `color/primary` |
| `colorTextPrimary` | `#1F1013` | `color/text-primary` |
| `colorTextSecondary` | `#6B4C55` | `color/text-secondary` |
| `colorBackground` | `#F5F2F1` | `color/background` |
| `colorSurface` | `#FFFFFF` | `color/surface` |
| `colorBorder` | `#C98CA0` | `color/border` |
| `colorIconSoftFill` | `#F4DCE1` | `color/soft-fill` |

### 3.3 Tipografía

**Inter**, embebida en `res/font/` en cuatro pesos (400/500/600/700) y
declarada como familia en `res/font/inter.xml`.

| Estilo | Fuente | Tamaño | Token de Figma |
| --- | --- | --- | --- |
| `TextAppearance.DonaVida.Title` | Bold | 24sp | — |
| `…Subtitle` | Semi Bold | 18sp | H2 · Título de sección |
| `…Body` / `…BodySecondary` | Regular | 14sp | Body · Texto de lectura |
| `…Caption` | Regular | 12sp | Caption · Nota / ayuda |
| `…ButtonLabel` | Semi Bold | 14sp | Button · Label de botón |

### 3.4 Métricas (`res/values/dimens.xml`)

Tomadas directamente de los mockups y constantes en las 43 pantallas:

| Recurso | Valor | En Figma |
| --- | --- | --- |
| `status_bar_height` | 24dp | 24dp |
| `top_app_bar_height` | 56dp | 56dp |
| `bottom_tab_bar_height` | 68dp | 68dp |
| `list_item_min_height` | 72dp | 72dp |
| `button_min_height` | 48dp | 48dp |

Márgenes laterales de 16dp (contenido de 343dp sobre un lienzo de 375dp) y
escala de espaciado de base 4dp. En pantallas anchas el contenido se centra y
se limita con `content_max_width` (480dp); no es un responsive estricto.

---

## 4. Estructura del proyecto

```
app/src/main/
  java/com/equipo/donavida/   43 actividades, una por pantalla del diseño
  res/layout/                 51 layouts (ConstraintLayout)
  res/drawable/               38 vectores y formas XML (iconos y fondos)
  res/font/                   Inter en cuatro pesos
  res/values/                 colors · dimens · strings · styles
  AndroidManifest.xml
```

Las 43 pantallas siguen el orden del flujo, de `SplashActivity` a
`LogoutActivity`, con la misma numeración que los mockups.

---

## 5. Notas

- Prototipo académico: los datos son simulados y no hay backend.
- Solo tema claro, igual que el diseño.
- Inter se incluye bajo la SIL Open Font License 1.1.
