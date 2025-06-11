package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import belajarspringwebmvc.belajar_spring_web_mvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void helloWorld(@RequestParam(name = "name", required = false) String name, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String responseBody = helloService.hello(name);

        response.getWriter().println(responseBody);
    }

}