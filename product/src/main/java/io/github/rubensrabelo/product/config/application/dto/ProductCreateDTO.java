package io.github.rubensrabelo.product.config.application.dto;

public class ProductCreateDTO {

    private String name;
    private double unitValue;
    private int quantity;

    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String name, double unitValue, int quantity) {
        this.name = name;
        this.unitValue = unitValue;
        this.quantity = quantity;
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
}
