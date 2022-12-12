package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;

import java.util.Map;

public interface ProductService {
    ProductDTO sendProductInformation(ProductDTO productDTO);
    CommandDTO sendCommand(CommandDTO commandDTO);
}
