package com.__assignment04.Assignment04;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goalId", nullable = false)
    private Goal goal;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStatus(@Nonnull String status) {
        this.status = status;
    }

    public Goal getGoal() {
        return goal;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    @Nonnull
    public String getStatus() {
        return status;
    }

    @Nonnull
    private String title;

    private String details;

    @Nonnull
    private String status;
}