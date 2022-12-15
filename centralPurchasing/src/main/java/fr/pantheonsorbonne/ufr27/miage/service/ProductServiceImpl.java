package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CommandDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.NationalProductDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.CommandDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Command;
import fr.pantheonsorbonne.ufr27.miage.model.NationalProduct;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.HashSet;

@ApplicationScoped
public class ProductServiceImpl implements ProductService{

    @Inject
    CommandDAO commandDAO;
    @Inject
    NationalProductDAO npDAO;

    @Override
    public CommandDTO createCommand(ProductDTO productDTO) {
        Command c = new Command();
        c.setDate(LocalDate.now());
        NationalProduct np = npDAO.findByName(productDTO.getName());
        np.setName(productDTO.getName());
        np.setType(productDTO.getType());
        HashSet<NationalProduct> set = new HashSet<>();
        set.add(np);
        c.setNationalProducts(set);
        commandDAO.createCommand(c);

        return new CommandDTO(productDTO, 1000);
    }
}
