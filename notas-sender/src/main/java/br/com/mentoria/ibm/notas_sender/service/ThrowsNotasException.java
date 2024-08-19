package br.com.mentoria.ibm.notas_sender.service;

public class ThrowsNotasException extends  RuntimeException{

    public ThrowsNotasException(String message){
        super(message);
    }
}
