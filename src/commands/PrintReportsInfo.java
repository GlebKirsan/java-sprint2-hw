package commands;

import printer.ReportPrinter;
import printer.console.ConsoleReportPrinterFabric;
import report.Report;
import report.ReportType;
import report.ReportsSingleton;

import java.util.List;


public class PrintReportsInfo extends Command {

    private final ReportPrinter reportPrinter;

    public PrintReportsInfo(int order, String text, ReportType reportType) {
        super(order, text);
        this.reportPrinter = ConsoleReportPrinterFabric.getPrinter(reportType);
    }

    @Override
    public void execute() {
        List<Report> reports = ReportsSingleton.getInstance().getAllReports();
        reportPrinter.printReportsInfo(reports);
    }

}
