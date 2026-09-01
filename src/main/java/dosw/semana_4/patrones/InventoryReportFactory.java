package dosw.semana_4.patrones;

public class InventoryReportFactory implements ReportFactory {

    @Override
    public ReportGenerator createReport() {
        return new InventoryReportGenerator();
    }
}
