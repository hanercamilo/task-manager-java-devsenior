# TaskManager – Gestor Básico de Tareas

## Descripción General
TaskManager es una aplicación de consola desarrollada en Java que permite administrar una lista de tareas pendientes. El proyecto demuestra buenas prácticas de programación profesional, incluyendo manejo robusto de excepciones, logging con SLF4J y Log4j2, y pruebas unitarias con JUnit 5.

Este proyecto fue desarrollado como parte del Proyecto Integrador del Módulo 3.

## Características
- **Gestión de Tareas**:
  - Agregar nuevas tareas con descripción.
  - Listar todas las tareas registradas.
  - Marcar tareas como completadas.
  - Eliminar tareas por ID.
- **Técnicas Implementadas**:
  - Manejo de excepciones (verificadas y no verificadas, personalizadas).
  - Sistema de Logging (INFO, DEBUG, WARN, ERROR).
  - Pruebas unitarias para validar la lógica de negocio.

## Requisitos Previos
- **Java Development Kit (JDK) 17** o superior.
- **Apache Maven** 3.8 o superior.
- Un IDE compatible (IntelliJ IDEA, Eclipse, VS Code) es recomendado.

## Estructura del Proyecto
```
task-manager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── Main.java           # Punto de entrada de la aplicación
│   │   │       ├── model/              # Clases de modelo (Tarea)
│   │   │       ├── service/            # Lógica de negocio
│   │   │       ├── exception/          # Excepciones personalizadas
│   │   │       └── util/               # Utilidades
│   │   └── resources/
│   │       └── log4j2.xml              # Configuración de Logging
│   └── test/                           # Pruebas unitarias JUnit
├── pom.xml                             # Configuración de Maven y dependencias
├── agents.md                           # Especificación del proyecto
└── README.md                           # Documentación del proyecto
```

## Configuración y Ejecución

### Compilar el proyecto
Para compilar el proyecto y descargar las dependencias, ejecuta el siguiente comando en la raíz del proyecto:

```bash
mvn clean install
```

### Ejecutar la aplicación
Puedes ejecutar la aplicación directamente desde tu IDE ejecutando la clase `com.example.Main`.

Alternativamente, si tienes configurado el plugin exec de Maven (o si tu IDE lo soporta):
```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

Alternativamente, compilar y ejecutar manualmente con el classpath (ejemplo en Windows):
```powershell
# Compilar
mvn package

# Ejecutar (nota: requiere que las dependencias estén en el classpath,
# se recomienda usar IDE o generar un "fat jar" si se desea portabilidad)
java -cp target/classes;target/dependency/* com.example.Main
```

### Ejecutar Pruebas
Para ejecutar las pruebas unitarias y verificar el correcto funcionamiento del sistema:

```bash
mvn test
```

## Tecnologías Utilizadas
- **Java 17**: Lenguaje de programación.
- **Maven**: Gestión de dependencias y construcción.
- **SLF4J + Log4j2**: Framework de logging.
- **JUnit 5**: Framework de pruebas unitarias.

## Autor
Haner Camilo Perea Yara, desarrollado para el curso de Java - DevSenior.
