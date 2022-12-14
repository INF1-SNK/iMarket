package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Employee;

public interface EmployeeDAO {

     void add(String familyName, String firstName, Integer age, String contractType, Integer weeklyHours, String timeOfDay, String position);

    Employee get(int id);

}
