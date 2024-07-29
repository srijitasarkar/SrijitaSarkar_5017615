// PaymentProcessor.java
interface PaymentProcessor {
    void processPayment(double amount);
}

// PaypalPaymentGateway.java
class PaypalPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Payment done through PayPal: $" + amount);
    }
}

// StripePaymentGateway.java
class StripePaymentGateway {
    public void charge(double amount) {
        System.out.println("Payment done through Stripe: $" + amount);
    }
}

// PaypalAdapter.java
class PaypalAdapter implements PaymentProcessor {
    private PaypalPaymentGateway paypalGateway;

    public PaypalAdapter(PaypalPaymentGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }


    public void processPayment(double amount) {
        paypalGateway.makePayment(amount);
    }
}

// StripeAdapter.java
class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway stripeGateway;

    public StripeAdapter(StripePaymentGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }


    public void processPayment(double amount) {
        stripeGateway.charge(amount);
    }
}

// AdapterPatternTest.java
class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PaypalPaymentGateway paypalGateway = new PaypalPaymentGateway();
        StripePaymentGateway stripeGateway = new StripePaymentGateway();

        // Create adapters for each payment gateway
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Process payments using the adapters
        paypalProcessor.processPayment(3000.00);
        stripeProcessor.processPayment(2000.00);
    }
}