package reader.csv.parser;

import report.Report;
import report.month.MonthlyReport;
import report.month.MonthReportEntry;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MonthReportParser implements CsvReportParser {

    private final FilenameParser filenameParser;

    public MonthReportParser(FilenameParser monthFilenameParser) {
        this.filenameParser = monthFilenameParser;
    }

    @Override
    public Pattern getFileNamePattern() {
        return filenameParser.getFilenamePattern();
    }

    @Override
    public Report parseReport(String text, String filename) {
        var monthReport = new MonthlyReport();
        Stream<String> linesWithoutHeader = text.lines().skip(1);
        linesWithoutHeader.map(this::parseLine).forEach(monthReport::add);
        monthReport.setYear(filenameParser.getPatternFromFilenameByGroup(filename, 1));
        monthReport.setMonth(filenameParser.getPatternFromFilenameByGroup(filename, 2));
        return monthReport;
    }

    private MonthReportEntry parseLine(String line) {
        var columns = line.split(",");
        var itemName = columns[0];
        var isExpense = Boolean.parseBoolean(columns[1]);
        var quantity = Integer.parseInt(columns[2]);
        var sumOfOne = Long.parseLong(columns[3]);
        return new MonthReportEntry(itemName, isExpense, quantity, sumOfOne);
    }

}
