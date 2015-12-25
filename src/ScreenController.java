import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ScreenController extends JFrame
{
	static int gameSize=8;
	static boolean turn=true; // true is white going first, false is black
	static int counterWhite=2;   //number of pieces
	static int counterBlack=2;
	static int counterWhiteWin=0; //number of wins,ties
	static int counterBlackWin=0;
	static int counterTie=0;
	
	TheGame game=new TheGame();   //make the objects
	JPanel options=new JPanel();
	JButton exit= new JButton("End Game");
	JRadioButton eight=new JRadioButton("8x8");
	JRadioButton six=new JRadioButton("6x6");
	JRadioButton white=new JRadioButton("White's First");
	JRadioButton black=new JRadioButton("Black's First");
	JButton restart=new JButton("New Game");
	JButton done=new JButton("Turn over");
	JLabel whitePieces=new JLabel("White's  pieces : " + ScreenController.counterWhite);
	JLabel blackPieces=new JLabel("Black's  pieces :"+ScreenController.counterBlack);
	JLabel whiteWins=new JLabel("White's  Wins :"+ScreenController.counterWhiteWin);
	JLabel blackWins=new JLabel("Black's  Wins :"+ScreenController.counterBlackWin);
	JLabel currentTurn=new JLabel("Current Turn: White's Turn");
	JLabel Ties=new JLabel("Ties :"+ScreenController.counterTie);

	
	ScreenController()
	{
		setSize(800,500); //make the game screen size and show it
		setTitle("Reversi");
		add(game );
		setVisible(true);
		
		
		
		exit.addActionListener(new listenerExit());  //give the objects listeners
		six.addActionListener(new listenerSix());
		eight.addActionListener(new listenerEight());
		restart.addActionListener(new listenerRestart());
		white.addActionListener(new listenerWhite());
		black.addActionListener(new listenerBlack());
		done.addActionListener(new listenerDone());
		
		
		 exit.setPreferredSize(new Dimension(200, 300)); //make them look bigger
		 restart.setPreferredSize(new Dimension(200, 300));
		
	 options.setLayout(new GridLayout(7,2));  // 7 rows 2 collmns 
		   
	   options.add(exit);  //add them all to panel
	   options.add(restart);
	   options.add(six);
	   options.add(eight);
	   options.add(white);
	   options.add(black);
	   options.add(done);
	   options.add(whitePieces);
	   options.add(blackPieces);
	   options.add(whiteWins);
	   options.add(blackWins);
	   options.add(Ties);
	   options.add(currentTurn);
	   eight.setSelected(true);
	   white.setSelected(true);
		  
	   add(options , BorderLayout.EAST);
	   setVisible(true);	
	}
	
	private class listenerExit implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(ScreenController.counterWhite > ScreenController.counterBlack) //check winner and display
			{
				ScreenController.counterWhiteWin++;	
			}
			else if(ScreenController.counterBlack>	ScreenController.counterWhite)
			{
				ScreenController.counterBlackWin++;	
			}
			else if (ScreenController.counterBlack==	ScreenController.counterWhite)
			{
				ScreenController.counterTie++;	
			}
			
		
			
			whiteWins.setText("White's  Wins : " + ScreenController.counterWhiteWin);
			blackWins.setText("Black's  Wins : " + ScreenController.counterBlackWin);whiteWins.setText("White's  Wins : " + ScreenController.counterWhiteWin);
			blackWins.setText("Black's  Wins : " + ScreenController.counterBlackWin);
			Ties.setText("Ties : " + ScreenController.counterTie);
			
		    TheGame.turnOff(); //call turnOff meathod that turns on enable of buttons
			}
	}
	
	
	private class listenerRestart implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
	     remove(game); //clear the board
		game=new TheGame();
		add(game ,BorderLayout.CENTER);
		revalidate();
		ScreenController.counterBlack=2; //restart the counters
		ScreenController.counterWhite=2;
		whitePieces.setText("White's  Pieces : " + ScreenController.counterWhite);
		blackPieces.setText("Black's  Pieces : " + ScreenController.counterBlack);

		if(turn) //check turn
		{
			currentTurn.setText("Current Turn:White's Turn");
		}
		else
		{
			currentTurn.setText("Current Turn:Black's Turn");
		}
		}
	}

	private class listenerDone implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			ScreenController.turn=!ScreenController.turn;  //change turn
			
			whitePieces.setText("White's  Pieces : " + ScreenController.counterWhite); //start counters display
			blackPieces.setText("Black's  Pieces : " + ScreenController.counterBlack);
			revalidate();
			
			if(turn) //set turn display
			{
				currentTurn.setText("Current Turn:White's Turn");
			}
			else
			{
				currentTurn.setText("Current Turn:Black's Turn");
			}
		}	
	}
	private class listenerSix implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			ScreenController.gameSize=6;	//6x6
			eight.setSelected(false);
		}
		
	}
	
	private class listenerEight implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			ScreenController.gameSize=8;	//8x8
			six.setSelected(false);
		}
	}
	private class listenerWhite implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			ScreenController.turn=true;		//white turn first
			black.setSelected(false);
		
		}
	}
	private class listenerBlack implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
				ScreenController.turn=false; //Black turn first
				white.setSelected(false);
		
		}		
	}
}
