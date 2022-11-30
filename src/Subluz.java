public class Subluz extends Espaconave {
	private final double LIMITE_VELOCIDAE = 0.3;

	private double velocidadeImpulso;
	private TipoCombustivel tipoCombustivel;

	public Subluz(String nome, double velocidadeImpulso, TipoCombustivel tipoCombustivel) {
		super(nome);
		this.velocidadeImpulso = velocidadeImpulso;
		this.tipoCombustivel = tipoCombustivel;
	}
}
