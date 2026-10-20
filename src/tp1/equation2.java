package tp1;
import javax.swing.*;

public class equation2 {
	
	public static void main(String[] args)throws Exception
	{
		JTextField champA = new JTextField("1.0");   // valeur par défaut
		JTextField champB = new JTextField("1.0");   // valeur par défaut
		JTextField champC = new JTextField("1.0");   // valeur par défaut
		Object[] message = {"valeur de a ?", champA, "valeur de b ?",champB, "valeur de c", champC}; //pour les labels et les entrØes de texte
		String[] options= {"OK","CANCEL"}; //pour les boutons
		int result; //pour savoir si on clique sur OK ou Cancel
		result = JOptionPane.showOptionDialog(new JFrame(), message, "Ma jolie boite de dialogue", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("painting.gif") , options, options[0]);
		if (result !=0)
		{
			System.exit(0); 
		}
		
		double a = Double.parseDouble(champA.getText());
		double b = Double.parseDouble(champB.getText());
		double c= Double.parseDouble(champC.getText());
		
		
		
		int cas;
		if(a==0 && b==0)cas =0;
		else if(a==0)cas = 1;
		else cas = 2;
		
		switch(cas)
		{
		case 0 : 
			JOptionPane.showMessageDialog(null, "Ce n'est pas une équation (a = 0 et b = 0).");
			break;
		case 1 :
			
			JOptionPane.showMessageDialog(null, "Équation du 1er degré ");
			break;
		case 2:
			resoleq r = new resoleq(a,b,c);
			r.resoudre();
			JOptionPane.showMessageDialog(null, r.resultat());
			r.afficher();
			break; 
		}
		System.exit(0);
	}

}
