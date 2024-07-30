package com.example.todolist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist.model.ToDo;
import com.example.todolist.repository.ToDoRepository;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }

    public ToDo findById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }
}
