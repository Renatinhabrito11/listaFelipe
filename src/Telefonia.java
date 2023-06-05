import java.util.Scanner;

public class Telefonia {
    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia(int maxPrePagos, int maxPosPagos) {
        prePagos = new PrePago[maxPrePagos];
        numPrePagos = 0;
        posPagos = new PosPago[maxPosPagos];
        numPosPagos = 0;
    }

    public void cadastrarAssinante() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o tipo do assinante (1 para pré-pago, 2 para pós-pago):");
			int tipoAssinante = scanner.nextInt();

			scanner.nextLine(); // Limpar o buffer do scanner

			System.out.println("Digite o CPF do assinante:");
			long cpf = scanner.nextLong();

			scanner.nextLine(); // Limpar o buffer do scanner

			System.out.println("Digite o nome do assinante:");
			String nome = scanner.nextLine();

			System.out.println("Digite o número do telefone do assinante:");
			long numeroTelefone = scanner.nextLong();

			if (tipoAssinante == 1) {
			    if (numPrePagos < prePagos.length) {
			        prePagos[numPrePagos] = new PrePago(cpf, nome, numeroTelefone);
			        numPrePagos++;
			        System.out.println("Assinante pré-pago cadastrado com sucesso.");
			    } else {
			        System.out.println("Não há mais espaço para cadastrar assinantes pré-pagos.");
			    }
			} else if (tipoAssinante == 2) {
			    if (numPosPagos < posPagos.length) {
			        posPagos[numPosPagos] = new PosPago(cpf, nome, nome, numeroTelefone);
			        numPosPagos++;
			        System.out.println("Assinante pós-pago cadastrado com sucesso.");
			    } else {
			        System.out.println("Não há mais espaço para cadastrar assinantes pós-pagos.");
			    }
			} else {
			    System.out.println("Tipo de assinante inválido.");
			}
		}
    }

    public void listarAssinantes() {
        System.out.println("Assinantes pré-pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println("CPF: " + prePagos[i].getClass() + " | Nome: " + prePagos[i].getNome() + " | Número de Telefone: " + prePagos[i].getNumeroTelefone());
        }

        System.out.println("Assinantes pós-pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println("CPF: " + posPagos[i].getClass() + " | Nome: " + posPagos[i].getNome() + " | Número de Telefone: " + posPagos[i].getNumeroTelefone());
        }
    }

    public void fazerChamada() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o tipo do assinante (1 para pré-pago, 2 para pós-pago):");
			int tipoAssinante = scanner.nextInt();

			scanner.nextLine(); // Limpar o buffer do scanner

			System.out.println("Digite o CPF do assinante:");
			long cpf = scanner.nextLong();

			if (tipoAssinante == 1) {
			    PrePago assinante = localizarPrePago(cpf);
			    if (assinante != null) {
			        System.out.println("Digite a duração da chamada em minutos:");
			        int duracao = scanner.nextInt();

			        scanner.nextLine(); // Limpar o buffer do scanner

			        System.out.println("Digite a data da chamada (formato: dd/MM/yyyy):");
			        String data = scanner.nextLine();

			        assinante.fazerChamada(duracao, data);
			    } else {
			        System.out.println("Assinante pré-pago não encontrado.");
			    }
			} else if (tipoAssinante == 2) {
			    PosPago assinante = localizarPosPago(cpf);
			    if (assinante != null) {
			        System.out.println("Digite a duração da chamada em minutos:");
			        int duracao = scanner.nextInt();

			        scanner.nextLine(); // Limpar o buffer do scanner

			        System.out.println("Digite a data da chamada (formato: dd/MM/yyyy):");
			        String data = scanner.nextLine();

			        assinante.fazerChamada(duracao, data);
			    } else {
			        System.out.println("Assinante pós-pago não encontrado.");
			    }
			} else {
			    System.out.println("Tipo de assinante inválido.");
			}
		}
    }

    public void fazerRecarga() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o CPF do assinante pré-pago:");
			long cpf = scanner.nextLong();

			PrePago assinante = localizarPrePago(cpf);
			if (assinante != null) {
			    System.out.println("Digite o valor da recarga:");
			    float valor = scanner.nextFloat();

			    scanner.nextLine(); // Limpar o buffer do scanner

			    System.out.println("Digite a data da recarga (formato: dd/MM/yyyy):");
			    String data = scanner.nextLine();

			    assinante.recarregar(valor, data);
			} else {
			    System.out.println("Assinante pré-pago não encontrado.");
			}
		}
    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getClass() == cpf) {
                return prePagos[i];
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (posPagos[i].getClass() == cpf) {
                return posPagos[i];
            }
        }
        return null;
    }

    public void imprimirFaturas() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o mês das faturas (1 a 12):");
			int mes = scanner.nextInt();

			System.out.println("Faturas dos assinantes pré-pagos:");
			for (int i = 0; i < numPrePagos; i++) {
			    prePagos[i].imprimirFatura(mes);
			}

			System.out.println("Faturas dos assinantes pós-pagos:");
			for (int i = 0; i < numPosPagos; i++) {
			    posPagos[i].imprimirFatura(mes);
			}
		}
    }

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

			    opcao = scanner.nextInt();

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
