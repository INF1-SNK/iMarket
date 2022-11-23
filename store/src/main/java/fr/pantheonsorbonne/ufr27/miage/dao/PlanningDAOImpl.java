package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Employee;
import fr.pantheonsorbonne.ufr27.miage.model.Planning;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
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
        return (List<Employee>) em.createQuery("SELECT p.employees from Planning p where p.id = ?1").setParameter(1, id).getResultList();
    }


}
