package reader.csv.parser;

import report.Report;

import java.util.regex.Pattern;

public interface CsvReportParser {
    Pattern getFileNamePattern();

    Report parseReport(String text, String filename);

}
