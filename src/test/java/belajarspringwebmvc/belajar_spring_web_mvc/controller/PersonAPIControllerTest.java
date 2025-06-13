package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import belajarspringwebmvc.belajar_spring_web_mvc.model.CreateAddressRequest;
import belajarspringwebmvc.belajar_spring_web_mvc.model.CreatePersonRequest;
import belajarspringwebmvc.belajar_spring_web_mvc.model.CreateSocialMediasRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonAPIControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        void testCreatePerson() throws Exception {
                CreatePersonRequest request = new CreatePersonRequest();
                request.setFirstName("Miftah");
                request.setLastName("Fadilah");
                request.setEmail("yahaha@gmail.com");
                request.setAge("99");
                request.setPhone("0812345678");
                request.setAddress(new CreateAddressRequest());
                request.getAddress().setCity("Ciherang");
                request.getAddress().setCountry("Indonesia");
                request.getAddress().setPostalCode("120120");
                request.getAddress().setStreet("Jalan yahaha");
                request.setHobbies(List.of("Coding", "Game"));
                request.setSocialMedias(new ArrayList<CreateSocialMediasRequest>());
                request.getSocialMedias().add(new CreateSocialMediasRequest("Facebook", "miftahfadilah71"));
                request.getSocialMedias().add(new CreateSocialMediasRequest("Instagram", "miftahfadilah71"));

                mockMvc.perform(
                                post("/api/person")
                                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                .content(objectMapper.writeValueAsString(request)))
                                .andExpectAll(
                                                status().isOk(),
                                                content().json(objectMapper.writeValueAsString(request)));
        }

        @Test
        void testErrorCreatePerson() throws Exception {
                CreatePersonRequest request = new CreatePersonRequest();
                request.setAddress(new CreateAddressRequest());
                request.getAddress().setPostalCode("120120");
                request.getAddress().setStreet("Jalan yahaha");
                request.setHobbies(List.of("Coding", "Game"));
                request.setSocialMedias(new ArrayList<CreateSocialMediasRequest>());
                request.getSocialMedias().add(new CreateSocialMediasRequest("Facebook", "miftahfadilah71"));
                request.getSocialMedias().add(new CreateSocialMediasRequest("Instagram", "miftahfadilah71"));

                mockMvc.perform(
                                post("/api/person")
                                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                .content(objectMapper.writeValueAsString(request)))
                                .andExpectAll(
                                                status().isBadRequest(),
                                                content().string(Matchers.containsString("Validation Error : ")));
        }

}
