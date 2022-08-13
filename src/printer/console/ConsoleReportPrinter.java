package printer.console;

import printer.ReportPrinter;
import printer.console.unitprinter.ReportPrinterForUnit;
import report.YearSummary;

import java.util.List;

public class ConsoleReportPrinter implements ReportPrinter {

    private final ReportPrinterForUnit printer;

    public ConsoleReportPrinter(ReportPrinterForUnit printer) {
        this.printer = printer;
    }

    @Override
    public void printReportsInfo(List<YearSummary> reports) {
        if (reports.isEmpty()) {
            System.out.println("Отчёты не загружены.");
        }

        switch (printer.getUnit()) {
            case MONTH -> reports.forEach(summary -> summary.getMonthlyReports().values().forEach(printer::print));
            case YEAR -> reports.forEach(summary -> printer.print(summary.getYearlyReport()));
        }
    }
}
