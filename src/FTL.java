public class FTL extends Espaconave {
	private double velocidadeImpulso;
	private double limiteTransporte;

	public FTL(String nome, double velocidadeImpulso, double limiteTransporte) {
		super(nome);
		this.velocidadeImpulso = velocidadeImpulso;
		this.limiteTransporte = limiteTransporte;
	}

	public double getLimiteTransporte() {
		return limiteTransporte;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(
				"""
						\t\tVelocidade máxima de impulso: %.2f Warp
						\t\tLimite de carga: %.2f t
						""", velocidadeImpulso, limiteTransporte);
	}
}
