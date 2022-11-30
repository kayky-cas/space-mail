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
}
