package com.example;

import com.example.exception.OperacionInvalidaException;
import com.example.exception.TareaNoEncontradaException;
import com.example.exception.TareaYaCompletadaException;
import com.example.model.Tarea;
import com.example.service.TareaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final TareaService tareaService = new TareaService();

    public static void main(String[] args) {
        log.info("Iniciando aplicacion TaskManager");
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    listarTareas();
                    break;
                case 3:
                    completarTarea();
                    break;
                case 4:
                    eliminarTarea();
                    break;
                case 5:
                    salir = true;
                    log.info("Finalizando aplicación...");
                    sout("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    sout("Opción no valida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        sout("\n--- TASK MANAGER ---");
        sout("1. Agregar Tarea");
        sout("2. Listar Tareas");
        sout("3. Completar Tarea");
        sout("4. Eliminar Tarea");
        sout("5. Salir");
        sout("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            // Limpiar buffer
            scanner.nextLine();
            log.warn("Entrada invalida al seleccionar opción de menu");
            return -1;
        } finally {
            // Consumir nueva linea
            scanner.nextLine();
        }
    }

    private static void agregarTarea() {
        try {
            sout("Ingrese la descripción de la tarea: ");
            String descripcion = scanner.nextLine();
            Tarea tarea = tareaService.agregarTarea(descripcion);
            sout("Tarea creada con ID: " + tarea.getId());
        } catch (OperacionInvalidaException e) {
            log.error("Error al agregar tarea: {}", e.getMessage());
            sout("Error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado al agregar tarea", e);
            sout("Error inesperado: " + e.getMessage());
        }
    }

    private static void listarTareas() {
        List<Tarea> tareas = tareaService.listarTareas();
        if (tareas.isEmpty()) {
            sout("No hay tareas registradas.");
        } else {
            sout("\n--- Lista de Tareas ---");
            for (Tarea tarea : tareas) {
                sout(tarea.toString());
            }
        }
    }

    private static void completarTarea() {
        try {
            sout("Ingrese el ID de la tarea a completar: ");
            int id = Integer.parseInt(scanner.nextLine());
            tareaService.completarTarea(id);
            sout("Tarea completada exitosamente.");
        } catch (NumberFormatException e) {
            log.warn("ID invalido ingresado para completar tarea");
            sout("Error: Debe ingresar un ID numerico valido.");
        } catch (TareaNoEncontradaException | TareaYaCompletadaException e) {
            log.error("Error al completar tarea: {}", e.getMessage());
            sout("Error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado al completar tarea", e);
            sout("Error inesperado: " + e.getMessage());
        }
    }

    private static void eliminarTarea() {
        try {
            sout("Ingrese el ID de la tarea a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            tareaService.eliminarTarea(id);
            sout("Tarea eliminada exitosamente.");
        } catch (NumberFormatException e) {
            log.warn("ID invalido ingresado para eliminar tarea");
            sout("Error: Debe ingresar un ID numérico valido.");
        } catch (TareaNoEncontradaException e) {
            log.error("Error al eliminar tarea: {}", e.getMessage());
            sout("Error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado al eliminar tarea", e);
            sout("Error inesperado: " + e.getMessage());
        }
    }

    // Función de utilidad para imprimir mensajes en consola
    private static void sout(String mensaje) {
        System.out.println(mensaje);
    }
}
