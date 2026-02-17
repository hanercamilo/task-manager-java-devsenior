package com.example.service;

import com.example.exception.TareaNoEncontradaException;
import com.example.exception.TareaYaCompletadaException;
import com.example.model.Tarea;
import com.example.util.Validaciones;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TareaService {

    private static final Logger log = LoggerFactory.getLogger(TareaService.class);
    private final List<Tarea> tareas;
    private int currentId;
    private final Validaciones validaciones;

    public TareaService() {
        this.tareas = new ArrayList<>();
        this.currentId = 1;
        this.validaciones = new Validaciones();
    }

    public Tarea agregarTarea(String descripcion) {
        log.debug("Intentando agregar tarea nueva con descripcion: {}", descripcion);
        validaciones.validarDescripcion(descripcion);

        Tarea nuevaTarea = new Tarea(currentId++, descripcion);
        tareas.add(nuevaTarea);
        log.info("Tarea agregada exitosamente: {}", nuevaTarea);
        return nuevaTarea;
    }

    public List<Tarea> listarTareas() {
        log.debug("Listando todas las tareas. Total: {}", tareas.size());
        return new ArrayList<>(tareas);
    }

    public void completarTarea(int id) throws TareaNoEncontradaException {
        log.debug("Intentando completar tarea con ID: {}", id);
        Tarea tarea = buscarTareaPorId(id);

        if (tarea.isCompletada()) {
            throw new TareaYaCompletadaException("La tarea con ID " + id + " ya esta completada.");
        }

        tarea.setCompletada(true);
        log.info("Tarea completada: ID {}", id);
    }

    public void eliminarTarea(int id) throws TareaNoEncontradaException {
        log.debug("Intentando eliminar tarea con ID: {}", id);
        Tarea tarea = buscarTareaPorId(id);
        tareas.remove(tarea);
        log.info("Tarea eliminada correctamente: ID {}", id);
    }

    private Tarea buscarTareaPorId(int id) throws TareaNoEncontradaException {
        return tareas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Tarea no encontrada con ID: {}", id);
                    return new TareaNoEncontradaException("La tarea con ID " + id + " no existe.");
                });
    }
}
