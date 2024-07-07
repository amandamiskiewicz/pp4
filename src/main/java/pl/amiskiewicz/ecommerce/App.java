package pl.amiskiewicz.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.amiskiewicz.ecommerce.catalog.ArrayListProductStorage;
import pl.amiskiewicz.ecommerce.catalog.ProductCatalog;
import pl.amiskiewicz.ecommerce.sales.cart.HashMapCartStorage;
import pl.amiskiewicz.ecommerce.sales.offering.OfferCalculator;
import pl.amiskiewicz.ecommerce.sales.SalesFacade;
import pl.amiskiewicz.ecommerce.sales.payment.PayUPayment;
import pl.amiskiewicz.ecommerce.sales.reservation.ReservationRepository;

import java.math.BigDecimal;


@SpringBootApplication
public class App {
    public static void main(String[] args){
        System.out.println("Here we go!");

        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("kotek 1", "nice one", BigDecimal.valueOf(10));
        productCatalog.addProduct("kotek 2", "nice one", BigDecimal.valueOf(20));
        productCatalog.addProduct("kotek 3", "nice one", BigDecimal.valueOf(30));

        return productCatalog;
    }

    @Bean
    SalesFacade createMySalesFacade(){
        return new SalesFacade();
    }
}