package app;

import java.util.Scanner;
import service.AlunoService;
import entities.Aluno;

public class app02 {
	static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            Menu.options();
            String opc=input.next();
            switch (opc) {
            case "1":
            	Menu.optionAluno();
            	break;
            case "2":
            	Menu.optionFicha();
            	break;
            case "3":
            	break;
            case "4":
            	break;
            }
        }
    }
}

