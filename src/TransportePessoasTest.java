import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportePessoasTest {
	EspacoPorto espacoPorto = new EspacoPorto("Porto", 1, 2, 3);
	EspacoPorto espacoPorto2 = new EspacoPorto("Porto 2", 3, 3, 2);

	@Test
	void calculaDistancia() {
		TransportePessoas transportePessoas = new TransportePessoas(espacoPorto, espacoPorto2, 100);

		assertEquals(1000000.0, transportePessoas.calculaDistancia());
	}

	@Test
	void calculaCusto() {
		TransportePessoas transportePessoas = new TransportePessoas(espacoPorto, espacoPorto2, 100);

		assertEquals(1.0E10, transportePessoas.calculaCusto());
	}
}