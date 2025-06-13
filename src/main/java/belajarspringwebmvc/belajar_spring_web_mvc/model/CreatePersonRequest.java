package belajarspringwebmvc.belajar_spring_web_mvc.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePersonRequest {

    private CreateAddressRequest address;

    private List<CreateSocialMediasRequest> socialMedias;

    private List<String> hobbies;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String age;

    @NotBlank
    private String phone;
}
