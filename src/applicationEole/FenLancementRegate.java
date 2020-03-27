package applicationEole;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class FenLancementRegate extends JFrame {

	private Window window;
	
	private static final long serialVersionUID = 1L;
	private FenListeParticipant listeParticipant = new FenListeParticipant(this.window);
	private FenRegateLancee regateLancee = new FenRegateLancee(window);
	private JPanel panelListeParticipant, panelPrincipal, panelBouton;
	private JScrollPane tableParticipants;
	private JButton btnLancementRegate;
	private JLabel lblLanceRegate;
	
	
	
	
	public FenLancementRegate(Window window) {
		this.window = window;
		
	}
	
	
	public void createLancementRegate() {
		
		this.panelPrincipal  = new JPanel();
		panelPrincipal.setBounds(12, 5, 758, 45);
		this.window.add(panelPrincipal);
		this.panelBouton = new JPanel();
		this.window.add(panelBouton);
		
		
		this.panelListeParticipant  = new JPanel();
		this.tableParticipants = listeParticipant.getScrollPane();
		this.panelListeParticipant.setBounds(12, 63, 758, 396);
		this.panelListeParticipant.add(tableParticipants, BorderLayout.CENTER);
		this.window.add(panelListeParticipant);
		
		
		this.lblLanceRegate = new JLabel("Liste des participants inscrit dans la régate :  ");
		panelPrincipal.add(lblLanceRegate);
		this.lblLanceRegate.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblLanceRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		getContentPane().setLayout(null);
		panelListeParticipant.setLayout(new BorderLayout(0, 0));
		
		this.panelBouton.setBounds(0, 472, 782, 45);
		this.panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.btnLancementRegate = new JButton("Lancement de la régate");
		this.panelBouton.add(btnLancementRegate);
		
		this.btnLancementRegate.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e){
				window.gestionRegate();
			}
		});
		
		this.btnLancementRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		
	}
}
