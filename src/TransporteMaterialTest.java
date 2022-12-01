import static org.junit.jupiter.api.Assertions.*;

class TransporteMaterialTest {

	EspacoPorto espacoPorto = new EspacoPorto("Porto", 1, 2, 3);
	EspacoPorto espacoPorto2 = new EspacoPorto("Porto 2", 3, 3, 2);

	@org.junit.jupiter.api.Test
	void calculaDistancia() {
		TransporteMaterial transporteMaterial = new TransporteMaterial(espacoPorto, espacoPorto2, "Ferro", 50.0);

		assertEquals(1000000.0, transporteMaterial.calculaDistancia());
	}

	@org.junit.jupiter.api.Test
	void calculaCusto() {
		TransporteMaterial transporteMaterial = new TransporteMaterial(espacoPorto, espacoPorto2, "Ferro", 50.0);

		assertEquals(2.5E10, transporteMaterial.calculaCusto());
	}

	@org.junit.jupiter.api.Test
	void getPesoCarga() {
		TransporteMaterial transporteMaterial = new TransporteMaterial(espacoPorto, espacoPorto2, "Ferro", 50.0);
		assertEquals(50.0, transporteMaterial.getPesoCarga());
	}
}