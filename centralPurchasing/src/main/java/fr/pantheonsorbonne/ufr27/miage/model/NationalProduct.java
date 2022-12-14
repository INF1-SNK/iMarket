package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class NationalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price")
    private Double price;

    @Size(max = 50)
    @Column(name = "type", length = 50)
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quantity_id")
    private Quantity quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationalstock_id")
    private NationalStock nationalstock;

    public NationalStock getNationalstock() {
        return nationalstock;
    }

    public void setNationalstock(NationalStock nationalstock) {
        this.nationalstock = nationalstock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

}