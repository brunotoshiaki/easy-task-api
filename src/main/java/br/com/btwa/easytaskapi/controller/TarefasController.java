package br.com.btwa.easytaskapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.btwa.easytaskapi.model.Tarefa;
import br.com.btwa.easytaskapi.repository.TarefasRepository;

@RestController
@RequestMapping("/")
public class TarefasController {

    @Autowired
    private TarefasRepository tarefasRepository;

    @PostMapping("/tarefas")
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return tarefasRepository.save(tarefa);
    }

}
