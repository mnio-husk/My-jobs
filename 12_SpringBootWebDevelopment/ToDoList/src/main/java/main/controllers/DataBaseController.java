package Main.controllers;

import Main.response.Task;
import Main.response.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class DataBaseController {

    private List tasks = Collections.synchronizedList(new ArrayList());

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task")
    public List<Task> list() {
        Iterable<Task> tasksIterable = taskRepository.findAll();
        ArrayList<Task> tasks =  new ArrayList<>();
        for (Task task : tasksIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @PostMapping("/task")
    public int addTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @PostMapping("/task/{id}")
    public void deleteTask(@PathVariable(value = "id") Integer id) {
        taskRepository.deleteById(id);
    }

    @DeleteMapping("/task")
    public void deleteAllTasks() {
        taskRepository.deleteAll();

    }

    @PutMapping("/task/{id}")
    public Task changeTask(@PathVariable(value = "id") Integer id, Task task) {
        return taskRepository.save(task);
    }


    @GetMapping("/task/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask, HttpStatus.OK);
    }
}
