public class TransporteMaterial extends Transporte {
	private String descricaoMaterial;
	private double pesoCarga;

	public TransporteMaterial(EspacoPorto origem, EspacoPorto destino, EstadoTransporte estadoTransporte, String descricaoMaterial, double pesoCarga) {
		super(origem, destino, estadoTransporte);
		this.descricaoMaterial = descricaoMaterial;
		this.pesoCarga = pesoCarga;
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
