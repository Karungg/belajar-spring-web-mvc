package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloGuest() throws Exception {
        mockMvc.perform(
                get("/hello")).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Guest")));
    }

    @Test
    void testHelloName() throws Exception {
        mockMvc.perform(get("/hello").queryParam("name", "Miftah Fadilah"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("Hello Miftah Fadilah")));
    }

}
