package pl.amiskiewicz.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PayuTest {
    @Test
    void creatingNewPayment(){
        PayU payu = thereIsPayu();
        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(orderCreateRequest);

        assertNotNull(response.getRedirectUri()); //where to redirect customer
        assertNotNull(response.getOrderId()); //transaction id
    }

    private OrderCreateRequest createExampleOrderCreateRequest(){
        var createRequest = new OrderCreateRequest();
        createRequest
                .setNotifyUrl("https://my.example.shop.amis.pl/api/order")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("My ebook")
                .setCurrencyCode("PLN")
                .setTotalAmount(21000)
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer((new Buyer())
                        .setEmail("john.doe@example.com")
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("ProductX")
                                .setQuantity(1)
                                .setUnitPrice(21000)
                ));
        return createRequest;
    }
    private PayU thereIsPayu() {
        return new PayU(
                new RestTemplate(),
                PayUCredentials.sandbox(
                        "300746",
                        "2ee86a66e5d97e3fadc400c9f19b065d"
                ));
    }
}
