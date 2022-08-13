package report;

import java.util.*;


public class ReportsSingleton {

    private static ReportsSingleton reportsSingleton;
    private final Map<Integer, YearSummary> reports = new HashMap<>();

    private ReportsSingleton() {}

    public static ReportsSingleton getInstance() {
        if (reportsSingleton == null) {
            reportsSingleton = new ReportsSingleton();
        }
        return reportsSingleton;
    }

    public void add(List<Report> reports) {
        reports.forEach(this::add);
    }

    public void add(Report report) {
        boolean isYearMissing = !reports.containsKey(report.getYear());
        if (isYearMissing) {
            reports.put(report.getYear(), new YearSummary(report.getYear()));
        }
        reports.get(report.getYear()).add(report);
    }

    public List<YearSummary> getAllReports() {
        return new ArrayList<>(reports.values());
    }
}
