package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CvDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.EmployeeDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.model.*;
import fr.pantheonsorbonne.ufr27.miage.resources.PlanningService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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
    @Inject
    @RestClient
    PlanningService planningService;

    private PlanningDTO getLastPlanningFromStore(){
        return planningService.getLastPlanning();
    }

    @Override
    public List<CvDTO> getCandidatures() {

        PlanningDTO planningDTO = getLastPlanningFromStore();
        if (cvIsNeeded(planningDTO)) {
            Collection<CvDTO> candidatures = new LinkedList<>();
            for (Cv cv : cvDAO.getAllCv()) {
                if (cv.getLocalisation().equals("Paris")) {
                    candidatures.add(new CvDTO(cv.getFirstName(), cv.getLastName(), cv.getLocalisation(), cv.getAge(), cv.getContractType(), cv.getWeeklyHours(), cv.getEmail()));
                }
            }
            return (List<CvDTO>) candidatures;
        }
        return new LinkedList<>();
    }

    public boolean cvIsNeeded(PlanningDTO planningDTO){
        Collection<EmployeeDTO> employeeDTOCollection = planningDTO.getEmployeeDTOCollection();
        if (planningDTO.getEveningHours() + planningDTO.getMorningHours() < planningDTO.getTotalHours()){
            int additionalHours = 0;
            for (EmployeeDTO e:
                 employeeDTOCollection) {
                if (e.getContractType().equals("permanent") || e.getContractType().equals("fixed-term")) {
                    additionalHours += 38;
                }else {
                    additionalHours += e.getWeeklyHours() + e.getWeeklyHours()* 0.1;
                }
            }
            return additionalHours < planningDTO.getTotalHours();
        }
        return false;
    }

}
