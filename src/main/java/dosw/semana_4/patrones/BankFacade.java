package dosw.semana_4.patrones;

public class BankFacade {

    private final LegacyBankService legacy;
    private final PaymentProcessor adapter;

    public BankFacade() {
        legacy = new LegacyBankService();
        adapter = new LegacyBankAdapter(legacy, "ACC-001");
    }

    public void procesarPago(double monto) {

        legacy.initializeConnection();
        legacy.initializeSession();
        legacy.initializeContext();
        legacy.verifyAccount("ACC-001");
        legacy.prepareTransaction();

        adapter.pay(monto);

        legacy.closeSession();
    }
}
