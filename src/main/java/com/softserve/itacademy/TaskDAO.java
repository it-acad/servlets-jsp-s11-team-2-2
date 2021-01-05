package com.softserve.itacademy;

import java.util.LinkedList;
import java.util.List;

public class TaskDAO {
    private List<Task> tasks = new LinkedList<>();

    private static TaskDAO taskDaoInstance = null;

    private TaskDAO() {
    }

    public static TaskDAO getInstance() {
        if (taskDaoInstance == null) {
            taskDaoInstance = new TaskDAO();
        }
        return taskDaoInstance;
    }

    public boolean create(Task task) {
        if (task != null)
            return tasks.add(task);
        return false;
    }

    public Task viewInfo(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public boolean edit(int id, Task task) {
        int index = tasks.indexOf(viewInfo(id));
        return tasks.set(index, task) != null;
    }

    public boolean delete(int id) {
        return tasks.remove(viewInfo(id));
    }

    public List<Task> showAll() {
        return tasks;
    }
}
