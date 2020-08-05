import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;
public class Pantera extends Creature{

    public Pantera(){
        super("P"+Noms.getNom());
    }

    public double getVitesse(){
        return 5*super.getVitesse();
    }

    public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase () ;
        /*
		g.setColor(new Color(255,140,0)) ; // c o u l e u r c o u r an te d e v i e n t Orange
		g.fillOval (getX()*tc , getY()*tc ,tc ,tc ) ; // c e r c l e p l e i n
        */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image im = toolkit.getImage("pantera.jpg");
		g.drawImage(im, getX () * tc , getY () * tc , tc , tc,null);
	}
}
