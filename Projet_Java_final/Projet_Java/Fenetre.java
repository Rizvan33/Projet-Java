import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fenetre extends javax.swing.JFrame {

    String nom_fichier_image = "1.jpg";

    public Fenetre()
    {
        super();
        setBounds(200, 200, 600, 400);
        JPanel panneau = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                ImageIcon m = new ImageIcon(nom_fichier_image);
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);

            }
        };

        //ajouter le panneau à la fenétre.
        getContentPane().add(panneau);
    }
    /*
    public static void main(String [] args)
    {
        new tonFenetre().setVisible(true);
    }
    */
}
