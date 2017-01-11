package com.shengtian.service.tmcs.parsing;

import com.shengtian.service.tmcs.domain.DataPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.shengtian.service.tmcs.parsing.ConfigFileAttribute.*;

@Component
public class ConfigFileParser extends CsvFileParser {

    private String filePath;

    private ConfigFileParser(@Value("${tmcs.path.config.file}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    String getFilePath() {
        return filePath;
    }

    public Set<DataPoint> parse() {
        try {
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
                    .moduleId(Integer.valueOf(row.get(moduleIndex)))
                    .channelId(Integer.valueOf(row.get(channelIndex)))
                    .maxTemperature(Double.valueOf(row.get(maxTmpIndex)))
                    .minTemperature(Double.valueOf(row.get(minTmpIndex)))
                    .build())
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
