package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Map;
import java.util.Objects;


public class StoreStockDTO {
    private final Integer storeNum;
    private final Map<String, Integer> products;

    public StoreStockDTO(Integer storeNum,  Map<String, Integer> products) {
        this.storeNum = storeNum;
        this.products = products;
    }


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