package validation;

import report.Report;
import report.ReportType;
import report.ReportsSingleton;

public class YearValidationStrategy implements Strategy{
    @Override
    public boolean isTruthy() {
        final var reports = ReportsSingleton.getInstance().getAllReports();
        long monthSumIncome = 0;
        long monthSumExpenses = 0;
        long yearIncome = 0;
        long yearExpenses = 0;
        for (Report report : reports) {
            if (report.getReportType() == ReportType.MONTH) {
                monthSumIncome += report.getTotalIncome();
                monthSumExpenses += report.getTotalExpenses();
            }
        }
        return monthSumIncome == yearIncome && monthSumExpenses == yearExpenses;
    }
}
