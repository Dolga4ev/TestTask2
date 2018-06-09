package test.task2;

import java.util.Objects;

public class Task {
    private String id;
    private String title;
    private String description;
    private String priority;
    private String deadline;
    private Status status;
    private String complete;

    public Task() {
    }
    public Task(String id, String title, String description, String priority, String deadline, Status status, String complete) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
        this.complete = complete;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(priority, task.priority) &&
                Objects.equals(deadline, task.deadline) &&
                status == task.status &&
                Objects.equals(complete, task.complete);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, priority, deadline, status, complete);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public Status getStatus() {
        return status;
    }

    public String getComplete() {
        return complete;
    }
    @Override
    public String toString() {
        return "Task " + id +
                " (" + title + "): "
                + description + ", "
                + priority + ", "
                + deadline + ", "
                + status + ", "
                + complete ;
    }
}
