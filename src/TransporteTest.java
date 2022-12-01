import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransporteTest {
	EspacoPorto espacoPorto = new EspacoPorto("Porto", 1, 2, 3);
	EspacoPorto espacoPorto2 = new EspacoPorto("Porto 2", 3, 3, 2);


	@Test
	void getDistancia() {
		TransportePessoas transportePessoas = new TransportePessoas(espacoPorto, espacoPorto2, 100);

		assertEquals(0.2449489742783178, transportePessoas.getDistancia());

	}
}