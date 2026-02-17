package com.example.util;

import com.example.exception.OperacionInvalidaException;

public class Validaciones {

    public void validarDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new OperacionInvalidaException("La descripcion de la tarea no puede estar vacia.");
        }
    }
}
