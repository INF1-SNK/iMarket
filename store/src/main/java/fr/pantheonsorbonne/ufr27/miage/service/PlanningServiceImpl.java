package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.PlanningDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.EmployeeDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.PlanningNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Planning;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@ApplicationScoped
public class PlanningServiceImpl implements PlanningService{

    @Inject
    PlanningDAO planningDAO;
    @Override
    public PlanningDTO getPlanningById(int id) {
        Planning planning = planningDAO.get(id);
        if(planning == null){
            return null;
        }
        return getPlanningDTO(planning);

    }

    @Override
    public PlanningDTO getLastPlanning() {
        Planning planning = planningDAO.getLastPlanning();
        return getPlanningDTO(planning);
    }

    private PlanningDTO getPlanningDTO(Planning planning) {
        Collection<Employee> morningEmployees = planningDAO.getTimeOfDayEmployees(planning.getId(), "morning");
        Collection<Employee> eveningEmployees = planningDAO.getTimeOfDayEmployees(planning.getId(), "evening");
        int morningHours = calculateWorkingHours(morningEmployees);
        int eveningHours = calculateWorkingHours(eveningEmployees);
        Collection<EmployeeDTO> employeeDTOCollection = new ArrayList<>();
        for (Employee e :
                planning.getEmployees()) {
            employeeDTOCollection.add(new EmployeeDTO(e.getFamilyName(), e.getAge(), e.getContractType(), e.getWeeklyHours(), e.getTimeOfDay(), e.getPosition()));
        }
        return new PlanningDTO(planning.getId(), planning.getTotalHours(), morningHours, eveningHours, morningEmployees.size(), eveningEmployees.size(), employeeDTOCollection);
    }

    public int calculateWorkingHours(Collection<Employee> employeeCollection){
        int hours = 0;
        for (Employee e :
                employeeCollection) {
            hours += e.getWeeklyHours();
        }
        return hours;
    }
}
