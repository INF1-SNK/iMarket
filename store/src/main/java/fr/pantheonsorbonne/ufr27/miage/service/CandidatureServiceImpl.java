package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.resources.CandidatureRessource;

import javax.inject.Inject;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CandidatureServiceImpl implements CandidatureService {

    @Inject
    CandidatureRessource candidatureRessource;

    //Verifie si on envoi ou pas les cv
    @Override
    public Collection<CvDTO> sendCandidatAccepted() {
        Collection<CvDTO> candidatures = new LinkedList<>();

        if(candidatureRessource.getCv().size() == 0){
            return null;
        }
        return chooseCV();
    }



    //Selectionner les Cv retenu
    public Collection<CvDTO> chooseCV(){
        Collection<CvDTO> candidatures = new LinkedList<>();

        for (CvDTO cv : candidatureRessource.getCv()) {
            if(cv.getLocalisation().equals("PARIS")){
                if(18 < cv.getAge() && (cv.getAge() < 26 || cv.getAge() > 55))
                    candidatures.add(new CvDTO(cv.getFirstName(), cv.getLastName(), cv.getLocalisation(), cv.getAge(),cv.getContractType(), cv.getWeeklyHours(), cv.getEmail() ));
            }
        }
        return candidatures;
    }

}
