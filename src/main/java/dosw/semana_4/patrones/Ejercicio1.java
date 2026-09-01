package dosw.semana_4.patrones;

public class Ejercicio1 {

    // Strategy
    interface PaymentStrategy {
        void process(double amount);
    }

    static class TarjetaStrategy implements PaymentStrategy {
        @Override
        public void process(double amount) {
            System.out.println("Pago con tarjeta: $" + amount);
        }
    }

    static class PseStrategy implements PaymentStrategy {
        @Override
        public void process(double amount) {
            System.out.println("Pago con PSE: $" + amount);
        }
    }

    static class NequiStrategy implements PaymentStrategy {
        @Override
        public void process(double amount) {
            System.out.println("Pago con Nequi: $" + amount);
        }
    }

    static class PaypalStrategy implements PaymentStrategy {
        @Override
        public void process(double amount) {
            System.out.println("Pago con PayPal: $" + amount);
        }
    }

    // Factory Method
    interface PaymentFactory {
        PaymentStrategy create(String type);
    }

    static class ColombiaPaymentFactory implements PaymentFactory {

        @Override
        public PaymentStrategy create(String type) {
            return switch (type.toLowerCase()) {
                case "pse" -> new PseStrategy();
                case "nequi" -> new NequiStrategy();
                case "tarjeta" -> new TarjetaStrategy();
                default -> throw new IllegalArgumentException(
                        "Método de pago no disponible en Colombia"
                );
            };
        }
    }

    static class UsaPaymentFactory implements PaymentFactory {

        @Override
        public PaymentStrategy create(String type) {
            return switch (type.toLowerCase()) {
                case "paypal" -> new PaypalStrategy();
                case "tarjeta" -> new TarjetaStrategy();
                default -> throw new IllegalArgumentException(
                        "Método de pago no disponible en USA"
                );
            };
        }
    }

    // Checkout utiliza Strategy sin conocer la implementación concreta
    static class Checkout {

        public void pay(PaymentStrategy strategy, double amount) {
            strategy.process(amount);
        }
    }

    public static void main(String[] args) {

        Checkout checkout = new Checkout();

        // Colombia
        PaymentFactory colombiaFactory = new ColombiaPaymentFactory();
        PaymentStrategy pse = colombiaFactory.create("pse");

        checkout.pay(pse, 150000);

        PaymentStrategy nequi = colombiaFactory.create("nequi");

        checkout.pay(nequi, 80000);

        // USA
        PaymentFactory usaFactory = new UsaPaymentFactory();
        PaymentStrategy paypal = usaFactory.create("paypal");

        checkout.pay(paypal, 200);
    }
}