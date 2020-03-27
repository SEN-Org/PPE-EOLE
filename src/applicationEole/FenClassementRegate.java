package applicationEole;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.Dimension;

public class FenClassementRegate extends JFrame {
	
	private Window window;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panelTitre, panelPrincipal ;
	private JTable tableParticipants, tableParticipants2;
	private JLabel lblClassementClasse1, lblClassementClasse2;
	private JScrollPane scrollPaneClasse1, scrollPaneClasse2;
	private ArrayList<Participant> listClasse1, listClasse2;
	
	public FenClassementRegate(Window window) {
		this.window = window;
		
	}
	
	public void triParticipantParClasse() {
		listClasse1 = new ArrayList<Participant>();
		listClasse2 = new ArrayList<Participant>();
		
		Participant participant;
		
		for (int i=0; i<Bdd.getListeParticipants().size(); i++) {
			
			participant = Bdd.getParticipant(i);
			
			if(participant.getClasseVoilier() == 1) {
				
				listClasse1.add(participant);
				
			}else if(participant.getClasseVoilier() == 2){
				
				listClasse2.add(participant);
			}
		}
		
	}
	
	
	public void triParticipantParTemps() {
		
		Participant participant;
		
		// Classement de la première liste ------------------------------------------
		
		for (int i=0; i<listClasse1.size(); i++) {
			participant = listClasse1.get(i);
			for (int y=1; y<listClasse1.size(); y++) {
				if(participant.getTempsCompense() > listClasse1.get(y).getTempsCompense()) {
					listClasse1.set(i, listClasse1.get(y));
					listClasse1.set(y, participant);
				}
			}
			
			
		}
		
		
		// Classement de la deuxième liste ------------------------------------------
		
		for (int i=0; i<listClasse2.size(); i++) {
			participant = listClasse2.get(i);
			for (int y=1; y<listClasse2.size(); y++) {
				if(participant.getTempsCompense() > listClasse2.get(y).getTempsCompense()) {
					listClasse2.set(i, listClasse2.get(y));
					listClasse2.set(y, participant);
				}
			}
			
			
		}
		
	}
	
	
	
	public void creationClassement() {
		
		setBounds(0,0,1400,700);
		getContentPane().setLayout(null);
		
		this.panelTitre  = new JPanel();
		panelTitre.setBounds(12, 5, 1358, 45);
		getContentPane().add(panelTitre);
		panelTitre.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		this.panelPrincipal  = new JPanel();
		panelPrincipal.setBounds(15, 70, 1355, 300);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel panel = new JPanel();
		panelTitre.add(panel);
		
		lblClassementClasse1 = new JLabel("Classement classe 1 :");
		lblClassementClasse1.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassementClasse1.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		panel.add(lblClassementClasse1);
		
		JPanel panel_1 = new JPanel();
		panelTitre.add(panel_1);
		
		
		this.lblClassementClasse2 = new JLabel("Classement classe 2 :");
		panel_1.add(lblClassementClasse2);
		this.lblClassementClasse2.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblClassementClasse2.setFont(new Font("Goudy Old Style", Font.PLAIN, 30));
		getContentPane().setLayout(null);
		
		tableParticipants = new JTable();
		tableParticipants.setBounds(12, 63, 670, 577);
		tableParticipants.setFont(new Font("Arial", Font.PLAIN, 30));
		
		tableParticipants2 = new JTable();
		tableParticipants2.setBounds(700, 63, 670, 577);
		tableParticipants2.setFont(new Font("Arial", Font.PLAIN, 30));
		
		innitTableauClasse1();
		innitTableauClasse2();
		scrollPaneClasse1.setPreferredSize(new Dimension(700,520));
		scrollPaneClasse2.setPreferredSize(new Dimension(700,520));
		
		this.panelPrincipal.add(scrollPaneClasse1);
		this.panelPrincipal.add(scrollPaneClasse2);
		
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new BorderLayout(0, 0));
		panelContainer.add(panelTitre, BorderLayout.NORTH);
		panelContainer.add(panelPrincipal, BorderLayout.CENTER);
		
		JOptionPane.showMessageDialog(this, panelContainer, "Classement par classe des régates", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	public void innitTableauClasse1() {
		
		this.scrollPaneClasse1 = new JScrollPane();
		this.scrollPaneClasse1.setBounds(12, 63, 670, 577);
		
		
		this.tableParticipants = new JTable(20,5);
		this.tableParticipants.setEnabled(false);
		this.scrollPaneClasse1.setViewportView(tableParticipants);
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
					"Numéro participant","Nom", "Prénom", "Voilier", "Rating","Temps réalisé"
			}
		));
		tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(45);
		tableParticipants.getColumnModel().getColumn(2).setPreferredWidth(45);
		this.tableParticipants.setRowHeight(25);
		this.tableParticipants.setFont(new Font("Arial", Font.PLAIN, 15));
		
		Participant participant;
		
		for (int i=0; i<listClasse1.size(); i++) {
			
			participant = listClasse1.get(i);
			tableParticipants.setValueAt(participant.getIdParticipant(), i, 0);
			tableParticipants.setValueAt(participant.getNom(), i, 1);
			tableParticipants.setValueAt(participant.getPrenom(), i, 2);
			tableParticipants.setValueAt(participant.getNomVoilier(), i, 3);
			tableParticipants.setValueAt(participant.getRatingVoilier(), i, 4);
			tableParticipants.setValueAt(participant.getTempsCompenseString(), i, 5);
		}
		
	}
	
	public void innitTableauClasse2() {
		
		this.scrollPaneClasse2 = new JScrollPane();
		this.scrollPaneClasse2.setBounds(700, 63, 670, 577);
		
		this.tableParticipants2 = new JTable(20,5);
		scrollPaneClasse2.setViewportView(tableParticipants2);
		this.tableParticipants2.setEnabled(false);
		this.tableParticipants2.setFillsViewportHeight(true);
		this.tableParticipants2.setModel(new DefaultTableModel(
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
					"Numéro participant","Nom", "Prénom", "Voilier", "Rating","Temps réalisé"
			}
		));
		tableParticipants2.getColumnModel().getColumn(1).setPreferredWidth(45);
		tableParticipants2.getColumnModel().getColumn(2).setPreferredWidth(45);
		this.tableParticipants2.setRowHeight(25);
		this.tableParticipants2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		Participant participant;
		
		for (int i=0; i<listClasse2.size(); i++) {
			
			participant = listClasse2.get(i);
			tableParticipants2.setValueAt(participant.getIdParticipant(), i, 0);
			tableParticipants2.setValueAt(participant.getNom(), i, 1);
			tableParticipants2.setValueAt(participant.getPrenom(), i, 2);
			tableParticipants2.setValueAt(participant.getNomVoilier(), i, 3);
			tableParticipants2.setValueAt(participant.getRatingVoilier(), i, 4);
			tableParticipants2.setValueAt(participant.getTempsCompenseString(), i, 5);
		}
		
	}
}
