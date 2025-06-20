package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FormControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testHello() throws Exception {
                mockMvc
                                .perform(
                                                post("/form/hello")
                                                                .queryParam("name", "Miftah Fadilah")
                                                                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                                .andExpectAll(
                                                status().isOk(),
                                                header().string(HttpHeaders.CONTENT_TYPE,
                                                                Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                                                content().string(Matchers.containsString("Hello Miftah Fadilah")));
        }

        @Test
        void testCreatePerson() throws Exception {
                mockMvc.perform(
                                post("/form/person")
                                                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                                .param("name", "Miftah Fadilah")
                                                .param("date", "2004-11-27")
                                                .param("address", "Indonesia"))
                                .andExpectAll(
                                                status().isOk(),
                                                content().string(Matchers.containsString(
                                                                "Create person successfully! Name : Miftah Fadilah, Date of birth : 2004-11-27, Address : Indonesia")),
                                                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(
                                                                MediaType.TEXT_PLAIN_VALUE)));
        }

}
