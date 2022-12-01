import java.util.List;
import java.util.List;

public class DataFile {
	private List<Transporte> transportes;
	private List<Espaconave> espaconaves;
	private List<EspacoPorto> portos;

	private int portoCurrentId;
	private int transporteCurrentId;

	public DataFile(List<Transporte> transportes, List<Espaconave> espaconaves, List<EspacoPorto> portos) {
		this.transportes = transportes;
		this.espaconaves = espaconaves;
		this.portos = portos;
		portoCurrentId = EspacoPorto.getCurrentId();
		transporteCurrentId = Transporte.getCurrentId();
	}


	public List<Transporte> getTransportes() {
		return transportes;
	}

	public List<Espaconave> getEspaconaves() {
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
