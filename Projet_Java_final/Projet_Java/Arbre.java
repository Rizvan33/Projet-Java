import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class Arbre extends Item{
    public Arbre(){
        super("Arbre");
    }

    public Arbre(String nom){
        super(nom);
    }

    public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase () ;
		g.setColor(new Color (0,0,255)) ; // c o u l e u r c o u r an te d e v i e n t bleu
		g.fillOval (getX () * tc , getY () * tc , tc , tc ) ; // c e r c l e p l e i n
	}
}
