package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class NationalStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "nationalstock", fetch = FetchType.EAGER)
    private Set<NationalProduct> nationalProducts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<NationalProduct> getNationalProducts() {
        return nationalProducts;
    }

    public void setNationalProducts(Set<NationalProduct> nationalProducts) {
        this.nationalProducts = nationalProducts;
    }

}