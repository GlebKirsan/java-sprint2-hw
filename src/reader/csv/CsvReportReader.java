package reader.csv;

import reader.ReportReader;
import reader.csv.parser.CsvReportParser;
import report.Report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReportReader implements ReportReader {

    private final CsvReportParser parser;

    public CsvReportReader(CsvReportParser parser) {
        this.parser = parser;
    }

    @Override
    public List<Report> readReports(String folder) {
        List<Report> reports = new ArrayList<>();
        List<Path> filesToRead = readAllFileNamesThatMatch(folder);
        for (Path filepath : filesToRead) {
            Optional<String> fileContent = readFileContentsOrNull(filepath);
            var filename = filepath.getFileName().toString();
            fileContent.map(text -> parser.parseReport(text, filename)).map(reports::add);
        }
        return reports;
    }

    private List<Path> readAllFileNamesThatMatch(String folder) {
        try (Stream<Path> files = Files.list(Path.of(folder))) {
            var matchPredicate = parser.getFileNamePattern().asPredicate();
            var matchedPaths = files.filter(path -> matchPredicate.test(path.toString()));
            return matchedPaths.collect(Collectors.toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private Optional<String> readFileContentsOrNull(Path filepath) {
        try {
            return Optional.of(Files.readString(filepath));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return Optional.empty();
        }
    }
}
