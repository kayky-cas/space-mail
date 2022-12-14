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

	public static int getCurrentId() {
		return currentId;
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

	public EspacoPorto getOrigem() {
		return origem;
	}

	public EspacoPorto getDestino() {
		return destino;
	}

	public Espaconave getEspaconave() {
		return espaconave;
	}

	public void setEspaconave(Espaconave espaconave) {
		this.espaconave = espaconave;
		estadoTransporte = EstadoTransporte.TRANSPORTANDO;
	}

	public double getDistancia() {
		double dX = Math.abs(getOrigem().getCoordX() - getDestino().getCoordX());
		double dY = Math.abs(getOrigem().getCoordY() - getDestino().getCoordY());
		double dZ = Math.abs(getOrigem().getCoordZ() - getDestino().getCoordZ());

		return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2) + Math.pow(dZ, 2)) / Transporte.DISTANCIA_ANOS_LUZ;
	}

	@Override
	public String toString() {
		return String.format(
				"""
							Transporte nº %d:
							\tOrigem:
							%s
							\tDestino:
							%s
							\tDistância: %.2f anos-luz
							\tEstado de transporte: %s
							%s\tCusto: C$ %.2f
						""",
				identificador,
				origem.toString(),
				destino.toString(),
				getDistancia(),
				estadoTransporte.toString(),
				espaconave == null ? "" : "\tNave:\n" + espaconave + "\n", calculaCusto());
	}
}
