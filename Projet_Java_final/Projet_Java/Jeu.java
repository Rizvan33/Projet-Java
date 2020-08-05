public class Jeu{
	public static void main(String[] args){
		Sac s=new Sac();
		Pomme p1=new Pomme();
		Pomme p2=new Pomme();
		s.ajouter(p1);
		s.ajouter(p2);
		System.out.println(s.toString());
		Creature c =new Creature();
		c.courir();
		Pomme p3=new Pomme();
		Pomme p4=new Pomme();
		Pomme p5=new Pomme();
		c.ajouterAcc(p3);
		c.ajouterAcc(p4);
		c.ajouterAcc(p5);
		c.courir();
		c.manger();
		c.courir();
/*
		Avatar av=new Avatar("gfh",100);
		Monde m=new Monde(4);
		m.ajouterItem(c);
		m.ajouterItem(av);
		m.ajouterItem(p1);
		m.ajouterItem(p2);
		m.ajouterItem(p3);
		m.ajouterItem(p4);
		m.ajouterItem(p5);
		m.afficher();
*/
	}
}
