package com.empresa.tareas.controller;

import com.empresa.tareas.entity.Tarea;
import com.empresa.tareas.service.TareaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@Valid @RequestBody Tarea tarea) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(tarea));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/completar")
    public ResponseEntity<Tarea> completar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.completar(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}