package com.empresa.tareas.service;

import com.empresa.tareas.entity.Tarea;
import com.empresa.tareas.exception.TareaNotFoundException;
import com.empresa.tareas.repository.TareaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TareaService {

    private final TareaRepository repo;

    public TareaService(TareaRepository repo) {
        this.repo = repo;
    }

    public Tarea crear(Tarea tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().isBlank())
            throw new IllegalArgumentException("El título no puede estar vacío");
        return repo.save(tarea);
    }

    public Tarea buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new TareaNotFoundException(id));
    }

    public List<Tarea> listarTodas() {
        return repo.findAll();
    }

    public Tarea completar(Long id) {
        Tarea t = buscarPorId(id);
        t.setCompletada(true);
        return repo.save(t);
    }
}