package applicationEole;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int height;
	private int length;
	private JPanel contentPane;

	public Window(String name, int height, int length) {
		this.name = name;
		this.height = height;
		this.length = length;
	}
		
	public void createWindow() {
		setTitle(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, height, length);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		reinitContentPane();
	}
	
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAccueil = new JMenu("Accueil");
		menuBar.add(mnAccueil);
		
		JMenuItem mntmReturnAccueil = new JMenuItem("Retourner à l'accueil");
		mntmReturnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouteAccueil();
			}
		});
		mnAccueil.add(mntmReturnAccueil);
		
		JMenu mnRgate = new JMenu("Régate");
		menuBar.add(mnRgate);
		
		JMenuItem mntmNouvelleRgate = new JMenuItem("Nouvelle régate");
		mntmNouvelleRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Bdd.nbRegate() > 0) {
					JOptionPane.showMessageDialog(contentPane, "Vous avez déjà créé une nouvelle régate.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					ajouterRegate();
				}
				
			}
		});
		mnRgate.add(mntmNouvelleRgate);
		
		JMenuItem mntmModifierRgate = new JMenuItem("Modifier régate");
		mntmModifierRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Bdd.nbRegate() > 0) {
					modifierRegate();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Veuillez créer une nouvelle régate.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		mnRgate.add(mntmModifierRgate);
		
		
		JMenuItem mntmSupprimerRgate = new JMenuItem("Supprimer régate");
		mntmSupprimerRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Bdd.nbRegate() > 0) {
					supprimerRegate();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Veuillez créer une nouvelle régate.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		mnRgate.add(mntmSupprimerRgate);
		
		
		JMenuItem mntmLancerRgate = new JMenuItem("Lancer régate");
		mntmLancerRgate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lancerRegate();
			}
		});
		mnRgate.add(mntmLancerRgate);
		
		JMenu mnParticipants = new JMenu("Participants");
		menuBar.add(mnParticipants);
		
		JMenuItem mntmAjouterParticipant = new JMenuItem("Ajouter participant");
		mntmAjouterParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterParticipant();
			}
		});
		mnParticipants.add(mntmAjouterParticipant);
		
		
		
		JMenuItem mntmModifierParticipant = new JMenuItem("Modifier participant");
		mntmModifierParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Bdd.nbParticipants() > 0) {
					modifierParticipant();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Veuillez saisir au moins un participant.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		mnParticipants.add(mntmModifierParticipant);
		
		JMenuItem mntmSupprimerParticipant = new JMenuItem("Supprimer participant");
		mntmSupprimerParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Bdd.nbParticipants() > 0) {
					supprimerParticipant();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Veuillez saisir au moins un participant.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnParticipants.add(mntmSupprimerParticipant);
		
		JMenuItem mntmListerParticipant = new JMenuItem("Lister participant");
		mntmListerParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listerParticipant();
			}
		});
		mnParticipants.add(mntmListerParticipant);
		
		
		JMenu mnClassement = new JMenu("Classement");
		menuBar.add(mnClassement);
		
		
		JMenuItem mntmClassementParCatgorie = new JMenuItem("Classement par catégorie");
		mntmClassementParCatgorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				classementRegate();
			}
		});
		mnClassement.add(mntmClassementParCatgorie);
		
		
	}

	
	public void reinitContentPane() {
		contentPane.removeAll();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void ajouteAccueil(){
		reinitContentPane();
		FenAccueil accueil = new FenAccueil(this);
		accueil.createAccueil();
		contentPane.revalidate();
	}
	
	public void ajouterParticipant(){
		reinitContentPane();
		FenAjoutParticipant nouveauParticipant = new FenAjoutParticipant(this);
		nouveauParticipant.createNewParticipant();
		contentPane.revalidate();
	}
	
	public void modifierParticipant(){
		reinitContentPane();
		FenModifParticipant modifParticipant = new FenModifParticipant(this);
		modifParticipant.modifParticipant();
		contentPane.revalidate();
	}
	
	public void supprimerParticipant(){
		reinitContentPane();
		FenSupprimeParticipant supprimeParticipant = new FenSupprimeParticipant(this);
		supprimeParticipant.suppParticipant();
		contentPane.revalidate();
	}
	
	public void listerParticipant(){
		reinitContentPane();
		FenListeParticipant supprimeParticipant = new FenListeParticipant(this);
		supprimeParticipant.creationListeParticipants();
		contentPane.revalidate();
	}
	
	public void ajouterRegate(){
		reinitContentPane();
		FenAjoutRegate nouvelleRegate = new FenAjoutRegate(this);
		nouvelleRegate.creationPanelAjoutRegate();
		contentPane.revalidate();
	}
	
	public void modifierRegate(){
		reinitContentPane();
		FenModifRegate modifRegate = new FenModifRegate(this);
		modifRegate.creationPanelModifRegate();
		contentPane.revalidate();
	}
	
	public void supprimerRegate(){
		reinitContentPane();
		FenSupprimeRegate suppRegate = new FenSupprimeRegate(this);
		suppRegate.supprimeRegate();
		contentPane.revalidate();
	}
	
	public void lancerRegate(){
		reinitContentPane();
		FenLancementRegate lanceRegate = new FenLancementRegate(this);
		lanceRegate.createLancementRegate();
		contentPane.revalidate();
	}
	
	public void gestionRegate(){
		reinitContentPane();
		FenRegateLancee lanceRegate = new FenRegateLancee(this);
		lanceRegate.createGestionRegate();
		lanceRegate.RemplirPanelParticipant();
		contentPane.revalidate();
	}
	
	public void classementRegate(){
		ajouteAccueil();
		FenClassementRegate classementRegate = new FenClassementRegate(this);
		classementRegate.triParticipantParClasse();
		classementRegate.triParticipantParTemps();
		classementRegate.creationClassement();
		contentPane.revalidate();
	}
	

	
}
