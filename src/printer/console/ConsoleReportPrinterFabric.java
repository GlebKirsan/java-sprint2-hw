package printer.console;

import printer.ReportPrinter;
import printer.console.unitprinter.MonthReportPrinter;
import printer.console.unitprinter.YearReportPrinter;
import report.ReportType;

import java.util.EnumMap;

public class ConsoleReportPrinterFabric {

    private static final EnumMap<ReportType, ConsoleReportPrinter> reportPrinters = new EnumMap<>(ReportType.class);

    static {
        reportPrinters.put(ReportType.MONTH, new ConsoleReportPrinter(new MonthReportPrinter()));
        reportPrinters.put(ReportType.YEAR, new ConsoleReportPrinter(new YearReportPrinter()));
    }
    public static ReportPrinter getPrinter(ReportType reportType) {
        boolean hasReportPrinter = reportPrinters.containsKey(reportType);
        if (!hasReportPrinter) {
            throw new NoReportPrinterException(reportType);
        }
        return reportPrinters.get(reportType);
    }
}
