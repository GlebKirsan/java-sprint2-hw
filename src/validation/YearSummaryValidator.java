package validation;

import report.Month;
import report.ReportsSingleton;
import report.YearSummary;
import report.month.MonthlyReport;
import report.year.YearReportEntry;

import java.util.HashMap;
import java.util.Map;

public class YearSummaryValidator {
    public void validate() {
        ReportsSingleton reportsSingleton = ReportsSingleton.getInstance();
        if (reportsSingleton.getAllReports().isEmpty()) {
            System.out.println("Отчёты не загружены.");
        }
        reportsSingleton.getAllReports().forEach(this::validate);
    }

    public void validate(YearSummary yearSummary) {
        Map<Month, Long> monthToIncome = new HashMap<>();
        Map<Month, Long> monthToExpenses = new HashMap<>();

        for (Map.Entry<Month, MonthlyReport> entry : yearSummary.getMonthlyReports().entrySet()) {
            monthToIncome.put(entry.getKey(), entry.getValue().getTotalIncome());
            monthToExpenses.put(entry.getKey(), entry.getValue().getTotalExpenses());
        }

        boolean isDataOk = true;
        for (YearReportEntry entry : yearSummary.getYearlyReport().getEntries()) {
            boolean isAmountCoincide;
            if (entry.isExpense()) {
                isAmountCoincide = entry.getAmount() == monthToExpenses.get(entry.getMonth());
            } else {
                isAmountCoincide = entry.getAmount() == monthToIncome.get(entry.getMonth());
            }
            isDataOk = isDataOk && isAmountCoincide;
            if (!isAmountCoincide) {
                System.out.println("В месяце " + entry.getMonth() + " обнаружено несоотвествие");
            }
        }

        if (isDataOk) {
            System.out.println("Сверка данных прошла успешно.");
        }
    }
}
