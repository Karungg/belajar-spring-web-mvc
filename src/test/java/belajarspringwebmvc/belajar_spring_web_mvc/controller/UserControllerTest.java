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

import belajarspringwebmvc.belajar_spring_web_mvc.model.User;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testGetUser() throws Exception {
                mockMvc.perform(
                                get("/user/current")
                                                .sessionAttr("user", new User("miftah")))
                                .andExpectAll(
                                                status().isOk(),
                                                content().string(Matchers.containsString("Hello miftah")));
        }

        @Test
        void testInvalidGetUser() throws Exception {
                mockMvc.perform(
                                get("/user/current")).andExpectAll(
                                                status().is3xxRedirection());
        }

}
