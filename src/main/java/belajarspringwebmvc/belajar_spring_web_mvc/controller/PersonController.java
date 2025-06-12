package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import belajarspringwebmvc.belajar_spring_web_mvc.model.CreatePersonRequest;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> createPerson(@ModelAttribute CreatePersonRequest request) {
        String body = """
                Successfully create person
                Full name : $firstName $lastName
                Email : $email
                City : $city
                Country : $country
                Postal Code : $postalCode
                Street : $street
                Phone : $phone
                Age : $age
                First hobby : $firstHobby
                Second hobby : $secondHobby
                Facebook name : $facebookName
                Facebook location : $facebookLocation
                Instagram name : $instagramName
                Instagram location : $instagramLocation
                """.replace("$firstName", request.getFirstName())
                .replace("$lastName", request.getLastName())
                .replace("$email", request.getEmail())
                .replace("$phone", request.getPhone())
                .replace("$age", request.getAge())
                .replace("$city", request.getAddress().getCity())
                .replace("$country", request.getAddress().getCountry())
                .replace("$postalCode", request.getAddress().getPostalCode())
                .replace("$street", request.getAddress().getStreet())
                .replace("$firstHobby", request.getHobbies().get(0))
                .replace("$secondHobby", request.getHobbies().get(1))
                .replace("$facebookName", request.getSocialMedias().get(0).getName())
                .replace("$facebookLocation", request.getSocialMedias().get(0).getLocation())
                .replace("$instagramName", request.getSocialMedias().get(1).getName())
                .replace("$instagramLocation", request.getSocialMedias().get(1).getLocation());
        return ResponseEntity.ok().body(body);
    }

}
