public class EspacoPorto {

	private static int currentId = 0;

	private int numero;

	private String nome;

	private double coordX;

	private double coordY;

	private double coordZ;

	public EspacoPorto(String nome, double coordX, double coordY, double coordZ) {
		this.numero = currentId++;
		this.nome = nome;
		this.coordX = coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;
	}

	public int getNumero() {
		return numero;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public double getCoordZ() {
		return coordZ;
	}

	public static int getCurrentId() {
		return currentId;
	}

	public static void setCurrentId(int currentId) {
		EspacoPorto.currentId = currentId;
	}

	@Override
	public String toString() {
		return String.format(
				"""
							\t\tPorto nº %d:
							\t\t\tNome: %s
							\t\t\tCoordenadas: (%.2f, %.2f, %.2f)
						""", numero, nome, coordX, coordY, coordZ);
	}
}
