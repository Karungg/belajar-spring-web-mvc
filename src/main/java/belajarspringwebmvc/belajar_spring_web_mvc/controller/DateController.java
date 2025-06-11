package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DateController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @GetMapping(path = "/date")
    public void getDate(@RequestParam(name = "date") Date date, HttpServletResponse response) throws IOException {
        response.getWriter().println("Date : " + dateFormat.format(date));
    }

}
