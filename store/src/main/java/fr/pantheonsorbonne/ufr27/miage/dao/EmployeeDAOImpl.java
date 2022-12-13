package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void add(String familyName, String firstName, Integer age, String contractType, Integer weeklyHours, String timeOfDay, String position) {
        Employee e = new Employee();
        e.setFamilyName(familyName);
        e.setFirstName(firstName);
        e.setAge(age);
        e.setContractType(contractType);
        e.setWeeklyHours(weeklyHours);
        e.setTimeOfDay(timeOfDay);
        e.setPosition(position);
        em.persist(e);
        em.flush();
    }

    @Override
    public Employee get(int id) {
        return null;
    }
}
