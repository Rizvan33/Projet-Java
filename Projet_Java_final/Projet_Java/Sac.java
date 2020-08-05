import java.awt.*;
import javax.swing.*;
public class Sac extends Acc{
	private Acc[] tab;
	public Sac(int n){
		super("sac");
		tab = new Acc[n];
	}

	public Sac(){
		super("sac");
		tab = new Acc[((int)(Math.random()*10))+1];
	}

	public int size(){
		return tab.length;
	}

	public void ajouter(Acc a){
		int s=0;
		for(int i=0;i<tab.length;i++){
			if(tab[i]==null){
				tab[i]=a;
				s=1;
				break;
			}
		}
		if(s==0){System.out.println("Pas de place");}
	}

	public int nbAcc(){
		int res=0;
		for(int i=0;i<tab.length;i++){
			if(tab[i]!=null){
				res++;
			}
		}
		return res;
	}
	public Acc obtenir(int i){
		Acc res=null;
		if(tab[i]!=null){
			res=tab[i];
			tab[i]=null;
		}
		return res;
	}
	public double getPoids(){
		double res=0;
		for(int i=0;i<tab.length;i++){
			if(tab[i]!=null){
				res=res+tab[i].getPoids();
			}
		}
		return res;
	}

	public String toString(){
		String res = super.toString()+" contient "+ nbAcc() +" accessoires sur " +size()+" places";
		for(int i=0;i<tab.length;i++){
			if(tab[i]!=null){
				res= res+ "\n	"+tab[i].toString();
			}
		}
		return res;
	}

	public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase () ;
		g.setColor(new Color (255,255,255) ) ; // c o u l e u r c o u r an te d e v i e n t noir
		g.fillOval (getX () * tc , getY () * tc , tc , tc ) ; // c e r c l e p l e i n
	}

}
