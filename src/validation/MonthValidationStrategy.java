package validation;

import report.Report;
import report.ReportType;
import report.ReportsSingleton;

public class MonthValidationStrategy implements Strategy {
    @Override
    public boolean isTruthy() {
        final var reports = ReportsSingleton.getInstance();
        for (Report report : reports.getAllReports()) {
            boolean isMonthReport =  report.getReportType() == ReportType.MONTH;
            boolean hasEqualExpensesAndIncome = isMonthReport && report.getTotalExpenses() != report.getTotalIncome();
            if (hasEqualExpensesAndIncome) {
                System.out.println("Обнаружено несоотвествие доходов и расходов. Месяц: ");
                return false;
            }
        }
        return true;
    }
}
