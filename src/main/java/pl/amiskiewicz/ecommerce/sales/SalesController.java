package pl.amiskiewicz.ecommerce.sales;


import org.springframework.web.bind.annotation.*;
import pl.amiskiewicz.ecommerce.sales.offering.Offer;
import pl.amiskiewicz.ecommerce.sales.reservation.AcceptOfferRequest;
import pl.amiskiewicz.ecommerce.sales.reservation.ReservationDetails;

@RestController
public class SalesController {
    SalesFacade salesFacade;

    public SalesController(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer() {
        String customerId = getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);
    }

    @PostMapping("/api/add-to-cart/{productId}")
    void addToCart(@PathVariable(name = "productId") String productId) {
        String customerId = getCurrentCustomerId();
        salesFacade.addProduct(customerId, productId);
    }

    @PostMapping("/api/accept-offer")
    ReservationDetails acceptOffer(AcceptOfferRequest acceptOfferRequest) {
        String customerId = getCurrentCustomerId();
        return salesFacade.acceptOffer(customerId, acceptOfferRequest);
    }

    private String getCurrentCustomerId() {
        return "Amanda";
    }
}