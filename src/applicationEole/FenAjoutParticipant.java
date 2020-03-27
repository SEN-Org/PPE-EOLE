package applicationEole;

import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;

public class FenAjoutParticipant extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private Window window;
	
	private JLabel lblNomParticipant, lblPrenomParticipant, lblNomDuVoilier, lblClasseVoilier, lblRating, lblTitle;
	private JTextField tfNomParticipant, tfPrenomParticipant, tfNomDuVoilier, tfClasseVoilier, tfRating;
	private JPanel panelNewParticipant, panelTitle;
	private JButton btnAjouter;

	
	public FenAjoutParticipant(Window window){
		
		this.window = window;
		
		
	}
	
	
	public void createNewParticipant() {
		
		this.panelTitle = new JPanel();
		this.panelTitle.setBounds(10, 10, 764, 57);
		this.panelTitle.setLayout(null);
		this.window.getContentPane().add(panelTitle);
		
		this.lblTitle = new JLabel("AJOUT PARTICIPANT");
		this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTitle.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		this.lblTitle.setBounds(10, 14, 744, 32);
		this.panelTitle.add(lblTitle);
		
		this.panelNewParticipant = new JPanel();
		this.panelNewParticipant.setBounds(200, 80, 400, 440);
		this.window.getContentPane().add(panelNewParticipant);
		
		panelNewParticipant.setLayout(new GridLayout(0, 1, 0, 10));
		
		this.lblNomParticipant = new JLabel("Nom du participant: ");
		lblNomParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelNewParticipant.add(lblNomParticipant);
		
		this.tfNomParticipant = new JTextField(15); 
		this.tfNomParticipant.setEditable(true);
		tfNomParticipant.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelNewParticipant.add(tfNomParticipant);
		
		this.lblPrenomParticipant = new JLabel("Prénom : ");
		lblPrenomParticipant.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelNewParticipant.add(lblPrenomParticipant);
		
		this.tfPrenomParticipant = new JTextField(15);
		this.tfPrenomParticipant.setEditable(true);
		tfPrenomParticipant.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelNewParticipant.add(tfPrenomParticipant);
		
		this.lblNomDuVoilier = new JLabel("Nom du voilier: ");
		lblNomDuVoilier.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelNewParticipant.add(lblNomDuVoilier);
		
		this.tfNomDuVoilier = new JTextField(15);
		this.tfNomDuVoilier.setEditable(true);
		tfNomDuVoilier.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelNewParticipant.add(tfNomDuVoilier);
		
		this.lblClasseVoilier = new JLabel("Classe du voilier : ");
		lblClasseVoilier.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelNewParticipant.add(lblClasseVoilier);
		
		this.tfClasseVoilier = new JTextField(15);
		this.tfClasseVoilier.setEditable(true);
		tfClasseVoilier.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelNewParticipant.add(tfClasseVoilier);
		
		this.lblRating = new JLabel("Rating : ");
		lblRating.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelNewParticipant.add(lblRating);
		
		this.tfRating = new JTextField(15);
		this.tfRating.setEditable(true);
		tfRating.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelNewParticipant.add(tfRating);
		
		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e){
				if(Bdd.nbParticipants() < 20) {
					if(Integer.parseInt(tfClasseVoilier.getText()) == 1 || Integer.parseInt(tfClasseVoilier.getText()) == 2){
						
						Skipper skipper = new Skipper(tfNomParticipant.getText(),tfPrenomParticipant.getText());
						Voilier voilier = new Voilier(tfNomDuVoilier.getText(),Integer.parseInt(tfClasseVoilier.getText()), Integer.parseInt(tfRating.getText()), skipper);
						Participant participant = new Participant(skipper, voilier);
						Bdd.AjoutParticipantBdd(participant);
						JOptionPane.showMessageDialog(panelNewParticipant, "Le participant a bien été ajouté ! ");
						int input = JOptionPane.showConfirmDialog(panelNewParticipant, "Voulez-vous ajouter un autre participant ?");
						if(input == 0) {
							window.ajouterParticipant();
							
						}else {
							window.ajouteAccueil();
						}
						
					}else {
						JOptionPane.showMessageDialog(panelNewParticipant, "Veuillez saisir un numéro de classe valide.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JPanel p = new JPanel();
					JLabel lblError = new JLabel("Il est impossible de rajouter un 21ème participant à la régate.");
					lblError.setFont(new Font("Arial", Font.PLAIN, 20));
					p.add(lblError);
					JOptionPane.showMessageDialog(panelNewParticipant, p, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
						
			}
		});
		
		this.btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.panelNewParticipant.add(btnAjouter);
		
		KeyListener ListenerCaracClasse = (new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (c == 49 || c == 50) {
                    
                } else {
                    evt.consume();
                }
                if(tfClasseVoilier.getText().length() > 0) {
                	evt.consume();
                }
                
            }
        });
		
		KeyListener ListenerCaracRating = (new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (c >= 48 && c <= 57) {
                    
                } else {
                    evt.consume();
                }
                if(tfRating.getText().length() > 3) {
                	evt.consume();
                }
                
            }
        });
		
		tfClasseVoilier.addKeyListener(ListenerCaracClasse);
		tfRating.addKeyListener(ListenerCaracRating);
		
		
		
	}
	
}
