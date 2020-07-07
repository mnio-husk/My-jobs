package main;

import org.springframework.web.bind.annotation.*;
import response.Task;

import java.util.HashMap;
import java.util.List;

@RestController
public class Todolist {

    @GetMapping("/tasks/")
    public HashMap<Integer,Task> list(){
        return DataBase.getTasks();
    }

    @PostMapping("/tasks/")
    public int addTask (Task task){
        return DataBase.addTask(task);
    }

    @PostMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable(value = "id") Integer id){
      return DataBase.deleteTask(id);
    }

    @DeleteMapping("/tasks/")
    public HashMap<Integer,Task> deleteAllTasks(){
        return DataBase.deleteAll();
    }
}
