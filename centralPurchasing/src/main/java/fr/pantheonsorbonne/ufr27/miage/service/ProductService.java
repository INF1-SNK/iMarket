package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    CommandDTO createCommand(ProductDTO productDTO);
}
