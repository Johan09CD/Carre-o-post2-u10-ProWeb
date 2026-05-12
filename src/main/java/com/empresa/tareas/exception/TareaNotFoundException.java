package com.empresa.tareas.exception;

import jakarta.persistence.EntityNotFoundException;

public class TareaNotFoundException extends EntityNotFoundException {
    public TareaNotFoundException(Long id) {
        super("Tarea no encontrada: " + id);
    }
}