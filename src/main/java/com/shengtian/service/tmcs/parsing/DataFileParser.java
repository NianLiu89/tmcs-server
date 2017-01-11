package com.shengtian.service.tmcs.parsing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataFileParser extends CsvFileParser {

    private String filePath;

    private DataFileParser(@Value("${tmcs.path.data.file}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    String getFilePath() {
        return filePath;
    }

    public Map<String, String> parse() {
        try {
            List<List<String>> rawData = parseCsv();
            return rawData.stream().collect(Collectors.toMap(row -> row.get(0), row -> row.get(1)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
