package printer.console.unitprinter;

import report.Report;
import report.ReportType;
import report.month.MonthReportEntry;
import report.month.MonthlyReport;

public class MonthReportPrinter implements ReportPrinterForUnit {
    @Override
    public ReportType getUnit() {
        return ReportType.MONTH;
    }

    @Override
    public void print(Report report) {
        MonthlyReport monthlyReport = (MonthlyReport) report;
        System.out.println("Месяц " + monthlyReport.getMonth().getName());
        printMostProfitableProduct(monthlyReport);
        printMostExpensiveProduct(monthlyReport);
    }

    private static void printMostProfitableProduct(MonthlyReport report) {
        var mostProfitableProduct = new MonthReportEntry("dummy", true, 0, 0);

        for (var entry : report.getEntries()) {
            long profitablePrice = mostProfitableProduct.getQuantity() * mostProfitableProduct.getSumOfOne();
            long currentPrice = entry.getSumOfOne() * entry.getQuantity();
            boolean isProfitable = !entry.isExpense() && currentPrice > profitablePrice;
            if (isProfitable) {
                mostProfitableProduct = entry;
            }
        }

        System.out.println("Самый прибыльный товар: " + mostProfitableProduct.getItemName() +
                ", сумма за единицу " + mostProfitableProduct.getSumOfOne());
    }

    private void printMostExpensiveProduct(MonthlyReport report) {
        var mostExpensiveProduct = new MonthReportEntry("dummy", false, 0, 0);

        for (var entry : report.getEntries()) {
            long profitablePrice = mostExpensiveProduct.getQuantity() * mostExpensiveProduct.getSumOfOne();
            long currentPrice = entry.getSumOfOne() * entry.getQuantity();
            boolean isExpensive = entry.isExpense() && currentPrice > profitablePrice;
            if (isExpensive) {
                mostExpensiveProduct = entry;
            }
        }

        System.out.println("Самый затратный товар: " + mostExpensiveProduct.getItemName() +
                ", сумма за единицу " + mostExpensiveProduct.getSumOfOne());
    }
}
