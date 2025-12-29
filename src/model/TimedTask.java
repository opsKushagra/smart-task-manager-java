package model;

import java.time.LocalDateTime;

public class TimedTask extends Task {

    public TimedTask(String title, String description,
                     Priority priority, LocalDateTime dueDate) {
        super(title, description, priority, dueDate);
    }

    @Override
    public boolean isOverdue() {
        return getDueDate() != null &&
               LocalDateTime.now().isAfter(getDueDate()) &&
               getStatus() != Status.DONE;
    }
}

