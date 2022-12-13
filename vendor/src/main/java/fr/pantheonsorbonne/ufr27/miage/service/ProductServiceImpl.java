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
                Map<ProductDTO, Integer> map = new HashMap<>();
                map.put(new ProductDTO("beef", "meat", pricing), 1000);
                return new CommandDTO(map);
            case 1:
                Map<ProductDTO, Integer> map1 = new HashMap<>();
                map1.put(new ProductDTO("avocado", "fruit", pricing), 1000);
                return new CommandDTO(map1);
            case 2:
                Map<ProductDTO, Integer> map2 = new HashMap<>();
                map2.put(new ProductDTO("cucumber", "vegetable", pricing), 1000);
                return new CommandDTO(map2);
        }
        throw new CommandException();
    }
}
