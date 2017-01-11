package com.shengtian.service;

import com.hxtt.sql.paradox.ParadoxDriver;
import com.shengtian.service.tmcs.data.init.Initializer;
import com.shengtian.service.tmcs.parsing.CsvFileParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmcsServerApplicationTests {

	@Inject
	Initializer initializer;

	@Inject
	CsvFileParser csvFileParser;

	@Test
	public void contextLoads() {
	}

	@Test
	public void dummyMain () throws IOException {
		csvFileParser.parseCsvFile("data/data.csv");
//		initializer.initializeDataPoints();
	}


}
