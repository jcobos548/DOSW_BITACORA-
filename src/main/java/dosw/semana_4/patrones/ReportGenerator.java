package dosw.semana_4.patrones;

public abstract class ReportGenerator {

    public final void generateReport() {
        generateHeader();
        generateBody();
        generateFooter();
    }

    protected abstract void generateHeader();

    protected abstract void generateBody();

    protected abstract void generateFooter();
}
