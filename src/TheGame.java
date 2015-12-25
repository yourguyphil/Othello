/*Philips Nguyen Program 10
 * 
 * This is the reversi game!!!! Everything is manual, but you can change the setting and the porgram will adjust to decisions
 * 
 * May 5, 2015
 * 
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TheGame extends JPanel
{
//***********************************************************

TheGame()  //make the main screen
{
setName("Reversi");
createContents();
} 

//***********************************************************

// Create components and add to window.
public static ArrayList<RoundedButton> butArray;//array that has all the board buttons to be used in differnt meathods

private void createContents()
{
RoundedButton button; // re-instantiate this button and use
// to fill entire board
setLayout(new GridLayout(ScreenController.gameSize, ScreenController.gameSize));
butArray=new ArrayList<RoundedButton>(); //make a new array
for (int i=0; i<ScreenController.gameSize; i++) //for the board according to size
{
for (int j=0; j<ScreenController.gameSize; j++)
{

button = new RoundedButton();  //make the buttons
button.addActionListener(new Listener());  
add(button);
butArray.add(button);
} // end for j
} // end for i


if(ScreenController.gameSize == 6) //set the initial color
{
	for(int i=0;i<35;i++)  
	{
		butArray.get(i).setGray();
	
	}
butArray.get(14).setWhite();
butArray.get(21).setWhite();
butArray.get(15).setBlack();
butArray.get(20).setBlack();
}
else
{
	for(int i=0;i<63;i++)
	{
		butArray.get(i).setGray();
		
	}
	butArray.get(27).setWhite();
	butArray.get(36).setWhite();
	butArray.get(28).setBlack();
	butArray.get(35).setBlack();

}

} // end createContents

public static void turnOff() //meathod to dis-enable the buttons on the board
{

	if(ScreenController.gameSize == 8)
	{
for(int i=0;i<64;i++)
{
	butArray.get(i).setEnabled(false);
}
	}
	else
	{
		for(int i=0;i<36;i++)
		{
			butArray.get(i).setEnabled(false);
		}
	}
	
}



//***********************************************************



private class Listener implements ActionListener
{
public void actionPerformed(ActionEvent e)  //make them turn diffrent colors and what happens to the counters in each possibility
{
RoundedButton btn = (RoundedButton) e.getSource();
if (ScreenController.turn&&btn.isGray())
{
btn.setWhite();
ScreenController.counterWhite++;

//**************************

//*****************************
}
else if(ScreenController.turn&&btn.isBlack())
{
	btn.setWhite();
		ScreenController.counterBlack--;;
		ScreenController.counterWhite++;
}
else if (!(ScreenController.turn)&&btn.isGray())
{
	btn.setBlack();
	ScreenController.counterBlack++;
}
else if (!(ScreenController.turn)&&btn.isWhite())
{
	btn.setBlack();
	ScreenController.counterBlack++;
	ScreenController.counterWhite--;
}
} // end actionPerformed
} // end class Listener
//***********************************************************

public static void main(String args[])// main make the game 
{
ScreenController start= new ScreenController();
start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}