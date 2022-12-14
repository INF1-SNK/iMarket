package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.NationalProduct;

import javax.transaction.Transactional;

public interface NationalProductDAO {

    NationalProduct findByName(String name);

    int checkProductQuantity(String name);

    @Transactional
    void refreshQty(String name, int qty);
}
