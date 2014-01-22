import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.*;

/**
 * This Class contains all the logic and components for the
 * Financial Learning game and GUI
 * 
 * The object of the game is to guess the word that fits the definition/phrase
 * with the least amount of incorrect guesses to gain the most amount of points.
 * The user will have to guess from a predefined set of words and when they go through
 * all the words, the user will have an option to start a new game or exit.
 * 
 * The user loses if they run out of money or ends the game with less money then
 * they started with "negative profit" or if they run out of words. A user wins if they make a "profit" once they run out of 
 * words (to achieve the highest score is to guess all the words correctly with no incorrect letter
 * guesses)
 * 
 * The words are retrieved from a text file where the first line of input is the number of words followed by
 * one line containing the word and then a second line containing that words definition (example below)
 * 
 * 3
 * word1
 * the first word in the list is ______
 * foobar
 * ______ is a term used in computer science
 * Recursion
 * see ______
 * 
 * The ability to make your own word list no longer makes this just a financial terms learning project but
 * now can be applied to many different things! Yay for versatility! 
 * 
 * @author Eileen Balci (ebalci@radford.edu)
 * @version v1.0
 */
public class GameGUI extends JPanel { 
		
		/*------- GUI Variables: ------*/
		//PANELS:
		  //game board
		private static JPanel gameBoard;
		private static JPanel display;
		private static JPanel definitions;
		  //score board
		private static JPanel scoreBoard;
		private static JPanel header;
		private static JPanel footer;
		private static JPanel buttonsBoard;
		private static JPanel scoreStuff;
		 	
		//LABELS:
		  //displays nothing
		private static JLabel blank;
		  //displays how many chances to guess they have left before losing
		private static JLabel chancesLeft;
		  //displays a message next to the guess button
		private static JTextField message;
		  //displays copyright
		private static JLabel copyRight;
		  //displays the definition
		private static JTextArea wordDef;
		  //displays users current score
		private static JLabel scoreInfo;
		  //displays users points to be gained/lost (+/-)
		private static JLabel pointInfo;
		  //displays number of words left to guess
		private static JLabel wordsLeft;
		 
		  //game board images (makes the money image) ImagesLocator is used
		  //because when the project is made into a .jar, the images don't show up
		  //using this ImagesLocator class fixes that problem.
		private static final ImageIcon T_1 = 
			ImagesLocator.getImage("images/t1.jpg");
		private static final ImageIcon T_2 = 
			ImagesLocator.getImage("images/t2.jpg");
		private static final ImageIcon T_3 = 
			ImagesLocator.getImage("images/t3.jpg");
		private static final ImageIcon T_4 = 
			ImagesLocator.getImage("images/t4.jpg");
		private static final ImageIcon T_5 = 
			ImagesLocator.getImage("images/t5.jpg");
		private static final ImageIcon T_6 = 
			ImagesLocator.getImage("images/t6.jpg");
		private static final ImageIcon T_7 = 
			ImagesLocator.getImage("images/t7.jpg");
		private static final ImageIcon T_8 = 
			ImagesLocator.getImage("images/t8.jpg");
		private static final ImageIcon T_9 = 
			ImagesLocator.getImage("images/t9.jpg");
		private static final ImageIcon T_10 = 
			ImagesLocator.getImage("images/t10.jpg");
		private static final ImageIcon M_1 = 
			ImagesLocator.getImage("images/m1-1.jpg");
		private static final ImageIcon M_2 = 
			ImagesLocator.getImage("images/m1-2.jpg");
		private static final ImageIcon M_3 = 
			ImagesLocator.getImage("images/m1-3.jpg");
		private static final ImageIcon M_4 = 
			ImagesLocator.getImage("images/m1-4.jpg");
		private static final ImageIcon M_5 = 
			ImagesLocator.getImage("images/m1-5.jpg");
		private static final ImageIcon M_6 = 
			ImagesLocator.getImage("images/m1-6.jpg");
		private static final ImageIcon M_7 = 
			ImagesLocator.getImage("images/m1-7.jpg");
		private static final ImageIcon M_8 = 
			ImagesLocator.getImage("images/m1-8.jpg");
		private static final ImageIcon M_9 = 
			ImagesLocator.getImage("images/m1-9.jpg");
		private static final ImageIcon M_10 = 
			ImagesLocator.getImage("images/m1-10.jpg");
		private static final ImageIcon M_11 = 
			ImagesLocator.getImage("images/m2-1.jpg");
		private static final ImageIcon M_12 = 
			ImagesLocator.getImage("images/m2-2.jpg");
		private static final ImageIcon M_13 = 
			ImagesLocator.getImage("images/m2-3.jpg");
		private static final ImageIcon M_14 = 
			ImagesLocator.getImage("images/m2-4.jpg");
		private static final ImageIcon M_15 = 
			ImagesLocator.getImage("images/m2-5.jpg");
		private static final ImageIcon M_16 = 
			ImagesLocator.getImage("images/m2-6.jpg");
		private static final ImageIcon M_17 = 
			ImagesLocator.getImage("images/m2-7.jpg");
		private static final ImageIcon M_18 = 
			ImagesLocator.getImage("images/m2-8.jpg");
		private static final ImageIcon M_19 = 
			ImagesLocator.getImage("images/m2-9.jpg");
		private static final ImageIcon M_20 = 
			ImagesLocator.getImage("images/m2-10.jpg");
		private static final ImageIcon B_1 = 
			ImagesLocator.getImage("images/b1.jpg");
		private static final ImageIcon B_2 = 
			ImagesLocator.getImage("images/b2.jpg");
		private static final ImageIcon B_3 = 
			ImagesLocator.getImage("images/b3.jpg");
		private static final ImageIcon B_4 = 
			ImagesLocator.getImage("images/b4.jpg");
		private static final ImageIcon B_5 = 
			ImagesLocator.getImage("images/b5.jpg");
		private static final ImageIcon B_6 = 
			ImagesLocator.getImage("images/b6.jpg");
		private static final ImageIcon B_7 = 
			ImagesLocator.getImage("images/b7.jpg");
		private static final ImageIcon B_8 = 
			ImagesLocator.getImage("images/b8.jpg");
		private static final ImageIcon B_9 = 
			ImagesLocator.getImage("images/b9.jpg");
		private static final ImageIcon B_10 = 
			ImagesLocator.getImage("images/b10.jpg");
		private static final ImageIcon B_11 = 
			ImagesLocator.getImage("images/b-1.jpg");
		private static final ImageIcon B_12 = 
			ImagesLocator.getImage("images/b-2.jpg");
		private static final ImageIcon B_13 = 
			ImagesLocator.getImage("images/b-3.jpg");
		private static final ImageIcon B_14 = 
			ImagesLocator.getImage("images/b-4.jpg");
		private static final ImageIcon B_15 = 
			ImagesLocator.getImage("images/b-5.jpg");
		private static final ImageIcon B_16 = 
			ImagesLocator.getImage("images/b-6.jpg");
		private static final ImageIcon B_17 = 
			ImagesLocator.getImage("images/b-7.jpg");
		private static final ImageIcon B_18 = 
			ImagesLocator.getImage("images/b-8.jpg");
		private static final ImageIcon B_19 = 
			ImagesLocator.getImage("images/b-9.jpg");
		private static final ImageIcon B_20 = 
			ImagesLocator.getImage("images/b-10.jpg");
		private static final ImageIcon INIT =
			ImagesLocator.getImage("images/blank.jpg");
		
		//BUTTONS:
		  //letter buttons
		private static JButton lA, lB, lC, lD, lE, lF, lG, lH, lI, lJ, lK, lL, 
			lM, lN, lO, lP, lQ, lR, lS, lT, lU, lV, lW, lX, lY, lZ, 
			guess, newWord, giveUp;	

		/*-------- Logic Variables: --------*/
		//Scanner to read the File that contains the words
		private static Scanner scan;
		
		//Constant Variables
		private static final int NUM_ROWS = 12;
		private static final int NUM_COLS = 12;
		//first thing in the data file is a number (the number of words)
		private static int TOTAL_WORDS;
		//define constants, this allows for variations of the game
		//and you only have to change the values in one place.
		private static final double INIT_SCORE = 5.00;
		private static final int INIT_CHANCES = 6;
		private static final double INIT_POINTS = 1.00;
		
		//Counters with their initial values
		  //counts how many chances are left
		private static int chances = INIT_CHANCES;
		  //holds the users score (starts at 5 bucks)
		private static double score = INIT_SCORE;
		  //holds points to be added/subtracted
		private static double points = INIT_POINTS;
		  //holds number of words left
		private static int wordsRemaining;
		 
		 
		//Strings
		  //determines what word to guess
		private static String wordChoice = "";	
		  //the definition of the wordChoice
		private static String def = "";
		  //displays + or - in front of points gained or lost
		private static String posORneg = "+";
		
		//Booleans
		  //if the user wins this boolean variable will be true
		private static boolean didWin = false;
		  //if this boolean is true it means that the user made a word guess
		private static boolean guessingWholeWord = false;

		//ARRAYS
		//creates a game array that holds JLabels which will fill 
		//the game board with the INIT/MONEY ImageIcons at initialization
		private static JLabel[][] gameArray = new JLabel[NUM_ROWS][NUM_COLS]; 
		
		//creates an array of words for the game to randomly choose from
		private static String[] wordArray;
		
		//holds the index number of the word from the wordArray and matches it with 
		//the corresponding definition
		private static HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
		
		//holds the indexes of the used indexes in getting words, this is to prevent repeated words
		//and to use all the words once
		private static ArrayList<Integer> list = new ArrayList<Integer>();
		
		//RANDOM
		   //used to retrieve a random number to match the index which will get a word and
		   //its definition/phrase
		private static Random randWord = new Random();
	
		/**
		 * Constructs components, 
		 * assigns variables and adds them
		 * to their panels when the game is created.
		 * 
		 * sets up all the initial game stuff and GUI
		 */
		public GameGUI()
		{
			//first read the words/defs from the file and create the array and hashmap for the game
			try{
				File wordsFile = new File("./words.dat");
			    scan = new Scanner(wordsFile); //will be used to scan the file
			    TOTAL_WORDS = scan.nextInt(); //first item in the file is the number of words
			  
			    scan.nextLine(); //eat up one line
			    wordArray = new String[TOTAL_WORDS]; //makes the array large enough for all the words
			    wordsRemaining = TOTAL_WORDS; //updates words remaining
			}catch (Exception e){
				System.out.println("NO SUCH FILE");
				System.exit(0);
			}
	
			addWords(); //add words from file (populate list)
			getWord(); //get a word from the list			
			
			//set up the game board 
			setLayout(new BorderLayout()); //main layout for 'this' JPanel
			setFocusable(true); //gives focus to main panel for key listener to work			
			
			//sub-JPanels to  be added to 'this' JPanel
			gameBoard = new JPanel();
			scoreBoard = new JPanel();
			buttonsBoard = new JPanel();
			definitions = new JPanel();
			header = new JPanel();
			footer = new JPanel();
			scoreStuff = new JPanel();
			
			addKeyListener(new LetterKeyListener()); //adds key listener
			addMouseListener(new FocusMouseListener()); //allows for focus to
			                                            //be regained for
			                                            //the key listener after
			                                            //a button has been used
			
			//set layouts for all sub-JPanels
			gameBoard.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
			header.setLayout(new GridLayout(4, 1));
			footer.setLayout(new GridLayout(2, 1));
			scoreBoard.setLayout(new BorderLayout());
			buttonsBoard.setLayout(new GridLayout(4, 7));
			scoreStuff.setLayout(new GridLayout(2, 3));
			
			//set colors for panels 
			gameBoard.setBackground(Color.white);

			gameBoard.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(2, 
					Color.LIGHT_GRAY, Color.GRAY), 
					BorderFactory.createLineBorder(Color.DARK_GRAY, 5)));
	
			//initialize stuff for the score board
			blank = new JLabel("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
			
			message = new JTextField();
			message.setText("If you think you know the word enter your guess here");
			
			chancesLeft = new JLabel("You Only Have: " + getChancesLeft() + " more guess(es) left");
			
			wordDef = new JTextArea();
			wordDef.setBackground(null);
			wordDef.setFont (new Font ("defalut", Font.BOLD, 14));
			wordDef.setEditable(false);
						
			chancesLeft.setFont (new Font ("Sydnie", Font.BOLD, 18));
			
			copyRight = new JLabel("                   Eileen Balci - ITEC493 - Radford University");
			copyRight.setFont (new Font ("defalut", Font.BOLD, 10));
						
		    //fill the gameBoard with the initial ImageIcons
			fill();
			//creates the word spaces in the game board
			createSpaces();
					
			//initialize all buttons
			lA = new JButton("A");
			lB = new JButton("B"); 
			lC = new JButton("C"); 
			lD = new JButton("D"); 
			lE = new JButton("E"); 
			lF = new JButton("F"); 
			lG = new JButton("G"); 
			lH = new JButton("H"); 
			lI = new JButton("I"); 
			lJ = new JButton("J"); 
			lK = new JButton("K"); 
			lL = new JButton("L"); 
			lM = new JButton("M"); 
			lN = new JButton("N"); 
			lO = new JButton("O"); 
			lP = new JButton("P"); 
			lQ = new JButton("Q"); 
			lR = new JButton("R"); 
			lS = new JButton("S"); 
			lT = new JButton("T"); 
			lU = new JButton("U"); 
			lV = new JButton("V"); 
			lW = new JButton("W"); 
			lX = new JButton("X"); 
			lY = new JButton("Y"); 
			lZ = new JButton("Z"); 
			newWord = new JButton("New Word");
			giveUp = new JButton("Give Up");
			guess = new JButton("Take a Guess?");
			
			//add the button listener to the buttons
			lA.addActionListener (new LetterButtonListener());
			lB.addActionListener (new LetterButtonListener());
			lC.addActionListener (new LetterButtonListener());
			lD.addActionListener (new LetterButtonListener());
			lE.addActionListener (new LetterButtonListener());
			lF.addActionListener (new LetterButtonListener());
			lG.addActionListener (new LetterButtonListener());
			lH.addActionListener (new LetterButtonListener());
			lI.addActionListener (new LetterButtonListener());
			lJ.addActionListener (new LetterButtonListener());
			lK.addActionListener (new LetterButtonListener()); 
			lL.addActionListener (new LetterButtonListener());
			lM.addActionListener (new LetterButtonListener());
			lN.addActionListener (new LetterButtonListener()); 
			lO.addActionListener (new LetterButtonListener());
			lP.addActionListener (new LetterButtonListener()); 
			lQ.addActionListener (new LetterButtonListener());
			lR.addActionListener (new LetterButtonListener());
			lS.addActionListener (new LetterButtonListener());
			lT.addActionListener (new LetterButtonListener());
			lU.addActionListener (new LetterButtonListener());
			lV.addActionListener (new LetterButtonListener());
			lW.addActionListener (new LetterButtonListener());
			lX.addActionListener (new LetterButtonListener());
			lY.addActionListener (new LetterButtonListener()); 
			lZ.addActionListener (new LetterButtonListener());
			
			giveUp.addActionListener (new LetterButtonListener());
			newWord.addActionListener (new LetterButtonListener());
			guess.addActionListener(new LetterButtonListener()); //not part of the buttonsBoard
			
			//add buttons to the buttons board
			buttonsBoard.add(lA);
			buttonsBoard.add(lB);
			buttonsBoard.add(lC);
			buttonsBoard.add(lD);
			buttonsBoard.add(lE);			
			buttonsBoard.add(lF);
			buttonsBoard.add(lG);
			buttonsBoard.add(lH);
			buttonsBoard.add(lI);
			buttonsBoard.add(lJ);
			buttonsBoard.add(lK);
			buttonsBoard.add(lL);
			buttonsBoard.add(lM);
			buttonsBoard.add(lN);
			buttonsBoard.add(lO);
			buttonsBoard.add(lP);
			buttonsBoard.add(lQ);
			buttonsBoard.add(lR);
			buttonsBoard.add(lS);
			buttonsBoard.add(lT);
			buttonsBoard.add(lU);
			buttonsBoard.add(lV);
			buttonsBoard.add(lW);
			buttonsBoard.add(lX);
			buttonsBoard.add(lY);
			buttonsBoard.add(lZ);
			
			buttonsBoard.add(newWord);
			buttonsBoard.add(giveUp);
			
			newWord.setEnabled(false);
			
			//set up the word and definition 
			definitions.setPreferredSize(new Dimension(328, 182));
			wordDef.setText(def);
			definitions.add(wordDef);
			
			//set up the score information
			JLabel head1 = new JLabel("Total Score:");
			JLabel head2 = new JLabel("Points (+/-):");
			JLabel head3 = new JLabel("Words Left:");
			scoreInfo = new JLabel(NumberFormat.getCurrencyInstance().format(score));
			pointInfo = new JLabel(posORneg + NumberFormat.getCurrencyInstance().format(points));
			wordsLeft = new JLabel(getWordsRemaining() + "/" + TOTAL_WORDS);
			
			scoreStuff.add(head1);
			scoreStuff.add(head2);
			scoreStuff.add(head3);
			scoreStuff.add(scoreInfo);
			scoreStuff.add(pointInfo);
			scoreStuff.add(wordsLeft);
			
			//set up the score board stuff
			header.add(chancesLeft);
			header.add(blank);
			header.add(message);
			header.add(guess);
			footer.add(scoreStuff);
			footer.add(copyRight);
			
			//add the word/definition and score board stuff to the score board panel
			scoreBoard.add(header, BorderLayout.NORTH);
			scoreBoard.add(definitions, BorderLayout.CENTER);
			scoreBoard.add(footer, BorderLayout.SOUTH);

			//adds all the JPanels to the BorderLayout for 'this' JPanel
			add(scoreBoard, BorderLayout.EAST);
			add(gameBoard, BorderLayout.CENTER);
			add(buttonsBoard, BorderLayout.SOUTH);
		}
		
		/**
		 * This method fills the game with the correct
		 * initial images
		 */
		public void fill()
		{
	        //fill the board with labels and set the icons 
			//to the correct images
			for(int rows=0; rows < NUM_ROWS; rows++){
				for(int cols=0; cols < NUM_COLS; cols++){
					if(rows==1 && cols==1){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_1);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==2){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_2);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==3){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_3);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==4){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_4);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==5){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_5);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==6){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_6);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==7){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_7);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==8){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_8);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==9){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_9);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==1 && cols==10){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(T_10);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==1){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_1);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==2){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_2);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==3){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_3);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==4){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_4);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==5){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_5);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==6){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_6);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==7){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_7);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==8){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_8);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==9){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_9);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==2 && cols==10){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_10);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==1){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_11);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==2){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_12);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==3){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_13);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==4){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_14);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==5){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_15);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==6){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_16);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==7){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_17);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==8){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_18);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==9){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_19);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==3 && cols==10){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(M_20);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==1){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_1);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==2){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_2);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==3){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_3);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==4){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_4);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==5){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_5);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==6){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_6);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==7){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_7);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==8){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_8);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==9){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_9);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==4 && cols==10){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_10);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==1){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_11);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==2){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_12);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==3){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_13);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==4){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_14);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==5){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_15);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==6){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_16);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==7){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_17);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==8){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_18);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==9){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_19);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else if(rows==5 && cols==10){
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setIcon(B_20);
						gameBoard.add(gameArray[rows][cols]);
						
					}
					else{
						//fill the board with the initial image
						gameArray[rows][cols] = new JLabel();
						gameArray[rows][cols].setText("");
						gameBoard.add(gameArray[rows][cols]);
					}
				}
			}
		}
		
		/**
		 * This method reads the text file and
		 * adds the words to the 'dictionary'
		 */
		public void addWords(){
			int i = 0;
			while(scan.hasNextLine() && i<TOTAL_WORDS){
				String word = scan.nextLine();
				String defLine = scan.nextLine();
				
				/* 
				 * The inputed string with a \n gets translated literally 
				 * so this part of the code is to actually put a new line
				 * in the string, with out this code the string: hello\nworld
				 * would print in the game as: hello\nworld
				 * but with this code it prints out: 
				 * hello
				 * world
				 */
				String def="";
				for(int c=0; c<defLine.length(); c++){
					if(defLine.charAt(c)=='\\'){
						
						c++; //eat the n
						def = def + "\n";
					}
					else{
						def = def + defLine.charAt(c);
					}
				}
				//debugging statements
				//System.out.println("word: " + word);
				//System.out.println("def: " + def);
				
				//add the word to the array and then add the word and definition pair to
				//the dictionary (hash map)
				wordArray[i] = word; //get the word 
				dictionary.put(i, def); //put the word, and the definition
										//in the dictionary
				i++; 
			}
				
		}
		
		/**
		 * Update the score after the user either guesses
		 * the word correctly or runs out of chances to guess.
		 */
		public void update(){
			//subtract from the words left
			wordsRemaining--;
			wordsLeft.setText(getWordsRemaining() + "/" + TOTAL_WORDS);
			//add points to score
			score += points;
			if(score < 0.0){ //didn't want them to have a negative score
				scoreInfo.setText(NumberFormat.getCurrencyInstance().format(0.0));
			}
			else{
				scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
			}
			
			//The word was fully guessed, make it red!
			for(int i = 0; i < getLength(); i++){
				gameArray[NUM_ROWS-2][i].setForeground(Color.RED);
			}
		}
		
		/**
		 * This method returns the number of chances left
		 * @return the number of chances left
		 */
		public int getChancesLeft(){
			return chances;
		}
		
		/**
		 * This method returns the number of words remaining
		 * @return number of words remaining
		 */
		public int getWordsRemaining(){
			return wordsRemaining;
		}
		
		/**
		 * This method gets the definition for the particular
		 * word that matches the definition
		 * (using the key value from the word array and matching
		 * it with the value in the hash map)
		 * 
		 * (to be used in the getWord method so you can get the 
		 * word and definition at the same time given the randomIndex)
		 * @param index to retrieve the word to be guessed from the hash map
		 * @return the definition for the word to be guessed
		 */
		public String getWordDef(int index){
			return dictionary.get(index);
		}
		
		/**
		 * This method gets a word randomly out of the 
		 * string array that holds the different words
		 * but will not repeat words
		 * @return a word for guessing
		 */
		public String getWord()
		{
			//find a random integer from 0 to 15 inclusive (this is because there
			//are only 15 words)
			int randomIndex = randWord.nextInt(TOTAL_WORDS);
			
			//find a randomIndex for a word that hasn't been used yet
			while(list.contains(randomIndex)){
				randomIndex = randWord.nextInt(TOTAL_WORDS);
			}
				
			wordChoice = wordArray[randomIndex].toUpperCase();
			def = getWordDef(randomIndex); //gets the definition for the word gotten
			list.add(randomIndex); //this list holds used words
			return wordChoice;
			
		}
		
		/**
		 * Gets the length of the word and returns it
		 * @return an integer that represents the length of the word
		 */
		public int getLength(){
			return wordChoice.length();
		}
		
		/**
		 * This method creates the spaces needed for the word
		 * (the underscores)
		 */
		public void createSpaces(){
			
			//gets the length and puts it in a variable
			int wordsLength = getLength();
			
			//the row stays the same, but the column will change
			//for each letter present in the word
			for(int i=0; i < wordsLength; i++){
				gameArray[NUM_ROWS-2][i].setText("_");
				gameBoard.add(gameArray[NUM_ROWS-2][i]);
			}
		}
		
		/** 
		 * This method is the one used to guess a letter
		 * (for the buttons/key listener)
		 * @param letter is the letter the user wants to guess.
		 */
		public void guessLetter(String letter){

			String guessingLetter = letter;
			
			if(wordChoice.contains(guessingLetter)){

				//if the letter appears 1 to 4 times in a word, this will find all 4
				//occurrences (if there are more than 4 occurrences, then... it doesn't work...
				int indexOfFirst = wordChoice.indexOf(guessingLetter);
				int indexOfMid = wordChoice.indexOf(guessingLetter, indexOfFirst+1);
				int indexOfMid2 = wordChoice.indexOf(guessingLetter, indexOfMid+1);
				int indexOfLast = wordChoice.lastIndexOf(guessingLetter);
				
				gameArray[NUM_ROWS-2][indexOfFirst].setText(guessingLetter.toUpperCase());
				gameArray[NUM_ROWS-2][indexOfLast].setText(guessingLetter.toUpperCase());
			    
				//in order to prevent an index out of bounds exception
				if(indexOfMid != -1){
					gameArray[10][indexOfMid].setText(guessingLetter.toUpperCase());
				}
				else{
					//do nothing
				}
				
				if(indexOfMid2 != -1){
					gameArray[NUM_ROWS-2][indexOfMid2].setText(guessingLetter.toUpperCase());
				}
				else{
					//do nothing
				}
				
				winChecker(); //check if the user guessed correctly
			}
			else{
				wrongGuess(); //the guess was wrong
			}
		}
		
		/**
		 * This method is used when the user guesses the whole word
		 * at one time using the text field and guess button
		 * @param letter is each individual letter in the word
		 */
		public void guessWord(String letter){

			String guessingLetter = letter;
			
			if(wordChoice.contains(guessingLetter)){
				
				//if the letter appears 1 to 4 times in a word, this will find all 4
				//occurrences (if there are more than 4 occurrences, then... it doesn't work...
				int indexOfFirst = wordChoice.indexOf(guessingLetter);
				int indexOfMid = wordChoice.indexOf(guessingLetter, indexOfFirst+1);
				int indexOfMid2 = wordChoice.indexOf(guessingLetter, indexOfMid+1);
				int indexOfLast = wordChoice.lastIndexOf(guessingLetter);
				
				gameArray[NUM_ROWS-2][indexOfFirst].setText(guessingLetter.toUpperCase());
				gameArray[NUM_ROWS-2][indexOfFirst].setForeground(Color.RED);
				gameArray[NUM_ROWS-2][indexOfLast].setText(guessingLetter.toUpperCase());
				gameArray[NUM_ROWS-2][indexOfLast].setForeground(Color.RED);
			    
				//in order to prevent an index out of bounds exception
				if(indexOfMid != -1){
					gameArray[NUM_ROWS-2][indexOfMid].setText(guessingLetter.toUpperCase());
					gameArray[NUM_ROWS-2][indexOfMid].setForeground(Color.RED);
				}
				else{
					//do nothing
				}
				
				if(indexOfMid2 != -1){
					gameArray[NUM_ROWS-2][indexOfMid2].setText(guessingLetter.toUpperCase());
					gameArray[NUM_ROWS-2][indexOfMid2].setForeground(Color.RED);
				}
				else{
					//do nothing
				}
				
			}
			else{
				//do nothing
			}
		}
		/**
		 * This method takes away from the 1000 dollar bill image and
		 * subtracts money from the players total score
		 */
		public void wrongGuess(){
			//subtract guessing chances left
			//remove pieces from the money image
			//and subtract points from total score
			
			chances--;
			chancesLeft.setText("You Only Have: " + getChancesLeft() + " more guess(es) left");
			if(chances==5){
				gameArray[1][6].setIcon(INIT);
				gameArray[2][5].setIcon(INIT);
				gameArray[3][6].setIcon(INIT);
				gameArray[4][6].setIcon(INIT);
				gameArray[5][1].setIcon(INIT);
				gameArray[1][4].setIcon(INIT);
				gameArray[5][2].setIcon(INIT);
				gameArray[4][4].setIcon(INIT);
				gameArray[2][8].setIcon(INIT);
				gameArray[2][4].setIcon(INIT);
				//change point amount for the round
				points -= .20;
				pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
				chancesLeft.setForeground(Color.magenta.darker());
			}
			else if(chances==4){
				gameArray[1][3].setIcon(INIT);
				gameArray[2][6].setIcon(INIT);
				gameArray[3][5].setIcon(INIT);
				gameArray[4][1].setIcon(INIT);
				gameArray[5][4].setIcon(INIT);
				gameArray[5][1].setIcon(INIT);
				gameArray[1][7].setIcon(INIT);
				gameArray[2][10].setIcon(INIT);
				gameArray[3][7].setIcon(INIT);
				gameArray[5][3].setIcon(INIT);
				gameArray[4][7].setIcon(INIT);
				gameArray[2][7].setIcon(INIT);
				//change point amount for the round
				points -= .20;
				pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
				chancesLeft.setForeground(Color.blue.darker());
			}
			else if(chances==3){
				gameArray[1][8].setIcon(INIT);
				gameArray[2][4].setIcon(INIT);
				gameArray[3][3].setIcon(INIT);
				gameArray[4][2].setIcon(INIT);
				gameArray[5][1].setIcon(INIT);
				gameArray[3][8].setIcon(INIT);
				gameArray[5][6].setIcon(INIT);
				gameArray[1][3].setIcon(INIT);
				gameArray[2][3].setIcon(INIT);
				gameArray[4][10].setIcon(INIT);
				//change point amount for the round
				points -= .20;
				pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
				chancesLeft.setForeground(Color.green.darker());
			}
			else if(chances==2){
				gameArray[1][9].setIcon(INIT);
				gameArray[2][3].setIcon(INIT);
				gameArray[3][4].setIcon(INIT);
				gameArray[4][3].setIcon(INIT);
				gameArray[5][1].setIcon(INIT);
				gameArray[5][9].setIcon(INIT);
				gameArray[1][2].setIcon(INIT);
				gameArray[2][2].setIcon(INIT);
				gameArray[5][5].setIcon(INIT);
				gameArray[5][7].setIcon(INIT);
				gameArray[2][6].setIcon(INIT);
				gameArray[3][10].setIcon(INIT);
				//change point amount for the round
				points -= .20;
				pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
				chancesLeft.setForeground(Color.yellow.darker());
			}
			else if(chances==1){
				gameArray[1][5].setIcon(INIT);
				gameArray[2][9].setIcon(INIT);
				gameArray[3][2].setIcon(INIT);
				gameArray[4][5].setIcon(INIT);
				gameArray[5][1].setIcon(INIT);
				gameArray[1][1].setIcon(INIT);
				gameArray[4][9].setIcon(INIT);
				gameArray[5][8].setIcon(INIT);
				gameArray[2][1].setIcon(INIT);
				gameArray[3][9].setIcon(INIT);
				gameArray[5][10].setIcon(INIT);
				//change point amount for the round
				points -= .20;
				pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
				chancesLeft.setText("You Only Have " + chances + " more guess left!");
				chancesLeft.setForeground(Color.orange.darker());
			}
			else if(chances==0){
				gameArray[1][10].setIcon(INIT);
				gameArray[2][1].setIcon(INIT);
				gameArray[3][1].setIcon(INIT);
				gameArray[4][8].setIcon(INIT);
				gameArray[5][1].setIcon(INIT);
				gameArray[2][9].setIcon(INIT);
				gameArray[3][8].setIcon(INIT);
				gameArray[5][2].setIcon(INIT);
				//change point amount for the round
				points -= .20;
				posORneg = "-";
				pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
				
				//update users score
				if(posORneg.equals("-")){
					update();	
					hasLost();
				}
				else{
					score += -points;
					if(score < 0.0){
						scoreInfo.setText("-"+NumberFormat.getCurrencyInstance().format(Math.abs(score)));
					}
					else{
						scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
					}
					hasLost();
				}
				
				chancesLeft.setText("You lost this round, but keep trying!");
				chancesLeft.setForeground(Color.red.darker());
				enableAllButtons(false);
				newWord.setEnabled(true);
				
				/* OPTIONAL CODE
					to make losing $1.00 when giving up [which shows the correct answer] worth it, 
					lets not show what the answer was after losing all chances to guess. 
					
					If later it is decided that the word should
					be shown regardless of losing chances or giving up, 
					uncomment the JOptionPane statement below
				*/
				
				// JOptionPane.showMessageDialog(null, "Better Luck Next Time! \nThe word was " 
				//		+ wordChoice + "\nYou lost " + NumberFormat.getCurrencyInstance().format(points));
				
			}
				
		}
		
		/**
		 * Checks to see if the users score is 0 an thus has
		 * lost the game
		 * @return true if the user lost, false if the user hasn't lost
		 */
		public boolean hasLost(){
			if(score > 0.0){
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "You lost all your money!"
						+ "\nYour final score was " + NumberFormat.getCurrencyInstance().format(0.0)
						+ "\nGAME OVER");
				enableAllButtons(false);
				return true;
			}
		}
		
		/**
		 * Checks to see if the user has completed the word
		 */
		public void winChecker(){
	
			int wordsLength = getLength();
			
			String answer = "";
			if(wordsRemaining > 0){
				for(int i=0; i<wordsLength; i++){
					answer = answer + gameArray[NUM_ROWS-2][i].getText();
				}
				
				if(answer.equals(wordChoice)){
					update();
					scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
					JOptionPane.showMessageDialog(null, "YOU WIN!\nThe word was " + wordChoice 
							+ "\nYou gained " + NumberFormat.getCurrencyInstance().format(points));
					newWord.setEnabled(true);
					didWin = true;
				}
			}
			else{
				for(int i=0; i<wordsLength; i++){
					answer = answer + gameArray[NUM_ROWS-2][i].getText();
				}
				
				if(answer.equals(wordChoice)){
					update();
					scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
					JOptionPane.showMessageDialog(null, "YOU WIN!\nThe final word was " + wordChoice 
							+ "\nYou gained " + NumberFormat.getCurrencyInstance().format(points) + "\n"
							+ "Your final score was " + NumberFormat.getCurrencyInstance().format(score));
					int ans = JOptionPane.showConfirmDialog(null, "Start a New Game?\nNo will exit the program");
					if(ans == 0){
						newGame();
					}
					else{
						System.exit(0);
					}
					newWord.setEnabled(false);
					didWin = true;
				}
			}
		}
		
		/**
		 * Removes the ability to click on all the buttons
		 * except the new word button
		 * @param state is the state of the buttons (true - enabled, false - disabled)
		 */
		public void enableAllButtons(boolean state){
			
			  lA.setEnabled(state);
			  lB.setEnabled(state);
			  lC.setEnabled(state);
			  lD.setEnabled(state);
			  lE.setEnabled(state);
			  lF.setEnabled(state);
			  lG.setEnabled(state);
			  lH.setEnabled(state);
			  lI.setEnabled(state);
			  lJ.setEnabled(state);
			  lK.setEnabled(state);
			  lL.setEnabled(state);
			  lM.setEnabled(state);
			  lN.setEnabled(state);
			  lO.setEnabled(state);
			  lP.setEnabled(state);
			  lQ.setEnabled(state);
			  lR.setEnabled(state);
			  lS.setEnabled(state);
			  lT.setEnabled(state);
			  lU.setEnabled(state);
			  lV.setEnabled(state);
			  lW.setEnabled(state);
			  lX.setEnabled(state);
			  lY.setEnabled(state);
			  lZ.setEnabled(state);
			  giveUp.setEnabled(state);
		}
		
		/**
		 * Adds back all the components just like the
		 * initial state they started as... (used to make a new game)
		 */
		public void addBackComponents(){
			
			gameBoard.removeAll();//removes all gameBoard components
			
			getWord();
			
			wordDef.setText(def);
			//add back all the components 
			fill();//refills gameBoard back up to its initial state
			createSpaces();
			guessingWholeWord = false;   
			didWin = false;
			message.setText("If you think you know the word enter your guess here");
			chances = INIT_CHANCES;
			chancesLeft.setText("You Only Have: " + getChancesLeft() + " more guess(es) left");
			
			enableAllButtons(true);
			newWord.setEnabled(false); //so the user get another new word
			
			chancesLeft.setForeground(Color.black);
			
			setFocusable(true);
			requestFocus(); //for the key listener	
			
			//reset points to init value
			points = INIT_POINTS;
			//make posORneg positive again
			posORneg = "+";
			//reset text
			pointInfo.setText(posORneg + NumberFormat.getCurrencyInstance().format(points));
		}
		
		/**
		 * Makes a new game/resets everything
		 */
		public void newGame(){
			
			list = new ArrayList<Integer>(); //"removes" all elements by making a new list
			
			addWords();
			
			//reset the things addBackComponents doesn't
			//reset score
			score = INIT_SCORE;
			scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
			//reset word counter
			wordsRemaining = TOTAL_WORDS;
			wordsLeft.setText(getWordsRemaining() + "/" + TOTAL_WORDS);
			
		}
		
		
          /*****************************************************************
	       *  Button Listener for all the buttons
	       ****************************************************************/
		   private class LetterButtonListener implements ActionListener
		   {
		      //--------------------------------------------------------------
		      //  by clicking a button with a letter on it the user is guessing that
			  //  letter. If it is correct, it will be displayed in the correct place 
			  //  in the word. If wrong, it will not be displayed and either way the
			  //  the button will become unclickable because it was already used.
		      //--------------------------------------------------------------
		      public void actionPerformed (ActionEvent event)
		      {
		    	
		    	  //figures out what button is being pressed 
		    	  //and performs its designated action
		    	  if (event.getSource() == lA){
		    		  lA.setEnabled(false);
		    		  guessLetter("A");
		    	  }
		    	  else if(event.getSource() == lB){
		    		  lB.setEnabled(false);
		    		  guessLetter("B");	  
		    	  }
		    	  else if(event.getSource() == lC){
		    		  lC.setEnabled(false);
		    		  guessLetter("C");
		    	  }
		    	  else if(event.getSource() == lD){
		    		  lD.setEnabled(false);
		    		  guessLetter("D");
		    		  
		    	  }
		    	  else if(event.getSource() == lE){
		    		  lE.setEnabled(false);
		    		  guessLetter("E");
		    		  
		    	  }
		    	  else if(event.getSource() == lF){
		    		  lF.setEnabled(false);
		    		  guessLetter("F");
		    		  
		    	  }
		    	  else if(event.getSource() == lG){
		    		  lG.setEnabled(false);
		    		  guessLetter("G");
		    		  
		    	  }
		    	  else if(event.getSource() == lH){
		    		  lH.setEnabled(false);
		    		  guessLetter("H");
		    		
		    	  }
		    	  else if(event.getSource() == lI){
		    		  lI.setEnabled(false);
		    		  guessLetter("I");
		    		
		    	  }
		    	  else if(event.getSource() == lJ){
		    		  lJ.setEnabled(false);
		    		  guessLetter("J");
		    		 
		    	  }
		    	  else if(event.getSource() == lK){
		    		  lK.setEnabled(false);
		    		  guessLetter("K");
		    		 
		    	  }
		    	  else if(event.getSource() == lL){
		    		  lL.setEnabled(false);
		    		  guessLetter("L");
		    		  
		    	  }
		    	  else if(event.getSource() == lM){
		    		  lM.setEnabled(false);
		    		  guessLetter("M");
		    		  
		    	  }
		    	  else if(event.getSource() == lN){
		    		  lN.setEnabled(false);
		    		  guessLetter("N");
		    		 
		    	  }
		    	  else if(event.getSource() == lO){
		    		  lO.setEnabled(false);
		    		  guessLetter("O");
		    		 
		    	  }
		    	  else if(event.getSource() == lP){
		    		  lP.setEnabled(false);
		    		  guessLetter("P");
		    		  
		    	  }
		    	  else if(event.getSource() == lQ){
		    		  lQ.setEnabled(false);
		    		  guessLetter("Q");
		    		  
		    	  }
		    	  else if(event.getSource() == lR){
		    		  lR.setEnabled(false);
		    		  guessLetter("R");
		    		  
		    	  }
		    	  else if(event.getSource() == lS){
		    		  lS.setEnabled(false);
		    		  guessLetter("S");
		    		  
		    	  }
		    	  else if(event.getSource() == lT){
		    		  lT.setEnabled(false);
		    		  guessLetter("T");
		    		  
		    	  }
		    	  else if(event.getSource() == lU){
		    		  lU.setEnabled(false);
		    		  guessLetter("U");
		    		  
		    	  }
		    	  else if(event.getSource() == lV){
		    		  lV.setEnabled(false);
		    		  guessLetter("V");
		    		  
		    	  }
		    	  else if(event.getSource() == lW){
		    		  lW.setEnabled(false);
		    		  guessLetter("W");
		    		  
		    	  }
		    	  else if(event.getSource() == lX){
		    		  lX.setEnabled(false);
		    		  guessLetter("X");
		    		  
		    	  }
		    	  else if(event.getSource() == lY){
		    		  lY.setEnabled(false);
		    		  guessLetter("Y");
		    		  
		    	  }
		    	  else if(event.getSource() == lZ){
		    		  lZ.setEnabled(false);
		    		  guessLetter("Z");
		    		  
		    	  }
		    	  //start new game
		    	  else if (event.getSource() == newWord){
		    		  if(getWordsRemaining() > 0){
		    			  addBackComponents();
		    		  }else{
		    			  if(score > INIT_SCORE){
		    				  	int ans = JOptionPane.showConfirmDialog(null, "You made a profit of " 
		    				  											+ NumberFormat.getCurrencyInstance().format(score-5) 
		    				  											+ "\nStart a New Game?\nNo and Cancel will exit the program");
								if(ans == 0){
									newGame();
									addBackComponents();
								}
								else{
									System.exit(0);
								}
		    			  }else{
		    				  	int ans = JOptionPane.showConfirmDialog(null, "You did not gain profit, your lost " 
		    				  											+ NumberFormat.getCurrencyInstance().format(5-score) 
		    				  											+ "\nStart a New Game?\nNo and Cancel will exit the program");
								if(ans == 0){
									newGame();
									addBackComponents();
								}
								else{
									System.exit(0);
								}
		    			  }
		    		  }
		    	  }
		    	  else if(event.getSource() == giveUp){
		    		  JOptionPane.showMessageDialog(null, "You gave up. The answer was: " + wordChoice 
		    				  + "\nThat is a $1.00 deduction from your score!");
		    		  points = -1.00;
		    		  update();
		    		//  scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
		    		  if(!hasLost()){
		    			  addBackComponents();
		    		  }		    		 
		    	  }
		    	  else if(event.getSource() == guess){
		    		  String usersGuess = message.getText();
		    		 
		    		  //the word was guessed correctly, make it appear in the gameBoard
		    		  if(usersGuess.toUpperCase().equals(wordChoice.toUpperCase())){
		    			  int lengthOfWord = getLength();
		    			  int i = 0;
		    			  guessingWholeWord = true;
		  				  newWord.setEnabled(true);
		  				  for(i=1; i<lengthOfWord; i++){
		  					  if(gameArray[NUM_ROWS-2][i].getText().equals("_")){
		  						guessWord("A");
		  						guessWord("B");
		  						guessWord("C");
		  						guessWord("D");
		  						guessWord("E");
		  						guessWord("F");
		  						guessWord("G");
		  						guessWord("H");
		  						guessWord("I");
		  						guessWord("J");
		  						guessWord("K");
		  						guessWord("L");
		  						guessWord("M");
		  						guessWord("N");
		  						guessWord("O");
		  						guessWord("P");
		  						guessWord("Q");
		  						guessWord("R");
		  						guessWord("S");
		  						guessWord("T");
		  						guessWord("U");
		  						guessWord("V");
		  						guessWord("W");
		  						guessWord("X");
		  						guessWord("Y");
		  						guessWord("Z");
		  					  }
		  					  else{
		  						  //do nothing
		  					  }
		  				  }
		  				  
		  				  winChecker();
		  				  didWin = true; 
		  				  guessingWholeWord = false;
		    		  }
		    		  else{
		    			  JOptionPane.showMessageDialog(null, "Nope, that isn't the word.");
		    			  guessingWholeWord = false;
		    			  wrongGuess();
		    		  }
		    	  }
		          else {
		        	 //This should NEVER be reached
		             JOptionPane.showMessageDialog(null, "ERROR with you guess!");
		          }
		    	  
		    	  //if the user wins, make all buttons except new word disabled
		    	  if(didWin){
		    		  enableAllButtons(false);
	    		  }
		      }
		   }
		   
		   /*****************************************************************
		    *  Key Listener for all the letter keys (for faster game play)
		    ****************************************************************/
		   private class LetterKeyListener extends KeyAdapter {

			   //--------------------------------------------------------------
			   //  by clicking a letter on the keyboard the user is guessing that
			   //  letter. If it is correct, it will be displayed in the correct place 
			   //  in the word. The button will be disabled to 
			   //  indicate the letter has already been used for guessing
			   //--------------------------------------------------------------
			   public void keyPressed(KeyEvent event) {
		
			      //figures out what key is being pressed 
		    	  //and performs its designated action if and only if that
			      //letter hasn't already been guessed (using the buttons
			      //state [enabled or disabled] as a boolean because if it 
				  //has been guessed, the button becomes disabled)
		    	  if (event.getKeyCode() == KeyEvent.VK_A && lA.isEnabled()){
		    		  lA.setEnabled(false);
		    		  guessLetter("A");
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_B && lB.isEnabled()){
		    		  lB.setEnabled(false);
		    		  guessLetter("B");	  
		    		
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_C && lC.isEnabled()){
		    		  lC.setEnabled(false);
		    		  guessLetter("C");
		    		
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_D && lD.isEnabled()){
		    		  lD.setEnabled(false);
		    		  guessLetter("D");
		    		
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_E && lE.isEnabled()){
		    		  lE.setEnabled(false);
		    		  guessLetter("E");
		    	
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_F && lF.isEnabled()){
		    		  lF.setEnabled(false);
		    		  guessLetter("F");
		    		
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_G && lG.isEnabled()){
		    		  lG.setEnabled(false);
		    		  guessLetter("G");
		    		
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_H && lH.isEnabled()){
		    		  lH.setEnabled(false);
		    		  guessLetter("H");
		    	
		    		
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_I && lI.isEnabled()){
		    		  lI.setEnabled(false);
		    		  guessLetter("I");
		    	
		    		
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_J && lJ.isEnabled()){
		    		  lJ.setEnabled(false);
		    		  guessLetter("J");
		    	
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_K && lK.isEnabled()){
		    		  lK.setEnabled(false);
		    		  guessLetter("K");
		    		
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_L && lL.isEnabled()){
		    		  lL.setEnabled(false);
		    		  guessLetter("L");
		    	
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_M && lM.isEnabled()){
		    		  lM.setEnabled(false);
		    		  guessLetter("M");
		    		
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_N && lN.isEnabled()){
		    		  lN.setEnabled(false);
		    		  guessLetter("N");
		    		
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_O && lO.isEnabled()){
		    		  lO.setEnabled(false);
		    		  guessLetter("O");
		    		
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_P && lP.isEnabled()){
		    		  lP.setEnabled(false);
		    		  guessLetter("P");
		    	
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_Q && lQ.isEnabled()){
		    		  lQ.setEnabled(false);
		    		  guessLetter("Q");
		    	
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_R && lR.isEnabled()){
		    		  lR.setEnabled(false);
		    		  guessLetter("R");
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_S && lS.isEnabled()){
		    		  lS.setEnabled(false);
		    		  guessLetter("S");
		    	
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_T && lT.isEnabled()){
		    		  lT.setEnabled(false);
		    		  guessLetter("T");
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_U && lU.isEnabled()){
		    		  lU.setEnabled(false);
		    		  guessLetter("U");
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_V && lV.isEnabled()){
		    		  lV.setEnabled(false);
		    		  guessLetter("V");
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_W && lW.isEnabled()){
		    		  lW.setEnabled(false);
		    		  guessLetter("W");
		    		 
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_X && lX.isEnabled()){
		    		  lX.setEnabled(false);
		    		  guessLetter("X");
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_Y && lY.isEnabled()){
		    		  lY.setEnabled(false);
		    		  guessLetter("Y");
		    		  
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_Z && lZ.isEnabled()){
		    		  lZ.setEnabled(false);
		    		  guessLetter("Z");
		    		
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_F2 && newWord.isEnabled()){
		    		  if(getWordsRemaining() > 0){
		    			  addBackComponents();
		    		  }else{
		    			  if(score > INIT_SCORE){
		    				  	int ans = JOptionPane.showConfirmDialog(null, "You made a profit of " 
		    				  											+ NumberFormat.getCurrencyInstance().format(score-5) 
		    				  											+ "\nStart a New Game?\nNo and Cancel will exit the program");
								if(ans == 0){
									newGame();
									addBackComponents();
								}
								else{
									System.exit(0);
								}
		    			  }else{
		    				  	int ans = JOptionPane.showConfirmDialog(null, "You did not gain profit, your lost " 
		    				  											+ NumberFormat.getCurrencyInstance().format(5-score) 
		    				  											+ "\nStart a New Game?\nNo and Cancel will exit the program");
								if(ans == 0){
									newGame();
									addBackComponents();
								}
								else{
									System.exit(0);
								}
		    			  }
		    		  }
		    	  }
		    	  else if(event.getKeyCode() == KeyEvent.VK_F3){
		    		  //give up
		    		  JOptionPane.showMessageDialog(null, "You gave up. The answer was: " + wordChoice 
		    				  + "\nThat is a $1.00 deduction from your score!");
		    		  points = -1.00;
		    		  update();
		    		 // scoreInfo.setText(NumberFormat.getCurrencyInstance().format(score));
		    		  if(!hasLost()){
		    			  addBackComponents();
		    		  }
		    		  else{
		    			  enableAllButtons(false);
		    		  }
		    	  }
		    	  else{
		    		  //if it is any other key, do nothing
		    	  }
		        
		    	  //if the user wins, make all buttons except new word disabled
		    	  if(didWin){
		    		  enableAllButtons(false);
		 
	    		  }			       
			    }

			    public void keyReleased(KeyEvent event) {
			     
			    }
		   }
		   
		   //because it is implementing an interface, all methods must be shown even if they
		   //aren't used. This is used to focus back to the buttons/keys
		   private class FocusMouseListener implements MouseListener{
				
			   //MouseListener Methods	
				public void mouseClicked(MouseEvent event){
					
				}
				
				public void mousePressed(MouseEvent event){
						
				}
				
				public void mouseReleased(MouseEvent event){
					requestFocus();
				}
				
				public void mouseEntered(MouseEvent event){
				
				}
				
				public void mouseExited(MouseEvent event){
					
				}
		  }
}
