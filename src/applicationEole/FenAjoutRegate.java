package applicationEole;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class FenAjoutRegate extends JFrame {

	private static final long serialVersionUID = 1L;

	private Window window;
	
	private JLabel lblNomRegate, lblDate, lblLieuDepart, lblLieuArrivee, lblDistance, lblTitle;
	private JTextField tfNomRegate, tfLieuDepart, tfLieuArrivee, tfDistance;
	private JPanel panelAjoutRegate, panelTitle;
	private JButton btnAjouter;
	private MaskFormatter maskFormat = null;
    private JFormattedTextField tfDate;
	
	
	public FenAjoutRegate(Window window) {
		this.window = window;
		
	}
	
	
	public void creationPanelAjoutRegate() {
		
		this.panelTitle = new JPanel();
		this.panelTitle.setBounds(10, 10, 764, 57);
		this.panelTitle.setLayout(null);
		this.window.getContentPane().add(panelTitle);
		
		this.lblTitle = new JLabel("AJOUT R\u00C9GATE");
		this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTitle.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		this.lblTitle.setBounds(10, 14, 744, 32);
		this.panelTitle.add(lblTitle);
		
		this.panelAjoutRegate = new JPanel();
		this.panelAjoutRegate.setBounds(200, 80, 400, 440);
		this.window.getContentPane().add(panelAjoutRegate);
		
		panelAjoutRegate.setLayout(new GridLayout(0, 1, 0, 10));
		
		this.lblNomRegate = new JLabel("Nom de la r\u00E9gate :  ");
		lblNomRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelAjoutRegate.add(lblNomRegate);
		
		this.tfNomRegate = new JTextField(15); 
		this.tfNomRegate.setEditable(true);
		tfNomRegate.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelAjoutRegate.add(tfNomRegate);
		
		this.lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelAjoutRegate.add(lblDate);
		
		try {
			maskFormat = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		this.tfDate = new JFormattedTextField(maskFormat);
		this.tfDate.setEditable(true);
		tfDate.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelAjoutRegate.add(tfDate);
		
		this.lblLieuDepart = new JLabel("Lieu de d\u00E9part : ");
		lblLieuDepart.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelAjoutRegate.add(lblLieuDepart);
		
		this.tfLieuDepart = new JTextField(15);
		this.tfLieuDepart.setEditable(true);
		tfLieuDepart.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelAjoutRegate.add(tfLieuDepart);
		
		this.lblLieuArrivee = new JLabel("Lieu d'arriv\u00E9e :");
		lblLieuArrivee.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelAjoutRegate.add(lblLieuArrivee);
		
		this.tfLieuArrivee = new JTextField(15);
		this.tfLieuArrivee.setEditable(true);
		tfLieuArrivee.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelAjoutRegate.add(tfLieuArrivee);
		
		this.lblDistance = new JLabel("Distance :");
		lblDistance.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		
		this.panelAjoutRegate.add(lblDistance);
		
		this.tfDistance = new JTextField(15);
		this.tfDistance.setEditable(true);
		tfDistance.setFont(new Font("Arial", Font.PLAIN, 25));
		this.panelAjoutRegate.add(tfDistance);
		
		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e){
				Regate regate = new Regate(tfNomRegate.getText(), tfDate.getText(), tfLieuDepart.getText(), tfLieuArrivee.getText(), Integer.parseInt(tfDistance.getText()));
				Bdd.AjoutRegateBdd(regate);
				JOptionPane.showMessageDialog(panelAjoutRegate, "La régate a bien été créée !");
				window.ajouteAccueil();		
			}
		});
		
		this.btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.panelAjoutRegate.add(btnAjouter);
		
		
		KeyListener ListenerCaracDate = (new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (c >= 48 && c <= 57) {
                    
                } else {
                    evt.consume();
                }
                
            }
        });
		
		tfDate.addKeyListener(ListenerCaracDate);
		tfDistance.addKeyListener(ListenerCaracDate);
		
	}
	
}
