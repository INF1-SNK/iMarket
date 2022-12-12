package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProductServiceImpl implements ProductService{

    private final int vendorType = new Random().nextInt(2);
    private double pricing;

    @Override
    public ProductDTO sendProductInformation(ProductDTO productDTO) {
        pricing = new Random().nextDouble(10.0);
        switch (vendorType){
            case 0:
                if (productDTO.getType().equals("meat")) {
                    return new ProductDTO("beef", "meat", pricing);
                }
            case 1:
                if (productDTO.getType().equals("fruit")){
                    return new ProductDTO("avocado", "fruit", pricing);
                }
            case 2:
                if (productDTO.getType().equals("vegetable")){
                    return new ProductDTO("cucumber", "vegetable", pricing);
                }
            default:
                return null;
        }
    }

    @Override
    public CommandDTO sendCommand(CommandDTO commandDTO) {
        switch (vendorType){
            case 0:
                return new CommandDTO(new HashMap<>().put(new ProductDTO("beef", "meat",pricing),1000));
            case 1:
                return new CommandDTO(new HashMap<>().put(new ProductDTO("avocado", "fruit",pricing),1000));
            case 2:
                return new CommandDTO(new HashMap<>().put(new ProductDTO("cucumber", "vegetable",pricing),1000));

    }
}
