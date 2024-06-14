package br.com.mentoria.ibm.projeto_escola.view;

import java.util.Scanner;

public class Inputs {
    Scanner input = new Scanner(System.in);

    public String retornarString(){
        return  input.nextLine();
    }
    public  int retornarInt(){
        int numero = input.nextInt();
        input.nextLine();
        return numero;
    }
}
