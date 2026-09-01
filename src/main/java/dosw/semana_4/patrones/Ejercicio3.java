package dosw.semana_4.patrones;

public class Ejercicio3 {

    public static void main(String[] args) {

        ReportFactory salesFactory = new SalesReportFactory();
        ReportGenerator salesReport = salesFactory.createReport();

        salesReport.generateReport();

        System.out.println();

        ReportFactory inventoryFactory = new InventoryReportFactory();
        ReportGenerator inventoryReport = inventoryFactory.createReport();

        inventoryReport.generateReport();
    }
}
