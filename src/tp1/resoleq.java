package tp1;

public class resoleq 
{
	private double a,b,c;
	private double delta;
	private double x1re, x1im, x2re, x2im;
	
	public resoleq(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c; 
	}
	public void resoudre()
	{
		delta = b*b-4*a*c;
		if (delta>0)
		{
			x1re = (-b+Math.sqrt(delta))/(2*a);
			x2re = (-b-Math.sqrt(delta))/(2*a);
			x1im = x2im = 0;
		}
		else if (delta == 0)
		{
			x1re=x2re=-b/(2*a);
			x1im = x2im = 0;
		}
		else 
		{
			x1re=x2re=-b/(2*a);
			x1im = (Math.sqrt(-delta))/(2*a);
			x2im = -x1im;
		}
	}
	public void afficher()
	{
		System.out.println("x1="+x1re+"+"+x1im+"i");
		System.out.println("x2="+x2re+"+"+x2im+"i");

	}
	public String resultat()
	{
	   return "delta = " + delta + "\nx1 = " + x1re + " + " + x1im + "i\nx2 = " + x2re + " + " + x2im + "i"; 
	}
}
