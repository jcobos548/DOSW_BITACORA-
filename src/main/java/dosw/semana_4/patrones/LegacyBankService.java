package dosw.semana_4.patrones;

public class LegacyBankService {

    public void initializeConnection() {
        System.out.println("1. Inicializando conexión con el banco...");
    }

    public void initializeSession() {
        System.out.println("2. Inicializando sesión...");
    }

    public void initializeContext() {
        System.out.println("3. Inicializando contexto...");
    }

    public void verifyAccount(String account) {
        System.out.println("4. Verificando cuenta: " + account);
    }

    public void verifyBalance(String account, int cents) {
        System.out.println("5. Verificando saldo...");
    }

    public void prepareTransaction() {
        System.out.println("6. Preparando transacción...");
    }

    public void executeTransaction(String account, int cents) {
        System.out.println(
                "7. Ejecutando transacción de " + cents +
                        " centavos en la cuenta " + account
        );
    }

    public void closeSession() {
        System.out.println("8. Cerrando sesión...");
    }
}