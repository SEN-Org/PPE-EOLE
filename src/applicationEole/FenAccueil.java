package applicationEole;

import javax.swing.*;
import java.awt.Window;

public class FenAccueil extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	private JLabel JImageBateau = new JLabel(new ImageIcon("images/bateau5.gif"));
	private JPanel cpImage = new JPanel();
	Window window;
	
	
	public FenAccueil(Window window)
	{
		this.window= window;
	}
	
	public void createAccueil()
	{
		this.cpImage.setBounds(0, 0, window.getWidth(), window.getHeight());
		this.cpImage.add(JImageBateau);
		this.window.add(cpImage);
	}

}
