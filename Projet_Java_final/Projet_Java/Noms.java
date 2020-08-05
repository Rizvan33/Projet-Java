public class Noms {
    private static String[] tabNoms={"Bob","Fil","Jaz"};
    private static int i=-1;
    private static int cpt=0;

    public static String getNom(){
        i++;
        if(i>=tabNoms.length){
            i=0;
            cpt++;
        }
        return (i==0? tabNoms[i]:tabNoms[i]+cpt);
    }

}
