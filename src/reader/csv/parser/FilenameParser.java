package reader.csv.parser;

import java.util.regex.Pattern;

public class FilenameParser {

    private final Pattern filenamePattern;

    public FilenameParser(Pattern filenamePattern) {
        this.filenamePattern = filenamePattern;
    }

    public Pattern getFilenamePattern() {
        return filenamePattern;
    }

    public int getPatternFromFilenameByGroup(String filename, int group) {
        var matcher = filenamePattern.matcher(filename);
        matcher.find();
        String number = matcher.group(group);
        return Integer.parseInt(number);
    }
}
