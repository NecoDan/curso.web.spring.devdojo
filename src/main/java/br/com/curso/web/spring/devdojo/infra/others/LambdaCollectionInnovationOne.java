package br.com.curso.web.spring.devdojo.infra.others;

import java.util.Optional;

class JavaUtilOptional {
    private Optional<String> optionalString;
    private Optional<String> optionalNull;

    public JavaUtilOptional() {
        this.optionalString = Optional.of("Valor presente");
        this.optionalNull = Optional.ofNullable(null);
    }

    public void getValorOpcionalEstahPresente() {
        System.out.println("Valor opcional que estah presente");
    }

    public void getValorOpcionalQueNaoEstahPresente() {
        System.out.println("Valor opcional que nao estah presente");
    }

}

public class LambdaCollectionInnovationOne {
    public static void main(String[] args) {

    }
}
