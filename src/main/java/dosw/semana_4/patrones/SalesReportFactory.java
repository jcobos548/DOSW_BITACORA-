package dosw.semana_4.patrones;

public class SalesReportFactory implements ReportFactory {

    @Override
    public ReportGenerator createReport() {
        return new SalesReportGenerator();
    }
}