import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;

public class Witch extends Creature{


	public Witch(){
		super("Witch");
	}

	public void dessiner (Graphics g, Monde m) {
		int tc=m.getTailleCase();
		/*
		g.setColor(new Color (0,0,255)) ; // c o u l e u r c o u r an te d e v i e n t bleu
		g.fillOval (getX () * tc , getY () * tc , tc , tc ) ; // c e r c l e p l e i n
		*/
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image im = toolkit.getImage("Witch.jpg");
		g.drawImage(im, getX () * tc , getY () * tc , tc , tc,null);
	}
}
