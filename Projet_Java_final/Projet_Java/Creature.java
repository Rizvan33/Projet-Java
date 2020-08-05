import java.awt.*;
import javax.swing.*;
public class Creature extends Personnage{
    private Sac leSac;
    public Creature(){
        super(Noms.getNom());
        leSac= new Sac();
        for(int i=0;i<Math.random()*3;i++){
            ajouterAcc(new Pomme());
        }
    }

    public Creature(String nom){
        super(nom);
        leSac= new Sac();
    }

    public void ajouterAcc(Acc a){
            double psac=leSac.getPoids();
            if(psac+a.getPoids()<=0.5*this.poids){
                leSac.ajouter(a);
            }
            else{
                System.out.println("Trop lourd");
            }
    }

    public double getVitesse(){
        double pc=poids;
        double ps=leSac.getPoids();
        double v=(0.25*pc)-ps;
        return (v<0? 0:v);
    }
     public void manger(){
         Acc t;
         for(int i=0;i<leSac.size();i++){
             t=leSac.obtenir(i);
             if (t instanceof Mangeable){
                 poids=poids+t.getPoids();
             }
            else{
                leSac.ajouter(t);
                }
          }
     }
      public void manger(Mangeable m) {
          poids=poids+m.getPoids();
      }

      public String getNom(){return this.nom;}

      public void courir(){
        System.out.println(super.toString()+" court a vitesse "+String.format("%.2f",getVitesse())+" km/h avec " + leSac.toString());
      }


}
