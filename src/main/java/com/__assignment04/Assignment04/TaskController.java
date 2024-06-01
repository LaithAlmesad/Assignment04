package com.__assignment04.Assignment04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private GoalService goalService;

    @GetMapping("/goal/{goalId}")
    public String viewTasksByGoal(@PathVariable int goalId, Model model) {
        Goal goal = goalService.getGoalById(goalId);
        if (goal == null) {
            return "error";
        }
        model.addAttribute("goal", goal);
        model.addAttribute("taskList", taskService.getTasksByGoal(goalId));
        return "task-list";
    }

    @GetMapping("/create/{goalId}")
    public String showCreateForm(@PathVariable int goalId, Model model) {
        Goal goal = goalService.getGoalById(goalId);
        if (goal == null) {
            return "error";
        }
        Task task = new Task();
        task.setGoal(goal);
        model.addAttribute("task", task);
        return "task-create";
    }

    @PostMapping("/create")
    public String addNewTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/goals/all" + task.getGoal().getGoalId();
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return "error";
        }
        model.addAttribute("task", task);
        return "task-update";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/goals/all" + task.getGoal().getGoalId();
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return "error";
        }
        int goalId = task.getGoal().getGoalId();
        taskService.deleteTask(id);
        return "redirect:/goal/all" + goalId;
    }

    @GetMapping("/{id}")
    public String viewTaskDetails(@PathVariable int id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return "error";
        }
        model.addAttribute("task", task);
        return "task-detail";
    }
}
