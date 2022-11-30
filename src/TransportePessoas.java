public class TransportePessoas extends Transporte {
	private int quantidadePessoas;

	public TransportePessoas(int identificador, EspacoPorto origem, EspacoPorto destino, EstadoTransporte estadoTransporte, int quantidadePessoas) {
		super(identificador, origem, destino, estadoTransporte);
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
