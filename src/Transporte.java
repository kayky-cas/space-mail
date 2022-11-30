public abstract class Transporte {

	private int identificador;

	private EspacoPorto origem;

	private EspacoPorto destino;

	public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino) {

	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

}
