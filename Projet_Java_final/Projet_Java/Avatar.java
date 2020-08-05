import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;

public class Avatar extends Personnage{
	private ArrayList<Creature> listeAmis;
	private ArrayList<Acc> listeAcc;
	private Monde monde;

	public Avatar(String n, double p, Monde m){
		super(n,p);
		listeAmis= new ArrayList<Creature>();
		listeAcc= new ArrayList<Acc>();
		monde=m;
		m.ajouterItem(this);
	}

	public String toString(){
		return super.toString()+ " "+ listeAmis.size()+ " ami(s) "+listeAcc.size()+ " accessoire(s)";
	}

	public boolean estAmi(Creature c){
		return listeAmis.contains(c);
	}

	public void devenirAmi(Creature c){
		if (!estAmi(c)){
			listeAmis.add(c);
			System.out.println(this.nom+" devient ami avec "+c.getNom());
		}
	}

	public void perdreAmi(Creature c){
		if(estAmi(c)){
			listeAmis.remove(c);
		}
	}

	public void rencontrer(Creature c){
		if(listeAcc.size()>0){
			Acc a=listeAcc.remove(0);
			c.ajouterAcc(a);
			if(!estAmi(c)&& a.getPoids()>=0.5){devenirAmi(c);}
		}
		else{
			if(estAmi(c)){
				perdreAmi(c);
			}
		}
	}

	public double course(){
		double res=0.0;
		for(Creature c : listeAmis){
			c.manger();
			c.courir();
			res=res+c.getVitesse();
		}
		return res;
	}

	public Creature getCreaturePlusRapide(){
		Creature res=listeAmis.get(0);
		for(Creature c : listeAmis){
			if(c.getVitesse()>res.getVitesse()){
				res=c;
			}
		}
		return res;
	}

	public int compterAccMangeable(){
		int res=0;
		for(Acc a : listeAcc){
			if(a instanceof Mangeable){
				res++;
			}
		}
		return res;
	}

	public void ramasser(Acc a){
		listeAcc.add(a);
		monde.supprimerItem(a);
		System.out.println(nom+" ramasse "+ a.getNom());
	}

	public void rencontrerVoisins(){
		ArrayList<Item> l=monde.getVoisins(this);
		for(Item i : l){
			if(i instanceof Acc){
				Acc a;
				a=(Acc)i;
				ramasser(a);
			}
			else if(i instanceof Creature){
				Creature c;
				c=(Creature)i;
				rencontrer(c);
			}
			else if(i instanceof Witch){
				for(Creature w : listeAmis){
					perdreAmi(w);
				}
				System.out.println("Witch!");
			}
			else if(i instanceof Avatar){
				System.out.println("Salut!!!");
			}
		}
	}

	public void seDeplacer(){
		Scanner sc = new Scanner(System.in);
		System.out.println("### Déplacement de "+nom+" ###");
		int i=-1;
		int j=-1;
		while(i<0||i>=monde.getTaille()){
			System.out.println("Entrer une abscisse entre [0,"+monde.getTaille()+"] :");
			i = sc.nextInt();
		}
		while(j<0||j>=monde.getTaille()){
			System.out.println("Entrer une ordonnée entre [0,"+monde.getTaille()+"] :");
			j = sc.nextInt();
		}
		System.out.println("Déplacement de "+nom+" de ("+getX()+","+getY()+") vers ("+i+","+j+")");
		this.setX(i);
		this.setY(j);
	}

	public void dessiner (Graphics g, Monde m) {
		int tc=m.getTailleCase();
		/*
		g.setColor(new Color (0,0,255)) ; // c o u l e u r c o u r an te d e v i e n t bleu
		g.fillOval (getX () * tc , getY () * tc , tc , tc ) ; // c e r c l e p l e i n
		*/
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image im = toolkit.getImage("1.jpg");
		g.drawImage(im, getX () * tc , getY () * tc , tc , tc,null);
	}
}
