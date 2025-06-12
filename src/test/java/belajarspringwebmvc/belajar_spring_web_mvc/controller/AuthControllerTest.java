package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import jakarta.servlet.http.Cookie;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSuccessLogin() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .param("username", "miftah")
                        .param("password", "rahasia")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("OK")),
                        cookie().value("username", Matchers.is("miftah")));
    }

    @Test
    void testErrorLogin() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .param("username", "Miftah")
                        .param("password", "password") // wrong password
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpectAll(
                        status().isUnauthorized(),
                        content().string(Matchers.containsString("KO")));
    }

    @Test
    void testGetUser() throws Exception {
        mockMvc.perform(
                get("/auth/user")
                        .cookie(new Cookie("username", "miftah")))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello miftah")));
    }

}
