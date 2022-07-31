package commands;

import printer.ReportPrinter;
import printer.console.ConsoleReportPrinterFabric;
import report.Report;
import report.ReportType;
import report.ReportsSingleton;

import java.util.List;


public class PrintReportsInfo extends Command {

    private final int order;
    private final String text;
    private final ReportPrinter reportPrinter;

    public PrintReportsInfo(int order, String text, ReportType reportType) {
        this.order = order;
        this.text = text;
        this.reportPrinter = ConsoleReportPrinterFabric.getPrinter(reportType);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void execute() {
        List<Report> reports = ReportsSingleton.getInstance().getAllReports();
        reportPrinter.printReportsInfo(reports);
    }

    @Override
    public int getOrder() {
        return order;
    }
}
