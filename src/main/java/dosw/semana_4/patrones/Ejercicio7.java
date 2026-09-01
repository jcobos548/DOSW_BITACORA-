package dosw.semana_4.patrones;

public class Ejercicio7 {

    public static void main(String[] args) {

        Document document =
                new Document("Contrato empresarial");

        DocumentHandler author = new AuthorHandler();
        DocumentHandler leader = new LeaderHandler();
        DocumentHandler legal = new LegalHandler();

        author.setNext(leader)
                .setNext(legal);

        System.out.println(
                "Estado inicial: " +
                        document.getState().getName()
        );

        System.out.println();

        author.handle(document);
        leader.handle(document);
        legal.handle(document);

        System.out.println();

        System.out.println(
                "Estado final: " +
                        document.getState().getName()
        );
    }
}
