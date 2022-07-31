package report.month;

import report.Month;
import report.Report;
import report.ReportType;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReport extends Report {

    private int year;
    private Month month;
    private final List<MonthReportEntry> entries = new ArrayList<>();
    private long totalIncome;
    private long totalExpenses;

    public MonthlyReport() {
        super(ReportType.MONTH);
    }

    public void add(MonthReportEntry entry) {
        long price = (long) entry.getQuantity() * entry.getSumOfOne();
        if (entry.isExpense()) {
            totalExpenses += price;
        } else {
            totalIncome += price;
        }
        entries.add(entry);
    }

    public List<MonthReportEntry> getEntries() {
        return entries;
    }

    @Override
    public long getTotalIncome() {
        return totalIncome;
    }

    @Override
    public long getTotalExpenses() {
        return totalExpenses;
    }

    public void setMonth(int month) {
        this.month = Month.getByNumber(month);
    }

    @Override
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }
}
