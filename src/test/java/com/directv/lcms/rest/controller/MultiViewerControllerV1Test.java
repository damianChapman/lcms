package com.directv.lcms.rest.controller;

import com.directv.lcms.dto.ScanTask;
import com.directv.lcms.service.MultiViewerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiViewerControllerV1Test {

    @Autowired
    private MultiViewerControllerV1 multiViewerController;

    @Autowired
    private MultiViewerService multiViewerService;
    private MockMvc mvc;


    @Before
    public void setUp() throws Exception {
        Whitebox.setInternalState(multiViewerController, "multiViewerService", multiViewerService);
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(multiViewerController).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetMosaic() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("/api/v1/multiviewer/tag/mosaic/1234");
        mvc.perform(MockMvcRequestBuilders.get(stringBuilder.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPostScanTask() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("/api/v1/multiviewer/tag/scantask");
        ScanTask scanTask = new ScanTask();
        scanTask.setIp_address_from("225.0.5.1");
        scanTask.setIp_address_to("225.0.5.10");
        scanTask.setNetwork_id("3");
        scanTask.setPort_from("2000");
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String scanTaskString = objectWriter.writeValueAsString(scanTask);
        mvc.perform(MockMvcRequestBuilders.post(stringBuilder.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(scanTaskString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetChannelConfigurations() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("/api/v1//multiviewer/tag/channel/configurations");
        mvc.perform(MockMvcRequestBuilders.get(stringBuilder.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetOutputLayout() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("/api/v1/multiviewer/tag/output/layout/1234");
        mvc.perform(MockMvcRequestBuilders.get(stringBuilder.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetEncoder() throws Exception {
        StringBuilder stringBuilder = new StringBuilder("/api/v1/multiviewer/tag/encoder/1234");
        mvc.perform(MockMvcRequestBuilders.get(stringBuilder.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
