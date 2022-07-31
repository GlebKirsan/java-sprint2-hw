package reader.csv;

import reader.NoReportReaderException;
import reader.ReportReader;
import reader.csv.parser.FilenameParser;
import reader.csv.parser.MonthReportParser;
import reader.csv.parser.YearReportParser;
import report.ReportType;

import java.util.EnumMap;
import java.util.regex.Pattern;

public class CsvReportReaderFabric {

    private static final EnumMap<ReportType, ReportReader> reportReaders = new EnumMap<>(ReportType.class);

    static {
        var monthFilenameParser = new FilenameParser(Pattern.compile("m\\.(\\d{4})(\\d{2})\\.csv$"));
        reportReaders.put(ReportType.MONTH, new CsvReportReader(new MonthReportParser(monthFilenameParser)));

        var yearFilenameParser = new FilenameParser(Pattern.compile("y\\.(\\d{4})\\.csv$"));
        reportReaders.put(ReportType.YEAR, new CsvReportReader(new YearReportParser(yearFilenameParser)));
    }

    private CsvReportReaderFabric() {}

    public static ReportReader getReader(ReportType reportType) {
        boolean hasReportReader = reportReaders.containsKey(reportType);
        if (!hasReportReader) {
            throw new NoReportReaderException(reportType);
        }
        return reportReaders.get(reportType);
    }

}
