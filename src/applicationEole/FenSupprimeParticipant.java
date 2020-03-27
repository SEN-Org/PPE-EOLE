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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class FenSupprimeParticipant extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Window window;
	
	private JLabel lblNomParticipant, lblPrenomParticipant, lblNomDuVoilier, lblClasseVoilier, lblRating, lblnumParticipant;
	private JPanel panelParticipantASupp, panelPrincipal;
	
	private JLabel lblParticipantASupp;
	private JPanel panelTitle;
	private JButton btnSupprimer;
	
	private JLabel lblNum = new JLabel();
	private JLabel lblNom = new JLabel();
	private JLabel lblPrenom = new JLabel();
	private JLabel lblNomVoilier = new JLabel();
	private JLabel lblCategorie = new JLabel();
	private JLabel lblRatingV = new JLabel();
	
	private int numASupprimer;
	
	
	
	public FenSupprimeParticipant(Window window){
		
		this.window = window;
		numASupprimer = Integer.parseInt(JOptionPane.showInputDialog("Veuillez entrer le numero du participant à supprimer"));
		numASupprimer -= 1;
		
		lblNum.setText(String.valueOf(Bdd.getParticipant(numASupprimer).getIdParticipant()));
		lblNom.setText(String.valueOf(Bdd.getParticipant(numASupprimer).getNom()));
		lblPrenom.setText(String.valueOf(Bdd.getParticipant(numASupprimer).getPrenom()));
		lblNomVoilier.setText(String.valueOf(Bdd.getParticipant(numASupprimer).getNomVoilier()));
		lblCategorie.setText(String.valueOf(Bdd.getParticipant(numASupprimer).getClasseVoilier()));
		lblRatingV.setText(String.valueOf(Bdd.getParticipant(numASupprimer).getRatingVoilier()));
		
	}
	
	
	public void suppParticipant() {
		
		this.panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 782, 553);
		this.window.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		this.panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 782, 50);
		panelPrincipal.add(panelTitle);
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.lblParticipantASupp = new JLabel("PARTICIPANT \u00C0 SUPPRIMER");
		lblParticipantASupp.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticipantASupp.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelTitle.add(lblParticipantASupp);
		
		
		this.panelParticipantASupp = new JPanel();
		panelParticipantASupp.setBounds(12, 63, 738, 417);
		panelPrincipal.add(panelParticipantASupp);
		
		panelParticipantASupp.setLayout(new GridLayout(0, 2, 0, 10));
		
		
		this.lblnumParticipant = new JLabel("Num\u00E9ro du participant : ");
		lblnumParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		lblnumParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblnumParticipant);
		
		
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblNum);
		
		this.lblNomParticipant = new JLabel("Nom du participant: ");
		lblNomParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblNomParticipant);
		
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblNom);
		
		this.lblPrenomParticipant = new JLabel("Prénom : ");
		lblPrenomParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenomParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblPrenomParticipant);
		
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblPrenom);
		
		this.lblNomDuVoilier = new JLabel("Nom du voilier: ");
		lblNomDuVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomDuVoilier.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblNomDuVoilier);
		
		lblNomVoilier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblNomVoilier);
		
		this.lblClasseVoilier = new JLabel("Classe du voilier : ");
		lblClasseVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasseVoilier.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblClasseVoilier);
		
		lblCategorie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblCategorie);
		
		this.lblRating = new JLabel("Rating : ");
		lblRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblRating.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblRating);
		
		lblRatingV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRatingV.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblRatingV);
		
		this.btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(305, 487, 190, 39);
		this.btnSupprimer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				Bdd.SupprimeParticipantBdd(numASupprimer);
				JOptionPane.showMessageDialog(panelPrincipal, "Le participant n° "+(numASupprimer+1)+" a bien été supprimé ! ");
				if(Bdd.getListeParticipants().isEmpty() == false) {
					
					int input = JOptionPane.showConfirmDialog(panelPrincipal, "Voulez-vous supprimer un autre participant ?");
					if(input == 0) {
						window.modifierParticipant();
						
					}else {
						window.ajouteAccueil();
					}
				}else {
					window.ajouteAccueil();
				}
				
				
			}
		});
		
		
		panelPrincipal.add(btnSupprimer);
		panelPrincipal.repaint();
		
		
	}
	
	

}
	
