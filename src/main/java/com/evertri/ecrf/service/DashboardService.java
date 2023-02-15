package com.evertri.ecrf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertri.ecrf.model.Dashboard;
import com.evertri.ecrf.repository.DashboardRepository;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    // get all dashboards
    public List<Dashboard> getAllDashboards() {
        return dashboardRepository.findAll();
    }

    // get dashboard by id
    public Dashboard getDashboardById(Long id) {
        return dashboardRepository.findById(id).orElse(null);
    }

    // add a new dashboard
    public Dashboard addDashboard(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    // update existing dashboard
    public Dashboard updateDashboard(Long id, Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    // delete dashboard by id
    public void deleteDashboard(Long id) {
        dashboardRepository.deleteById(id);
    }

    // get dashboard by name
    public Dashboard getDashboardByName(String name) {
        return dashboardRepository.findByName(name);
    }

}
