package reader.csv.parser;

import report.Report;
import report.year.YearlyReport;
import report.year.YearReportEntry;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class YearReportParser implements CsvReportParser {

    private final FilenameParser filenameParser;

    public YearReportParser(FilenameParser filenameParser) {
        this.filenameParser = filenameParser;
    }

    @Override
    public Pattern getFileNamePattern() {
        return filenameParser.getFilenamePattern();
    }

    @Override
    public Report parseReport(String text, String filename) {
        var yearReport = new YearlyReport();
        Stream<String> linesWithoutHeader = text.lines().skip(1);
        linesWithoutHeader.map(this::parseLine).forEach(yearReport::add);
        yearReport.setYear(filenameParser.getPatternFromFilenameByGroup(filename, 1));
        return yearReport;
    }

    private YearReportEntry parseLine(String line) {
        var columns = line.split(",");
        var monthNumber = Integer.parseInt(columns[0]);
        var amount = Integer.parseInt(columns[1]);
        var isExpense = Boolean.parseBoolean(columns[2]);
        return new YearReportEntry(monthNumber, amount, isExpense);
    }

}
