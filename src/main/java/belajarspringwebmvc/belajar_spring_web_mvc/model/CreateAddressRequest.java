package belajarspringwebmvc.belajar_spring_web_mvc.model;

import lombok.Data;

@Data
public class CreateAddressRequest {

    private String country;

    private String city;

    private String postalCode;

    private String street;

}
