import java.util.GregorianCalendar;

public class PosPago {
    private float assinatura;
    private Chamada[] chamadas;
    private int numChamadas;

    public PosPago(long cpf, String nome, String numero, float assinatura) {
        this.assinatura = assinatura;
        chamadas = new Chamada[100]; // Define o tamanho inicial do vetor de chamadas
        numChamadas = 0;
    }

    public void fazerChamada(int duracao, String data) {
        if (numChamadas >= chamadas.length) {
            System.out.println("Não há mais espaço para armazenar chamadas.");
            return;
        }

        float custoChamada = 1.04f * data;

        // Armazenar a chamada no vetor chamadas
        // ...

        numChamadas++;

        System.out.println("Chamada registrada com sucesso!");
    }

    public void imprimirFatura(int mes) {
        // Imprimir os dados do assinante
        // ...
        // Imprimir as chamadas feitas no mês
        // ...

        float valorTotalFatura = assinatura;

        // Calcular o valor total da fatura (assinatura + custo das chamadas)
        // ...

        System.out.println("Valor total da fatura: R$" + valorTotalFatura);
    }

	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNumeroTelefone() {
		// TODO Auto-generated method stub
		return null;
	}

)

