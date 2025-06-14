package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddToDo() throws Exception {
        mockMvc.perform(
                post("/todos")
                        .param("todo", "Ngoding")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Ngoding")));
    }

    @Test
    void testGetToDo() throws Exception {
        mockMvc.perform(
                get("/todos")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Ngoding")));
    }

}
