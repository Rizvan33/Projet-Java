import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
public class Monde extends JPanel{
	private ArrayList<Item> listeItems;
	private int taille;
	private int tailleCase;

	public Monde(int taille , int tailleCase ) {
		listeItems=new ArrayList<Item>();
		setPreferredSize(new Dimension (taille * tailleCase ,taille * tailleCase));
		this.tailleCase=tailleCase;
		this.taille=taille;
	}
	/*public Monde(int t){
		listeItems=new ArrayList<Item>();
		taille=t;
	}*/

	public int getTaille(){
		return taille;
	}

	public int getTailleCase(){
		return tailleCase;
	}

	public int getPositionAlea(){
		return (int)(Math.random()*(taille+1));
	}

	public void ajouterItem(Item item){
		item.setX(getPositionAlea());
		item.setY(getPositionAlea());
		listeItems.add(item);
	}

	public Item supprimerItem(Item item){
		Item res =listeItems.remove(listeItems.indexOf(item));
		res.setX(-1);
		res.setY(-1);
		return res;
	}

	public Item chercher(int x,int y){
		for(Item i : listeItems){
			if( i.getX()==x && i.getY()==y){
				return i;
			}
		}
		return null;
	}

	public ArrayList<Item> getVoisins(Item item){
		ArrayList<Item> res =new ArrayList<Item>();
		for(Item i : listeItems){
			if( i.distance(item)<=2){
				res.add(i);
			}
		}
		res.remove(item);
		return res;
	}

	private static String getNomCourt(String nom){
		switch(nom.length()) {
			case 1:
				return "  "+nom+" ";
			case 2:
				return " "+nom+" ";
			case 3:
				return nom+" ";
			default: return nom.substring(0,4);
		}
	}

	public void afficher(){
		System.out.print("  ");
		for(int i=0;i<taille;i++){
			System.out.print("|  "+i+" ");
		}
		System.out.println("|");
		for(int i=0;i<taille;i++){
			System.out.print(""+i+" |");
			for(int j=0;j<taille;j++){
				if(chercher(i,j)!=null){
					System.out.print(getNomCourt(chercher(i,j).getNom())+"|");
				}
				else{
					System.out.print("    |");
				}
			}
			System.out.print("\n");
		}
	}
	public void paintComponent (Graphics g) {
		super.paintComponent (g) ; // r e d e s s i n e l e panneau
		for(Item itemVoisin : listeItems) {
			if(itemVoisin != null) {
				itemVoisin.dessiner (g,this) ;
			}
		}
	}
	public void bougerItemsAlea(){
		for(Item i : listeItems){
			if(!( i instanceof Avatar)){
				i.setX(getPositionAlea());
				i.setY(getPositionAlea());
			}
		}
	}
	/*
	public void dessiner(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		TexturePaint tp=new TexturePaint(image,)
	}
	*/
}
