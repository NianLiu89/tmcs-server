package com.shengtian.service.tmcs.parsing;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public abstract class CsvFileParser {

    abstract String getFilePath();

    List<List<String>> parseCsv() throws IOException {
        final List<String> lines = Files.readLines(new File(getFilePath()), Charsets.UTF_8);
        return lines.stream()
                .map(line -> Splitter.on(",")
                        .trimResults()
                        .splitToList(line))
                .collect(Collectors.toList());
    }
}
