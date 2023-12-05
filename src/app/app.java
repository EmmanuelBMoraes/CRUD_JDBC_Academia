package app;

import java.util.Scanner;
import service.AlunoService;
import entities.Aluno;

public class app {
    public static void main(String[] args) {
        //INSERIR 
        Scanner teclado = new Scanner(System.in);
        /*System.out.println("Inserindo novo aluno: ");
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
        }*/
        //FIM INSERIR
        //CONSULTAR
        /*System.out.println("Digite o cpf do aluno a buscar: ");
        String cpf = teclado.nextLine();
        try {
            AlunoService service = new AlunoService();
            Aluno aluno = service.recuperarAluno(cpf);
            System.out.println(aluno.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        //FIM CONSULTAR
        //REMOVER
        System.out.print("Insira o cpf do aluno a ser removido: ");
        String cpf_remover = teclado.nextLine();
        try {
            AlunoService rm_Aluno = new AlunoService();
            rm_Aluno.removerAluno(cpf_remover);
            System.out.println("Aluno removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Aluno não encontrado!");
        }

    }
}
