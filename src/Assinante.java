public class Assinante {
//    private long cpf;
    private int cpf
    private String nome;
    private String numero;
    private int numChamadas;

//    public Assinante(long cpf, String nome, String numero) {
      public Assinante(int cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.setNumChamadas(0);
    }

//    public long getCpf() {
      public int getCpf() {
        return cpf;
    }

//    @Override
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
