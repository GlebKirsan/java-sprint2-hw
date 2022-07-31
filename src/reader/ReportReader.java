package reader;

import report.Report;

import java.util.List;

public interface ReportReader {

    List<Report> readReports(String pathToContainingFolder);
}
