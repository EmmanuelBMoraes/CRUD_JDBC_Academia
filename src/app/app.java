package app;

import java.util.Scanner;
import service.AlunoService;
import entities.Aluno;

public class app {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o cpf do aluno: ");
        String cpf = teclado.nextLine();
        try {
            AlunoService service = new AlunoService();
            Aluno aluno = service.recuperarAluno(cpf);
            System.out.println(aluno.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
