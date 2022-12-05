package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CvDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.model.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RequestScoped
public class CandidatureServiceImpl implements CandidatureService {

    @PersistenceContext
    EntityManager em;
    @Inject
    CvDAO cvDAO;

    PlanningDTO planningDTO;


    @Override
    public List<CvDTO> getCandidatures() {
        Collection<CvDTO> candidatures = new LinkedList<>();
        for (Cv cv : cvDAO.getAllCv()) {
            if(cv.getLocalisation().equals("Paris")){
                candidatures.add(new CvDTO(cv.getFirstName(), cv.getLastName(), cv.getLocalisation(), cv.getAge(),cv.getContractType(), cv.getWeeklyHours(), cv.getEmail() ));
            }
        }
        return (List<CvDTO>) candidatures;
    }

}
