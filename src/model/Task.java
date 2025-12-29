package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Task implements Serializable {

    private final String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime dueDate;

    protected Task(String title, String description,
                   Priority priority, LocalDateTime dueDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.TODO;
        this.dueDate = dueDate;
    }

    public abstract boolean isOverdue();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


public LocalDateTime getDueDate() {
    return dueDate;
}

public Status getStatus() {
    return status;
}

public Priority getPriority() {
    return priority;
}

}

