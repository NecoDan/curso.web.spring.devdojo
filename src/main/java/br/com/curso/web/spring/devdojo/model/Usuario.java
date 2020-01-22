package br.com.curso.web.spring.devdojo.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Usuario {

    private Long usuarioId;
    private String login;
    private String senha;
    private LocalDateTime dataLancamento;
    private Boolean ativo;
}
