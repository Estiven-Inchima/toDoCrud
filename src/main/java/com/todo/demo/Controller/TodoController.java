package com.todo.demo.Controller;


import com.todo.demo.Model.Task;
import com.todo.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;
    @GetMapping(value = "/")
    public String inicio(){
        return "Bienvenido!";
    }

    //listar
    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    //crear
    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "save Task";
    }
    //actualizar
    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id,@RequestBody Task task){
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        todoRepository.save(updateTask);
        return "update task ";
    }

    //eliminar
    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "delete task";
    }


}
