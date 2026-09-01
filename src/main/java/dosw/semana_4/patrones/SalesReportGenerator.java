package dosw.semana_4.patrones;

public class SalesReportGenerator extends ReportGenerator {

    @Override
    protected void generateHeader() {
        System.out.println("=== REPORTE DE VENTAS ===");
    }

    @Override
    protected void generateBody() {
        System.out.println("Ventas totales: $5.000.000");
        System.out.println("Número de ventas: 150");
    }

    @Override
    protected void generateFooter() {
        System.out.println("Fin del reporte de ventas.");
    }
}