public class TransporteMaterial extends Transporte {
	private String descricaoMaterial;
	private double pesoCarga;

	public TransporteMaterial(EspacoPorto origem, EspacoPorto destino, String descricaoMaterial, double pesoCarga) {
		super(origem, destino);
		this.descricaoMaterial = descricaoMaterial;
		this.pesoCarga = pesoCarga;
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
		double calculoTransportado = pesoCarga * 500;
		return calculaDistancia() * calculoTransportado;
	}
}
