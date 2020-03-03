package br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.conversor_romano.negocio;

import br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.conversor_romano.model.SimbolNumeralRomano;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Builder
public class ConversorNumeroRomanoService {

    public int converte(String valor) {
        return this.converter(valor);
    }

    public Integer converter(String valor) {
        if (Objects.isNull(valor) || valor.isEmpty())
            return Integer.parseInt(String.valueOf(BigDecimal.ZERO));

        return SimbolNumeralRomano.fromNumeral(valor).getCodigo();
    }

    public Integer converteRefatorado(String valor) {
        if (Objects.isNull(valor) || valor.isEmpty())
            return Integer.parseInt(String.valueOf(BigDecimal.ZERO));

        int numAcumulador = 0;
        int ultimoVizinhoDireita = 0;
        for (int i = valor.length() - 1; i >= 0; i--) {
            int atual = SimbolNumeralRomano.fromNumeral(String.valueOf(valor.charAt(i))).getCodigo();
            int multiplicador = 1;

            if (atual < ultimoVizinhoDireita)
                multiplicador = -1;

            numAcumulador += (atual * multiplicador);
            ultimoVizinhoDireita = atual;
        }

        return numAcumulador;
    }
}
