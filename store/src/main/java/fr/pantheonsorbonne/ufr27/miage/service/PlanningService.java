package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.PlanningDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.PlanningNotFoundException;

public interface PlanningService {

    PlanningDTO getPlanningById(int id);

    PlanningDTO getLastPlanning();
}
