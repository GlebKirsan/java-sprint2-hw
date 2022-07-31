package printer.console.unitprinter;

import report.Report;

public interface ReportPrinterForUnit<T extends Report> {

    void print(T report);

}
