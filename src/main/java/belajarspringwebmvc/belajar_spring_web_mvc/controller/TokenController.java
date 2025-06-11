package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TokenController {

    @GetMapping("/token")
    @ResponseBody
    public String header(@RequestHeader("X-TOKEN") String token) {
        if (token.equals("MIFTAH")) {
            return "OK";
        } else {
            return "KO";
        }
    }

}
