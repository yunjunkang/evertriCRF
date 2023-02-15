package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Dashboard;
import com.evertri.ecrf.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboards")
public class DashboardController {
    //inject the DashboardService
    @Autowired
    private DashboardService dashboardService;

    // method to get all dashboards
    @GetMapping
    public List<Dashboard> getAllDashboards() {
        return dashboardService.getAllDashboards();
    }

    // method to get a specific dashboard by id
    @GetMapping("/{id}")
    public Dashboard getDashboardById(@PathVariable Long id) {
        return dashboardService.getDashboardById(id);
    }

    // method to add a new dashboard
    @PostMapping
    public Dashboard addDashboard(@RequestBody Dashboard dashboard) {
        return dashboardService.addDashboard(dashboard);
    }

    // method to update an existing dashboard
    @PutMapping("/{id}")
    public Dashboard updateDashboard(@PathVariable Long id, @RequestBody Dashboard dashboard) {
        return dashboardService.updateDashboard(id, dashboard);
    }

    // method to delete a dashboard
    @DeleteMapping("/{id}")
    public void deleteDashboard(@PathVariable Long id) {
        dashboardService.deleteDashboard(id);
    }

    // method to get dashboard by its name
    @GetMapping("/byName/{name}")
    public Dashboard getDashboardByName(@PathVariable String name) {
        return dashboardService.getDashboardByName(name);
    }
}
