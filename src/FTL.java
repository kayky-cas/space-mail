public class FTL extends Espaconave {
	private double velocidadeImpulso;
	private int limiteTransporte;

	public FTL(String nome, double velocidadeImpulso, int limiteTransporte) {
		super(nome);
		this.velocidadeImpulso = velocidadeImpulso;
		this.limiteTransporte = limiteTransporte;
	}

//	@Override
//	public String toJson() {
//		return null;
//	}
}
