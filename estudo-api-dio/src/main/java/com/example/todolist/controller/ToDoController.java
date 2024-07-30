package com.example.todolist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todolist.model.ToDo;
import com.example.todolist.service.ToDoService;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.findAll();
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoService.save(toDo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        ToDo toDo = toDoService.findById(id);
        return toDo != null ? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDoDetails) {
        ToDo toDo = toDoService.findById(id);
        if (toDo == null) {
            return ResponseEntity.notFound().build();
        }
        toDo.setTitle(toDoDetails.getTitle());
        toDo.setDescription(toDoDetails.getDescription());
        toDo.setCompleted(toDoDetails.isCompleted());
        ToDo updatedToDo = toDoService.save(toDo);
        return ResponseEntity.ok(updatedToDo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        ToDo toDo = toDoService.findById(id);
        if (toDo == null) {
            return ResponseEntity.notFound().build();
        }
        toDoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
