
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControleApp extends JFrame {

    private ArrayList<Turma> listaTurma = new ArrayList<>();
    private ArrayList<Disciplina> listaDisciplina = new ArrayList<>();
    private ArrayList<Estudante> listaEstudante = new ArrayList<>();
    
    public ControleApp() {

        super("Aplicacao Matricula");

        listaDisciplina.add(new Disciplina(110, "Estrutura de Dados"));
        listaDisciplina.add(new Disciplina(120, "Sistemas Operacionais"));
        listaDisciplina.add(new Disciplina(130, "Programação OO"));
        listaEstudante.add(new Estudante(1001, "José da Silva"));
        listaEstudante.add(new Estudante(1002, "João de Souza"));
        listaEstudante.add(new Estudante(1003, "Marcelo dos Santos"));
        listaEstudante.add(new Estudante(1004, "Maria de Jesus"));
        listaEstudante.add(new Estudante(1005, "Marcos da Silva"));
        listaEstudante.add(new Estudante(1006, "Aluno 6"));
        listaEstudante.add(new Estudante(1007, "Aluno 7"));
        listaEstudante.add(new Estudante(1008, "Aluno 8"));
        listaEstudante.add(new Estudante(1009, "Aluno 9"));
        listaEstudante.add(new Estudante(1010, "Aluno 10"));

        JPanel cards = new JPanel(new CardLayout());
        this.getContentPane().add(cards, BorderLayout.CENTER);

        JPanel inicial = new JPanel(new BorderLayout());
        cards.add(inicial, "inicial");

        CriaTurma criaTurma = new CriaTurma(this, listaDisciplina, listaEstudante);
        criaTurma.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(criaTurma, "formCadTurma");
        
        CriaDisciplina criadisc = new CriaDisciplina(this);
        criadisc.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(criadisc, "cadDisc");

        ConsultaTurma telaConsulta = new ConsultaTurma(listaDisciplina, listaTurma);
        telaConsulta.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(telaConsulta, "cadConTurma");

        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu turmaMenu = new JMenu("Turma");
        menu.add(turmaMenu);
        JMenuItem cadTurma = new JMenuItem("Cadastrar");
        JMenuItem conTurma = new JMenuItem("Consultar");
        turmaMenu.add(cadTurma);
        turmaMenu.add(conTurma);

        // Menu para o Estudante
        JMenu estudanteMenu = new JMenu("Estudante");
        menu.add(estudanteMenu);
        JMenuItem cadEstudante = new JMenuItem("Cadastrar");
        estudanteMenu.add(cadEstudante);

        // Menu para a Disciplina
        JMenu disciplinaMenu = new JMenu("Disciplina");
        menu.add(disciplinaMenu);
        JMenuItem cadDisciplina = new JMenuItem("Cadastrar");
        disciplinaMenu.add(cadDisciplina);

        cadTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardCriaTurma = (CardLayout) (cards.getLayout());
                cardCriaTurma.show(cards, "formCadTurma");
            }
        });

        conTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConTurma = (CardLayout) (cards.getLayout());
                cardConTurma.show(cards, "cadConTurma");
            }
        });

        cadEstudante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Nome = JOptionPane.showInputDialog("Informe o nome");

                String NroMatric = JOptionPane.showInputDialog("Informe o numero de matricula");
                int nroMatric = Integer.parseInt(NroMatric);
            }
        });

        cadDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardCriaDisc = (CardLayout) (cards.getLayout());
                cardCriaDisc.show(cards, "cadDisc");
                //String Nome = JOptionPane.showInputDialog("Informe o nome da disciplina");

                // String Codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina");
                //int codigo = Integer.parseInt(Codigo);
            }
        });

        this.setSize(720, 480);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public ArrayList<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }

    public void insereTurma(Turma t) {
        listaTurma.add(t);
    }

    public static void main(String[] args) {
        new ControleApp();
    }
}
