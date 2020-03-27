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

public class FenSupprimeRegate extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Window window;
	
	private JLabel lblNomRegate, lblDateRegate, lblLieuDepart, lblLieuArrivee, lblDistanceRegate;
	private JPanel panelParticipantASupp, panelPrincipal;
	
	private JLabel lblRegateASupp;
	private JPanel panelTitle;
	private JButton btnSupprimer;
	
	private JLabel lblNom = new JLabel();
	private JLabel lblDate = new JLabel();
	private JLabel lblDepart = new JLabel();
	private JLabel lblArrivee = new JLabel();
	private JLabel lblDistance = new JLabel();
	
	
	public FenSupprimeRegate(Window window){
		
		this.window = window;
		
		lblNom.setText(String.valueOf(Bdd.getRegate(0).getNomRegate()));
		lblDate.setText(String.valueOf(Bdd.getRegate(0).getDateRegate()));
		lblDepart.setText(String.valueOf(Bdd.getRegate(0).getLieuDepart()));
		lblArrivee.setText(String.valueOf(Bdd.getRegate(0).getLieuArrivee()));
		lblDistance.setText(String.valueOf(Bdd.getRegate(0).getDistance()));
		
	}
	
	
	public void supprimeRegate() {
		
		this.panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 782, 553);
		this.window.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		this.panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 782, 50);
		panelPrincipal.add(panelTitle);
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.lblRegateASupp = new JLabel("RÉGATE \u00C0 SUPPRIMER");
		lblRegateASupp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegateASupp.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelTitle.add(lblRegateASupp);
		
		
		this.panelParticipantASupp = new JPanel();
		panelParticipantASupp.setBounds(12, 63, 738, 417);
		panelPrincipal.add(panelParticipantASupp);
		
		panelParticipantASupp.setLayout(new GridLayout(0, 2, 0, 10));
		
		this.lblNomRegate = new JLabel("Nom de la régate : ");
		lblNomRegate.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblNomRegate);
		
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblNom);
		
		this.lblDateRegate = new JLabel("Date : ");
		lblDateRegate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblDateRegate);
		
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblDate);
		
		this.lblLieuDepart = new JLabel("Lieu de départ :");
		lblLieuDepart.setHorizontalAlignment(SwingConstants.CENTER);
		lblLieuDepart.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblLieuDepart);
		
		lblDepart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepart.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblDepart);
		
		this.lblLieuArrivee = new JLabel("Lieu d'arrivée :");
		lblLieuArrivee.setHorizontalAlignment(SwingConstants.CENTER);
		lblLieuArrivee.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblLieuArrivee);
		
		lblArrivee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArrivee.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblArrivee);
		
		this.lblDistanceRegate = new JLabel("Rating : ");
		lblDistanceRegate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelParticipantASupp.add(lblDistanceRegate);
		
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistance.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipantASupp.add(lblDistance);
		
		this.btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(305, 487, 190, 39);
		this.btnSupprimer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				Bdd.SupprimeRegateBdd(0);
				JOptionPane.showMessageDialog(panelPrincipal, "La régate a bien été supprimé ! ");
				window.ajouteAccueil();
				
				
			}
		});
		
		
		panelPrincipal.add(btnSupprimer);
		panelPrincipal.repaint();
		
		
	}

}
