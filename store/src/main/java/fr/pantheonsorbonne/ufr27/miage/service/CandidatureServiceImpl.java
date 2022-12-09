package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.resources.CandidatureHRService;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
@ApplicationScoped
public class CandidatureServiceImpl implements CandidatureService {

    @Inject
    @RestClient
    CandidatureHRService candidatureHRService;

    //Verifie si on envoi ou pas les cv
    @Override
    public Collection<CvDTO> sendCandidatAccepted() {
        if(candidatureHRService.getCv().size() == 0){
            return Collections.emptyList();
        }
        return chooseCV();
    }



    //Selectionner les Cv retenu
    public Collection<CvDTO> chooseCV(){
        Collection<CvDTO> candidatures = new LinkedList<>();

        for (CvDTO cv : candidatureHRService.getCv()) {
            if(cv.getLocalisation().equals("Paris")){
                if(18 < cv.getAge() && (cv.getAge() < 26 || cv.getAge() > 55))
                    candidatures.add(new CvDTO(cv.getFirstName(), cv.getLastName(), cv.getLocalisation(), cv.getAge(),cv.getContractType(), cv.getWeeklyHours(), cv.getEmail() ));
            }
        }
        return candidatures;
    }

}
