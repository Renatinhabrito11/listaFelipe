import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Telefonia telefonia = new Telefonia(100, 100);
        try (Scanner scanner = new Scanner(System.in)) {
			int opcao;
			do {
			    System.out.println("Selecione uma opção:");
			    System.out.println("1. Cadastrar assinante");
			    System.out.println("2. Listar assinantes");
			    System.out.println("3. Fazer chamada");
			    System.out.println("4. Fazer recarga");
			    System.out.println("5. Imprimir faturas");
			    System.out.println("0. Sair");

			    // Verifica se há um próximo valor inteiro disponível
			    if (scanner.hasNextInt()) {
			        opcao = scanner.nextInt();
			        scanner.nextLine(); // Limpa o buffer
			    } else {
			        System.out.println("Opção inválida. Tente novamente.");
			        scanner.nextLine(); // Limpa o buffer
			        opcao = -1;
			        continue;
			    }

			    switch (opcao) {
			        case 1:
			            telefonia.cadastrarAssinante();
			            break;
			        case 2:
			            telefonia.listarAssinantes();
			            break;
			        case 3:
			            telefonia.fazerChamada();
			            break;
			        case 4:
			            telefonia.fazerRecarga();
			            break;
			        case 5:
			            telefonia.imprimirFaturas();
			            break;
			        case 0:
			            System.out.println("Saindo...");
			            break;
			        default:
			            System.out.println("Opção inválida.");
			            break;
			    }
			} while (opcao != 0);
		}
    }
}