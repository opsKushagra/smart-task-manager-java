package service;

import dao.TaskDAO;
import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    private final TaskDAO taskDAO;
    private final List<Task> tasks;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
        this.tasks = taskDAO.load(); // load saved tasks
    }

    // Add new task
    public void addTask(Task task) {
        tasks.add(task);
        taskDAO.save(tasks);
    }

    // Delete task by ID
    public void deleteTask(String taskId) {
        tasks.removeIf(t -> t.getId().equals(taskId));
        taskDAO.save(tasks);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // Get overdue tasks
    public List<Task> getOverdueTasks() {
        return tasks.stream()
                .filter(Task::isOverdue)
                .collect(Collectors.toList());
    }
}
