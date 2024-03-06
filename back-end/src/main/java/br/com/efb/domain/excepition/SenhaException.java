package br.com.efb.domain.excepition;

public class SenhaException extends RuntimeException {

    public SenhaException(){
        super("Senha invalida");
    }
}
