public class AdapterPatternTest {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of Rs." + amount + " processed through PayPal.");
        }
    }

    static class StripeGateway {
        public void pay(double amount) {
            System.out.println("Payment of Rs." + amount + " processed through Stripe.");
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal;

        public PayPalAdapter(PayPalGateway paypal) {
            this.paypal = paypal;
        }

        public void processPayment(double amount) {
            paypal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.pay(amount);
        }
    }

    public static void main(String[] args) {

        PaymentProcessor paypalProcessor =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripeProcessor =
                new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(1000);
        stripeProcessor.processPayment(2000);
    }
}