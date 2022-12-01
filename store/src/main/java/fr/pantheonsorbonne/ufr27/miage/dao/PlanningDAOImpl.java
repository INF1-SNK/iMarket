package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Planning;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class PlanningDAOImpl implements PlanningDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Planning get(int id) {
        return em.find(Planning.class, id);
    }

    @Override
    public Collection<Employee> getEmployeesFromPlanning(int id) {
        return (Collection<Employee>) em.createQuery("SELECT p.employees from Planning p where p.id = ?1").setParameter(1, id).getResultList();
    }

    @Override
    public Collection<Employee> getTimeOfDayEmployees(int id, String timeOfDay) {
        Collection<Employee> employeeCollection = getEmployeesFromPlanning(id);
        Collection<Employee> employeeCollection1 = new LinkedList<>();
        for (Employee e :
                employeeCollection) {
            if (e.getTimeOfDay().equals(timeOfDay)) {
                employeeCollection1.add(e);
            }
        }
        return employeeCollection1;
    }

    @Override
    public Planning getLastPlanning() {
        List planningList = em.createQuery("select p from Planning p order by p.id desc").setMaxResults(1).getResultList();
        return (Planning) planningList.get(0);
    }


}
