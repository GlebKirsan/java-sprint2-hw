package report.month;

public class MonthReportEntry {
    private final String itemName;
    private final boolean isExpense;
    private final int quantity;
    private final long sumOfOne;


    public MonthReportEntry(String itemName, boolean isExpense, int quantity, long sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getSumOfOne() {
        return sumOfOne;
    }
}
