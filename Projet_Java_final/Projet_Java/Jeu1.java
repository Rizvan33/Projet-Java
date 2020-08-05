import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Jeu1{
	private static final int TAILLE_CASE=30;
   	private static final int NB_CASES=20;
	public static void main(String[] args) throws InterruptedException{

		Scanner sc = new Scanner(System.in);
        //Créationfenêtregraphiqueetsescaractéristiques

		JFrame f=new JFrame();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Créationdumonde(quiestunpanneau)
        Monde m=new Monde(NB_CASES,TAILLE_CASE);
        f.setContentPane(m);//Ajoutdumondeàlafenêtre
        f.pack();//Adaptationdelafenêtreaupanneau
        f.setVisible(true);
		/*
		Fenetre f = new Fenetre();
		f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Monde m=new Monde(NB_CASES,TAILLE_CASE);
		try{
			BufferedImage myImage = ImageIO.read(new File("1.jpeg"));
			f.setContentPane(new ImagePanel(myImage));
		}catch(IOException e){
			e.printStackTrace();
		}
        f.setContentPane(m);//Ajoutdumondeàlafenêtre
        f.pack();//Adaptationdelafenêtreaupanneau
        f.setVisible(true);
		*/
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Creature());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Pomme());
        }
		for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Witch());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Poire());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Pantera());
        }
		m.repaint();

        Avatar p1=new Mario("P1",75.0,m);
        Avatar p2=new Luigi("P2",75.0,m);



		int t=-1;
		while(t<1){
			System.out.println("Saisissez le nombre de tours que vous voulez jouer:");
			t = sc.nextInt();
		}
		System.out.println("Saisissez la position initiale de Mario:");
		p1.seDeplacer();
		m.repaint();
		System.out.println("Saisissez la position initiale de Luigi:");
		p2.seDeplacer();
		m.repaint();
        for(int i=0;i<t;i++){
        	/*Thread.sleep(1000);*/

            System.out.println("Tour: "+(i+1));
            int ii=0,jj=0;

            while(ii!=1 && ii!=2){
			System.out.println("Mario: entrer 1 pour se deplacer, 2 pour rencontrer vos voisins et ramasser les items.");
			ii = sc.nextInt();
			}

			if(ii==1){p1.seDeplacer();m.repaint();} else {p1.rencontrerVoisins();m.repaint();}

			while(jj!=1 && jj!=2){
				System.out.println("Luigi: entrer 1 pour se deplacer, 2 pour rencontrer vos voisins et ramasser les items.");
				jj = sc.nextInt();
			}

			if(jj==1){p2.seDeplacer();m.repaint();} else {p2.rencontrerVoisins();m.repaint();}

        	m.bougerItemsAlea();
        	m.repaint();//Redessinelegraphique
        }

        double res1=p1.course();
        double res2=p2.course();

        System.out.println((res1>res2? "Joueur 1 gagne":"Joueur 2 gagne"));

    }

}
