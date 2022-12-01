public class TransportePessoas extends Transporte {
	private int quantidadePessoas;

	public TransportePessoas(EspacoPorto origem, EspacoPorto destino, int quantidadePessoas) {
		super(origem, destino);
		this.quantidadePessoas = quantidadePessoas;
	}

	@Override
	public double calculaDistancia() {
		return getDistancia() >= 0.5 ? 100 : 1_000_000;
	}

	@Override
	public double calculaCusto() {
		double calculoTransportado = quantidadePessoas * 100;
		return calculaDistancia() * calculoTransportado;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(
				"""
							\tQuantidade de pessoas: %d
						""", quantidadePessoas
		);
	}
}
