package com.shengtian.service;

import com.hxtt.sql.paradox.ParadoxDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmcsServerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void dummyLoadData() {
		try {
			Class.forName(ParadoxDriver.class.getName());
			Connection e = DriverManager.getConnection("jdbc:paradox:/src/test/resources/data");
			Statement statement = e.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from locality");

			while(resultSet.next()) {
				System.out.println("\n\n******************************");
				System.out.println(resultSet.getObject("Gongwei"));
				System.out.println(resultSet.getObject("Commentary"));
				System.out.println(resultSet.getObject("moduleid"));
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}
	}

}
