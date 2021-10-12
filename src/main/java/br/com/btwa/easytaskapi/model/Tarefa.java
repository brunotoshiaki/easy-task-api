package br.com.btwa.easytaskapi.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import enums.StatusTarefa;
import lombok.Data;

@Document
@Data
public class Tarefa {

    @Id
    private String id;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private StatusTarefa statusTarefa;

}
