package io.github.rubensrabelo.product.application.dto;

import java.util.Objects;

public class ProductResponseDTO {

    private int id;
    private String name;
    private double unitValue;
    private int quantity;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(int id, String name, double unitValue, int quantity) {
        this.id = id;
        this.name = name;
        this.unitValue = unitValue;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductResponseDTO product = (ProductResponseDTO) o;
        return id == product.id && Double.compare(unitValue, product.unitValue) == 0 && quantity == product.quantity && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unitValue, quantity);
    }
}
