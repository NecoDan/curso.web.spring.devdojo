package br.com.curso.web.spring.devdojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Raca {

    private Long racaId;
    private String descricao;
    private Boolean ativo;
    private LocalDateTime data;
    @JsonProperty("Especie")
    private Especie especie;

}
