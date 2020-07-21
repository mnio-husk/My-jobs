package Main.controllers;

import Main.models.Task;
import Main.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TaskControllers {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task")
    public String taskMain(Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "task-main";
    }

    @GetMapping("/task/add")
    public String taskAdd(Model model) {
        return "task-add";
    }

    @PostMapping("/task/add")
    public String taskPostAdd(@RequestParam String name, @RequestParam String dateComplected, Model model) {
        Task task = new Task(name, dateComplected);
        taskRepository.save(task);
        return "redirect:/task";
    }

    @GetMapping("/task/{id}")
    public String taskDetails(@PathVariable(value = "id") Long id, Model model) {
        if (!taskRepository.existsById(id)) {
            return "redirect:/task";
        }
        Optional<Task> task = taskRepository.findById(id);
        ArrayList<Task> result = new ArrayList<>();
        task.ifPresent(result::add);
        model.addAttribute("task", result);
        return "task-details";
    }

    @GetMapping("/task/{id}/edit")
    public String taskEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!taskRepository.existsById(id)) {
            return "redirect:/task";
        }
        Optional<Task> task = taskRepository.findById(id);
        ArrayList<Task> result = new ArrayList<>();
        task.ifPresent(result::add);
        model.addAttribute("task", result);
        return "task-edit";
    }

    @PostMapping("/task/{id}/edit")
    public String taskPostUpdate(@PathVariable(value = "id") Long id, @RequestParam String name, @RequestParam String dateComplected, Model model) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setName(name);
        task.setDateComplected(dateComplected);
        taskRepository.save(task);
        return "redirect:/task";
    }

    @PostMapping("/task/{id}/remove")
    public String taskPostRemove(@PathVariable(value = "id") Long id, Model model) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
        return "redirect:/task";
    }
}
