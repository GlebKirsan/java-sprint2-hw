package reader;

import report.ReportType;

public class NoReportReaderException extends RuntimeException {

    public NoReportReaderException(ReportType reportType) {
        super("ReportReader для " + reportType + " не реализован.");
    }
}
