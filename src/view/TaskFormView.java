package view;

import javax.swing.*;
import java.awt.*;

public class TaskFormView extends JDialog {

    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<String> priorityBox;
    private JButton saveButton;

    public TaskFormView(JFrame parent) {
        super(parent, "Add Task", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(6, 1, 10, 10));

        titleField = new JTextField();
        descriptionArea = new JTextArea(3, 20);
        priorityBox = new JComboBox<>(new String[]{"LOW", "MEDIUM", "HIGH"});
        saveButton = new JButton("Save Task");

        add(new JLabel("Title"));
        add(titleField);
        add(new JLabel("Description"));
        add(new JScrollPane(descriptionArea));
        add(priorityBox);
        add(saveButton);
    }

    // Getters
    public JTextField getTitleField() {
        return titleField;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    public JComboBox<String> getPriorityBox() {
        return priorityBox;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
