package applicationEole;



public class Main {
	
	

	public static void main(String[] args) {
			
		Window window = new Window("Gestion des r�gates",800,600);
		window.createWindow();
		window.createMenu();
		window.ajouteAccueil();
		window.setVisible(true);
	}
}
