import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel painel;
    private JButton carregarArquivoButton;
    private JButton salvarArquivoButton;
    private JButton cadastrarEspaçoportoButton;
    private JButton cadastrarEspaçonaveButton;
    private JButton cadastrarTransporteButton;

    private DefaultTableModel tblModel;
    private JTextField nomeArquivo;
    private JTextField nomeArquivoSalvar;
    private JTable tabela;

    public App() {
        super();
        this.setContentPane(painel);
        this.setTitle("Trabalho 3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(1200, 900);
        this.setVisible(true);


        cadastrarEspaçoportoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField campoNum = new JTextField();
                JTextField campoNome = new JTextField();
                JTextField coordenadaX = new JTextField();
                JTextField coordenadaY = new JTextField();
                JTextField coordenadaZ = new JTextField();
                Object[] fields = {
                        "Codigo", campoNum,
                        "Field 2", campoNome,
                        "Coordenada X", coordenadaX,
                        "Coordenada Y", coordenadaY,
                        "Coordenada Z", coordenadaZ
                };
                int escolha = JOptionPane.showConfirmDialog(painel, fields, "Cadastrar nave", 0);
                if (escolha == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(painel, "espaçoporto cadastrado!");

                }
            }
        });
        cadastrarEspaçonaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField campoNome = new JTextField();
                JTextField codPorto = new JTextField();
                JComboBox velocidade = new JComboBox();
                velocidade.addItem("Subluz");
                velocidade.addItem("FTL");


                Object[] fields = {

                        "Nome da nave", campoNome,
                        "Código do porto", codPorto,
                        "Velocidade da nave", velocidade
                };
                int escolha = JOptionPane.showConfirmDialog(painel, fields, "Cadastrar nave", 0);
                if (escolha == JOptionPane.YES_OPTION) {
                    if (velocidade.getSelectedItem().equals("Subluz")) {
                        try {
                            int porto = Integer.parseInt(codPorto.getText());
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(painel, "Código do porto incorretamente digitado");
                            return;
                        }
                        JTextField velocidadeMaximaImpulso = new JTextField();

                    }
                    JOptionPane.showMessageDialog(painel, "espaçonave cadastrada!");
                }
            }
        });
        cadastrarTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField codPorto1 = new JTextField();
                JTextField codPorto2 = new JTextField();
                JComboBox transportes = new JComboBox();
                transportes.addItem("Pessoas");
                transportes.addItem("Materiais");

                Object[] fields = {
                        "Porto de origem", codPorto1,
                        "Porto de destino", codPorto2,
                        "Conteúdo transportado", transportes
                };

                int escolha = JOptionPane.showConfirmDialog(painel, fields, "Cadastrar transportes", 2);
                if (escolha == JOptionPane.YES_OPTION) {


                    if (transportes.getSelectedItem().equals("Pessoas")) {
                        String quantidadePessoa = JOptionPane.showInputDialog(painel, "Quantidade de Pessoas", "Pessoas", 1);
                    } else {
                        JTextField descricaoMaterial = new JTextField();
                        JTextField cargaMaterial = new JTextField();
                        Object[] materiais = {
                                "Descrição", descricaoMaterial,
                                "Carga Material", cargaMaterial,

                        };
                        JOptionPane.showConfirmDialog(painel, materiais, "Materiais", 2);
                    }
                }
            }
        });

    }
}