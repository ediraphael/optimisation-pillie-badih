package vue;

import affichage.Affichage;


public class Ecran_fenetre extends Affichage
{
	AffichageTrace affichage;

	public Ecran_fenetre(AffichageTrace affichage)
	{
		super();
		this.affichage = affichage;
	}

	public AffichageTrace getAffichage()
	{
		return affichage;
	}

	public void setAffichage(AffichageTrace affichage)
	{
		this.affichage = affichage;
	}

	@Override
	protected void afficher_message(Object message)
	{
		this.affichage.rajouterTexte(message.toString());
		this.affichage.repaint();
		this.affichage.validate();
	}
	
	protected void reset_message()
	{
		AffichageTrace.reset();
	}
}