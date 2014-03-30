package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Scenario;
import affichage.Affichage;

public class FenetrePrincipal
{
	public static Scenario scenario = new Scenario();
	public static DownloadFile dfile = new DownloadFile("Votre fichier correspondant au graphe", "C250.9.clq");
	public static ChoixAlgo algo = new ChoixAlgo();

	public static Scenario getGraphe()
	{
		return scenario;
	}

	public static void setGraphe(Scenario scenario)
	{
		FenetrePrincipal.scenario = scenario;
	}

	public static void loadFichier(boolean matrice)
	{
		
	}

	public static void lancerAffichage() throws IOException
	{
		JFrame cadre = new javax.swing.JFrame("Algo de recherche");

		AffichageTrace affichageTrace = new AffichageTrace();
		AlgoRecherche algoRecherche = new AlgoRecherche();
		Ecran_fenetre ecran = new Ecran_fenetre(affichageTrace);
		Affichage.setECRAN(ecran);

		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(dfile, BorderLayout.NORTH);
		JPanel choixCliqueEtRepresentation = new JPanel();
		choixCliqueEtRepresentation.setLayout(new GridLayout(1, 1));
		choixCliqueEtRepresentation.add(algo);
		top.add(choixCliqueEtRepresentation, BorderLayout.CENTER);

		JPanel panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		panneau.add(top, BorderLayout.NORTH);
		panneau.add(affichageTrace, BorderLayout.CENTER);
		panneau.add(algoRecherche, BorderLayout.SOUTH);

		cadre.setContentPane(panneau);
		cadre.pack();
		cadre.setLocationRelativeTo(null);
		cadre.setVisible(true);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] arg) throws IOException
	{
		FenetrePrincipal.lancerAffichage();
	}
}
