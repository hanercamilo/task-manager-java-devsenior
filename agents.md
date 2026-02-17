# Proyecto Integrador – Sistema de Gestión de Tareas

## Descripción general

Se debe desarrollar una aplicación Java de consola llamada 'TaskManager – Gestor Básico de
Tareas'. El sistema permitirá administrar una lista de tareas pendientes desde la línea de
comandos, aplicando buenas prácticas de programación profesional: manejo adecuado de errores
y excepciones, registro de eventos mediante logs y desarrollo de pruebas unitarias.

## Objetivo del proyecto

Construir una aplicación en Java que permita crear, listar, completar y eliminar tareas,
demostrando el dominio de: manejo de excepciones, uso de logging profesional y creación de
pruebas unitarias.

## Requerimientos funcionales

- Agregar una tarea con ID, descripción y estado.
- Listar todas las tareas registradas.
- Marcar una tarea como completada.
- Eliminar una tarea por ID.
- Salir correctamente del sistema.

## Requerimientos técnicos obligatorios

### 1. Excepciones y manejo de errores

El proyecto debe incluir manejo adecuado de excepciones usando bloques try-catch-finally,
diferenciación entre excepciones verificadas y no verificadas, y creación de al menos una
excepción personalizada como TareaNoEncontradaException u OperacionInvalidaException.

### 2. Logging con SLF4J y Log4j

Se debe configurar SLF4J como fachada de logging y Log4j como implementación. La aplicación
debe registrar eventos importantes usando niveles INFO, DEBUG, WARN y ERROR, y contar con
un archivo log4j2.xml correctamente configurado.

### 3. Pruebas Unitarias con JUnit

El proyecto debe incluir pruebas unitarias que validen la funcionalidad principal del sistema,
incluyendo pruebas para creación y eliminación de tareas, así como validación del correcto
lanzamiento de excepciones.


## Entregables

- Código fuente del proyecto completo.
- Archivo de configuración de Log4j.
- Pruebas unitarias funcionales.
- Evidencia de ejecución del programa.
- Documento explicativo del trabajo realizado.

## Criterios de evaluación

- Manejo correcto de excepciones: 30%
- Implementación adecuada de logging: 25%
- Pruebas unitarias funcionales: 25%
- Funcionalidad general del sistema: 20%

Este proyecto busca que el estudiante demuestre habilidades fundamentales del desarrollo
profesional en Java, aplicando buenas prácticas de programación, depuración y pruebas.


