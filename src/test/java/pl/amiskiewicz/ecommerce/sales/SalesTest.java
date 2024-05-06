package pl.amiskiewicz.ecommerce.sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.UUID;

public class SalesTest {
    @Test
    void itAddProductToCart(){
        SalesFacade sales = thereIsSalesFacade();

    }

    @Test
    void itShowsCurrentOffer(){
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsCustomer("Amanda");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0,offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private String thereIsCustomer(String name) {
        return name;
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }

    @Test
    void itRemoveProductFromCart(){

    }

    @Test
    void itAllowToAcceptOffer(){

    }

    @Test
    void itAllowToPayForReservation(){

    }
}
