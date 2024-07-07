package pl.amiskiewicz.ecommerce.sales;


import pl.amiskiewicz.ecommerce.sales.cart.Cart;
import pl.amiskiewicz.ecommerce.sales.cart.HashMapCartStorage;
import pl.amiskiewicz.ecommerce.sales.offering.Offer;
import pl.amiskiewicz.ecommerce.sales.offering.OfferCalculator;

import pl.amiskiewicz.ecommerce.sales.reservation.AcceptOfferRequest;


import pl.amiskiewicz.ecommerce.sales.reservation.ReservationDetails;
import pl.amiskiewicz.ecommerce.sales.reservation.ReservationRepository;


import java.util.UUID;

public class SalesFacade {

    private HashMapCartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(HashMapCartStorage cartStorage, OfferCalculator calculator) {
        this.cartStorage = cartStorage;
        this.offerCalculator = calculator;

    }

    public SalesFacade() {

    }

    public void addProduct(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);
        cart.add(productId);
        cartStorage.save(customerId, cart);
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);
        return offerCalculator.calculate(cart.getCartItems());
    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetails();
    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomer(customerId)
                .orElse(Cart.empty());
    }

}