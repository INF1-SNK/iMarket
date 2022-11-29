package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.PlanningDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.PlanningNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Planning;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PlanningServiceImpl implements PlanningService{

    @Inject
    PlanningDAO planningDAO;
    @Override
    public PlanningDTO getPlanningById(int id) throws PlanningNotFoundException {
        Collection<Employee> employeeCollection = planningDAO.getEmployeesFromPlanning(id);
        Planning planning = planningDAO.get(id);
        if (planning != null) {
            int morningHours = 0;
            int eveningHours = 0;
            for (Employee e :
                    employeeCollection) {
                if (e.getTimeOfDay().equals("morning")) {
                    morningHours += e.getWeeklyHours();
                } else if (e.getTimeOfDay().equals("evening")) {
                    eveningHours += e.getWeeklyHours();
                }
            }
            return new PlanningDTO(id, planning.getTotalHours(), morningHours, eveningHours);
        }
        throw new PlanningNotFoundException("planning not found");
    }
}
