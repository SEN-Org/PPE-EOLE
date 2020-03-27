package applicationEole;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class FenModifParticipant extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Window window;
	
	private JLabel lblNomParticipant, lblPrenomParticipant, lblNomDuVoilier, lblClasseVoilier, lblRating, lblParticipantNonModif, lblnumParticipant;
	private JPanel panelModif1, panelPrincipal;
	
	private JLabel lblNomParticipant2, lblPrenomParticipant2, lblNomDuVoilier2, lblClasseVoilier2, lblRating2, lblParticipantModifie;
	private JPanel panelModif2, panelTitle2, panelModif;
	
	private JTextField tfNom2, tfPrenom2, tfNomVoilier2, tfClasse2, tfRatingV2;
	private JButton btnModifier;
	
	private JLabel lblNum = new JLabel();
	private JLabel lblNom = new JLabel();
	private JLabel lblPrenom = new JLabel();
	private JLabel lblNomVoilier = new JLabel();
	private JLabel lblCategorie = new JLabel();
	private JLabel lblRatingV = new JLabel();
	
	private int numAModifier;
	
	
	
	public FenModifParticipant(Window window){
		
		this.window = window;
		numAModifier = Integer.parseInt(JOptionPane.showInputDialog("Veuillez entrer le numero du participant à modifier"));
		numAModifier -= 1;
		
		lblNum.setText(String.valueOf(Bdd.getParticipant(numAModifier).getIdParticipant()));
		lblNom.setText(String.valueOf(Bdd.getParticipant(numAModifier).getNom()));
		lblPrenom.setText(String.valueOf(Bdd.getParticipant(numAModifier).getPrenom()));
		lblNomVoilier.setText(String.valueOf(Bdd.getParticipant(numAModifier).getNomVoilier()));
		lblCategorie.setText(String.valueOf(Bdd.getParticipant(numAModifier).getClasseVoilier()));
		lblRatingV.setText(String.valueOf(Bdd.getParticipant(numAModifier).getRatingVoilier()));
		
		
		
	}
	
	
	public void modifParticipant() {
		
		this.panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 782, 553);
		this.window.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		this.panelTitle2 = new JPanel();
		panelTitle2.setBounds(0, 0, 782, 50);
		panelPrincipal.add(panelTitle2);
		panelTitle2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.lblParticipantNonModif = new JLabel("PARTICIPANT NON - MODIFI\u00C9");
		this.lblParticipantNonModif.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblParticipantNonModif.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		this.panelTitle2.add(lblParticipantNonModif);
		
		this.lblParticipantModifie = new JLabel("PARTICIPANT MODIFI\u00C9");
		lblParticipantModifie.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipantModifie.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelTitle2.add(lblParticipantModifie);
		
		this.panelModif = new JPanel();
		panelModif.setBounds(20, 64, 750, 408);
		panelPrincipal.add(panelModif);
		panelModif.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelModif1 = new JPanel();
		panelModif.add(panelModif1);
		
		panelModif1.setLayout(new GridLayout(0, 1, 0, 10));
		
		
		this.lblnumParticipant = new JLabel("Num\u00E9ro du participant : ");
		lblnumParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblnumParticipant);
		
		
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblNum);
		
		this.lblNomParticipant = new JLabel("Nom du participant: ");
		lblNomParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblNomParticipant);
		
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblNom);
		
		this.lblPrenomParticipant = new JLabel("Prénom : ");
		lblPrenomParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblPrenomParticipant);
		
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblPrenom);
		
		this.lblNomDuVoilier = new JLabel("Nom du voilier: ");
		lblNomDuVoilier.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblNomDuVoilier);
		
		lblNomVoilier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblNomVoilier);
		
		this.lblClasseVoilier = new JLabel("Classe du voilier : ");
		lblClasseVoilier.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblClasseVoilier);
		
		lblCategorie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblCategorie);
		
		this.lblRating = new JLabel("Rating : ");
		lblRating.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblRating);
		
		lblRatingV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblRatingV);
		
		this.panelModif2 = new JPanel();
		panelModif.add(panelModif2);
		panelModif2.setLayout(new GridLayout(0, 1, 0, 10));
		
		this.lblNomParticipant2 = new JLabel("Nom du participant: ");
		lblNomParticipant2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblNomParticipant2);
		
		this.tfNom2 = new JTextField();
		tfNom2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfNom2);
		
		this.lblPrenomParticipant2 = new JLabel("Pr\u00E9nom : ");
		lblPrenomParticipant2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblPrenomParticipant2);
		
		this.tfPrenom2 = new JTextField();
		tfPrenom2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfPrenom2);
		
		this.lblNomDuVoilier2 = new JLabel("Nom du voilier: ");
		lblNomDuVoilier2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblNomDuVoilier2);
		
		this.tfNomVoilier2 = new JTextField();
		tfNomVoilier2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfNomVoilier2);
		
		this.lblClasseVoilier2 = new JLabel("Classe du voilier : ");
		lblClasseVoilier2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblClasseVoilier2);
		
		this.tfClasse2 = new JTextField();
		tfClasse2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfClasse2);
		
		this.lblRating2 = new JLabel("Rating : ");
		lblRating2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblRating2);
		
		this.tfRatingV2 = new JTextField();
		tfRatingV2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfRatingV2);
		
		this.btnModifier = new JButton("Modifier");
		btnModifier.setBounds(300, 480, 190, 39);
		this.btnModifier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				Bdd.modifParticipantBdd(numAModifier, tfNom2.getText(), tfPrenom2.getText(), tfNomVoilier2.getText(), Integer.parseInt(tfClasse2.getText()), Integer.parseInt(tfRatingV2.getText()));
				JOptionPane.showMessageDialog(panelPrincipal, "Le participant n° "+(numAModifier+1)+" a bien été modifié ! ");
				int input = JOptionPane.showConfirmDialog(panelPrincipal, "Voulez-vous modifier un autre participant ?");
				if(input == 0) {
					window.modifierParticipant();
					
				}else {
					window.ajouteAccueil();
				}
				
			}
		});
		
		
		panelPrincipal.add(btnModifier);
		panelPrincipal.repaint();
		
	}
	
	

}
	
