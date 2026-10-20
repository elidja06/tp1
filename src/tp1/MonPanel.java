package tp1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private double a = 1, b = 0, c = 0;
	private boolean modeDessin = false;

	public void setDessin(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		modeDessin = true;
		repaint();
	}
	public MonPanel() {
		setBackground(new Color(255, 250, 220)); // fond jaune clair
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!modeDessin) return;

		int w = getWidth();
		int h = getHeight();
		int marge = 20;
		double xmin = -10, xmax = 10;
		int n = 200; // nombre de segments

		// 1) calcul des y et de leur plage
		double[] ys = new double[n + 1];
		double ymin = 0, ymax = 0; // on force l'axe y = 0 dans la plage
		for (int i = 0; i <= n; i++) {
			double x = xmin + i * (xmax - xmin) / n;
			ys[i] = a * x * x + b * x + c;
			ymin = Math.min(ymin, ys[i]);
			ymax = Math.max(ymax, ys[i]);
		}

		// 2) échelle : valeurs -> pixels
		double ratioX = (w - 2 * marge) / (xmax - xmin);
		double ratioY = (h - 2 * marge) / (ymax - ymin);

		// 3) axes
		g.setColor(Color.GRAY);
		int yAxe = h - marge - (int) ((0 - ymin) * ratioY);
		int xAxe = marge + (int) ((0 - xmin) * ratioX);
		g.drawLine(marge, yAxe, w - marge, yAxe);
		g.drawLine(xAxe, marge, xAxe, h - marge);

		// 4) courbe
		g.setColor(Color.BLUE);
		for (int i = 0; i < n; i++) {
			double x1 = xmin + i * (xmax - xmin) / n;
			double x2 = xmin + (i + 1) * (xmax - xmin) / n;
			int px1 = marge + (int) ((x1 - xmin) * ratioX);
			int px2 = marge + (int) ((x2 - xmin) * ratioX);
			int py1 = h - marge - (int) ((ys[i] - ymin) * ratioY);
			int py2 = h - marge - (int) ((ys[i + 1] - ymin) * ratioY);
			g.drawLine(px1, py1, px2, py2);
		}
	}
}