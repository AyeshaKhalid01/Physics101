//Program name: BackController
//Programmed by: Basmala Moumneh
//Date created:  07/01/2019
//Description: Controller that informs the gui to return back to the main screen when the 'back' button is clicked.

//imports
import javax.swing.*;
import java.awt.event.*;

//class
public class BackController extends Object implements ActionListener
{
     //instance variables 
     private Physics101GUI gui;
     
     // constructor
     public  BackController(Physics101GUI gui)
     {
          this.gui = gui; //sets the gui 
     } //end of method
     
//runs when an event occurs 
     public void actionPerformed (ActionEvent e)
     {
          this.gui.updateBack(); // once an action has been performed (the button has been clicked), the GUI is informed to display the main screen.
     }//end of method
     
}// end of class