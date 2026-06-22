public class StrategyPatternTest {

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {

        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using Credit Card");
        }
    }

    static class PayPalPayment implements PaymentStrategy {

        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using PayPal");
        }
    }

    static class PaymentContext {

        private PaymentStrategy strategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(double amount) {
            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(5000);

        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(2500);
    }
}