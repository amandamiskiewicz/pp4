package pl.amiskiewicz.ecommerce.sales.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HashMapCartStorage {
    Map<String, Cart> carts;

    public HashMapCartStorage() {
        this.carts = new HashMap<>();
    }
    public Optional<Cart> getForCustomer(String customerId) {
        return Optional.of(carts.get(customerId));
    }
    public Optional<Cart> loadForCustomer(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }
    public void save(String customerId, Cart cart) {
        carts.put(customerId, cart);
    }

    public Optional<Cart> findByCustomer(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    };
}
