package vue;

import modele.*;

import javax.swing.*;

import affichage.Affichage;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AlgoRecherche extends JPanel implements ActionListener
{
	private JButton rechercheClique = new JButton("START");
	private JButton clear = new JButton("CLEAR");
	private Scenario scenario;
	private String listeBase;
	private String listeEntreprise;
	public static String typeAlgo;

	public AlgoRecherche()
	{
		typeAlgo = "";
		add(clear, BorderLayout.WEST);
		add(rechercheClique, BorderLayout.CENTER);
		clear.addActionListener(this);
		rechercheClique.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == rechercheClique)
		{
			AffichageTrace.reset();
			this.listeBase = "Data/ScВnarios/Liste Bases/" + DownloadFile.listeBases.getSelectedValue();
			this.listeEntreprise = "Data/ScВnarios/Liste Entreprises/" + DownloadFile.listeEntreprises.getSelectedValue();
			this.scenario = new Scenario();

			// GrapheClique.progressBar.setClique(GrapheClique.getClique());
			Thread th = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					long start = System.currentTimeMillis();
					scenario.loadDatas(listeBase, listeEntreprise);

					switch (typeAlgo)
					{
					case "Glouton Cout Max":
						scenario.launchGloutonCoutMax();
						break;
					case "Glouton Cout Min":
						scenario.launchGloutonCoutMin();
						break;
					case "Glouton Entreprise":
						scenario.launchGloutonEntrepriseMax();
						break;
					case "Branch And Bound Fast":
						scenario.launchBranchAndBoundFast();
						break;
					case "Branch And Bound":
						scenario.launchBranchAndBound();
						break;
					default:
						scenario.launchBranchAndBound();
						break;
					}

					long start2 = System.currentTimeMillis();
					Affichage.afficher(scenario.algoRecherche.getChaine());
					Affichage.afficher("Durée de calcul : " + ((float) (start2 - start)) / 1000 + "s");
				}
			});
			th.start();
		} else if (e.getSource() == clear)
		{
			Affichage.reset();
		}
	}
}
