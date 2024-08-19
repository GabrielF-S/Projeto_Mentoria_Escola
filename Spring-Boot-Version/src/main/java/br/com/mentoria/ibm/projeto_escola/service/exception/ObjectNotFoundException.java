package br.com.mentoria.ibm.projeto_escola.service.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message){
        super(message);
    }
}
