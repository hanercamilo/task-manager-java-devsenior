package com.example.service;

import com.example.exception.OperacionInvalidaException;
import com.example.exception.TareaNoEncontradaException;
import com.example.exception.TareaYaCompletadaException;
import com.example.model.Tarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TareaServiceTest {

    private TareaService tareaService;

    @BeforeEach
    void setUp() {
        tareaService = new TareaService();
    }

    @Test
    void testAgregarTareaExitosa() {
        Tarea tarea = tareaService.agregarTarea("Crear el trabajo final del módulo");
        assertNotNull(tarea);
        assertEquals(1, tarea.getId());
        assertEquals("Crear el trabajo final del módulo", tarea.getDescripcion());
        assertFalse(tarea.isCompletada());
    }

    @Test
    void testAgregarTareaDescripcionInvalida() {
        assertThrows(OperacionInvalidaException.class, () -> tareaService.agregarTarea(""));
        assertThrows(OperacionInvalidaException.class, () -> tareaService.agregarTarea(null));
    }

    @Test
    void testListarTareas() {
        tareaService.agregarTarea("Tarea 1");
        tareaService.agregarTarea("Tarea 2");
        List<Tarea> tareas = tareaService.listarTareas();
        assertEquals(2, tareas.size());
    }

    @Test
    void testCompletarTareaExitosa() throws TareaNoEncontradaException, TareaYaCompletadaException {
        Tarea tarea = tareaService.agregarTarea("Estudiar Java");
        tareaService.completarTarea(tarea.getId());
        assertTrue(tarea.isCompletada());
    }

    @Test
    void testCompletarTareaYaCompletada() throws TareaNoEncontradaException {
        Tarea tarea = tareaService.agregarTarea("Estudiar Java");
        tareaService.completarTarea(tarea.getId());
        assertThrows(TareaYaCompletadaException.class, () -> tareaService.completarTarea(tarea.getId()));
    }

    @Test
    void testCompletarTareaNoEncontrada() {
        assertThrows(TareaNoEncontradaException.class, () -> tareaService.completarTarea(999));
    }

    @Test
    void testEliminarTareaExitosa() throws TareaNoEncontradaException {
        Tarea tarea = tareaService.agregarTarea("Hacer ejercicio");
        tareaService.eliminarTarea(tarea.getId());
        List<Tarea> tareas = tareaService.listarTareas();
        assertTrue(tareas.isEmpty());
    }

    @Test
    void testEliminarTareaNoEncontrada() {
        assertThrows(TareaNoEncontradaException.class, () -> tareaService.eliminarTarea(999));
    }
}
