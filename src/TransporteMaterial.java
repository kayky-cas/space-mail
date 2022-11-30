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
		return 0;
	}

	@Override
	public double calculaCusto() {
		return 0;
	}
}
