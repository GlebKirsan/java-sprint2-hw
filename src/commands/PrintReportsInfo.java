package commands;

import printer.ReportPrinter;
import printer.console.ConsoleReportPrinterFabric;
import report.ReportType;
import report.ReportsSingleton;
import report.YearSummary;

import java.util.List;


public class PrintReportsInfo extends Command {

    private final ReportPrinter reportPrinter;

    public PrintReportsInfo(int order, String text, ReportType reportType) {
        super(order, text);
        this.reportPrinter = ConsoleReportPrinterFabric.getPrinter(reportType);
    }

    @Override
    public void execute() {
        List<YearSummary> reports = ReportsSingleton.getInstance().getAllReports();
        reportPrinter.printReportsInfo(reports);
    }

}
