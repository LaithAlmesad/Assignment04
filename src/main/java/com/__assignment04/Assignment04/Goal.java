package com.__assignment04.Assignment04;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goalId;

    @Nonnull
    private int userId;

    @Nonnull
    private String title;

    private String details;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date targetDate;

    @Nonnull
    private String status;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public void setStatus(@Nonnull String status) {
        this.status = status;
    }

    public int getGoalId() {
        return goalId;
    }

    public int getUserId() {
        return userId;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    @Nonnull
    public String getStatus() {
        return status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
