package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio5 {

    static class Transaction {
        private String id;
        private double amount;
        private boolean approved;

        public Transaction(String id, double amount, boolean approved) {
            this.id = id;
            this.amount = amount;
            this.approved = approved;
        }

        public boolean isApproved() {
            return approved;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id='" + id + '\'' +
                    ", amount=" + amount +
                    ", approved=" + approved +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("T001", 150.0, true),
                new Transaction("T002", 300.0, true),
                new Transaction("T003", 75.0, false),
                new Transaction("T004", 500.0, true)
        );

        boolean hasNotApproved = transactions.stream()
                .peek(transaction -> System.out.println(
                        "Procesando: " + transaction))
                .anyMatch(transaction -> !transaction.isApproved());

        boolean valid = !hasNotApproved;

        System.out.println("¿Lote válido? " + valid);
    }
}