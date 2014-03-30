package modele;

public abstract class AlgoRecherche
{
	String chaine = "";
	int tempExecution = 0;

	public abstract void rechercher(Scenario scenario);

	public String getChaine()
	{
		return chaine;
	}

	public void setChaine(String chaine)
	{
		this.chaine = chaine;
	}
}
