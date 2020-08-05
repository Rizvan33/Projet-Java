public abstract class Acc extends Item{
	protected static int cpt=0;
	protected int numero=0;
	protected String categorie;

	public Acc (String categorie){
		super(categorie);
		cpt++;
		numero=cpt;
		this.categorie=categorie;
	}

	public abstract double getPoids();

	public String toString() {
		return categorie+" No "+ numero + " "+String.format("%.2f",getPoids())+"kg";
	}

	

	

}

	
