public class TransportePessoas extends Transporte {
	private int quantidadePessoas;

	public TransportePessoas(EspacoPorto origem, EspacoPorto destino, int quantidadePessoas) {
		super(origem, destino);
		this.quantidadePessoas = quantidadePessoas;
	}

	@Override
	public double calculaDistancia() {
		double dX = Math.abs(getOrigem().getCoordX() - getDestino().getCoordX());
		double dY = Math.abs(getOrigem().getCoordY() - getDestino().getCoordY());
		double dZ = Math.abs(getOrigem().getCoordZ() - getDestino().getCoordZ());

		double distancia = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2) + Math.pow(dZ, 2)) / Transporte.DISTANCIA_ANOS_LUZ;

		return distancia >= 0.5 ? 100 : 1_000_000;
	}

	@Override
	public double calculaCusto() {
		double calculoTransportado = quantidadePessoas * 100;
		return calculaDistancia() * calculoTransportado;
	}
}
