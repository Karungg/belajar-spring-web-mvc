package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = PartnerController.class)
public class PartnerControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testGetPartner() throws Exception {
                mockMvc.perform(
                                get("/partner/current")
                                                .header("X-API-KEY", "Sample"))
                                .andExpectAll(
                                                status().isOk(),
                                                content().string(
                                                                Matchers.containsString("Sample : Sample Partner")));
        }

}
