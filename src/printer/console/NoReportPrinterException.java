package printer.console;

import report.ReportType;

public class NoReportPrinterException extends RuntimeException {
    public NoReportPrinterException(ReportType reportType) {
        super("ReportPrinter для " + reportType + " не реализован.");
    }
}

