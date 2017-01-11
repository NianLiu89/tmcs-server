package com.shengtian.service.tmcs.parsing;

import com.shengtian.service.tmcs.data.DataPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.shengtian.service.tmcs.parsing.ConfigFileAttribute.*;

@Component
public class ConfigFileParser extends CsvFileParser {

    @Value("${tmcs.path.config.file}")
    private String filePath;

    public Set<DataPoint> parse() throws IOException {
        List<List<String>> rawData = parseCsv();

        List<String> titleRow = rawData.get(0);
        int codeIndex = titleRow.indexOf(CODE.getParadoxName());
        int kilnIndex = titleRow.indexOf(KILN.getParadoxName());
        int slotIndex = titleRow.indexOf(SLOT.getParadoxName());
        int positionIndex = titleRow.indexOf(POSITION.getParadoxName());
        int maxTmpIndex = titleRow.indexOf(MAX_TEMPERATURE.getParadoxName());
        int minTmpIndex = titleRow.indexOf(MIN_TEMPERATURE.getParadoxName());
        int moduleIndex = titleRow.indexOf(MODULE.getParadoxName());
        int channelIndex = titleRow.indexOf(CHANNEL.getParadoxName());

        rawData.remove(0);
        return rawData.stream().map(row -> DataPoint.builder()
                .code(row.get(codeIndex))
                .kiln(row.get(kilnIndex))
                .slot(Integer.parseInt(row.get(slotIndex)))
//                    .position(row.get(positionIndex))
                .moduleId(Integer.parseInt(row.get(moduleIndex)))
                .channelId(Integer.parseInt(row.get(channelIndex)))
                .maxTemperature(Double.parseDouble(row.get(maxTmpIndex)))
                .minTemperature(Double.parseDouble(row.get(minTmpIndex)))
                .build())
                .collect(Collectors.toSet());
    }

    @Override
    String getFilePath() {
        return filePath;
    }
}
