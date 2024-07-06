package pl.amiskiewicz.ecommerce.sales;


import pl.amiskiewicz.ecommerce.sales.cart.Cart;
import pl.amiskiewicz.ecommerce.sales.cart.HashMapCartStorage;
import pl.amiskiewicz.ecommerce.sales.offering.Offer;
import pl.amiskiewicz.ecommerce.sales.offering.OfferCalculator;
import pl.amiskiewicz.ecommerce.sales.payment.PaymentGateway;
import pl.amiskiewicz.ecommerce.sales.reservation.AcceptOfferRequest;

import pl.amiskiewicz.ecommerce.sales.reservation.ReservationDetails;
import pl.amiskiewicz.ecommerce.sales.reservation.ReservationRepository;


import java.util.UUID;

public class SalesFacade {
    private HashMapCartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(HashMapCartStorage cartStorage, OfferCalculator offerCalculator,PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRepository;
    }
    public Offer getCurrentOffer(String customerId) {
        Cart cart = cartStorage.loadForCustomer(customerId).orElse(Cart.empty());

        Offer offer = offerCalculator.calculate(cart.getCartItems());

        return offer;
    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetails();
    }

    public void addToCart(String customerId, String productId) {

    }
}