package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Planning;

import java.util.Collection;

public interface PlanningDAO {
    Planning get(int id);
    Collection<Employee> getEmployeesFromPlanning(int id);

    Collection<Employee> getTimeOfDayEmployees(int id, String timeOfDay);

    Planning getLastPlanning();
}
