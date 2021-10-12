package br.com.btwa.easytaskapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.btwa.easytaskapi.model.Tarefa;
import br.com.btwa.easytaskapi.service.TarefaService;

@RestController
@RequestMapping("/")
public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/tarefas")
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    @GetMapping("/tarefas")
    public List<Tarefa> getAll() {
        return tarefaService.findAll();
    }

    @GetMapping("/tarefas/{id}")
    public Tarefa findById(@PathVariable String id) {
        return tarefaService.findById(id);
    }

    @GetMapping("tarefas/descricao/{descricao}")
    public List<Tarefa> findByDescricao(@PathVariable String descricao) {
        return tarefaService.findByDescricaoLikeIgnoreCase(descricao);
    }

    @PutMapping("tarefas/{id}")
    public Tarefa update(@PathVariable String id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("/tarefas/{id}")
    public void delete(@PathVariable String id) {
        tarefaService.delete(id);
    }

}
