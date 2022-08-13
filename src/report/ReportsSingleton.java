package report;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ReportsSingleton {

    private static ReportsSingleton reportsSingleton;
    private final Map<Integer, List<Report>> reports = new HashMap<>();

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
            reports.put(report.getYear(), new ArrayList<>());
        }
        reports.get(report.getYear()).add(report);
    }

    public List<Report> getAllReports() {
        return reports.values().stream().flatMap(List::stream).collect(toList());
    }
}
