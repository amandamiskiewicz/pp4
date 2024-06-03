package pl.amiskiewicz.ecommerce.payu;

import java.util.List;

public class OrderCreateRequest {

    Status status;

    String redirectUri;
    String orderId;
    String extOrderId;
    public String getRedirectUri() {
        return redirectUri;
    }

    public Status getStatus() {
        return status;
    }

    public OrderCreateRequest setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OrderCreateRequest setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderCreateRequest setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    String notifyUrl;
    String customerIp;
    String merchantPosId;
    String description;
    String currencyCode;
    Integer totalAmount;
    Buyer buyer;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderCreateRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public OrderCreateRequest setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        return this;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public OrderCreateRequest setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderCreateRequest setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public OrderCreateRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public OrderCreateRequest setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public OrderCreateRequest setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public OrderCreateRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public OrderCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    List<Product> products;

}

//{
//        "notifyUrl": "https://your.eshop.com/notify",
//        "customerIp": "127.0.0.1",
//        "merchantPosId": "145227",
//        "description": "RTV market",
//        "currencyCode": "PLN",
//        "totalAmount": "21000",
//        "extOrderId":"2uikc6gjd99b4lxc75ip4k",
//        "buyer": {
//            "email": "john.doe@example.com",
//            "phone": "654111654",
//            "firstName": "John",
//            "lastName": "Doe",
//            "language": "pl"
//        },
//        "products": [
//            {
//                "name": "Wireless Mouse for Laptop",
//                "unitPrice": "15000",
//                "quantity": "1"
//            },
//            {
//                "name": "HDMI cable",
//                "unitPrice": "6000",
//                "quantity": "1"
//            }
//        ]
//    }