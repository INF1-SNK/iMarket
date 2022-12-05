package fr.pantheonsorbonne.ufr27.miage.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StorestockProductId implements Serializable {
    private static final long serialVersionUID = -2410685867410799581L;
    @NotNull
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @NotNull
    @Column(name = "storestock_id", nullable = false)
    private Integer storestockId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStorestockId() {
        return storestockId;
    }

    public void setStorestockId(Integer storestockId) {
        this.storestockId = storestockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StorestockProductId entity = (StorestockProductId) o;
        return Objects.equals(this.storestockId, entity.storestockId) &&
                Objects.equals(this.productId, entity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storestockId, productId);
    }

}