package tp1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Maboite extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField champA = new JTextField("1.0");
	private JTextField champB = new JTextField("1.0");
	private JTextField champC = new JTextField("1.0");

	public Maboite(fenetreEq parent) {
		super(parent, "Saisie des coefficients", false); // false = non modale
		setLayout(new GridLayout(4, 2, 5, 5));
		add(new JLabel("a :"));
		add(champA);
		add(new JLabel("b :"));
		add(champB);
		add(new JLabel("c :"));
		add(champC);

		JButton boutonCalculer = new JButton("Calculer");
		boutonCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					parent.calculer(getA(), getB(), getC());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(Maboite.this, "Saisie invalide : tapez un nombre.");
				}
			}
		});
		add(new JLabel());
		add(boutonCalculer);

		setSize(300, 180);
		setLocationRelativeTo(parent);
	}

	public double getA() {
		return Double.parseDouble(champA.getText());
	}

	public double getB() {
		return Double.parseDouble(champB.getText());
	}

	public double getC() {
		return Double.parseDouble(champC.getText());
	}
}