package com.shengtian.service.tmcs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shengtian.service.tmcs.domain.DataPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Set;

@Controller
@RequestMapping("/datapoints")
public class DataPointsController {

    @Inject
    private DataPointsService dataPointsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Set<DataPoint> dataPoints = dataPointsService.getDataPoints();
        return mapper.writeValueAsString(dataPoints);
    }


}
