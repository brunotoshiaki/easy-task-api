package br.com.btwa.easytaskapi.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.btwa.easytaskapi.enums.StatusTarefa;
import lombok.Data;

@Document
@Data
public class Tarefa {

    @Id
    private String id;
    @NotBlank(message = "Descricao obrigatória")
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    @NotBlank(message = "statusTarefa obrigatório")
    private StatusTarefa statusTarefa;

}
