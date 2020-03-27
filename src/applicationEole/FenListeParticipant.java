package applicationEole;

import java.awt.Font;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;



public class FenListeParticipant extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelTableParticipant, panelTitreRegate;
	private JLabel lblSelRegate;
	private Window window;
	private JScrollPane scrollPane;
	private JTable tableParticipants;

	public FenListeParticipant(Window window) {
	
		this.window = window;	

	}
	
	public void creationListeParticipants() {
		
		this.panelTitreRegate = new JPanel();
		this.panelTitreRegate.setBounds(12, 5, 758, 45);
		this.panelTitreRegate.setLayout(null);
		this.window.add(panelTitreRegate);
		
		this.lblSelRegate = new JLabel("Liste des participants inscrit : ");
		this.lblSelRegate.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSelRegate.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		this.lblSelRegate.setBounds(10, 14, 744, 32);
		this.panelTitreRegate.add(lblSelRegate);
		
		
		this.panelTableParticipant = new JPanel();
		this.panelTableParticipant.setBounds(12, 63, 758, 396);
		this.panelTableParticipant.setLayout(null);
		this.window.add(panelTableParticipant);
		
		innitTableau();
		this.panelTableParticipant.add(scrollPane);

	
		
	}
	
	
	public void innitTableau() {
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 13, 742, 371);
		
		this.tableParticipants = new JTable(20,5);
		this.tableParticipants.setEnabled(false);
		this.scrollPane.setViewportView(tableParticipants);
		this.tableParticipants.setFillsViewportHeight(true);
		this.tableParticipants.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
					"Numéro participant","Nom", "Prénom", "Voilier", "Classe", "Rating"
			}
		));
		tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(45);
		tableParticipants.getColumnModel().getColumn(2).setPreferredWidth(45);
		this.tableParticipants.setRowHeight(18);
		this.tableParticipants.setFont(new Font("Arial", Font.PLAIN, 15));
		
		Participant participant;
		
		for (int i=0; i<Bdd.getListeParticipants().size(); i++) {
			
			participant = Bdd.getParticipant(i);
			tableParticipants.setValueAt(participant.getIdParticipant(), i, 0);
			tableParticipants.setValueAt(participant.getNom(), i, 1);
			tableParticipants.setValueAt(participant.getPrenom(), i, 2);
			tableParticipants.setValueAt(participant.getNomVoilier(), i, 3);
			tableParticipants.setValueAt(participant.getClasseVoilier(), i, 4);
			tableParticipants.setValueAt(participant.getRatingVoilier(), i, 5);
		}
		
	}


	public JScrollPane getScrollPane() {
		innitTableau();
		return scrollPane;
	}
	
	

	
	
	
	

}

