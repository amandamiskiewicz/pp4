package pl.amiskiewicz.ecommerce.sales.reservation;

import java.math.BigDecimal;

public class ReservationDetails {
    private String reservationId;
    private String paymentUrl;

    public ReservationDetails(String reservationId, String paymentUrl) {
        this.reservationId = reservationId;
        this.paymentUrl = paymentUrl;
    }

    public ReservationDetails() {
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public String getReservationId() {
        return reservationId;
    }
}