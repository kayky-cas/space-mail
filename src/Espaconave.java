import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Espaconave implements Serializable {

	private String nome;

	public Espaconave(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}


	@Override
	public String toString() {
		return "\t\tNome: " + nome;
	}
}
