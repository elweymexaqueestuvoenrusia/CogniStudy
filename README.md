# CogniStudy 📱🧠

Una aplicación Android innovadora que combina principios de cognición corporeizada con técnicas de estudio basadas en investigación científica.

## 🌟 Características Principales

### 🎵 **Reproductor de Música Clásica Integrado**
- 15 canciones clásicas cuidadosamente seleccionadas
- Controles intuitivos: play, pause, next, previous, stop
- Selección directa de canciones desde la lista
- Funciones de reproducción continua y automática

### 📚 **Sistema de Recomendaciones Inteligente**
- **60 recomendaciones científicas** organizadas en 4 categorías:
  1. **Postura** (15 recs) - Optimiza tu posición corporal
  2. **Espacio** (15 recs) - Mejora tu entorno de estudio
  3. **Estudio** (15 recs) - Técnicas de aprendizaje efectivas
  4. **Música** (15 recs) - Uso de música para potenciar el aprendizaje

### 🔍 **Funcionalidades Avanzadas**
- **Búsqueda en tiempo real** en títulos, descripciones y teoría
- **Filtrado por categorías** con chips interactivos
- **Sistema de favoritos** para guardar recomendaciones clave
- **Explicación teórica detallada** para cada recomendación
- **Contadores de estadísticas** (total, filtradas, favoritos)

## 🎨 Interfaz de Usuario

### Diseño Moderno con Jetpack Compose
- **Material Design 3** implementado completamente
- **Temas personalizados** con colores coherentes
- **Cards interactivas** con efectos visuales
- **Responsive design** para diferentes tamaños de pantalla

### Navegación Intuitiva
- Barra de búsqueda prominente
- Filtros de categoría fácilmente accesibles
- Reproductor de música desplegable
- Dialogos modales para teoría detallada

## 🧠 Base Científica

CogniStudy se basa en tres pilares teóricos:

### 1. **Cognición Corporeizada**
- Tu cuerpo no es solo un soporte, es parte integral del proceso cognitivo
- Movimientos específicos mejoran la concentración y memoria
- Posturas expansivas aumentan la confianza y capacidad de aprendizaje

### 2. **Cognición Situada**
- El contexto físico afecta directamente el rendimiento cognitivo
- Espacios ordenados reducen la carga mental
- La luz natural regula ritmos circadianos

### 3. **Cognición Extendida**
- Herramientas físicas como post-its y mapas mentales extienden la capacidad cognitiva
- La música actúa como ancla contextual para la memoria
- Objetos específicos crean asociaciones mentales poderosas

## 🎵 Música Clásica Incluida

### Selección Científicamente Curated
1. **Concierto para Oboe - Marcello**
2. **Danzas Polovtsianas - Borodin**
3. **Gaudeamus Igitur - Coro**
4. **Humoresque - Dvorak**
5. **Flauta de Pan - Borelly**
6. **Rapsodia Húngara No.2 - Liszt**
7. **Vals No.2 - Shostakovich**
8. **Concierto para Piano No.1 - Tchaikovsky**
9. **Concierto de Brandeburgo No.2 - Bach**
10. **Campo Ruso - Obodzinsky**
11. **El Moldava - Smetana**
12. **Las Bodas de Fígaro - Mozart**
13. **Caminando por Moscú - Dunaevsky**
14. **Hope - Lev Leshenko**
15. **La Campanella - Paganini/Liszt**
16. **Moscow in May - Traditional**

## 📱 Screenshots

*(Agrega capturas de pantalla aquí)*

## 🛠 Tecnologías Utilizadas

### Lenguajes y Frameworks
- **Kotlin** - Lenguaje principal
- **Jetpack Compose** - UI declarativa moderna
- **Android SDK** - Plataforma nativa Android

### Arquitectura
- **Single Activity** con múltiples composables
- **State hoisting** para manejo de estado
- **Clean Architecture** (en desarrollo)

### Dependencias Principales
```gradle
androidx.compose.* - UI moderna
androidx.lifecycle - Manejo de ciclo de vida
androidx.activity - Componentes de actividad
Material 3 - Sistema de diseño
MediaPlayer - Reproducción de audio
```

## 🔧 Instalación y Configuración

### Requisitos Previos
- Android Studio Flamingo o superior
- Android SDK API 21+
- JDK 11 o superior
- Dispositivo Android 5.0+ o emulador

### Pasos de Instalación
1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/elweymexaqueestuvoenrusia/CogniStudy.git
   ```

2. **Abre en Android Studio:**
   - File → Open → Selecciona carpeta CogniStudy
   - Espera la sincronización de Gradle

3. **Configura el dispositivo:**
   - Conecta dispositivo físico vía USB
   - O inicia un emulador desde AVD Manager

4. **Ejecuta la aplicación:**
   - Click en Run (▶️)
   - Selecciona tu dispositivo
   - Espera la compilación e instalación

### Configuración de Audio
Los archivos de música deben colocarse en:
```
app/src/main/res/raw/
```
Nombres esperados: `marcello_oboe.mp3`, `borodin_polovtsian.mp3`, etc.

## 📁 Estructura del Proyecto

```
CogniStudy/
├── app/src/main/java/com/example/cognistudy/
│   ├── MainActivity.kt          # Actividad principal
│   └── (otros componentes)
├── app/src/main/res/
│   ├── raw/                     # Archivos de audio
│   ├── layout/                  # Layouts XML
│   └── values/                  # Recursos, strings, colores
└── build.gradle                 # Dependencias del módulo
```

## 🚀 Uso de la Aplicación

### Recomendaciones
1. **Explora por categorías** usando los chips de filtro
2. **Busca términos específicos** en la barra de búsqueda
3. **Marca como favoritas** las recomendaciones más útiles
4. **Lee la teoría detallada** haciendo click en el icono ℹ️

### Reproductor de Música
1. **Abre el reproductor** desde el icono de música
2. **Selecciona una canción** de la lista
3. **Usa los controles** para play, pause, next, etc.
4. **Combina música con técnicas** de estudio

## 🧪 Pruebas y Desarrollo

### Ejecutar Pruebas
```bash
./gradlew test          # Pruebas unitarias
./gradlew connectedTest # Pruebas en dispositivo
```

### Flujo de Desarrollo
```bash
git checkout -b feature/nueva-funcionalidad
# Desarrolla cambios
git add .
git commit -m "Descripción de cambios"
git push origin feature/nueva-funcionalidad
# Crea Pull Request
```

## 📊 Métricas de Calidad

- **Cobertura de código**: En desarrollo
- **Pruebas unitarias**: En desarrollo
- **UI Tests**: En desarrollo
- **Análisis estático**: En desarrollo

## 👥 Contribuir

### Guía para Contribuyentes
1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Estándares de Código
- **Kotlin Coding Conventions** oficiales
- **Compose Guidelines** de Android
- **Clean Architecture** principios
- **Material Design 3** especificaciones

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👤 Autor

**Bruno**  
- 📧 brunost30@gmail.com  
- 🐙 [GitHub](https://github.com/elweymexaqueestuvoenrusia)
- 🎓 Estudiante de desarrollo de software

## 🙏 Agradecimientos

- **Google** por Android y Jetpack Compose
- **Investigadores en cognición** por las bases teóricas
- **Comunidad de compositores** por la música incluida
- **Usuarios beta** por sus valiosos comentarios

## 🔗 Enlaces Relacionados

- [Documentación de Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [Teoría de Cognición Corporeizada](https://es.wikipedia.org/wiki/Cognici%C3%B3n_encarnada)

## 📈 Roadmap Futuro

### Próximas Versiones
- [ ] Sistema de seguimiento de progreso
- [ ] Personalización de playlist
- [ ] Recordatorios inteligentes
- [ ] Sincronización con nube
- [ ] Modo offline completo
- [ ] Más categorías de recomendaciones
- [ ] Estadísticas detalladas de uso
- [ ] Exportación de datos

### Mejoras Técnicas
- [ ] Implementación completa de Clean Architecture
- [ ] Base de datos local con Room
- [ ] ViewModel para manejo de estado
- [ ] Tests unitarios y de UI completos
- [ ] Internacionalización (i18n)
- [ ] Modo oscuro mejorado

---

⭐ **¡Si este proyecto te resulta útil, considera darle una estrella en GitHub!**

---

**CogniStudy** - Donde el cuerpo, la mente y el entorno se unen para potenciar tu aprendizaje.
