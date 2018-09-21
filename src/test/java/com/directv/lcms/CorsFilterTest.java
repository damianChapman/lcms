package com.directv.lcms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext
public class CorsFilterTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCorsFilter() throws Exception {
        MvcResult result = mvc
                .perform(options("/api/v1/multiviewers"))
                .andExpect(status().isOk())
                .andExpect(header().string("Allow", "DELETE"))
                .andExpect(header().string("X-Content-Type-Options", is("nosniff")))
                .andExpect(header().string("X-XSS-Protection", is("1; mode=block")))
                .andExpect(header().string("Cache-Control", is("no-cache, no-store, max-age=0, must-revalidate")))
                .andExpect(header().string("Pragma", is("no-cache")))
                .andExpect(header().string("Expires", is("0")))
                .andExpect(header().string("X-Frame-Options", is("DENY")))

                .andDo(print())
                .andReturn();

        MockHttpServletResponse mockResponse = result.getResponse();
        Collection<String> responseHeaders = mockResponse.getHeaderNames();
        assertThat(responseHeaders).isNotNull();
        assertThat(responseHeaders.size()).isEqualTo(7);
    }
}
