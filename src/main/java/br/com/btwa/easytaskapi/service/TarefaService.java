package br.com.btwa.easytaskapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.btwa.easytaskapi.model.Tarefa;
import br.com.btwa.easytaskapi.repository.TarefasRepository;
import br.com.btwa.easytaskapi.repository.exeption.ObjectNotFoundException;

@Service
public class TarefaService {

    @Autowired
    private TarefasRepository tarefasRepository;

    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa save(Tarefa tarefa) {
        tarefa.setDataCriacao(LocalDate.now());
        return tarefasRepository.save(tarefa);
    }

    @ResponseStatus(HttpStatus.OK)
    public List<Tarefa> findAll() {
        return tarefasRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    public Tarefa findById(String id) {
        return tarefasRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @ResponseStatus(HttpStatus.OK)
    public List<Tarefa> findByDescricaoLikeIgnoreCase(String descricao) {
        return tarefasRepository.findByDescricaoLikeIgnoreCase(descricao);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tarefa update(Tarefa tarefa) {
        var newObj = this.findById(tarefa.getId());
        this.updateData(newObj, tarefa);

        return null;
    }

    private void updateData(Tarefa newObj, Tarefa tarefa) {
        newObj.setDescricao(tarefa.getDescricao());
        newObj.setStatusTarefa(tarefa.getStatusTarefa());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(String id) {
        this.findById(id);
        tarefasRepository.deleteById(id);
    }

}
