package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Cv;

import java.util.Collection;

public interface CvDAO {
    public Cv getCV(int id);
    public Collection<Cv> getAllCv();
}
