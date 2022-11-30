public abstract class Transporte {

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;


	private EstadoTransporte estadoTransporte;

	public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino, EstadoTransporte estadoTransporte) {
		this.identificador = identificador;
		this.origem = origem;
		this.destino = destino;
		this.estadoTransporte = estadoTransporte;
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

}
