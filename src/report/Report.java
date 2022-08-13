package report;

public abstract class Report {

    private final ReportType reportType;

    protected Report(ReportType reportType) {
        this.reportType = reportType;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public abstract long getTotalIncome();
    public abstract long getTotalExpenses();
    public abstract int getYear();
}
