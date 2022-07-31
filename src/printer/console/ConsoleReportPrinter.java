package printer.console;

import printer.ReportPrinter;
import printer.console.unitprinter.ReportPrinterForUnit;
import report.Report;

import java.util.List;

public class ConsoleReportPrinter implements ReportPrinter {

    private final ReportPrinterForUnit<? extends Report> printer;

    public ConsoleReportPrinter(ReportPrinterForUnit<? extends Report> printer) {
        this.printer = printer;
    }

    @Override
    public void printReportsInfo(List<Report> reports) {
        reports.forEach(printer::print);
    }
}
