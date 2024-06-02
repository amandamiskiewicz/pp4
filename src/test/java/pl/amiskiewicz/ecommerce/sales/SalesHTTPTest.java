package pl.amiskiewicz.ecommerce.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.amiskiewicz.ecommerce.catalog.ProductCatalog;

import javax.xml.catalog.Catalog;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

public class SalesHTTPTest {
    @Autowired
    TestRestTemplate http;

    @Autowired
    ProductCatalog catalog;

    @LocalServerPort
    private int port;

    @Test
    void itAllowToAcceptOffer(){
        //ARRANGE
        String productId = thereIsExampleProduct("example product" , BigDecimal.valueOf(10.10));
        //ACT
        //add product to cart
        String addProductToCartURL = String.format("http://localhost:%s/%s/%s",
                port,
                "api/add-to-cart/",
                productId
        );
        ResponseEntity<Object> addProductResponse = http.postForEntity(
                addProductToCartURL, null, Object.class);
        //accept offer
        String acceptOfferUrl = String.format("http://localhost:%s/%s",
                port,
                "api/accept-offer/"
        );
        AcceptOfferRequest acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest.
                setFirstName("Amanda").
                setLastName("Miśkiewicz").
                setEmail("amanda@gmail.com");
        ResponseEntity<ReservationDetail> reservationDetailResponseEntity =
                http.postForEntity(acceptOfferUrl, acceptOfferRequest, ReservationDetail.class);
        //Arrange
        //-> reservationWithIdExists
        //->thereIsPaymentURLAvailable
        assertThat(reservationDetailResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(reservationDetailResponseEntity.getBody().getReservationId());
        assertNotNull(reservationDetailResponseEntity.getBody().getPaymentUrl());
        assertEquals(BigDecimal.valueOf(10.10), reservationDetailResponseEntity.getBody().getTotal());
    }

    private String thereIsExampleProduct(String name, BigDecimal price) {
        var id = catalog.addProduct(name, name,price);
        catalog.changePrice(id, price);
        return "Products";
    }


}

