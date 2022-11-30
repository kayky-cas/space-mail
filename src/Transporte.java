public abstract class Transporte {

	private static int currentId = 0;

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;

	private EstadoTransporte estadoTransporte;

	public Transporte(EspacoPorto origem, EspacoPorto destino) {
		identificador = currentId++;
		estadoTransporte = EstadoTransporte.PENDENTE;
		this.origem = origem;
		this.destino = destino;
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

	public void setEstadoTransporte(EstadoTransporte estadoTransporte) {
		this.estadoTransporte = estadoTransporte;
	}

	public static void setCurrentId(int id) {
		currentId = id;
	}
	public int getIdentificador() {
		return identificador;
	}

	public EstadoTransporte getEstadoTransporte() {
		return estadoTransporte;
	}
}
