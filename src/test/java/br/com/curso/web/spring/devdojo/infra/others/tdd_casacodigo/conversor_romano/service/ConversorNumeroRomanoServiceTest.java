package br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.conversor_romano.service;

import br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.conversor_romano.model.SimbolNumeralRomano;
import br.com.curso.web.spring.devdojo.infra.others.tdd_casacodigo.conversor_romano.negocio.ConversorNumeroRomanoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@Slf4j
public class ConversorNumeroRomanoServiceTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveRetornarUmNumeroInteiroAPartirCodigoNumeralUm() {
        // -- 01_Cenário
        ConversorNumeroRomanoService c = ConversorNumeroRomanoService.builder().build();

        // -- 02_Ação
        int numero = c.converte("I");
        SimbolNumeralRomano numeralRomano = SimbolNumeralRomano.fromCodigo(numero);

        // -- 03_Verificacao-Validacao
        assertEquals(1, numero);
        log.info("{} ", "#TEST: deveRetornarUmNumeroInteiroAPartirCodigoNumeralUm: ");
        log.info("{} ", "Valor: ".concat(numeralRomano.toStringSimples()));
    }

    @Test
    public void deveRetornarUmNumeroInteiroAPartirCodigoNumeralCinco() {
        // -- 01_Cenário
        ConversorNumeroRomanoService c = ConversorNumeroRomanoService.builder().build();

        // -- 02_Ação
        int numero = c.converte("V");
        SimbolNumeralRomano numeralRomano = SimbolNumeralRomano.fromCodigo(numero);

        // -- 03_Verificacao-Validacao
        assertEquals(5, numero);
        log.info("{} ", "#TEST: deveRetornarUmNumeroInteiroAPartirCodigoNumeralCinco: ");
        log.info("{} ", "Valor: ".concat(numeralRomano.toStringSimples()));
    }

    @Test
    public void deveRetornarUmNumeroInteiroAPartirCodigoNumeralDois() {
        // -- 01_Cenário
        ConversorNumeroRomanoService c = ConversorNumeroRomanoService.builder().build();

        // -- 02_Ação
        int numero = c.converteRefatorado("II");

        // -- 03_Verificacao-Validacao
        assertEquals(2, numero);
        log.info("{} ", "#TEST: deveRetornarUmNumeroInteiroAPartirCodigoNumeralDois: ");
        log.info("{} ", "Valor: ".concat(String.valueOf(numero)));
    }

    @Test
    public void deveRetornarUmNumeroInteiroAPartirDeQualquerCodigoNumeralADireita() {
        // -- 01_Cenário
        String valorNumeralRomano = "XXX";
        ConversorNumeroRomanoService c = ConversorNumeroRomanoService.builder().build();

        // -- 02_Ação
        int numero = c.converteRefatorado(valorNumeralRomano);

        // -- 03_Verificacao-Validacao
        assertEquals(30, numero);
        log.info("{} ", "#TEST: deveRetornarUmNumeroInteiroAPartirDeQualquerCodigoNumeralADireita: ");
        log.info("{} ", "Valor: ".concat(String.valueOf(numero)));
    }

    @Test
    public void deveRetornarUmNumeroInteiroAPartirDeQualquerCodigoNumeralMenorAEsquerda() {
        // -- 01_Cenário
        String valorNumeralRomano = "IX";
        ConversorNumeroRomanoService c = ConversorNumeroRomanoService.builder().build();

        // -- 02_Ação
        int numero = c.converteRefatorado(valorNumeralRomano);

        // -- 03_Verificacao-Validacao
        assertEquals(9, numero);
        log.info("{} ", "#TEST: deveRetornarUmNumeroInteiroAPartirDeQualquerCodigoNumeralMenorAEsquerda: ");
        log.info("{} ", "Valor: ".concat(String.valueOf(numero)));
    }

    @Test
    public void deveRetornarUmNumeroInteiroAPartirDeQualquerCodigoNumeralMenorADireita() {
        // -- 01_Cenário
        String valorNumeralRomano = "XXIV";
        ConversorNumeroRomanoService c = ConversorNumeroRomanoService.builder().build();

        // -- 02_Ação
        int numero = c.converteRefatorado(valorNumeralRomano);

        // -- 03_Verificacao-Validacao
        assertEquals(24, numero);
        log.info("{} ", "#TEST: deveRetornarUmNumeroInteiroAPartirDeQualquerCodigoNumeralMenorADireita: ");
        log.info("{} ", "Valor: ".concat(String.valueOf(numero)));
    }
}
