package controller;

import model.Priority;
import model.TimedTask;
import service.TaskService;
import view.TaskDashboardView;
import view.TaskFormView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;

public class TaskController {

    private final TaskService service;
    private final TaskDashboardView dashboard;

    public TaskController(TaskService service, TaskDashboardView dashboard) {
        this.service = service;
        this.dashboard = dashboard;

        initController();
        loadTasks();
    }

    private void initController() {
        dashboard.getAddButton().addActionListener(e -> openAddTaskDialog());
        dashboard.getDeleteButton().addActionListener(e -> deleteSelectedTask());
        dashboard.getRefreshButton().addActionListener(e -> loadTasks());
    }

    private void openAddTaskDialog() {
        TaskFormView form = new TaskFormView(dashboard);

        form.getSaveButton().addActionListener(e -> {
            String title = form.getTitleField().getText();
            String description = form.getDescriptionArea().getText();
            Priority priority = Priority.valueOf(
                    form.getPriorityBox().getSelectedItem().toString()
            );

            service.addTask(new TimedTask(
                    title,
                    description,
                    priority,
                    LocalDateTime.now().plusDays(1)
            ));

            form.dispose();
            loadTasks();
        });

        form.setVisible(true);
    }

    private void deleteSelectedTask() {
        int selectedRow = dashboard.getTaskTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(dashboard,
                    "Please select a task to delete");
            return;
        }

        String taskId = dashboard.getTableModel()
                .getValueAt(selectedRow, 0)
                .toString();

        service.deleteTask(taskId);
        loadTasks();
    }

    private void loadTasks() {
        DefaultTableModel model = dashboard.getTableModel();
        model.setRowCount(0);

        service.getAllTasks().forEach(task -> model.addRow(new Object[]{
                task.getId(),
                task.getTitle(),
                task.getPriority(),
                task.getStatus(),
                task.getDueDate()
        }));
    }
}
