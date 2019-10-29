import ReportingSystem.CuttingReport;
import ReportingSystem.InvoiceReport;
import ReportingSystem.ReportSystem;

public class ToyBlockFactoryApplication {
    public static void main(String[] args) {
//        ReportSystem cuttingReport = new CuttingReport();
//        cuttingReport.displayOutputToTerminal();
        ReportSystem invoiceReport = new InvoiceReport();
        invoiceReport.displayOutputToTerminal();
    }
}
