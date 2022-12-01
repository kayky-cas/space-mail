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
		return getDistancia() >= 0.5 ? 100 : 1_000_000;
	}

	@Override
	public double calculaCusto() {
		double calculoTransportado = pesoCarga * 500;
		return calculaDistancia() * calculoTransportado;
	}

	public double getPesoCarga() {
		return pesoCarga;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(
				"""
							\tDescrição do material: %s
							\tPeso da carga: %.2f t
						""", descricaoMaterial, pesoCarga
		);
	}
}
