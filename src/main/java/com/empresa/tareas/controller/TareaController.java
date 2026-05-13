package com.empresa.tareas.controller;

import com.empresa.tareas.entity.Tarea;
import com.empresa.tareas.service.TareaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping("/tareas")
    public String paginaTareas() {
        return "tareas";
    }

    @PostMapping("/api/tareas")
    @ResponseBody
    public ResponseEntity<Tarea> crear(@Valid @RequestBody Tarea tarea) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(tarea));
    }

    @GetMapping("/api/tareas")
    @ResponseBody
    public ResponseEntity<List<Tarea>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/api/tareas/{id}")
    @ResponseBody
    public ResponseEntity<Tarea> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/api/tareas/{id}/completar")
    @ResponseBody
    public ResponseEntity<Tarea> completar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.completar(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}