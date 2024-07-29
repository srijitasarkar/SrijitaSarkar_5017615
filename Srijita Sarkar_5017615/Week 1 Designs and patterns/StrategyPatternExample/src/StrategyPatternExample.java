
interface PaymentStrategy {
    void pay(int amount);
}
class CreditCardPayment implements PaymentStrategy {

    public CreditCardPayment() {
    }


    public void pay(int amount) {
        System.out.println(amount + " paid via credit card.");
    }
}
class PayPalPayment implements PaymentStrategy {

    public PayPalPayment() {
    }


    public void pay(int amount) {
        System.out.println(amount + " paid via PayPal.");
    }
}
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}
class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with credit card
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        context.setPaymentStrategy(creditCardPayment);
        context.pay(100);

        // Paying with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment();
        context.setPaymentStrategy(payPalPayment);
        context.pay(9000);
    }
}