package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToMany
    @JoinTable(name = "Product_Command",
            joinColumns = @JoinColumn(name = "command_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<fr.pantheonsorbonne.ufr27.miage.model.NationalProduct> nationalProducts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<fr.pantheonsorbonne.ufr27.miage.model.NationalProduct> getNationalProducts() {
        return nationalProducts;
    }

    public void setNationalProducts(Set<fr.pantheonsorbonne.ufr27.miage.model.NationalProduct> nationalProducts) {
        this.nationalProducts = nationalProducts;
    }

}