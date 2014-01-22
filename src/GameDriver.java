import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is the main class and it runs and displays
 * the program and makes the menu bar options etc
 * 
 * @author Eileen Balci 
 * @version v1.0
 */
public class GameDriver { 

		private static GameGUI game = new GameGUI();
		
		/**
		 * Runs the Game
		 */
		public static void main(String[] args) {
			
			JFrame window = new JFrame("FINANCE");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			window.getContentPane().add(game);
			makeMenuBar(window);//adds the menu bar
			
			//makes it so users can't resize window
			window.setPreferredSize(new Dimension(657, 450));
			window.setResizable(false);
		
			window.pack();
			window.setVisible(true);
			
		}
		
		/**
	     * Create the main frame's menu bar.
	     * which will hold menu options such as
	     * Quit which will quit the program
	     * 
	     * Taken from: 
	     * 	Objects First with Java a Pratical Intro Using BlueJ
	     *  Authors: Michael Kolling and David J Barnes 
	     *  Modified by: Eileen Balci
	     */
	    private static void makeMenuBar(JFrame frame)
	    {
	    	//used to make shortcut keys
	        final int SHORTCUT_MASK =
	            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

	        JMenuBar menubar = new JMenuBar();
	        frame.setJMenuBar(menubar);
	        	       
	        JMenuItem item;
	        JMenu menu;
	
	        // put a spacer into the menubar, so the next menu appears to the right
	        menubar.add(Box.createHorizontalGlue());

	        // create the Help menu
	        menu = new JMenu("Help");
	        menubar.add(menu);
	        
	        item = new JMenuItem("How To Play...");
	            item.addActionListener(new ActionListener() {
	                               public void actionPerformed(ActionEvent e) 
	                               { 
	                            	   showAbout(); 
	                               }
	                           });
	        menu.add(item);
	        
	        //will allow user to quit but selecting it from the menu
	        //or by using the shortcut ctr+Q
	        item = new JMenuItem("Quit");
	            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
	            item.addActionListener(new ActionListener() {
	                               public void actionPerformed(ActionEvent e) 
	                               { 
	                            	   quit(); 
	                               }
	                           });
	        menu.add(item);
	    }
	    
	    /**
	     * Quit function: quit the application.
	     */
	    private static void quit()
	    {
	        System.exit(0);
	    }
	    
	    /**
	     * An explaination of the
	     * Connect Four game and how to play.
	     */
	    private static void showAbout()
	    {
	        JOptionPane.showMessageDialog(null, 
	                    "FINANCIAL LEARNING GAME\n" + 
	                    "A one player game that involves puzzle solving skills.\n\n" +
	                    "Try to guess the word using the definition\n and finding what letters are " + 
	                    "in the word using the buttons or keyboard.\n If you guess a correct letter, it will show up" +
	                    " in the location it would be in the word\n" +
	                    "if you guess all the letters in the word\n" +
	                    "or if you think you know the word and you type it in the text field" +
	                    " and get it right money will be added to your score!" + 
	                    "\nIf you guess an incorrect word or letter you will lose a chance\n" +
	                    "and you won't gain as much money. If you lose all your guessing chances then you lose twenty cents." +
	                    "\nIf you click on the \"Give Up\" button it will deduct $1.00 from your score,\n" +
	                    "but it will also tell you what the word was and continue the game with the next word in the word bank." +
	                    "\n\n\nGood luck and\nENJOY THE GAME! Try to make the most profit possible!");
	    }
}
