package com.platzi.javatests.payments;

public class PaymenteResponse {

    enum PaymentStatus {
        OK, ERROR
    }

    private PaymentStatus status;

    public PaymenteResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
