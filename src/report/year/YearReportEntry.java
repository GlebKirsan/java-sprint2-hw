package report.year;

import report.Month;

public class YearReportEntry {
    private final Month month;
    private final int amount;
    private final boolean isExpense;

    public YearReportEntry(int month, int amount, boolean isExpense) {
        this.month = Month.getByNumber(month);
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public Month getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isExpense() {
        return isExpense;
    }
}
