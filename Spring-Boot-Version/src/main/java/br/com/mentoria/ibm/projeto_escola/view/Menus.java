package br.com.mentoria.ibm.projeto_escola.view;

import br.com.mentoria.ibm.projeto_escola.controller.EscolaService;
import br.com.mentoria.ibm.projeto_escola.controller.EscolaServiceImpl;
import br.com.mentoria.ibm.projeto_escola.model.Escola;

import java.util.Scanner;
public class Menus {
    Escola escola;
    Scanner input= new Scanner(System.in);

    EscolaService escolaService = new EscolaServiceImpl();

    public void init() throws Exception {

        escola = escolaService.criarEscola();
        menu();
    }
    public void menu() throws Exception {
        try {
            boolean controleMenu = true;

            while(controleMenu){
                System.out.println("Escola: "+ escolaService.obterNomeEscola());
                System.out.println("-".repeat(10)+ "Menu"+ "-".repeat(10));
                System.out.println("1 - Cadastrar\n2 - Procurar \n3 - Editar\n4 - Excluir");
                System.out.println("Insira o numero da opção do Menu");
                int opcao = selecionarOpcao();
                switch (opcao) {
                    case 1 -> this.cadastrarMenu();
                    case 2 -> this.procurarMenu();
                    case 3 -> this.atualizarMenu();
                    case 4 -> this.excluirMenu();
                    default -> {
                        controleMenu = false;
                        System.out.println("Encerrando...");
                    }
                }
            }
        }catch (Throwable e){
            System.out.println("ERRO FATAL: FINALIZANDO PROGRAMA");
        }

    }

    public void cadastrarMenu() throws Exception {
        boolean controleMenu = true;
        while(controleMenu){
            System.out.println("Você deseja cadastrar: \n1- Turma\n2- Aluno\n3 - Menu Anterior");
            int opcao = selecionarOpcao();
            switch (opcao) {
                case 1 -> escolaService.cadastrarTurma();
                case 2 -> escolaService.cadastrarAluno();
                case 3 -> {

                    controleMenu = false;
                }
            }

        }

    }

    private void procurarMenu() throws Exception {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja procurar: \n1- Exibir Todas as Turmas\n2- Turma por nome\n3- Aluno" +
                    "\n4- Exibir todos os alunos\n5 - Menu Anterior");
            int opcao = selecionarOpcao();
            switch (opcao) {
                case 1 -> escolaService.localizarTodasTurmas();
                case 2 -> escolaService.localizarTurma();
                case 3 -> escolaService.localizarAluno();
                case 4 -> escolaService.localizarTodosAlunos();
                case 5 -> {
                    controleMenu = false;
                }
            }
        }
    }

    private void atualizarMenu() throws Exception {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja editar: \n1- Turma\n2- Aluno\n3 - Menu Anterior");
            int opcao = selecionarOpcao();
            input.nextLine();
            switch (opcao) {
                case 1 -> escolaService.editarTurma();
                case 2 -> escolaService.editarAluno();
                case 3 -> {
                    controleMenu = false;
                }
            }
        }

    }

    private void excluirMenu() throws Throwable {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja excluir: \n1- Turma\n2- Aluno\n3 - Menu Anterior");
            int opcao = selecionarOpcao();
            input.nextLine();
            switch (opcao) {
                case 1 -> escolaService.excluirTurma();
                case 2 -> escolaService.excluirAluno();
                case 3 -> {
                    controleMenu = false;
                }
            }
        }
    }
    public int selecionarOpcao(){
        return input.nextInt();
    }

}
