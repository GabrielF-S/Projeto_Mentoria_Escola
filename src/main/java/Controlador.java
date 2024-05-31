import java.util.Scanner;

public class Controlador {
    Escola escola;
    Scanner input= new Scanner(System.in);
    public void init() throws Exception {

        String escolaNome = solicitarNomeEscola();
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
    public void menu() throws Exception {
        try {
            boolean controleMenu = true;

            while(controleMenu){
                System.out.println("main.Escola: "+ escola.getNomeEscola());
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

    private void excluirMenu() throws Throwable {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja excluir: \n1- main.Turma\n2- main.Aluno\n3 - Menu Anterior");
            int opcao = selecionarOpcao();
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

    private void atualizarMenu() throws Exception {
        boolean controleMenu = true;
        while(controleMenu) {
            System.out.println("Você deseja editar: \n1- main.Turma\n2- main.Aluno\n3 - Menu Anterior");
            int opcao = selecionarOpcao();
            input.nextLine();
            switch (opcao) {
                case 1 -> escola.editarTurmas();
                case 2 -> escola.editarAluno();
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

    public void cadastrarMenu() throws Exception {
        boolean controleMenu = true;

        while(controleMenu){
            System.out.println("Você deseja cadastrar: \n1- main.Turma\n2- main.Aluno\n3 - Menu Anterior");
            int opcao = selecionarOpcao();
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
    public int selecionarOpcao(){
        int opcao =  input.nextInt();
        return opcao;
    }

    public Aluno criarAluno(){
        String alunoNome = solicitarNomeAluno();
        String sobrenome = solicitarSobrenomeAluno();
        int idade = solicitarIdadeAluno();

        return new Aluno(alunoNome,sobrenome,idade);
    }



    public Turma criarTurma() {
        String turmaNome = solicitarNomeTurma();
        return new Turma(turmaNome);
    }

    public String novoNomeTurma() {
        String novoNomeTurma = this.solicitarNomeTurma();
        return novoNomeTurma;
    }

    public String localizarAluno() {
       String nomeAluno = solicitarNomeAlunoOuID();
        return nomeAluno;
    }

    public String solicitarNomeAlunoOuID() {
        System.out.println("Informe o nome ou o ID do aluno");
       return input.nextLine();
    }

    public Aluno atualizarAluno(Aluno aluno) {
        String novoNome = this.solicitarNomeAluno();
        String novoSobrenome = this.solicitarSobrenomeAluno();
        int novaIdade = this.solicitarIdadeAluno();
       return aluno.atualizarAluno(novoNome, novoSobrenome, novaIdade);
    }

    public String solicitarNomeAluno(){
        System.out.println("Informe o nome do aluno: ");
        String novoNome = input.nextLine();
        return novoNome;
    }
    public String solicitarSobrenomeAluno(){
        System.out.println("Informe o sobrenome do aluno: ");
        String novoSobrenomee = input.nextLine();
        return novoSobrenomee;
    }
    public int solicitarIdadeAluno(){
        System.out.println("Informe a idade do aluno: ");
        int novaidade = input.nextInt();
        return novaidade;
    }
    public String solicitarNomeTurma(){
        System.out.println("Informe o nome da turma: ");
        String nomeTurma = input.nextLine();
        return nomeTurma;
    }

    public Turma localizarTurma() throws Exception {
        String nomeTurma = solicitarNomeTurma();
        return this.escola.localizarTurma(nomeTurma);
    }

    public Aluno localizarAlunoTurma(String idAluno) {
        for (Turma turma  : escola.getTurmas()){
          Aluno aluno = turma.localizarAlunoId(idAluno);
          if (aluno!=null){
              return aluno;
          }
        }
        System.out.println("ERRO: Aluno não localizado!");
        return null;
    }

    public boolean confirmacao(){
        String confirmacao = solicitarConfirmacao();
        return confirmacao.equalsIgnoreCase("y") ||
                confirmacao.equalsIgnoreCase("yes") ||
                confirmacao.equalsIgnoreCase("s") ||
                confirmacao.equalsIgnoreCase("sim");

    }

    public String solicitarConfirmacao(){
        System.out.println("Confirmar a ação? y/n");
        String confirmacao = input.nextLine();
        return  confirmacao;
    }

    public String solicitarNomeEscola(){
        System.out.println("Digite o nome da escola: ");
        String escolaNome = input.nextLine();
        return  escolaNome;
    }
}
