package app;

import java.util.Scanner;
import service.AlunoService;
import entities.Aluno;

public class app {
    static Scanner teclado = new Scanner(System.in);
    public static boolean consultar(){
        String cpf = consultarCPF();
        try {
            AlunoService service = new AlunoService();
            Aluno aluno = service.recuperarAluno(cpf);
            if (aluno == null){
                System.out.println("Aluno não encontrado!");
                return false;
            }
            System.out.println("\nNome: "+aluno.getNome());
            System.out.println("Ficha: "+aluno.getIdFicha());
            if(aluno.getRua() == null){
                    System.out.println("Rua: Não informado");
                }
                else{System.out.println("Rua: "+aluno.getRua());}
            System.out.println("Matrícula: "+aluno.getMatricula());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static String consultarCPF(){
        System.out.print("Digite o cpf do aluno: ");
        String cpf = teclado.nextLine();
        try {
            AlunoService service = new AlunoService();
            Aluno aluno = service.recuperarAluno(cpf);
            if (aluno == null){
                cpf = null;
                return cpf;
            }
            cpf = aluno.getCPF();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cpf;
    }

    public static void atualizar(){
        System.out.println("Atualização de aluno........");
        String cpf = consultarCPF();
        if(cpf != null){
            try {
                AlunoService consulta_aluno = new AlunoService();
                String cpf_aluno = cpf; 
                System.out.print("Digite o novo nome do aluno: ");
                String nome = teclado.nextLine();
                System.out.print("Digite a nova matricula do aluno: ");
                String mat = teclado.nextLine();
                System.out.print("Digite a nova rua do aluno: ");
                String rua = teclado.nextLine();
                System.out.println("Digite a nova ficha do aluno: ");
                int ficha = teclado.nextInt();
                teclado.nextLine();
                Aluno aluno = new Aluno(cpf_aluno, nome, mat, rua, ficha);

                if(consulta_aluno.atualizarAluno(aluno)) System.out.println("Atualizado com sucesso!");
                else{System.out.println("Aluno não encontrado!");}
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else{System.out.println("Erro, Aluno não encontrado");}
    }

    public static void deletar(){
        System.out.print("Insira o cpf do aluno a ser removido: ");
        String cpf_remover = teclado.nextLine();
        try {
            AlunoService rm_Aluno = new AlunoService();
            if(rm_Aluno.removerAluno(cpf_remover)) System.out.println("Aluno removido com sucesso!");
            else{System.out.println("Aluno não encontrado!");}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inserir(){
        System.out.println("Inserindo novo aluno");
        System.out.print("Digite o cpf do aluno: ");
        String cpfInserir = teclado.nextLine();
        System.out.print("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.print("Digite a matricula do aluno: ");
        String mat = teclado.nextLine();
        System.out.print("Digite o nome da rua: ");
        String rua = teclado.nextLine();
        System.out.print("Digite o id da ficha do aluno: ");
        int id_ficha_aluno = teclado.nextInt();
        teclado.nextLine();
        Aluno alunoInserir = new Aluno(cpfInserir, nome, mat, rua, id_ficha_aluno);
        try {
            AlunoService serviceInserir = new AlunoService();
            serviceInserir.salvarAluno(alunoInserir);
            System.out.println("Aluno inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Aluno não inserido!");
        }
    }

    public static void listarTodos(){
        try {
            AlunoService service = new AlunoService();
            if(service.listarAlunos().size() < 1){
                    System.out.println("Nenhum aluno encontrado!");
                    return;
                }
            for(Aluno aluno: service.listarAlunos()){
                System.out.println("Nome: "+aluno.getNome());
                System.out.println("Ficha: "+aluno.getIdFicha());
                if(aluno.getRua() == null){
                    System.out.println("Rua: Não informado");
                }
                else{System.out.println("Rua: "+aluno.getRua());}
                System.out.println("Matrícula: "+aluno.getMatricula()+"\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deletarTodos(){
        try {
            AlunoService service = new AlunoService();
            if(service.deletarTodos()) System.out.println("Operação concluída com sucesso!");
            else{System.out.println("Falha na operação.......");}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDigite 1 para: inserir um aluno.\nDigite 2 para consultar um aluno por cpf.\nDigite 3 para listar todos os alunos.\nDigite 4 para atualizar um aluno.\nDigite 5 para deletar um aluno\nDigite 6 para deletar TODOS os alunos.\nDigite 0 para sair.");
            System.out.print("Digite a opção escolhida: ");
            String option = teclado.next();
            teclado.nextLine();
            System.out.println("\n");
            switch (option) {
                case "0":
                    return;
                case "1":
                    inserir();
                    break;
                case "2":
                    consultar();
                    break;
                case "3":
                    listarTodos();
                    break;
                case "4":
                    atualizar();
                    break;
                case "5":
                    deletar();
                    break;
                case "6":
                    deletarTodos();
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA........");
                    break;
            }
        }
    }
}
