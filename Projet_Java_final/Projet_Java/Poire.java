import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;
public class Poire extends Acc implements Mangeable{
	private double rayon;

	public Poire(){
		super("poire");
		rayon=Math.random()*5+3;
	}

	public double getRayon() {return rayon;}

	public double getPoids() {return (4.0/3000.0)*Math.PI*rayon*rayon*rayon;}

	public String toString(){
		return super.toString() + " "+String.format("%.1f",getRayon()) +"cm";
	}
	public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase () ;
		/*
		g.setColor(new Color(0,255,0) ) ; // c o u l e u r c o u r an te d e v i e n t Vert
		g.fillOval (getX()*tc , getY()*tc ,tc ,tc ) ; // c e r c l e p l e i n
		*/
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image im = toolkit.getImage("poire.jpg");
		g.drawImage(im, getX () * tc , getY () * tc , tc , tc,null);
	}
}
