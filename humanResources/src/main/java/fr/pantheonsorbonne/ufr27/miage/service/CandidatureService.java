package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Cv;

import java.util.Collection;
import java.util.List;

public interface CandidatureService {

    List<CvDTO> getCandidatures();

}
