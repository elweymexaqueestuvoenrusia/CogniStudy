package com.example.cognistudy

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.cognistudy.ui.theme.CogniStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CogniStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CogniStudyApp()
                }
            }
        }
    }
}

// CLASE MusicPlayer - COMPLETA CON LAS NUEVAS CANCIONES
class MusicPlayer {
    private var mediaPlayer: MediaPlayer? = null
    var isPlaying = false
    var currentTrackIndex = 0

    // Lista de IDs de recursos RAW - CON LAS NUEVAS CANCIONES AGREGADAS
    val trackResources = listOf(
        R.raw.marcello_oboe,
        R.raw.borodin_polovtsian,
        R.raw.gaudeamus,
        R.raw.dvorak_humoresque,
        R.raw.flauta_pan,
        R.raw.liszt_rhapsody,
        R.raw.shostakovich_waltz,
        R.raw.tchaikovsky_concerto,
        R.raw.bach_brandenburg,
        R.raw.russian_field,
        R.raw.smetana_moldau,
        R.raw.figaro,
        R.raw.walking_through_moscow,
        R.raw.hope,           // NUEVA CANCIÓN 1
        R.raw.la_campanela,   // NUEVA CANCIÓN 2
        R.raw.moscow_in_may   // NUEVA CANCIÓN 3
    )

    // Nombres de las canciones - CON LOS NUEVOS NOMBRES AGREGADOS
    val trackNames = listOf(
        "Concierto para Oboe - Marcello",
        "Danzas Polovtsianas - Borodin",
        "Gaudeamus Igitur - Coro",
        "Humoresque - Dvorak",
        "Flauta de Pan - Borelly",
        "Rapsodia Húngara No.2 - Liszt",
        "Vals No.2 - Shostakovich",
        "Concierto para Piano No.1 - Tchaikovsky",
        "Concierto de Brandeburgo No.2 - Bach",
        "Campo Ruso - Obodzinsky",
        "El Moldava - Smetana",
        "Las Bodas de Fígaro - Mozart",
        "Caminando por Moscú - Dunaevsky",
        "Hope - Lev Leshenko",           // NUEVA CANCIÓN 1
        "La Campanella - Paganini/Liszt", // NUEVA CANCIÓN 2
        "Moscow in May - Traditional"     // NUEVA CANCIÓN 3
    )

    fun play(context: android.content.Context, index: Int) {
        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }

        currentTrackIndex = index
        try {
            mediaPlayer = MediaPlayer.create(context, trackResources[index])

            mediaPlayer?.setOnCompletionListener {
                isPlaying = false
                next(context)
            }

            mediaPlayer?.start()
            isPlaying = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun pause() {
        if (isPlaying) {
            mediaPlayer?.pause()
            isPlaying = false
        }
    }

    fun resume() {
        if (!isPlaying && mediaPlayer != null) {
            mediaPlayer?.start()
            isPlaying = true
        }
    }

    fun stop() {
        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
            isPlaying = false
        }
    }

    fun next(context: android.content.Context) {
        val nextIndex = (currentTrackIndex + 1) % trackResources.size
        play(context, nextIndex)
    }

    fun previous(context: android.content.Context) {
        val prevIndex = if (currentTrackIndex - 1 < 0) trackResources.size - 1 else currentTrackIndex - 1
        play(context, prevIndex)
    }
}

// Modelo de datos con teoría
data class Recommendation(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val icon: String,
    val theory: String,
    val detailedTheory: String
)

// Lista con 60 recomendaciones COMPLETAS
val recommendations = listOf(
    // CATEGORÍA: POSTURA (15 recomendaciones)
    Recommendation(1, "Estudia de pie", "Alterna entre estar sentado y de pie cada 20-30 minutos.", "Postura", "🚶", "Mejora circulación sanguínea.", "Basado en cognición corporeizada: El cuerpo participa activamente en el proceso cognitivo. Estudiar de pie mejora la oxigenación cerebral y estimula el sistema nervioso, facilitando conexiones neuronales más eficientes."),
    Recommendation(2, "Pomodoro activo", "25 minutos de estudio + 5 minutos de movimiento.", "Postura", "⏱️", "Mejora retención de información.", "Cognición situada: Los descansos activos crean contextos diferenciados que ayudan a consolidar la memoria. El movimiento físico durante pausas reactiva el cerebro y prepara para nuevas sesiones de aprendizaje."),
    Recommendation(3, "Estira los dedos", "Haz estiramientos de dedos cada 30 minutos.", "Postura", "✋", "Reduce tensión en manos.", "Corporeización: La tensión muscular afecta directamente la capacidad cognitiva. Liberar tensión en manos y dedos mejora la concentración y reduce la fatiga mental."),
    Recommendation(4, "Postura de poder", "Adopta posturas expansivas antes de estudiar.", "Postura", "💪", "Aumenta confianza y concentración.", "Basado en estudios de Amy Cuddy: Posturas expansivas aumentan niveles de testosterona y disminuyen cortisol, mejorando el desempeño cognitivo y la actitud frente al aprendizaje."),
    Recommendation(5, "Marcha en el lugar", "Marcha suavemente durante pausas breves.", "Postura", "👣", "Aumenta oxigenación cerebral.", "Cognición corporeizada: El movimiento rítmico sincroniza la actividad cerebral, aumentando el flujo sanguíneo al cerebro en un 15-20%, mejorando todas las funciones cognitivas."),
    Recommendation(6, "Balanceo suave", "Balancea suavemente el cuerpo mientras lees.", "Postura", "🔄", "Movimiento rítmico facilita concentración.", "Sistemas dinámicos: El balanceo rítmico activa el sistema vestibular, que está conectado con áreas cerebrales responsables de la atención y el procesamiento espacial."),
    Recommendation(7, "Cambia de posición", "Cambia de posición cada 15 minutos.", "Postura", "🔄", "Previene fatiga muscular y mental.", "Cognición extendida: El entorno físico (silla, postura) forma parte del sistema cognitivo. Variar posiciones evita la habituación y mantiene activo el sistema atencional."),
    Recommendation(8, "Usa un balancín", "Usa una silla balancín para estudiar.", "Postura", "🪑", "Estimula sistema vestibular.", "Integración sensorial: El movimiento constante pero suave del balancín proporciona retroalimentación propioceptiva que mantiene el cerebro en estado de alerta óptimo para el aprendizaje."),
    Recommendation(9, "Movimiento de tobillos", "Rota los tobillos mientras estudias.", "Postura", "🦶", "Previene problemas circulatorios.", "Conexión cuerpo-mente: La circulación periférica afecta directamente la oxigenación cerebral. Movimientos circulares en tobillos mejoran el retorno venoso y la claridad mental."),
    Recommendation(10, "Estiramiento cervical", "Estira el cuello suavemente cada hora.", "Postura", "👤", "Libera tensión en cervicales.", "Corporeización: La tensión cervical comprime arterias vertebrales, reduciendo el flujo sanguíneo al cerebro. Liberarla mejora inmediatamente la concentración y reduce dolores de cabeza."),
    Recommendation(11, "Respiración abdominal", "Practica respiración profunda diafragmática.", "Postura", "🫁", "Oxigena mejor el cerebro.", "Regulación fisiológica: La respiración profunda activa el sistema parasimpático, reduciendo estrés y aumentando la capacidad de la corteza prefrontal para funciones ejecutivas."),
    Recommendation(12, "Movimiento ocular", "Ejercita los ojos mirando diferentes distancias.", "Postura", "👀", "Previene fatiga visual.", "Sistema sensorimotor: Los músculos oculares están conectados con áreas cerebrales de atención. Su movimiento estimula la activación cortical y previene el cansancio mental."),
    Recommendation(13, "Postura de loto", "Siéntate en posición de loto para meditar.", "Postura", "🧘", "Mejora postura y atención.", "Mindfulness corporeizado: Posturas estables y centradas facilitan estados de atención plena, mejorando la concentración y reduciendo la dispersión mental."),
    Recommendation(14, "Caminata de pingüino", "Camina con pasos pequeños y rápidos.", "Postura", "🐧", "Activa múltiples grupos musculares.", "Coordinación bilateral: Movimientos cruzados activan el cuerpo calloso, mejorando la comunicación entre hemisferios cerebrales y facilitando el aprendizaje integrado."),
    Recommendation(15, "Balanceo de brazos", "Balancea los brazos mientras estudias de pie.", "Postura", "💪", "Mejora circulación en brazos.", "Cognición en acción: El movimiento de brazos estimula áreas motoras complementarias que participan en procesos de razonamiento y resolución de problemas."),

    // CATEGORÍA: ESPACIO (15 recomendaciones)
    Recommendation(16, "Iluminación natural", "Estudia cerca de una ventana con luz natural.", "Espacio", "☀️", "Regula ritmo circadiano.", "Cognición situada: La luz natural sincroniza los ritmos circadianos, optimizando los periodos de alerta y mejorando la calidad del sueño, esencial para consolidación de memoria."),
    Recommendation(17, "Orden minimalista", "Mantén solo lo esencial en tu mesa.", "Espacio", "🧹", "Reduce carga cognitiva visual.", "Carga cognitiva: El desorden visual compite por recursos atencionales. Un espacio ordenado libera capacidad cognitiva para tareas de aprendizaje importantes."),
    Recommendation(18, "Plantas en el espacio", "Coloca plantas pequeñas en tu área de estudio.", "Espacio", "🌿", "Mejora calidad del aire.", "Biofilia: La presencia de elementos naturales reduce el estrés fisiológico y mejora el estado de ánimo, creando condiciones óptimas para el aprendizaje."),
    Recommendation(19, "Ruido blanco", "Usa ruido blanco para bloquear distracciones.", "Espacio", "🔊", "Facilita concentración.", "Procesamiento auditivo: El ruido blanco enmascara sonidos distractores sin sobrecargar el sistema auditivo, permitiendo un foco atencional más sostenido."),
    Recommendation(20, "Acceso a agua", "Ten agua fresca siempre disponible.", "Espacio", "💧", "Hidratación es esencial para funciones cognitivas.", "Neurofisiología: Una deshidratación del 2% reduce la capacidad cognitiva en un 10%. El agua mantiene el balance electrolítico necesario para la transmisión neuronal."),
    Recommendation(21, "Cambia de lugar", "Estudia en diferentes lugares.", "Espacio", "🏠", "Crea asociaciones contextuales.", "Memoria contextual: Diferentes espacios crean distintas huellas mnémicas, facilitando la recuperación de información al activar múltiples rutas de acceso."),
    Recommendation(22, "Organiza con objetos", "Usa post-its y diagramas físicos.", "Espacio", "📌", "Facilita resolución de problemas.", "Cognición extendida: Externalizar pensamientos en objetos físicos reduce la carga de memoria de trabajo y permite manipulación concreta de conceptos abstractos."),
    Recommendation(23, "Temperatura óptima", "Mantén temperatura entre 20-22°C.", "Espacio", "🌡️", "Máximo confort térmico.", "Regulación homeostática: Temperaturas extremas requieren recursos metabólicos para termorregulación, recursos que dejan de estar disponibles para procesos cognitivos."),
    Recommendation(24, "Colores calmantes", "Usa tonos azules o verdes en tu espacio.", "Espacio", "🎨", "Promueven calma y concentración.", "Psicología del color: Colores fríos reducen la presión arterial y la frecuencia cardíaca, creando un estado fisiológico óptimo para el estudio prolongado."),
    Recommendation(25, "Silla ergonómica", "Invierte en una silla que soporte tu espalda.", "Espacio", "🪑", "Previene dolores y permite sesiones largas.", "Ergonomía cognitiva: El dolor físico consume recursos atencionales. Una postura cómoda libera atención para tareas cognitivas en lugar de monitoreo corporal."),
    Recommendation(26, "Altura de mesa", "Ajusta mesa a la altura de tus codos.", "Espacio", "📏", "Evita tensiones en hombros y cuello.", "Biomecánica del estudio: Posturas forzadas activan receptores de dolor que envían señales constantes al cerebro, interfiriendo con procesos de concentración."),
    Recommendation(27, "Monitor a nivel de ojos", "Coloca pantalla a altura de tus ojos.", "Espacio", "🖥️", "Previene problemas cervicales.", "Alineación postural: Una posición neutral del cuello mantiene abiertas las vías vasculares que irrigan el cerebro, asegurando óptima oxigenación cerebral."),
    Recommendation(28, "Espacio personalizado", "Decora con objetos que te inspiren.", "Espacio", "✨", "Mejora motivación.", "Identidad y aprendizaje: Los objetos significativos activan circuitos emocionales positivos, aumentando la dopamina que facilita la plasticidad sináptica."),
    Recommendation(29, "Separación de espacios", "Separa espacio de estudio del de descanso.", "Espacio", "🚪", "Crea asociaciones mentales claras.", "Contextualización: Diferentes espacios crean distintos marcos mentales. Esta separación ayuda al cerebro a cambiar rápidamente entre modos 'estudio' y 'descanso'."),
    Recommendation(30, "Control de humedad", "Mantén humedad entre 40-60%.", "Espacio", "💦", "Confort respiratorio óptimo.", "Fisiología respiratoria: Humedad adecuada mantiene mucosas nasales saludables, optimizando la oxigenación sanguínea y por tanto la función cerebral."),

    // CATEGORÍA: ESTUDIO (15 recomendaciones)
    Recommendation(31, "Mapas mentales", "Crea mapas mentales para organizar ideas.", "Estudio", "🧠", "Facilita conexiones conceptuales.", "Redes semánticas: Los mapas mentales reflejan la estructura natural de la memoria asociativa, facilitando la codificación y recuperación de información relacionada."),
    Recommendation(32, "Enseñar a otros", "Explica conceptos a otra persona.", "Estudio", "👥", "Profundiza comprensión.", "Efecto de producción: Explicar conceptos activa diferentes rutas neuronales que la mera recepción, consolidando el aprendizaje y revelando áreas de comprensión incompleta."),
    Recommendation(33, "Repetición distribuida", "Distribuye sesiones de estudio en el tiempo.", "Estudio", "📅", "Refuerza memoria a largo plazo.", "Curva del olvido de Ebbinghaus: Repasos espaciados aprovechan el proceso natural de consolidación, reforzando conexiones sinápticas con menor esfuerzo total."),
    Recommendation(34, "Pruebas de práctica", "Haz pruebas frecuentes en lugar de solo repasar.", "Estudio", "📝", "Fortalece recuperación activa.", "Prueba de práctica: Recuperar información de la memoria fortalece más las conexiones neuronales que la relectura pasiva, creando rutas de acceso más robustas."),
    Recommendation(35, "Resumen en tus palabras", "Resume cada sección con tus propias palabras.", "Estudio", "📄", "Demuestra comprensión real.", "Procesamiento profundo: Reformular información en palabras propias requiere integración conceptual, señal de comprensión genuina y no solo memorización superficial."),
    Recommendation(36, "Usa diagramas", "Dibuja diagramas para comprender relaciones.", "Estudio", "📊", "Facilita razonamiento.", "Pensamiento visual: Convertir información verbal en visual activa diferentes áreas cerebrales, creando representaciones duales que mejoran la comprensión y retención."),
    Recommendation(37, "Estudio espacial", "Organiza información en el espacio físico.", "Estudio", "🗺️", "Usa espacio como herramienta cognitiva.", "Método de loci: Asociar información con ubicaciones espaciales aprovecha la excelente memoria espacial humana, facilitando la recuperación mediante 'paseos mentales'."),
    Recommendation(38, "Manipulación física", "Usa objetos para representar conceptos abstractos.", "Estudio", "🎲", "Concreto facilita abstracto.", "Anclaje corporeizado: Representar conceptos abstractos con objetos físicos crea referentes concretos que facilitan la comprensión y manipulación mental posterior."),
    Recommendation(39, "Escritura manual", "Escribe notas a mano en lugar de digitalmente.", "Estudio", "✍️", "Activa más áreas cerebrales.", "Integración sensorimotora: La escritura manual activa circuitos motores, sensoriales y visuales simultáneamente, creando huellas mnémicas más ricas y duraderas."),
    Recommendation(40, "Mapas mentales grandes", "Crea mapas grandes en papel o pizarra.", "Estudio", "🧠", "Expansión física refleja expansión mental.", "Externalización cognitiva: El espacio físico ampliado permite representar relaciones complejas que exceden la capacidad de la memoria de trabajo, facilitando el razonamiento."),
    Recommendation(41, "Estudio kinestésico", "Asocia movimientos a diferentes tipos de contenido.", "Estudio", "💃", "Memoria muscular refuerza memoria conceptual.", "Memoria episódica: Asociar información con movimientos específicos crea episodios memorables que facilitan la recuperación a través de la recreación del movimiento."),
    Recommendation(42, "Uso de colores", "Asigna colores específicos a diferentes categorías.", "Estudio", "🎨", "Facilita organización visual.", "Codificación cromática: Los colores actúan como etiquetas visuales que aceleran el procesamiento y facilitan la categorización automática de información."),
    Recommendation(43, "Construcción física", "Construye modelos físicos de sistemas o procesos.", "Estudio", "🧱", "Construcción externa facilita mental.", "Pensamiento a través de hacer: Manipular físicamente componentes para construir modelos activa circuitos de comprensión profunda que la observación pasiva no alcanza."),
    Recommendation(44, "Dramatización", "Dramatiza procesos históricos o científicos.", "Estudio", "🎭", "Crea memorias episódicas ricas.", "Aprendizaje experiencial: Asumir roles y recrear eventos crea memorias episódicas vívidas que incluyen componentes emocionales, mejorando significativamente la retención."),
    Recommendation(45, "Uso de metáforas", "Crea metáforas físicas para conceptos abstractos.", "Estudio", "🔄", "Físico ancla abstracto.", "Pensamiento metafórico: Las metáforas permiten comprender lo desconocido a través de lo conocido, creando puentes cognitivos entre dominios familiares y nuevos conceptos."),

    // CATEGORÍA: MÚSICA (15 recomendaciones)
    Recommendation(46, "Mozart para matemáticas", "Escucha sonatas de Mozart para razonamiento matemático.", "Música", "🎹", "Efecto Mozart mejora pensamiento espacial-temporal.", "Efecto Mozart: La estructura matemática de las composiciones de Mozart estimula patrones cerebrales similares a los usados en razonamiento espacial y lógico, aunque el efecto es temporal y específico."),
    Recommendation(47, "Barroca para concentración", "Bach o Vivaldi para enfoque profundo.", "Música", "🎻", "Patrones predecibles facilitan concentración.", "Música barroca: Los patrones repetitivos y estructurados de la música barroca inducen estados de concentración profunda al proporcionar estímulo sin sorpresas que distraigan."),
    Recommendation(48, "Clásica sin voces", "Prefiere música instrumental para evitar interferencia.", "Música", "🎵", "Voces pueden competir con procesamiento verbal.", "Interferencia lingüística: Las letras en idiomas conocidos activan circuitos del lenguaje que compiten por recursos con el procesamiento de material de estudio verbal."),
    Recommendation(49, "Volumen bajo", "Música a volumen bajo de fondo, not como foco principal.", "Música", "🔉", "Proporciona estímulo sin sobrecarga.", "Nivel de activación óptimo: Música a volumen moderado mantiene un nivel de arousal cortical ideal - suficiente para evitar aburrimiento, no tanto para distraer."),
    Recommendation(50, "Tempo moderado", "Busca piezas con tempo de 60-80 BPM.", "Música", "💓", "Sincroniza con ritmos biológicos naturales.", "Sincronización neural: Tempos similares al ritmo cardíaco en reposo facilitan la sincronización de ondas cerebrales, induciendo estados de concentración relajada."),
    Recommendation(51, "Clásica para lectura", "Chopin o Debussy para sesiones de lectura prolongada.", "Música", "📖", "La música romántica crea ambiente sin distraer.", "Música romántica: Las variaciones sutiles y el carácter expresivo de la música romántica mantienen cierto nivel de novedad que previene la habituación durante sesiones largas."),
    Recommendation(52, "Minimalismo para enfoque", "Philip Glass o Steve Reich para tareas repetitivas.", "Música", "🔄", "Patrones minimalistas inducen estado de flujo.", "Música minimalista: Los patrones repetitivos con variaciones mínimas inducen estados de trance ligero que facilitan la concentración en tareas monótonas."),
    Recommendation(53, "Música para memoria", "Escucha las mismas piezas mientras aprendes y repasas.", "Música", "🧠", "La música actúa como ancla contextual para la memoria.", "Anclaje musical: La música crea un contexto auditivo único que, al reproducirse durante el repaso, activa las mismas redes neuronales usadas durante el aprendizaje original."),
    Recommendation(54, "Sin cambios bruscos", "Evita piezas con cambios dinámicos o de tempo abruptos.", "Música", "📈", "Los cambios bruscos pueden romper la concentración.", "Predictibilidad auditiva: Cambios abruptos en volumen o tempo activan reflejos de orientación que interrumpen el flujo de pensamiento y rompen la concentración."),
    Recommendation(55, "Música para resolución", "Escucha música clásica cuando trabajes en problemas complejos.", "Música", "🧩", "Ayuda a mantener la calma durante la frustración.", "Regulación emocional: La música clásica modula la actividad de la amígdala, ayudando a mantener un estado emocional estable durante tareas cognitivamente demandantes."),
    Recommendation(56, "Clásica para idiomas", "Escucha música instrumental mientras estudias vocabulario.", "Música", "🗣️", "Proporciona fondo sin interferir con procesamiento verbal.", "Separación de modalidades: Música instrumental sin letras evita la competencia por recursos del hemisferio izquierdo, especializado en procesamiento lingüístico."),
    Recommendation(57, "Música para repaso", "Escucha música clásica tranquila antes del examen.", "Música", "📚", "Ayuda a consolidar memorias durante el sueño.", "Consolidación nocturna: La exposición a música tranquila antes de dormir puede modular la actividad de ondas lentas durante el sueño, fase crucial para consolidación de memoria."),
    Recommendation(58, "Cuatro Estaciones", "Vivaldi para variación estacional en estudio.", "Música", "🍂", "Diferentes movimientos para diferentes estados de ánimo.", "Variedad contextual: Diferentes movimientos de 'Las Cuatro Estaciones' corresponden a distintos estados emocionales, permitiendo seleccionar el más apropiado para cada tarea."),
    Recommendation(59, "Conciertos para piano", "Mozart, Beethoven o Rachmaninoff para variación.", "Música", "🎹", "Estructura concierto proporciona variación con coherencia.", "Estructura de concierto: La forma concierto ofrece variedad suficiente para mantener el interés pero suficiente estructura para no distraer, ideal para sesiones largas."),
    Recommendation(60, "Música de cámara", "Cuartetos de cuerdas para intimidad y concentración.", "Música", "🎻", "El tamaño reducido del ensamble es menos abrumador.", "Intimidad auditiva: Los conjuntos pequeños producen texturas sonoras menos densas que las orquestales, facilitando la concentración sin crear sobrecarga sensorial.")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CogniStudyApp() {
    var selectedCategory by remember { mutableStateOf("Todas") }
    var searchQuery by remember { mutableStateOf("") }
    var showMusicPlayer by remember { mutableStateOf(false) }
    var favoriteIds by remember { mutableStateOf(setOf<Int>()) }
    var showTheoryDialog by remember { mutableStateOf(false) }
    var selectedTheory by remember { mutableStateOf("") }
    val musicPlayer = remember { MusicPlayer() }
    val context = LocalContext.current

    // Filtrar recomendaciones - CORREGIDO: ahora filtra correctamente por categoría
    val filteredRecs = recommendations.filter { rec ->
        val matchesCategory = if (selectedCategory == "Todas") {
            true
        } else {
            rec.category == selectedCategory
        }

        val matchesSearch = searchQuery.isEmpty() ||
                rec.title.contains(searchQuery, ignoreCase = true) ||
                rec.description.contains(searchQuery, ignoreCase = true) ||
                rec.theory.contains(searchQuery, ignoreCase = true)

        matchesCategory && matchesSearch
    }

    // Categorías disponibles
    val categories = listOf("Todas", "Postura", "Espacio", "Estudio", "Música")

    // Dialog para teoría
    if (showTheoryDialog) {
        Dialog(onDismissRequest = { showTheoryDialog = false }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "📚 Base Teórica",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF673AB7),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = selectedTheory,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "🔍 Teoría aplicada:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color(0xFF2196F3),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Text(
                        text = "Esta recomendación se basa en principios de cognición corporeizada, situada y extendida. Tu cuerpo, espacio y herramientas no son solo medios para aprender, sino parte integral del proceso cognitivo mismo.",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "CogniStudy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    // Botón de música - USANDO TEXTO como alternativa
                    IconButton(
                        onClick = { showMusicPlayer = !showMusicPlayer }
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF673AB7)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "♪",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFE3F2FD))
        ) {
            // Reproductor de música (si está visible)
            if (showMusicPlayer) {
                SimpleMusicPlayer(musicPlayer, context)
            }

            // Barra de búsqueda
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("Buscar recomendaciones...") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Buscar")
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            // Filtro de categorías
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                categories.forEach { category ->
                    CategoryChip(
                        text = category,
                        isSelected = selectedCategory == category,
                        onClick = { selectedCategory = category }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Contadores
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${filteredRecs.size} de ${recommendations.size} recs",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                if (favoriteIds.isNotEmpty()) {
                    Text(
                        text = "${favoriteIds.size} favoritos",
                        color = Color(0xFFFF9800),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Lista de recomendaciones
            if (filteredRecs.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "No se encontraron recomendaciones",
                            color = Color.Gray
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredRecs) { recommendation ->
                        RecommendationCard(
                            recommendation = recommendation,
                            isFavorite = favoriteIds.contains(recommendation.id),
                            onFavoriteClick = {
                                favoriteIds = if (favoriteIds.contains(recommendation.id)) {
                                    favoriteIds - recommendation.id
                                } else {
                                    favoriteIds + recommendation.id
                                }
                            },
                            onTheoryClick = {
                                selectedTheory = recommendation.detailedTheory
                                showTheoryDialog = true
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleMusicPlayer(musicPlayer: MusicPlayer, context: android.content.Context) {
    var currentTrackIndex by remember { mutableStateOf(musicPlayer.currentTrackIndex) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Título
            Text(
                text = "Reproductor de Música",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF673AB7),
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Canción actual - ACTUALIZADO para usar el estado local
            Text(
                text = musicPlayer.trackNames[currentTrackIndex],
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Controles - USANDO TEXTO en lugar de iconos problemáticos
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Anterior - USANDO TEXTO
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF673AB7))
                        .clickable {
                            musicPlayer.previous(context)
                            currentTrackIndex = musicPlayer.currentTrackIndex
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text("⏮", color = Color.White, fontSize = 20.sp)
                }

                // Play/Pause - USANDO TEXTO
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF673AB7))
                        .clickable {
                            if (musicPlayer.isPlaying) {
                                musicPlayer.pause()
                            } else {
                                musicPlayer.play(context, currentTrackIndex)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        if (musicPlayer.isPlaying) "⏸" else "▶",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }

                // Siguiente - USANDO TEXTO
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF673AB7))
                        .clickable {
                            musicPlayer.next(context)
                            currentTrackIndex = musicPlayer.currentTrackIndex
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text("⏭", color = Color.White, fontSize = 20.sp)
                }

                // Detener - USANDO TEXTO
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                        .clickable {
                            musicPlayer.stop()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text("⏹", color = Color.White, fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Lista de canciones
            Text(
                text = "Seleccionar canción:",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Lista simple de canciones - CAMBIADO a LazyColumn para poder deslizar
            LazyColumn(
                modifier = Modifier.height(180.dp) // Altura fija pero con scroll
            ) {
                items(musicPlayer.trackNames.size) { index ->
                    Text(
                        text = "${index + 1}. ${musicPlayer.trackNames[index]}",
                        fontSize = 12.sp,
                        color = if (index == currentTrackIndex) Color(0xFF673AB7) else Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                musicPlayer.play(context, index)
                                currentTrackIndex = index
                            }
                            .padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) Color(0xFF2196F3) else Color(0xFFE0E0E0))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 12.sp
        )
    }
}

@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onTheoryClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icono
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF2196F3)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = recommendation.icon,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Contenido
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = recommendation.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )

                        // Botón favorito
                        IconButton(
                            onClick = onFavoriteClick,
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                                contentDescription = "Favorito",
                                tint = if (isFavorite) Color.Red else Color.Gray
                            )
                        }

                        // Botón teoría
                        IconButton(
                            onClick = onTheoryClick,
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Teoría",
                                tint = Color(0xFF673AB7)
                            )
                        }
                    }

                    Text(
                        text = recommendation.description,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    // Teoría breve
                    Text(
                        text = recommendation.theory,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            // Categoría
            Text(
                text = "Categoría: ${recommendation.category}",
                fontSize = 12.sp,
                color = Color(0xFF2196F3),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CogniStudyTheme {
        CogniStudyApp()
    }
}


