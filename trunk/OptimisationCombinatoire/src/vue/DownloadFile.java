package vue;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DownloadFile extends JPanel
{
	public static JList<String> listeBases = new JList<String>();
	public static JList<String> listeEntreprises = new JList<String>();

	public DownloadFile(String name, String path)
	{
		File repertoire = new File("Data/ScВnarios/Liste Bases/");
		File[] fichiesrTxt = repertoire.listFiles(new FilenameFilter()
		{
			@Override
			public boolean accept(File repertoire, String nomFichier)
			{
				return nomFichier.endsWith(".txt");
			}
		});
		ArrayList<String> listeFichierTxt = new ArrayList<String>();
		for (File fichier : fichiesrTxt)
		{
			listeFichierTxt.add(fichier.getName());
		}
		DownloadFile.listeBases = new JList<String>(listeFichierTxt.toArray(new String[1]));
		
		repertoire = new File("Data/ScВnarios/Liste Entreprises/");
		fichiesrTxt = repertoire.listFiles(new FilenameFilter()
		{
			@Override
			public boolean accept(File repertoire, String nomFichier)
			{
				return nomFichier.endsWith(".txt");
			}
		});
		listeFichierTxt = new ArrayList<String>();
		for (File fichier : fichiesrTxt)
		{
			listeFichierTxt.add(fichier.getName());
		}
		DownloadFile.listeEntreprises = new JList<String>(listeFichierTxt.toArray(new String[1]));
		JLabel label = new JLabel("Liste de bases");
		JLabel label2 = new JLabel("Liste d'entreprises");
		DownloadFile.listeBases.setSelectedValue("Liste Bases1.txt", true);
		DownloadFile.listeEntreprises.setSelectedValue("Liste Ent1.txt", true);
		
		setLayout(new GridLayout(2, 2));
		add(label);
		add(label2);
		add(DownloadFile.listeBases);
		add(DownloadFile.listeEntreprises);
	}
}
