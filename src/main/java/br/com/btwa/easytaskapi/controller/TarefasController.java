package br.com.btwa.easytaskapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TarefasController {

    @GetMapping
    public String hello() {
        return "Bem vindo";
    }

}
