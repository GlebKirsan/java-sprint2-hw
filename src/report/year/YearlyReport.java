package report.year;

import report.Report;
import report.ReportType;

import java.util.ArrayList;
import java.util.List;

public class YearlyReport extends Report {

    private int year;
    private List<YearReportEntry> entries = new ArrayList<>();
    private long totalIncome;
    private long totalExpenses;

    public YearlyReport() {
        super(ReportType.YEAR);
    }

    @Override
    public long getTotalIncome() {
        return totalIncome;
    }

    @Override
    public long getTotalExpenses() {
        return totalExpenses;
    }

    public void add(YearReportEntry entry) {
        if (entry.isExpense()) {
            totalExpenses += entry.getAmount();
        } else {
            totalIncome += entry.getAmount();
        }
        entries.add(entry);
    }

    public List<YearReportEntry> getEntries() {
        return entries;
    }

    @Override
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
