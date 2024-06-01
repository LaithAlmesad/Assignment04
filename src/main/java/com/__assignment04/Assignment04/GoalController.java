package com.__assignment04.Assignment04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/all")
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "goal-list";
    }

    @GetMapping("/{id}")
    public String getGoalById(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal-detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("goal", new Goal());
        return "goal-create";
    }

    @PostMapping("/create")
    public String addNewGoal(@ModelAttribute Goal goal) {
        goalService.saveGoal(goal);
        return "redirect:/goals/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Goal goal = goalService.getGoalById(id);
        model.addAttribute("goal", goal);
        return "goal-update";
    }

    @PostMapping("/update")
    public String updateGoal(@ModelAttribute Goal goal) {
        goalService.saveGoal(goal);
        return "redirect:/goals/" + goal.getGoalId();
    }

    @PostMapping("/delete/{id}")
    public String deleteGoal(@PathVariable int id) {
        goalService.deleteGoal(id);
        return "redirect:/goals/all";
    }
}
