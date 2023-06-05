import java.util.GregorianCalendar;

public class PrePago {
    private Recarga[] recargas;
    private int numRecargas;
    private float creditos;

    public PrePago(long cpf, String nome, long numeroTelefone) {
        recargas = new Recarga[90]; // Define o tamanho inicial do vetor de recargas
        numRecargas = 0;
        creditos = 0;
    }

    public void fazerChamada(int duracao, String data) {
        if (numRecargas == 0) {
            System.out.println("Não há recargas feitas. Faça uma recarga para poder fazer chamadas.");
            return;
        }

        float custoChamada = 1.45f * data;

        if (creditos >= custoChamada) {
            // Fazer a chamada e atualizar os créditos
            creditos -= custoChamada;
            // Armazenar a chamada no vetor chamadas
            // ...
            System.out.println("Chamada realizada com sucesso!");
        } else {
            System.out.println("Créditos insuficientes. Faça uma recarga para poder fazer chamadas.");
        }
    }

    public void recarregar(float valor, String data) {
        if (numRecargas >= recargas.length) {
            System.out.println("Não há mais espaço para recargas.");
            return;
        }

        // Fazer a recarga e atualizar o número de recargas e os créditos
        // ...
        System.out.println("Recarga realizada com sucesso!");
    }

    public void imprimirFatura(int mes) {
        // Imprimir os dados do assinante
        // ...
        // Imprimir as chamadas feitas no mês
        // ...
        // Imprimir as recargas feitas no mês
        // ...
        // Imprimir o valor total de chamadas e recargas do mês e os créditos
        // ...
    }

	public String getNumeroTelefone() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
}
