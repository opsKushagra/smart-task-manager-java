package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TaskDashboardView extends JFrame {

    private JTable taskTable;
    private DefaultTableModel tableModel;

    private JButton addButton;
    private JButton deleteButton;
    private JButton refreshButton;

    public TaskDashboardView() {
        setTitle("Smart Task Manager");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        // Table
        String[] columns = {"ID", "Title", "Priority", "Status", "Due Date"};
        tableModel = new DefaultTableModel(columns, 0);
        taskTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(taskTable);

        // Buttons
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");
        refreshButton = new JButton("Refresh");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters for controller
    public JTable getTaskTable() {
        return taskTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }
}
