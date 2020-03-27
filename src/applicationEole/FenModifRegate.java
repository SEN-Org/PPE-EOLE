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

public class FenModifRegate extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Window window;
	
	private JLabel lblNomRegate, lblDateRegate, lblLieuDepart, lblLieuArrivee, lblDistanceRegate, lblRegateNonModif;
	private JPanel panelModif1, panelPrincipal;
	
	private JLabel lblNomRegate2, lblDateRegate2, lblLieuDepart2, lblLieuArrivee2, lblDistanceRegate2, lblRegateModifie;
	private JPanel panelModif2, panelTitle2, panelModif;
	
	private JTextField tfNom, tfDate, tfDepart, tfArrivee, tfDistance;
	private JButton btnModifier;
	private JLabel lblNom = new JLabel();
	private JLabel lblDate = new JLabel();
	private JLabel lblDepart = new JLabel();
	private JLabel lblArrivee = new JLabel();
	private JLabel lblDistance = new JLabel();
	
	
	public FenModifRegate(Window window) {
		this.window = window;
		
		
		lblNom.setText(String.valueOf(Bdd.getRegate(0).getNomRegate()));
		lblDate.setText(String.valueOf(Bdd.getRegate(0).getDateRegate()));
		lblDepart.setText(String.valueOf(Bdd.getRegate(0).getLieuDepart()));
		lblArrivee.setText(String.valueOf(Bdd.getRegate(0).getLieuArrivee()));
		lblDistance.setText(String.valueOf(Bdd.getRegate(0).getDistance()));
		
	}
	
	
	
	public void creationPanelModifRegate() {
		
		this.panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 782, 553);
		this.window.getContentPane().add(panelPrincipal);
		
		panelPrincipal.setLayout(null);
		this.panelTitle2 = new JPanel();
		panelTitle2.setBounds(0, 0, 782, 50);
		panelPrincipal.add(panelTitle2);
		panelTitle2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.lblRegateNonModif = new JLabel("REGATE NON - MODIFI\u00C9");
		this.lblRegateNonModif.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblRegateNonModif.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		this.panelTitle2.add(lblRegateNonModif);
		
		this.lblRegateModifie = new JLabel("REGATE MODIFI\u00C9");
		lblRegateModifie.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegateModifie.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelTitle2.add(lblRegateModifie);
		
		this.panelModif = new JPanel();
		panelModif.setBounds(20, 64, 750, 408);
		panelPrincipal.add(panelModif);
		panelModif.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelModif1 = new JPanel();
		panelModif.add(panelModif1);
		
		panelModif1.setLayout(new GridLayout(0, 1, 0, 10));
		
		this.lblNomRegate = new JLabel("Nom de la r\u00E9gate : ");
		lblNomRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblNomRegate);
		
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblNom);
		
		this.lblDateRegate = new JLabel("Date :");
		lblDateRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblDateRegate);
		
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblDate);
		
		this.lblLieuDepart = new JLabel("Lieu du d\u00E9part :");
		lblLieuDepart.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblLieuDepart);
		
		lblDepart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblDepart);
		
		this.lblLieuArrivee = new JLabel("Lieu d'arriv\u00E9e");
		lblLieuArrivee.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblLieuArrivee);
		
		lblArrivee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblArrivee);
		
		this.lblDistanceRegate = new JLabel("Distance :");
		lblDistanceRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelModif1.add(lblDistanceRegate);
		
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif1.add(lblDistance);
		
		this.panelModif2 = new JPanel();
		panelModif.add(panelModif2);
		panelModif2.setLayout(new GridLayout(0, 1, 0, 10));
		
		this.lblNomRegate2 = new JLabel("Nom de la r\u00E9gate : ");
		lblNomRegate2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblNomRegate2);
		
		this.tfNom = new JTextField();
		tfNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfNom);
		
		this.lblDateRegate2 = new JLabel("Date :");
		lblDateRegate2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblDateRegate2);
		
		this.tfDate = new JTextField();
		tfDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfDate);
		
		this.lblLieuDepart2 = new JLabel("Lieu du d\u00E9part :");
		lblLieuDepart2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblLieuDepart2);
		
		this.tfDepart = new JTextField();
		tfDepart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfDepart);
		
		this.lblLieuArrivee2 = new JLabel("Lieu d'arriv\u00E9e");
		lblLieuArrivee2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblLieuArrivee2);
		
		this.tfArrivee = new JTextField();
		tfArrivee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfArrivee);
		
		this.lblDistanceRegate2 = new JLabel("Distance :");
		lblDistanceRegate2.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		panelModif2.add(lblDistanceRegate2);
		
		this.tfDistance = new JTextField();
		tfDistance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelModif2.add(tfDistance);
		
		this.btnModifier = new JButton("Modifier");
		btnModifier.setBounds(300, 480, 190, 39);
		this.btnModifier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				Bdd.modifRegateBdd(tfNom.getText(), tfDate.getText(), tfDepart.getText(), tfArrivee.getText(), Integer.parseInt(tfDistance.getText()));
				JOptionPane.showMessageDialog(panelPrincipal, "La régate a bien été modifié ! ");
				window.ajouteAccueil();
				
			}
		});
		
		
		panelPrincipal.add(btnModifier);
		panelPrincipal.repaint();
	}
}
