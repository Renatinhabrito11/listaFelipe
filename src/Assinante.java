public class Assinante {
    private long cpf;
    private String nome;
    private String numero;
    private int numChamadas;

    public Assinante(long cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.setNumChamadas(0);
    }

    public long getCpf() {
        return cpf;
    }

// garantir que você está sobrescrevendo um método e não criando um novo.
    @Override
    public String toString() {
        return "CPF: " + cpf + "\nNome: " + nome + "\nNúmero: " + numero;
    }

	public int getNumChamadas() {
		return numChamadas;
	}

	public void setNumChamadas(int numChamadas) {
		this.numChamadas = numChamadas;
	}
}
