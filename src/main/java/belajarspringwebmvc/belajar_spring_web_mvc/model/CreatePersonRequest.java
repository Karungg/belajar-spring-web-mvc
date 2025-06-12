package belajarspringwebmvc.belajar_spring_web_mvc.model;

import java.util.List;

import lombok.Data;

@Data
public class CreatePersonRequest {

    private CreateAddressRequest address;

    private List<CreateSocialMediasRequest> socialMedias;

    private List<String> hobbies;

    private String firstName;

    private String lastName;

    private String email;

    private String age;

    private String phone;
}
