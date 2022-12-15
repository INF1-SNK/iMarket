package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.CommandException;

public interface ProductService {
    ProductDTO sendProductInformation(ProductDTO productDTO);
    CommandDTO sendCommand(CommandDTO commandDTO) throws CommandException;
}
