package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import java.io.IOException;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");

        if (Objects.isNull(name)) {
            name = "Guest";
        }

        response.getWriter().println("Hello " + name);
    }

}