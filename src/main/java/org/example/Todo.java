package org.example;

import java.time.LocalDate;

public class Todo {
    private int todoId;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private int assigneeId;

    public Todo(int todoId, String title, String description, LocalDate deadline, boolean done, int assigneeId) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public Todo(String title, String description, LocalDate deadline, boolean done, int assigneeId) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public int getTodoId() {
        return todoId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return done;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    @Override
    public String toString() {
        return "TodoItems{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assigneeId=" + assigneeId +
                '}';
    }
}
