package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.CommandException;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    private final int vendorType = new Random().nextInt(2);
    private Double pricing;

    @Override
    public ProductDTO sendProductInformation(ProductDTO productDTO) {
        pricing = new Random().nextDouble()*10.0;
        switch (vendorType) {
            case 0:
                if (productDTO.getType().equals("meat")) {
                    return new ProductDTO("beef", "meat", pricing);
                }
            case 1:
                if (productDTO.getType().equals("fruit")) {
                    return new ProductDTO("avocado", "fruit", pricing);
                }
            case 2:
                if (productDTO.getType().equals("vegetable")) {
                    return new ProductDTO("cucumber", "vegetable", pricing);
                }
            default:
                return null;
        }
    }

    @Override
    public CommandDTO sendCommand(CommandDTO commandDTO) throws CommandException {
        switch (vendorType) {
            case 0:
                ProductDTO p = new ProductDTO("beef", "meat", pricing);
                return new CommandDTO(p, 1000);
            case 1:
                ProductDTO p1 = new ProductDTO("avocado", "fruit", pricing);
                return new CommandDTO(p1, 1000);
            case 2:
                ProductDTO p2 = new ProductDTO("cucumber", "vegetable", pricing);
                return new CommandDTO(p2, 1000);
        }
        throw new CommandException();
    }
}
