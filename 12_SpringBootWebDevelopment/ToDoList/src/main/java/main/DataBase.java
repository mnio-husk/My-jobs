package main;

import response.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private static HashMap<Integer, Task> tasks = new HashMap<>();
    private static int number = 1;

    public static int addTask(Task task) {
        int id = number++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public static Task deleteTask(Integer id) {
        return tasks.remove(id);
    }

    public static HashMap<Integer, Task> deleteAll() {
        for (int i = 0; i < tasks.size() ; i++) {
            tasks.remove(i);
        }
        return tasks;
    }
}
