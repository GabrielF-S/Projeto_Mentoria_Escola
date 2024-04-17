import java.util.Scanner;

public class Controlador {
    Escola escola;
    Scanner input= new Scanner(System.in);
    public void init() {
        System.out.println("Digite o nome da escola: ");
        String escolaNome = input.nextLine();
        escola = new Escola(escolaNome);
        escola.setControlador(this);

        Turma turma1 = new Turma("1-A");
        escola.adicionarTurma(turma1);
        Turma turma2 = new Turma("1-B");
        escola.adicionarTurma(turma2);
        Turma turma3 = new Turma("1-C");
        escola.adicionarTurma(turma3);

        Aluno aluno1 = new Aluno("John","Doe", 18);
        turma1.adicionarAluno(aluno1);
        escola.adicionarAluno(aluno1);
        Aluno aluno2 = new Aluno("Bill" ,"Doe", 19);
        turma2.adicionarAluno(aluno2);
        escola.adicionarAluno(aluno2);
        Aluno aluno3 = new Aluno("Mary","Doe", 17);
        turma3.adicionarAluno(aluno3);
        escola.adicionarAluno(aluno3);

        menu();


    }

    public void menu(){
        try {
            boolean controleMenu = true;

            while(controleMenu){
                System.out.println("Escola: "+ escola.getNomeEscola());
                System.out.println("-".repeat(10)+ "Menu"+ "-".repeat(10));
                System.out.println("1 - Cadastrar\n2 - Procurar \n3 - Editar\n4 - Excluir");

                System.out.println("Insira o numero da opção do Menu");

                int opcao = input.nextInt();
                switch (opcao) {
                    case 1 -> cadastrarMenu();
                    case 2 -> procurarMenu();
                    case 3 -> atualizarMenu();
                    case 4 -> excluirMenu();
                    default -> {
                        controleMenu = false;
                        System.out.println("Encerrando...");
                    }
                }
            }
        }catch (RuntimeException e){
            System.out.println("ERRO FATAL: FINALIZANDO PROGRAMA");
        }

    }

    private void excluirMenu() {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja excluir: \n1- Turma\n2- Aluno\n3 - Menu Anterior");
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> escola.excluirTurmas();
                case 2 -> escola.excluirAluno();
                case 3 -> {
                    controleMenu = false;
                }
            }
        }
    }

    private void atualizarMenu() {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja editar: \n1- Turma\n2- Aluno\n3 - Menu Anterior");
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> escola.editarTurmas();
                case 2 -> escola.atualizarAluno();
                case 3 -> {
                    controleMenu = false;
                }
            }
        }

    }

    private void procurarMenu() {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja procurar: \n1- Exibir Todas as Turmas\n2- Turma por nome\n3- Aluno\n4- Exibir todos os alunos\n5 - Menu Anterior");
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> escola.localizarTodasTurmas();
                case 2-> this.localizarTurma();
                case 3 -> escola.localizarAluno();
                case 4 -> escola.localizarTodosAlunos();
                case 5 -> {

                    controleMenu = false;
                }
            }
        }
    }

    public void cadastrarMenu(){
        boolean controleMenu = true;

        while(controleMenu){
            System.out.println("Você deseja cadastrar: \n1- Turma\n2- Aluno\n3 - Menu Anterior");
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> escola.cadastrarTurma();
                case 2 -> escola.cadastrarAluno();
                case 3 -> {

                    controleMenu = false;
                }
            }

        }

    }

    public Aluno criarAluno(){

        System.out.println("Digite o nome do aluno");
        String alunoNome = input.nextLine();
        System.out.println("Digite o sobrenome do aluno");
        String sobrenome = input.nextLine();
        System.out.println("Digite o a idade do aluno");
        int idade = input.nextInt();
        input.nextLine();

        return new Aluno(alunoNome,sobrenome,idade);
    }




    public Turma criarTurma() {
        System.out.println("Informar o nome da Turma: ");
        String turmaNome = input.nextLine();
        return new Turma(turmaNome);
    }

    public String novoNomeTurma() {
        System.out.println("Informe o novo nome da turma");

        return input.nextLine();
    }

    public String localizarAluno() {
        System.out.println("Informe o id ou nome do aluno que deseja editar");
        return input.nextLine();
    }

    public void atualizarAluno(Aluno aluno) {
        System.out.println("Informe o nome do aluno: ");
        String novoNome = input.nextLine();
        System.out.println("Informe o sobrenome do aluno: ");
        String novoSobrenome = input.nextLine();
        System.out.println("Informe a idade do aluno: ");
        int novaIdade = input.nextInt();
        input.nextLine();
        aluno.atualizarAluno(novoNome, novoSobrenome, novaIdade);
    }

    public Turma localizarTurma() {
        System.out.println("Informe o nome da turma: ");
        String nomeTurma = input.nextLine();
        return this.escola.localizarTurma(nomeTurma);
    }

    public Turma localizarAlunoTurma(String idAluno) {
        for (Turma turma  : escola.getTurmas()){
            turma.localizarAlunoId(idAluno);
        }
        System.out.println("ERRO: Aluno não localizado!");
        return null;
    }

    public boolean confirmacao(){
        System.out.println("Confirmar a ação? y/n");
        String confirmacao = input.nextLine();
        return confirmacao.equalsIgnoreCase("y") || confirmacao.equalsIgnoreCase("yes") || confirmacao.equalsIgnoreCase("s") || confirmacao.equalsIgnoreCase("sim");

    }
}
