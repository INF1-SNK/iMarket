package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Command;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class CommandDAOImpl implements CommandDAO{

    @Inject
    EntityManager em;

    @Transactional
    @Override
    public void createCommand(Command c) {
        Command command = c;
        em.persist(command);
        em.flush();
    }
}
