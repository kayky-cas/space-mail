import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ACMESpace {
	List<EspacoPorto> portos = new ArrayList<>();
	Queue<Transporte> pendentes = new ArrayDeque<>();
	List<Espaconave> disponiveis = new ArrayList<>();
	List<Transporte> transportes = new ArrayList<>();

	public void initialize() {
		Scanner in = new Scanner(System.in);
		int opcao;

		do {
			menu();
			System.out.print("Opção: ");
			opcao = in.nextInt();

			in.nextLine();
			switch (opcao) {
				case 1 -> cadastrarEspacoporto(in);

				case 2 -> cadastrarEspaconave(in);

				case 3 -> cadastroTransporte(in);

				case 4 -> consultaDados();

				case 5 -> alterarEstado(in);

				case 6 ->
					//TODO
						System.out.println("Funcionabilidade indisponível no momento...");
				case 7 -> designarTransporte();

				case 8 -> salvarDados(in);

				case 9 -> carregarDados(in);

				case 0 -> System.out.println("Volte sempre!");
				default -> System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}

	private void designarTransporte() {
		try {
			designarTransporte(pendentes.remove());
		} catch (NoSuchElementException e) {
			System.out.println("Não há nenhum transporte pendente...");
		}
	}

	private void consultaDados() {
		if (transportes.isEmpty()) return;
		for (Transporte transporte : transportes) {
			System.out.println(transporte);
		}
	}

	private void cadastrarEspacoporto(Scanner in) {
		System.out.print("Nome: ");
		String nomePorto = in.nextLine();
		System.out.print("Coordenadas(X, Y e Z): ");
		int cordX = in.nextInt();
		int cordY = in.nextInt();
		int cordZ = in.nextInt();
		EspacoPorto espacoPorto = new EspacoPorto
				(nomePorto, cordX, cordY, cordZ);
		portos.add(espacoPorto);
	}

	private void cadastrarEspaconave(Scanner in) {
		System.out.print("Nome: ");
		String nomeNave = in.nextLine();
		System.out.println("1 - Criar nave Subluz");
		System.out.println("2 - Criar nave FTL");
		int opcaoNave = in.nextInt();
		Espaconave nave = null;
		switch (opcaoNave) {
			case 1 -> {
				System.out.print("Velocidade máxima de impulso: ");
				double velMaxImp = in.nextDouble();
				System.out.println("Tipo de combustível: ");
				System.out.println("1 - Nuclear");
				System.out.println("2 - Íon");
				int combustivel = in.nextInt();

				switch (combustivel) {
					case 1 -> {
						nave = new Subluz(nomeNave, velMaxImp, TipoCombustivel.NUCLEAR);
					}
					case 2 -> {
						nave = new Subluz(nomeNave, velMaxImp, TipoCombustivel.ION);
					}
					default -> System.out.println("Opção inválida, voltando ao menu anterior...");

				}
			}
			case 2 -> {
				System.out.print("Velocidade máxima Wrap: ");
				double velMaxWarp = in.nextDouble();
				System.out.print("Carga limite: ");
				int cargaLimite = in.nextInt();

				nave = new FTL(nomeNave, velMaxWarp, cargaLimite);
			}
		}
		if (nave != null) {
			disponiveis.add(nave);
		}
	}

	private void cadastroTransporte(Scanner in) {
		System.out.print("Código espaço-porto origem: ");
		int codOrigem = in.nextInt();
		System.out.print("Código espaço-porto destino: ");
		int codDestino = in.nextInt();
		System.out.println("1 - Transporte de pessoas");
		System.out.println("2 - Transporte de materiais");
		int opcaoTransporte = in.nextInt();
		EspacoPorto origem = null;
		EspacoPorto destino = null;
		for (EspacoPorto porto : portos) {
			if (porto.getNumero() == codOrigem) {
				origem = porto;
			}
			if (porto.getNumero() == codDestino) {
				destino = porto;
			}
		}
		if (origem == null || destino == null) {
			System.out.println("Porto de origem ou de destino não encontrado...");
			return;
		}
		switch (opcaoTransporte) {
			case 1 -> {
				System.out.print("Quantidade de pessoas: ");
				int quantPessoas = in.nextInt();

				TransportePessoas transportePessoas = new TransportePessoas
						(origem, destino, quantPessoas);
				pendentes.add(transportePessoas);
				transportes.add(transportePessoas);
			}
			case 2 -> {
				in.nextLine();
				System.out.print("Descrição materiais: ");
				String descricao = in.nextLine();
				System.out.println("Carga(toneladas): ");
				double cargaTotal = in.nextDouble();

				TransporteMaterial transporteMaterial = new TransporteMaterial
						(origem, destino, descricao, cargaTotal);
				pendentes.add(transporteMaterial);
				transportes.add(transporteMaterial);
			}
		}
	}

	private void carregarDados(Scanner in) {
		System.out.println("Nome do arquivo (sem extensão) no qual deseja carregar os dados: ");
		String arquivo = in.nextLine();
		DataFile dataFile;
		Path path1 = Paths.get(arquivo + ".json");
		try (BufferedReader reader = Files.newBufferedReader(path1,
				Charset.defaultCharset())) {
			dataFile = new Gson().fromJson(reader.readLine(), DataFile.class);

			dataFile.correctIds();

			transportes = dataFile.getTransportes();
			pendentes.clear();

			transportes.stream()
					.filter(t -> t.getEstadoTransporte() == EstadoTransporte.PENDENTE)
					.forEach(pendentes::add);

			disponiveis = dataFile.getEspaconaves();
			portos = dataFile.getPortos();
		} catch (IOException e) {
			System.err.format("Não foi possivel ler o arquivo por: %s\n", e);
		}
	}

	private void salvarDados(Scanner in) {
		System.out.println("Nome do arquivo (sem extensão) no qual deseja salvar os dados: ");
		String arquivo = in.nextLine();

		DataFile dataFile = new DataFile(transportes, disponiveis, portos);

		String json = new Gson().toJson(dataFile);

		Path path = Paths.get(arquivo + ".json");
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()))) {
			writer.println(json);
		} catch (IOException e) {
			System.out.println("Não foi possível salvar nesse arquivo!");
		}
	}

	private void alterarEstado(Scanner in) {
		Transporte transporteConsulta = null;
		System.out.print("Código do transporte: ");
		int codTransporte = in.nextInt();
		for (Transporte transporte : transportes) {
			if (transporte.getIdentificador() == codTransporte)
				transporteConsulta = transporte;
		}
		if (transporteConsulta == null) return;
		if (transporteConsulta.getEstadoTransporte() == EstadoTransporte.FINALIZADO
				|| transporteConsulta.getEstadoTransporte() == EstadoTransporte.CANCELADO) {
			System.out.println("Estado do transporte indisponível para mudança...");
			return;
		}
		System.out.println("Qual estado deseja atribuir ao transporte:");
		System.out.println("1 - Pendente");
		System.out.println("2 - Transportando");
		System.out.println("3 - Cancelado");
		System.out.println("4 - Finalizado");
		System.out.print("Opção: ");
		int opcaoEstado = in.nextInt();
		if (opcaoEstado < 1 || opcaoEstado > 4) {
			System.out.println("Opção inválida...");
			return;
		}
		EstadoTransporte estadoTransporte = EstadoTransporte.values()[opcaoEstado - 1];
		if (estadoTransporte == EstadoTransporte.TRANSPORTANDO) {
			if (transporteConsulta.getEspaconave() == null) {
				if (!designarTransporte(transporteConsulta)) {
					return;
				}
			}
		} else {
			disponiveis.add(transporteConsulta.getEspaconave());
			transporteConsulta.setEspaconave(null);
		}
		transporteConsulta.setEstadoTransporte(estadoTransporte);
	}

	private boolean designarTransporte(Transporte transporte) {
		Espaconave espaconave;

		if (transporte instanceof TransporteMaterial) {
			espaconave = procuraCargaNave(((TransporteMaterial) transporte).getPesoCarga());
			if (espaconave == null) {
				System.out.println("Não foi possivel achar uma espaçonave que atenda os requisitos da carga...");
				pendentes.add(transporte);
				return false;
			}
		}

		try {
			espaconave = disponiveis.remove(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nenhuma nave disponível no momento...");
			pendentes.add(transporte);
			return false;
		}

		transporte.setEspaconave(espaconave);

		return true;
	}

	public void menu() {
		System.out.println("================================");
		System.out.println("1 - Cadastrar espaço-porto");
		System.out.println("2 - Cadastrar espaçonave");
		System.out.println("3 - Cadastrar transporte");
		System.out.println("4 - Consulta todos transportes");
		System.out.println("5 - Alterar estado de transporte");
		System.out.println("6 - Carregar dados iniciais");
		System.out.println("7 - Designar transportes");
		System.out.println("8 - Salvar dados");
		System.out.println("9 - Carregar dados");
		System.out.println("0 - Finalizar sistema");
		System.out.println("================================");
	}

	public Espaconave procuraCargaNave(double carga) {
		for (Espaconave e : disponiveis) {
			if (e instanceof FTL && ((FTL) e).getLimiteTransporte() >= carga) {
				disponiveis.remove(e);
				return e;
			}
		}

		return null;
	}

}
