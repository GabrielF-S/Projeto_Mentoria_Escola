package br.com.mentoria.ibm.notas_sender.service;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message){
        super(message);
    }
}
