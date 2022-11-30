import java.util.ArrayList;
import java.util.List;

public abstract class Espaconave {

	private String nome;

	private EspacoPorto localAtual;

	private List<Transporte> transportes;

	public Espaconave(String nome) {
		this.nome = nome;
		transportes = new ArrayList<>();
	}
}
