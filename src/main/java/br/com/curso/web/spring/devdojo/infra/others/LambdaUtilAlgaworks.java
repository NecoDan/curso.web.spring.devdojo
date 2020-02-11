package br.com.curso.web.spring.devdojo.infra.others;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
class Fatura {
    private String emailDevedor;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private Boolean notificacaoEnviada;

    public String toStringResumoFatura() {
        if (Objects.nonNull(this.valor))
            return String.format("Valor R$ %s, vencimento %s", this.valor, this.toStringDataVencimento());
        return String.valueOf(BigDecimal.ZERO);
    }

    public String toStringDataVencimento() {
        if (Objects.isNull(this.dataVencimento))
            return "Data não informada.";
        return this.dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

class EnviadorEmail {
    public void enviar(String to, String mensagem) {
        System.out.printf("Enviando e-mail para: %s ... Com o Texto: %s \n ", to, mensagem);
    }
}

class FaturaRepository {
    public List<Fatura> recuperarFaturasVencidas() {
        List<Fatura> faturasVencidas = new ArrayList<>();
        faturasVencidas.add(Fatura.builder()
                .emailDevedor("gustavo@gmail.com")
                .valor(BigDecimal.valueOf(350.00))
                .dataVencimento(LocalDate.now().minusDays(3))
                .build());

        faturasVencidas.add(Fatura.builder()
                .emailDevedor("marcela@gmail.com")
                .valor(BigDecimal.valueOf(150.00))
                .dataVencimento(LocalDate.now().minusMonths(2).minusDays(2))
                .build());

        return faturasVencidas;
    }
}

public class LambdaUtilAlgaworks {
    public static void main(String[] args) {
        EnviadorEmail enviadorEmail = new EnviadorEmail();

        List<Fatura> faturas = new FaturaRepository().recuperarFaturasVencidas();
        faturas.forEach(f -> enviadorEmail.enviar(f.getEmailDevedor(), f.toStringResumoFatura()));
    }
}
