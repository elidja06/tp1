package tp1;
import java.io.*;

public class equation 
{
	
	public static void main(String[] args)throws Exception
	{
		boolean ok = false;
		double a = 0;
		double b = 0;
		double c= 0;
		BufferedReader clavier=new BufferedReader(new InputStreamReader(System.in));
		while (!ok)
		{
		try
		{
			
			System.out.println("Valeur de a ?");
			String chaine=clavier.readLine(); //pour lire au clavier
			a=Double.parseDouble(chaine) ; //chaine est transtypØ (String-> entier)
			//Pour des variables de type float-> Float.parseFloat(...)
			System.out.println("Valeur de b ?");                                           
			chaine = clavier.readLine();                                            
			b = Double.parseDouble(chaine);
			System.out.println("Valeur de c ?");                                          
			chaine = clavier.readLine();                                            
			c = Double.parseDouble(chaine);
			
			boolean erreur = false;
			try
			{
				if (a == 0 || b == 0) throw new ArithmeticException("a=0 |");
			}
			catch (ArithmeticException e )
			{
				System.out.print("Division par zéro : " + e.getMessage());
				erreur = true;
			}
			
			try
			{
				if (c == 10) throw new MonException ("c= 10");
			}
			catch(MonException e)
			{
				System.out.print("| c = 10 change" );
				erreur = true;
			}
			
			if (erreur)
			{
				System.out.println();
			}
			else
			{
				resoleq r = new resoleq(a,b,c);
				r.resoudre();
				r.afficher();
				ok = true;
			}
			
		}
		
		catch (NumberFormatException e)
		{
			System.out.println("Saisie invalide : tapez un nombre.");
		}
		
		}
	}

}
