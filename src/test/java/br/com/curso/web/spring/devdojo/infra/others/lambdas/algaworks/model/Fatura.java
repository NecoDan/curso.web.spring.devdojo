package br.com.curso.web.spring.devdojo.infra.others.lambdas.algaworks.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Fatura {
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
