package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import belajarspringwebmvc.belajar_spring_web_mvc.model.HelloRequest;
import belajarspringwebmvc.belajar_spring_web_mvc.model.HelloResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class BodyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testBody() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("Miftah");

        mockMvc.perform(
                post("/body/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpectAll(status().isOk())
                .andExpect(result -> {
                    String responseBody = result.getResponse().getContentAsString();
                    HelloResponse helloResponse = objectMapper.readValue(responseBody, HelloResponse.class);
                    Assertions.assertEquals("Hello Miftah", helloResponse.getHello());
                });
    }

}
