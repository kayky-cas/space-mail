public abstract class Transporte {
	protected static final int DISTANCIA_ANOS_LUZ = 10;

	private static int currentId = 0;

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;

	private EstadoTransporte estadoTransporte;

	private Espaconave espaconave;

	public Transporte(EspacoPorto origem, EspacoPorto destino) {
		identificador = currentId++;
		estadoTransporte = EstadoTransporte.PENDENTE;
		this.origem = origem;
		this.destino = destino;
		espaconave = null;
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

	public void setEstadoTransporte(EstadoTransporte estadoTransporte) {
		this.estadoTransporte = estadoTransporte;
	}

	public static void setCurrentId(int id) {
		currentId = id;
	}

	public EspacoPorto getOrigem() {
		return origem;
	}

	public EspacoPorto getDestino() {
		return destino;
	}

	public void setEspaconave(Espaconave espaconave) {
		this.espaconave = espaconave;
		estadoTransporte = EstadoTransporte.TRANSPORTANDO;
	}
}
