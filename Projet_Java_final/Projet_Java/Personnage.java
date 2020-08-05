import java.awt.*;
import javax.swing.*;
public class Personnage extends Item{
  protected String nom;
  protected double poids;
  public Personnage(String nom, double poids){
    super(nom);
    this.nom=nom;
    this.poids=poids;
  }

  public Personnage(String nom){
    super(nom);
    this.nom=nom;
    this.poids=Math.random()*101+30;
  }

  protected void addPoids(double p){
    if(p>0)
      poids+=p;
  }
  public void dessiner (Graphics g , Monde m) {
      int tc=m.getTailleCase () ;
      /*
      g.setColor(new Color(0,255,255) ) ; // c o u l e u r c o u r an te d e v i e n t Cyan
      g.fillOval (getX()*tc , getY()*tc ,tc ,tc ) ; // c e r c l e p l e i n
      */
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Image im = toolkit.getImage("kinopio.png");
      g.drawImage(im, getX () * tc , getY () * tc , tc , tc,null);
  }
  public String toString(){
    return nom+" "+String.format("%.1f",poids)+" kg";
  }
}
