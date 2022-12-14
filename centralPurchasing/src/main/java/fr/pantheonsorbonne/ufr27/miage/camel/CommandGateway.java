package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import fr.pantheonsorbonne.ufr27.miage.service.StockService;
import org.apache.camel.CamelContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CommandGateway {

    @Inject
    StockService stockService;



    public void updateStocks(CommandDTO commandDTO) {

            stockService.sendFromVendor(commandDTO.getProductDTO(), commandDTO.getQuantity());

    }
}