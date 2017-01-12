package com.shengtian.service;

import com.shengtian.service.tmcs.domain.DataPoint;
import com.shengtian.service.tmcs.DataPointsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmcsServerApplicationTests {

	@Inject
    DataPointsService dataService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void dummyMain () throws IOException {
		final Set<DataPoint> dataPoints = dataService.getDataPoints();
		System.out.println(dataPoints);
	}


}
