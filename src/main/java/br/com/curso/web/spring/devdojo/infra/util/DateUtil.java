package br.com.curso.web.spring.devdojo.infra.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component  // ----> Indica que a classe é utilizada e iniciada com a injeção de depedências
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime data) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(data);
    }
}
