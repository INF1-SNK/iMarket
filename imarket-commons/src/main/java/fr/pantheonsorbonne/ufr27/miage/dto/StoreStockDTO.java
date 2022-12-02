package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Map;
import java.util.Objects;


public class StoreStockDTO {
<<<<<<< HEAD
    private  Integer storeNum;
    private  Map<String, Integer> products;
=======
    private final Integer storeNum;
    private final Map<String, Integer> products;
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2

    public StoreStockDTO(Integer storeNum,  Map<String, Integer> products) {
        this.storeNum = storeNum;
        this.products = products;
    }

<<<<<<< HEAD
    public StoreStockDTO() {
    }
=======
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2

    public Integer getStoreNum() {
        return storeNum;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreStockDTO entity = (StoreStockDTO) o;
        return Objects.equals(this.storeNum, entity.storeNum) &&
                Objects.equals(this.products, entity.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeNum, products);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "storeNum = " + storeNum + ", " +
                "products = " + products + ")";
    }
}