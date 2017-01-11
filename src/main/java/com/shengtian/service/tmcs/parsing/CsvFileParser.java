package com.shengtian.service.tmcs.parsing;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CsvFileParser {


    public List<List<String>> parseCsvFile(String filePath) throws IOException {
//        final List<String> lines = Files.readLines(new File(filePath), Charsets.UTF_8);
        final List<String> lines = Files.readLines(new File("data/config.csv"), Charsets.UTF_8);


        List<List<String>> dataGroupByColumns = new ArrayList<>();
        lines.forEach(line -> {
            int rowIndex = lines.indexOf(line);

            final List<String> currentRow = Splitter.on(",").trimResults().splitToList(line);
            currentRow.forEach(column -> {

                if (rowIndex == 0) {
                    dataGroupByColumns.add(new ArrayList<>());
                }

                int columnIndex = currentRow.indexOf(column);
                dataGroupByColumns.get(columnIndex).add(column);
            });
        });

        return dataGroupByColumns;
    }
}
