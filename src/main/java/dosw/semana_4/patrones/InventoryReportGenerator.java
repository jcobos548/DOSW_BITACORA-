package dosw.semana_4.patrones;

public class InventoryReportGenerator extends ReportGenerator {

    @Override
    protected void generateHeader() {
        System.out.println("=== REPORTE DE INVENTARIO ===");
    }

    @Override
    protected void generateBody() {
        System.out.println("Productos disponibles: 320");
        System.out.println("Productos agotados: 15");
    }

    @Override
    protected void generateFooter() {
        System.out.println("Fin del reporte de inventario.");
    }
}
