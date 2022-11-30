public enum TipoCombustivel {
	NUCLEAR("núclear"),
	ION("íon");

	private String descricao;

	TipoCombustivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
