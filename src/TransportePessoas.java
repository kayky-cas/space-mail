public class TransportePessoas extends Transporte {
	private int quantidadePessoas;

	public TransportePessoas(EspacoPorto origem, EspacoPorto destino, int quantidadePessoas) {
		super(origem, destino);
		this.quantidadePessoas = quantidadePessoas;
	}

	@Override
	public double calculaDistancia() {
		return 0;
	}

	@Override
	public double calculaCusto() {
		return 0;
	}
}
