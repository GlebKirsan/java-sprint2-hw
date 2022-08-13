package printer.console.unitprinter;

import report.Report;
import report.ReportType;

public interface ReportPrinterForUnit {

    void print(Report report);

    ReportType getUnit();

}
