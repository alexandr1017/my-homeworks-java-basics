package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {
    @RequestMapping("/")
    public String index (){
        return (new String("Это страница заглушка, отображающая только текущую дату и время :) ") + new Date().toString());
    }
}
