package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.service.StockService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CommandGateway {

    @Inject
    StockService stockService;



    public void updateStocks(CommandDTO commandDTO) {

            stockService.sendFromVendor(commandDTO.getProductDTO(), commandDTO.getQuantity());

    }
}