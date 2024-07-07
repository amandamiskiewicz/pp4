package pl.amiskiewicz.ecommerce.sales.offering;


import pl.amiskiewicz.ecommerce.catalog.ProductCatalog;
import pl.amiskiewicz.ecommerce.sales.cart.CartItem;
import pl.amiskiewicz.ecommerce.sales.offering.Offer;
import java.math.BigDecimal;
import java.util.List;

public class OfferCalculator {

    public Offer calculate(List<CartItem> lines) {
        BigDecimal basePrice = BigDecimal.valueOf(20);
        BigDecimal totalPrice = basePrice.multiply(new BigDecimal(lines.size()));
        BigDecimal threshold = BigDecimal.valueOf(50);
        BigDecimal discount50 = BigDecimal.valueOf(10);

        int productCount = lines.size();
        BigDecimal discount = BigDecimal.ZERO;


        if (productCount%3==0 && productCount != 0){
            productCount++;
        }
        if(totalPrice.compareTo(threshold) >= 0){
            totalPrice = totalPrice.subtract(discount50);
        }

        BigDecimal finalPrice = totalPrice.subtract(discount);

        return new Offer(finalPrice, productCount);

    }
}
