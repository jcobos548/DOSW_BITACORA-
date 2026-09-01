package dosw.semana_4.patrones;

public class Ejercicio5 {

    public static void main(String[] args) {

        BankFacade bankFacade = new BankFacade();

        System.out.println("Procesando pago...");
        bankFacade.procesarPago(150.50);
    }
}
