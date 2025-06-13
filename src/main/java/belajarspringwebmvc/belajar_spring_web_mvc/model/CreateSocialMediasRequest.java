package belajarspringwebmvc.belajar_spring_web_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSocialMediasRequest {
    private String name;

    private String location;
}
