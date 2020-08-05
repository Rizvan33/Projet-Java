import java.awt.*;
import javax.swing.*;
public class TestGraphisme{
    private static final int TAILLE_CASE=30;
    private static final int NB_CASES=20;
    public static void main(String[]args) throws InterruptedException{
        //Créationfenêtregraphiqueetsescaractéristiques
        JFrame f=new JFrame();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Créationdumonde(quiestunpanneau)
        Monde m=new Monde(NB_CASES,TAILLE_CASE);
        f.setContentPane(m);//Ajoutdumondeàlafenêtre
        f.pack();//Adaptationdelafenêtreaupanneau
        f.setVisible(true);
        Avatar jake=new Avatar("Jake",79.5,m);//ajouteJakedanslemonde
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Creature());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Pomme());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Poire());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Sac());
        }
        for(int i=0;i<Math.random()*5;i++){
            m.ajouterItem(new Pantera());
        }
        for(int i=0;i<10;i++){
            Thread.sleep(1000);//Ralentil’affichage
            jake.seDeplacer();
            jake.rencontrerVoisins();
            m.repaint();//Redessinelegraphique
        }
    }
}
