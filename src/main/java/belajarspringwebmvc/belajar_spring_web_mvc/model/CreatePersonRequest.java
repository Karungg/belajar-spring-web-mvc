package belajarspringwebmvc.belajar_spring_web_mvc.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    private CreateAddressRequest address;

    private List<CreateSocialMediasRequest> socialMedias;

    private List<String> hobbies;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String age;

    @NotNull
    private String phone;
}
