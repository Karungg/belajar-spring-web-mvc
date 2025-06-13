package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebAndModelController {

    @GetMapping(path = "/web/hello")
    public ModelAndView hello(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "title") String title) {

        return new ModelAndView("hello", Map.of(
                "title", title,
                "name", name));
    }

}
