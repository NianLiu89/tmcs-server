package com.shengtian.service.tmcs.data.database;

import com.hxtt.sql.paradox.ParadoxDriver;
import com.shengtian.service.tmcs.data.DataPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DatabaseAccessor {

    private String dataSourcePath;

    @Inject
    DatabaseAccessor(@Value("${tmcs.path.data.source}") String dataSourcePath) {
        this.dataSourcePath = dataSourcePath;
        System.out.println();
    }

    public Set<DataPoint> queryDataPoints() {
        Set<DataPoint> dataPoints = new HashSet<>();

        try (ResultSet resultSet = query("locality")) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                System.out.println(metaData.getColumnName(i + 1));
            }

            while (resultSet.next()) {
                final String code = String.valueOf(resultSet.getObject("Gongwei"));
                final String kiln = String.valueOf(resultSet.getObject("Kiln"));
                final String slot = String.valueOf(resultSet.getObject("Chewei"));
                final String position = String.valueOf(resultSet.getObject("Weizhi"));
                final String maxTemperature = String.valueOf(resultSet.getObject("Hlimit"));
                final String minTemperature = String.valueOf(resultSet.getObject("Llimit"));
                final String moduleId = String.valueOf(resultSet.getObject("ModuleID"));
                final String channelId = String.valueOf(resultSet.getObject("Channels"));

                DataPoint dataPoint = new DataPoint(code);
                dataPoint.setKilnCode(kiln);
                dataPoint.setSlot(Integer.valueOf(slot));
//                dataPoint.setPosition();  // TODO check what does U D M means?
                dataPoint.setMaxTemperature(Double.valueOf(maxTemperature));
                dataPoint.setMinTemperature(Double.valueOf(minTemperature));
                dataPoint.setModuleId(Integer.valueOf(moduleId));
                dataPoint.setChannelId(Integer.valueOf(channelId));
                dataPoint.setTemperature(0.0);

                System.out.println(dataPoint);
                dataPoints.add(dataPoint);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] something went wrong while querying!");
        }
        return dataPoints;
    }

    public void updateTemperature(Set<DataPoint> dataPoints) {
        Map<String, DataPoint> map = dataPoints.stream().collect(Collectors.toMap(DataPoint::getCode, Function.identity()));

        try (ResultSet resultSet = query("locality")) {
            while (resultSet.next()) {
                String code = String.valueOf(resultSet.getObject("Gongwei"));
                double temperature = Double.valueOf(String.valueOf(resultSet.getObject("Value")));
                map.get(code).setTemperature(temperature);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] something went wrong while querying!");
        }
    }

    private ResultSet query(String tableName) throws SQLException {
        DriverManager.registerDriver(new ParadoxDriver());
        final Connection connection = DriverManager.getConnection("jdbc:paradox:" + dataSourcePath);
        final Statement statement = connection.createStatement();
        return statement.executeQuery("select * from " + tableName);
    }
}
