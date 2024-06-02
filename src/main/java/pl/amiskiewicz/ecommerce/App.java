package pl.amiskiewicz.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.amiskiewicz.ecommerce.catalog.ArrayListProductStorage;
import pl.amiskiewicz.ecommerce.catalog.ProductCatalog;
import pl.amiskiewicz.ecommerce.sales.SalesFacade;

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
        productCatalog.addProduct("kicia 1", "nice one", BigDecimal.valueOf(10));
        productCatalog.addProduct("kicia 2", "nice one", BigDecimal.valueOf(20));
        productCatalog.addProduct("kicia 3", "nice one", BigDecimal.valueOf(30));

        return productCatalog;
    }

    @Bean
    SalesFacade createMySalesFacade(){
        return new SalesFacade();
    }
}
