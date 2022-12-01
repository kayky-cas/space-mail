public class Subluz extends Espaconave {
	private final double LIMITE_VELOCIDAE = 0.3;

	private double velocidadeImpulso;
	private TipoCombustivel tipoCombustivel;

	public Subluz(String nome, double velocidadeImpulso, TipoCombustivel tipoCombustivel) {
		super(nome);
		this.velocidadeImpulso = velocidadeImpulso;
		this.tipoCombustivel = tipoCombustivel;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(
				"""
						\t\tVelocidade máxima: %.2f Warp
						\t\tTipo de combustível: %s
						""", velocidadeImpulso, tipoCombustivel.toString());
	}
}
