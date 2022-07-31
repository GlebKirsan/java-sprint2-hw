package commands;

import reader.ReportReader;
import reader.csv.CsvReportReaderFabric;
import report.Report;
import report.ReportType;
import report.ReportsSingleton;

import java.util.List;

public class ReadReport extends Command {

    private final int order;
    private final String text;
    private final ReportReader reader;

    public ReadReport(int order, String text, ReportType reportType) {
        this.order = order;
        this.text = text;
        this.reader = CsvReportReaderFabric.getReader(reportType);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void execute() {
        List<Report> report = reader.readReports("./resources");
        ReportsSingleton.getInstance().add(report);
    }

    @Override
    public int getOrder() {
        return order;
    }
}
