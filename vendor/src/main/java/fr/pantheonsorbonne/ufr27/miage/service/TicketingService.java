package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.NoSuchTicketException;

import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.ExpiredTransitionalTicketException;

import fr.pantheonsorbonne.ufr27.miage.model.Ticket;

public interface TicketingService {


    void cleanUpTransitionalTicket(int transitionalTicketId);

    boolean validateTicket(Ticket t);
}
