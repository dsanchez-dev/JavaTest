package com.platzi.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup() {
        //La finalidad de este método es inicializar los objetos que se van a utilizar en los tests
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {
        //partes de un test:  Preparación de los objetos, ejecución del método, verificación del resultado
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        assertTrue( paymentProcessor.makePaymente(1000));
    }

    @Test
    public void payment_is_wrong() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse( paymentProcessor.makePaymente(1000));
    }
}