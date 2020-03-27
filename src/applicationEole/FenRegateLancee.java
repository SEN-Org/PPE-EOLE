package applicationEole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JButton;

public class FenRegateLancee extends JFrame{

	private static final long serialVersionUID = 1L;
	private Window window;
	
	private GestRegate gestRegate = new GestRegate();
	private JPanel panelTitre, panelGestRegate, panelBoutonTerminer ;
	private JLabel[] jlabelParticipant = new JLabel[20];
	private JLabel[] jlabelParticipantTime = new JLabel[20];
	private JButton[] jbuttonSTOP = new JButton [20];
	private JButton[] jbuttonABANDON = new JButton [20];
	private JButton[] jbuttonMODIF = new JButton [20];
	private JPanel[] jpanels = new JPanel [20];
	private ActionListener l1, l2;
	private Chrono chrono = new Chrono();
	private long tempsDepart=0;
    private long tempsFin=0;
    private long duree=0;
    String temps;
    private boolean estTermine = false;
	
	
	public FenRegateLancee(Window window) {
		this.window = window ;
		tempsDepart=System.currentTimeMillis();
		
		
	}
	
	public void createGestionRegate() {
		
		this.panelTitre = new JPanel();
		panelTitre.setBounds(12, 5, 758, 45);
		this.window.add(panelTitre);
		
		JLabel lblTitre = new JLabel("Gestion de la régate");
		lblTitre.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		panelTitre.add(lblTitre);
		
		this.panelGestRegate = new JPanel();
		panelGestRegate.setBounds(12, 63, 758, 405);
		this.window.add(panelGestRegate);
		panelGestRegate.setLayout(new GridLayout(10, 2, 0, 0));
		
		this.panelBoutonTerminer = new JPanel();
		panelBoutonTerminer.setBounds(12, 480, 758, 45);
		this.window.add(panelBoutonTerminer);
		
		
		
		for(int i = 0; i<Bdd.nbParticipants(); i++) {
			jpanels[i] = new JPanel();
			//jlabelParticipant[i] = new JLabel(Bdd.getParticipant(i).getNomVoilier());
			jlabelParticipant[i] = new JLabel(Bdd.getParticipant(i).getNomVoilier()+" :");
			jlabelParticipantTime[i] = new JLabel("En course");
			jbuttonSTOP[i] = new JButton("STOP");
			jbuttonMODIF[i] = new JButton("MODIF");
			jbuttonMODIF[i].setEnabled(false);
			
			jbuttonSTOP[i].addActionListener(new ActionListener() {
		    
		        public void actionPerformed(ActionEvent e) {
		        	for(int y = 0; y<Bdd.nbParticipants(); y++) {
		        		if(e.getSource().equals(jbuttonSTOP[y])) {
		        			tempsFin = System.currentTimeMillis();
		        			duree=(tempsFin-tempsDepart);
		        			temps = chrono.timeToHMS(duree/1000);
		        			jlabelParticipantTime[y].setText(temps);
		        			jbuttonSTOP[y].setEnabled(false);
		        			jbuttonABANDON[y].setEnabled(false);
		        			jbuttonMODIF[y].setEnabled(true);
		        			Bdd.getParticipant(y).setTempsReel((int)Math.round(duree/1000));
		        			Bdd.getParticipant(y).setTempsCompense(gestRegate.tempsCompenses(Bdd.getParticipant(y).getTempsReel(), Bdd.getParticipant(y), Bdd.getRegate(0)));
		        			Bdd.getParticipant(y).setTempsCompenseString(chrono.timeToHMS(Bdd.getParticipant(y).getTempsCompense()));
		        		}
		        	}
		        	
		            
		        }
		    });
			
			
			
			jbuttonABANDON[i] = new JButton("ABANDON");
			jbuttonABANDON[i].addActionListener(new ActionListener() {
		    
		        public void actionPerformed(ActionEvent e) {
		        	for(int y = 0; y<Bdd.nbParticipants(); y++) {
		        		if(e.getSource().equals(jbuttonABANDON[y])) {
		        			jlabelParticipantTime[y].setText("00:00:00");
		        			jbuttonSTOP[y].setEnabled(false);
		        			jbuttonABANDON[y].setEnabled(false);
		        			jbuttonMODIF[y].setEnabled(true);
		        		}
		        	}
		        	
		            
		        }
		    });
			
			jbuttonMODIF[i].addActionListener(new ActionListener() {
		    
		        public void actionPerformed(ActionEvent e) {
		        	for(int y = 0; y<Bdd.nbParticipants(); y++) {
		        		if(e.getSource().equals(jbuttonMODIF[y])) {
		        			jlabelParticipantTime[y].setText("En course");
		        			jbuttonSTOP[y].setEnabled(true);
		        			jbuttonABANDON[y].setEnabled(true);
		        		}
		        	}
		        	
		            
		        }
		    });
			
			jpanels[i].add(jlabelParticipant[i]);
			jpanels[i].add(jlabelParticipantTime[i]);
			jpanels[i].add(jbuttonSTOP[i]);
			jpanels[i].add(jbuttonABANDON[i]);
			jpanels[i].add(jbuttonMODIF[i]);
					
			jlabelParticipant[i].setFont(new Font("Arial", Font.PLAIN, 20));
			jlabelParticipantTime[i].setFont(new Font("Arial", Font.PLAIN, 20));
			panelGestRegate.add(jpanels[i]);

		}
		
		JButton btnTermineRegate = new JButton("Terminer la régate");
		btnTermineRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		panelBoutonTerminer.add(btnTermineRegate);
		btnTermineRegate.addActionListener(new ActionListener() {
		    
	        public void actionPerformed(ActionEvent e) {
	        	int input = JOptionPane.showConfirmDialog(panelGestRegate, "Voulez-vous vraiment terminer la course ?\n Tous les participants non-arrivés seront mis en statut 'Abandon'");
				if(input == 0) {
					for(int y = 0; y<Bdd.nbParticipants(); y++) {
						jbuttonMODIF[y].setEnabled(false);
		        		if(jlabelParticipantTime[y].getText() == "En course") {
		        			jlabelParticipantTime[y].setText("00:00:00");
		        			jbuttonSTOP[y].setEnabled(false);
		        			jbuttonABANDON[y].setEnabled(false);
		        		}else {
		        			
		        		}
		        	}
					JOptionPane.showMessageDialog(panelGestRegate, "Vous pouvez maintenant accéder aux classements de la régate.");
					btnTermineRegate.setEnabled(false);
					
				}else {
					
				}
	        	
	        	
	            
	        }
	    });
		
		
		
		
	}
	
	
	public void RemplirPanelParticipant() {
		
		
		
	}
	
}
