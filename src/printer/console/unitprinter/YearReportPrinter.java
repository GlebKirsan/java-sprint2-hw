package printer.console.unitprinter;

import report.Month;
import report.year.YearReportEntry;
import report.year.YearlyReport;

import java.util.*;

public class YearReportPrinter implements ReportPrinterForUnit<YearlyReport> {

    @Override
    public void print(YearlyReport report) {
        Map<Integer, Integer> monthsProfit = new TreeMap<>();
        double meanIncome = 0;
        double meanExpenses = 0;

        for (YearReportEntry entry : report.getEntries()) {
            Integer integer = monthsProfit.getOrDefault(entry.getMonth().getNumber(), 0);
            if (entry.isExpense()) {
                meanExpenses += entry.getAmount();
                integer -= entry.getAmount();
            } else {
                meanIncome += entry.getAmount();
                integer += entry.getAmount();
            }
            monthsProfit.put(entry.getMonth().getNumber(), integer);
        }

        System.out.println("Год " + report.getYear());
        printProfitByMonth(monthsProfit);
        System.out.println("Средний расход за все месяцы в году: " + meanExpenses / Month.values().length);
        System.out.println("Средний доход за все месяцы в году: " + meanIncome / Month.values().length);
    }

    private static void printProfitByMonth(Map<Integer, Integer> monthsProfit) {
        for (Map.Entry<Integer, Integer> month : monthsProfit.entrySet()) {
            String monthName = Month.getByNumber(month.getKey() + 1).getName();
            System.out.print("Прибыль за " + monthName + ": " + month.getValue() + '\n');
        }
    }
}
