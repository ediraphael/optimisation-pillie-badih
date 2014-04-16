package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ChoixAlgo extends JPanel implements ActionListener
{
	//private JRadioButton optimal = new JRadioButton("Optimal", false);
	private JRadioButton gloutonCoutMax = new JRadioButton("Glouton Cout Max", false);
	private JRadioButton gloutonCoutMin = new JRadioButton("Glouton Cout Min", false);
	private JRadioButton gloutonEntreprise = new JRadioButton("Glouton Entreprise", false);
	private JRadioButton branchAndBoundFast = new JRadioButton("Branch And Bound Fast", false);
	private JRadioButton branchAndBound = new JRadioButton("Branch And Bound", true);

	public ChoixAlgo()
	{
		//optimal.addActionListener(this);
		gloutonCoutMax.addActionListener(this);
		gloutonCoutMin.addActionListener(this);
		gloutonEntreprise.addActionListener(this);
		branchAndBoundFast.addActionListener(this);
		branchAndBound.addActionListener(this);

		ButtonGroup groupe = new ButtonGroup();
		//groupe.add(optimal);
		groupe.add(gloutonCoutMax);
		groupe.add(gloutonCoutMin);
		groupe.add(gloutonEntreprise);
		groupe.add(branchAndBoundFast);
		groupe.add(branchAndBound);

		this.setLayout(new GridLayout(2,4));
		//this.add(optimal);
		this.add(new JLabel("Algorithme :"));
		this.add(gloutonCoutMin);
		this.add(gloutonCoutMax);
		this.add(gloutonEntreprise);
		this.add(new JLabel(""));
		this.add(branchAndBoundFast);
		this.add(branchAndBound);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		AlgoRecherche.typeAlgo=((JRadioButton)e.getSource()).getText();
	}

}
