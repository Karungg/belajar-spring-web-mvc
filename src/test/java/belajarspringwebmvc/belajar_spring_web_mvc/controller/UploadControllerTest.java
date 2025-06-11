package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testUpload() throws Exception {
                mockMvc.perform(multipart("/upload/profile")
                                .file(new MockMultipartFile("profile", "profile.jpeg", "image/jpeg",
                                                getClass().getResourceAsStream("upload/profile.jpeg")))
                                .param("name", "Miftah")
                                .contentType(MediaType.MULTIPART_FORM_DATA))
                                .andExpectAll(status().isOk(), content().string(Matchers.containsString(
                                                "Success save profile Miftah to upload to upload/profile.jpeg")));
        }

}
