package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreatePerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("firstName", "Miftah")
                        .param("lastName", "Fadilah")
                        .param("email", "yahaha@gmail.com")
                        .param("address.country", "Indonesia")
                        .param("address.city", "Walangsangit")
                        .param("address.postalCode", "120120")
                        .param("address.street", "Jalan terbang")
                        .param("age", "99")
                        .param("phone", "0895793798712")
                        .param("socialMedias[0].name", "fbyahaha")
                        .param("socialMedias[0].location", "Indonesia")
                        .param("socialMedias[1].name", "igyahaha")
                        .param("socialMedias[1].location", "Indonesia")
                        .param("hobbies[0]", "Ngoding")
                        .param("hobbies[1]", "Game"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("""
                                Successfully create person
                                Full name : Miftah Fadilah
                                Email : yahaha@gmail.com
                                City : Walangsangit
                                Country : Indonesia
                                Postal Code : 120120
                                Street : Jalan terbang
                                Phone : 0895793798712
                                Age : 99
                                First hobby : Ngoding
                                Second hobby : Game
                                Facebook name : fbyahaha
                                Facebook location : Indonesia
                                Instagram name : igyahaha
                                Instagram location : Indonesia
                                                """)));
    }

}
