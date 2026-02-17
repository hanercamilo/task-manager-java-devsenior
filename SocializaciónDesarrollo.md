# Socialización del Desarrollo - Task Manager

## 1. Introducción
Este documento detalla el proceso de desarrollo y las decisiones técnicas tomadas para la construcción del "Task Manager", una aplicación de consola en Java diseñada para gestionar una lista de tareas pendientes. El objetivo principal fue crear una solución robusta que cumpliera con los requisitos funcionales y demostrara el uso de buenas prácticas de programación profesional.

## 2. Arquitectura de la Solución
Se adoptó una arquitectura en capas para separar las responsabilidades y mejorar la mantenibilidad del código:

*   **`com.example.model`**: Contiene la clase `Tarea`, que representa la entidad principal del sistema con sus atributos (ID, descripción, estado).
*   **`com.example.service`**: Contiene la clase `TareaService`, donde reside la lógica de negocio. Aquí se gestionan las operaciones CRUD y se validan las reglas de negocio.
*   **`com.example.exception`**: Define las excepciones personalizadas para manejar errores específicos del dominio.
*   **`com.example.util`**: Incluye la clase `Validaciones` para centralizar la validación de entradas y estados.
*   **`com.example.Main`**: Punto de entrada de la aplicación, encargado de la interacción con el usuario a través de la consola y la orquestación de las llamadas al servicio.

## 3. Decisiones Técnicas Destacadas

### 3.1 Manejo de Excepciones y Robustez
Para garantizar la estabilidad del sistema y proporcionar retroalimentación clara al usuario, se implementó un esquema de manejo de excepciones detallado:

*   **Excepciones Personalizadas**: Se crearon `TareaNoEncontradaException`, `TareaYaCompletadaException` y `OperacionInvalidaException` (heredando de `RuntimeException` o `Exception` según corresponda) para capturar situaciones específicas del negocio.
*   **Bloques Try-Catch**: El `Main` utiliza bloques `try-catch` para capturar estas excepciones y mostrar mensajes amigables al usuario, evitando que la aplicación se cierre abruptamente ante errores esperados.
*   **Validaciones Previas**: Se utilizan métodos utilitarios para verificar condiciones (ej. descripción vacía, ID inexistente) antes de proceder con las operaciones, lanzando excepciones si las condiciones no se cumplen.

### 3.2 Estrategia de Logging
Se implementó un sistema de logging profesional utilizando la fachada **SLF4J** con **Log4j2** como implementación subyacente.

*   **Niveles de Log**:
    *   `INFO`: Para registrar eventos normales del flujo (ej. inicio de aplicación, tarea agregada).
    *   `WARN`: Para advertencias de negocio (ej. intento de completar una tarea ya completada).
    *   `ERROR`: Para registrar excepciones y fallos críticos.
*   **Configuración**: El archivo `log4j2.xml` define cómo y dónde se guardan estos logs (consola y archivo `app.log` en la carpeta `logs/`), facilitando la auditoría y depuración posterior.

### 3.3 Pruebas Unitarias
Se utilizó **JUnit 5** para garantizar la calidad del código, enfocándose en la clase `TareaService`. Se cubrieron escenarios de:
*   Éxito: Agregar, listar, completar y eliminar tareas correctamente.
*   Fallo: Intentar operar sobre tareas inexistentes o duplicadas, validando que se lancen las excepciones correctas.

## 4. Conclusión
El proyecto "Task Manager" cumple con todos los requerimientos funcionales y técnicos establecidos. La estructura modular y el uso de patrones estándar facilitan la extensión futura (ej. persistencia en base de datos) y el mantenimiento del código. La inclusión de logs y pruebas unitarias eleva la calidad del entregable a un nivel profesional.

---
**Autor:** Haner Camilo Perea Yara
**Curso:** Java - DevSenior
