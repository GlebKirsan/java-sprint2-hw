package report;

import report.month.MonthlyReport;
import report.year.YearlyReport;

import java.util.HashMap;
import java.util.Map;

public class YearSummary {

    private final int year;

    private final Map<Month, MonthlyReport> monthlyReports = new HashMap<>();

    private YearlyReport yearlyReport = new YearlyReport();

    public YearSummary(int year) {
        this.year = year;
    }

    public Map<Month, MonthlyReport> getMonthlyReports() {
        return monthlyReports;
    }

    public YearlyReport getYearlyReport() {
        return yearlyReport;
    }

    public void add(Report report) {
        if (report.getYear() != year) {
            throw new IllegalArgumentException("Год отчёта и год совокупности отчётов не совпадают.");
        }

        switch (report.getReportType()) {
            case MONTH -> {
                var monthlyReport = (MonthlyReport) report;
                monthlyReports.put(monthlyReport.getMonth(), monthlyReport);
            }
            case YEAR -> yearlyReport = (YearlyReport) report;
        }
    }
}
