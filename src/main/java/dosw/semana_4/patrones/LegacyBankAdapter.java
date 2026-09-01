package dosw.semana_4.patrones;

public class LegacyBankAdapter implements PaymentProcessor {

    private final LegacyBankService legacy;
    private final String account;

    public LegacyBankAdapter(LegacyBankService legacy, String account) {
        this.legacy = legacy;
        this.account = account;
    }

    @Override
    public void pay(double amount) {
        int cents = (int) (amount * 100);

        legacy.verifyBalance(account, cents);
        legacy.executeTransaction(account, cents);
    }
}