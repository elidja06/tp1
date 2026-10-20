package tp1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class fenetreEq extends JFrame {

	private static final long serialVersionUID = 1L;
	private MonPanel contentPane;
	private JLabel labelX1;
	private JLabel labelX2;
	private double derA = 1, derB = -3, derC = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetreEq frame = new fenetreEq();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fenetreEq() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenuItem menuLancer = new JMenuItem("Lancer le programme");
		menuBar.add(menuLancer);
		JMenuItem menuQuitter = new JMenuItem("Quitter");
		menuBar.add(menuQuitter);
		JMenuItem menuAide = new JMenuItem("Aide");
		menuBar.add(menuAide);
		JMenuItem menuDessin = new JMenuItem("Affichage en mode dessin");
		menuBar.add(menuDessin);
		contentPane = new MonPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		labelX1 = new JLabel("x1 = ?");
		contentPane.add(labelX1);

		labelX2 = new JLabel("x2 = ?");
		contentPane.add(labelX2);
		menuQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menuAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fenetreEq.this,
						"Résolution de ax² + bx + c = 0.\nCliquez sur « Lancer le programme », saisissez a, b et c, puis validez.");
			}
		});

		menuLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Maboite(fenetreEq.this).setVisible(true);
			}
		});
		menuDessin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setDessin(derA, derB, derC);
			}
		});
	}

	public void calculer(double a, double b, double c) {
		derA = a;
		derB = b;
		derC = c;
		try {
			if (a == 0)
				throw new MonException("a = 0 : ce n'est pas une équation du second degré");
			resoleq r = new resoleq(a, b, c);
			r.resoudre();
			labelX1.setText("<html>" + r.resultat().replace("\n", "<br>") + "</html>");
			labelX2.setText("");
		} catch (MonException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

}
