package br.com.curso.web.spring.devdojo.util;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class ResourceNotFoundDetails {

    private String titulo;
    private int status;
    private String detalhes;
    private Long timestamp;
    private String mensagem;
}
