package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidHeader() throws Exception {
        mockMvc.perform(
                get("/token")
                        .header("X-TOKEN", "MIFTAH"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("OK")));
    }

    @Test
    void testErrorHeader() throws Exception {
        mockMvc.perform(
                get("/token")
                        .header("X-TOKEN", "ANJAS"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("KO")));
    }

}
