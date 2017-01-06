package com.shengtian.service;

import com.hxtt.sql.paradox.ParadoxDriver;
import com.shengtian.service.tmcs.data.init.Initializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmcsServerApplicationTests {

	@Inject
	Initializer initializer;

	@Test
	public void contextLoads() {
	}

	@Test
	public void dummyMain () {
		initializer.initializeDataPoints();
	}

	@Test
	public void dummyLoadData() {
		try {
			Class.forName(ParadoxDriver.class.getName());
			Connection e = DriverManager.getConnection("jdbc:paradox:/src/test/resources/data");
			Statement statement = e.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from locality");
			ResultSetMetaData metaData = resultSet.getMetaData();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				System.out.println(metaData.getColumnName(i+1));
			}

	int i = 0;
			while(resultSet.next()) {
				System.out.println("\n\n******************************");
				System.out.println(resultSet.getObject("Gongwei"));
				System.out.println(resultSet.getObject("Commentary"));
				System.out.println(resultSet.getObject("moduleid"));
				System.out.println(resultSet.getObject("kiln"));

				i++;
				if ( i  > 3) {
					break;
				}
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}
	}

}
