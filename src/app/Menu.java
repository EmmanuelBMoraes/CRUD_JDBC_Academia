package app;

import java.util.Scanner;

import entities.Aluno;
import service.AlunoService;

public class Menu {
	static Scanner input = new Scanner(System.in);
	
	public static String consultarCPF(){
        System.out.print("Informe o CPF: ");
        String cpf = input.nextLine();
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
	
    public static void options(){
        System.out.println("===Menu===");
        System.out.println("1. Aluno");
        System.out.println("2. Ficha");
        System.out.println("3. Matricula");
        System.out.println("4. Funcionário");
    }
    public static void optionAluno(){
    	while (true) {
        System.out.println("===== Menu Aluno =====");
        System.out.println("1. Create Aluno");
        System.out.println("2. Update Aluno");
        System.out.println("3. List Aluno");
        System.out.println("4. Delete Aluno");
        System.out.println("5. Return");
        String opc=input.next();
        input.nextLine();
        switch (opc) {
		case "1": 
			System.out.print("CPF do aluno: ");
	        String cpfInserir = input.nextLine();
	        System.out.print("Nome do aluno: ");
	        String nome = input.nextLine();
	        System.out.print("Matrícula do aluno: ");
	        String mat = input.nextLine();
	        System.out.print("Nome da rua: ");
	        String rua = input.nextLine();
	        System.out.print("Id da ficha do aluno: ");
	        int id_ficha_aluno = input.nextInt();
	        input.nextLine();
	        Aluno alunoInserir = new Aluno(cpfInserir, nome, mat, rua, id_ficha_aluno);
	        try {
	            AlunoService serviceInserir = new AlunoService();
	            if(serviceInserir.salvarAluno(alunoInserir)) System.out.println("Aluno cadastrado com sucesso!");
	            else{System.out.println("Erro na inserção do aluno!");}
	        } catch (Exception e) {
	            System.out.println("Aluno não inserido!");
	        }
	        break;
		case "2":
			System.out.println("Atualização de aluno........");
	        String cpf = consultarCPF();
	        if(cpf != null){
	            try {
	                AlunoService consulta_aluno = new AlunoService();
	                String cpf_aluno = cpf; 
	                System.out.print("Digite o novo nome do aluno: ");
	                String nomeA = input.nextLine();
	                System.out.print("Digite a nova matricula do aluno: ");
	                String matA = input.nextLine();
	                System.out.print("Digite a nova rua do aluno: ");
	                String ruaA = input.nextLine();
	                System.out.println("Digite a nova ficha do aluno: ");
	                int ficha = input.nextInt();
	                input.nextLine();
	                Aluno aluno = new Aluno(cpf_aluno, nomeA, matA, ruaA, ficha);

	                if(consulta_aluno.atualizarAluno(aluno)) System.out.println("Atualizado com sucesso!");
	                else{System.out.println("Aluno não encontrado!");}
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	                System.out.println("Ocorreu um erro!");
	            }
	        }
	        else{System.out.println("Erro, Aluno não encontrado");}
			break;
		case "3":
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
			break;
		case "4":
			System.out.print("Insira o cpf do aluno a ser removido: ");
	        String cpf_remover = input.nextLine();
	        try {
	            AlunoService rm_Aluno = new AlunoService();
	            if(rm_Aluno.removerAluno(cpf_remover)) System.out.println("Aluno removido com sucesso!");
	            else{System.out.println("Aluno não encontrado!");}
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
			break;
		case "5":
			return;
			default:
				System.out.println("Opção inválida!");
	        }
    	}
    }
    public static void optionFicha(){
        System.out.println("===== Menu Ficha =====");
        System.out.println("1. Create Ficha");
        System.out.println("2. Update Ficha");
        System.out.println("3. List Ficha");
        System.out.println("4. Delete Ficha");
        System.out.println("5. Return");
    }
}
