package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CvDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.model.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;

@RequestScoped
public class CandidatureServiceImpl implements CandidatureService {

    @PersistenceContext
    EntityManager em;
    @Inject
    CvDAO cvDAO;


    @Override
    public Collection<CvDTO> getCandidatures() {
        Collection<CvDTO> candidatures = new LinkedList<>();
        for (Cv cv : cvDAO.getAllCv()) {
            if(cv.getLocalisation() == "Paris"){
                if( cv.getAge() > 18 && cv.getAge() < 23 ||  cv.getAge() > 50  ){
                    candidatures.add(new CvDTO(cv.getFirstName(), cv.getLastName(), cv.getLocalisation(), cv.getAge(),cv.getContractType(), cv.getWeeklyHours(), cv.getEmail() ));
                }
            }
        }
        return candidatures;
    }

}
