package printer;

import report.YearSummary;

import java.util.List;

public interface ReportPrinter  {

    void printReportsInfo(List<YearSummary> reports);
}
