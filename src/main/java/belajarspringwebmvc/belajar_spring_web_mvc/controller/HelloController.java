package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public void helloWorld(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello world");
    }

}