public abstract class Transporte {

	private static int currentId = 0;

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;

	private EstadoTransporte estadoTransporte;

	public Transporte(EspacoPorto origem, EspacoPorto destino, EstadoTransporte estadoTransporte) {
		identificador = currentId++;
		this.origem = origem;
		this.destino = destino;
		this.estadoTransporte = estadoTransporte;
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

	public static void setCurrentId(int id) {
		currentId = id;
	}
}
