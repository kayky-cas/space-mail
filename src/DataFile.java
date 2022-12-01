import java.util.List;
import java.util.Queue;

public class DataFile {
	private List<Transporte> transportes;
	private Queue<Espaconave> espaconaves;
	private List<EspacoPorto> portos;

	private int portoCurrentId;
	private int transporteCurrentId;

	public DataFile(List<Transporte> transportes, Queue<Espaconave> espaconaves, List<EspacoPorto> portos) {
		this.transportes = transportes;
		this.espaconaves = espaconaves;
		this.portos = portos;
		portoCurrentId = EspacoPorto.getCurrentId();
		transporteCurrentId = Transporte.getCurrentId();
	}


	public List<Transporte> getTransportes() {
		return transportes;
	}

	public Queue<Espaconave> getEspaconaves() {
		return espaconaves;
	}

	public List<EspacoPorto> getPortos() {
		return portos;
	}

	public void correctIds() {
		Transporte.setCurrentId(transporteCurrentId);
		EspacoPorto.setCurrentId(portoCurrentId);
	}
}
