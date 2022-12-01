import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Espaconave implements Serializable {

	private String nome;

	private EspacoPorto localAtual;

	public Espaconave(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
