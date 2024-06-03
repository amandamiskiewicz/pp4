package pl.amiskiewicz.ecommerce.payu;

public class Product {
    String name;
    Integer unitPrice;

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    Integer quantity;
}
