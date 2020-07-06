//Program name: BackToEqnsK2Controller
//Description: Controller that for the 'back to equation page' for the kinematics part 2 equations.

//imports
import javax.swing.*;
import java.awt.event.*;

//class
public class BackToEqnsK2Controller implements ActionListener
{
     //instance variables of model and textfield
     private Physics101GUI gui;
     
     // constructor
     public  BackToEqnsK2Controller(Physics101GUI gui)
     {
          this.gui = gui; //sets the GUI
     } // end of method 
     
     public void actionPerformed (ActionEvent e)
     {
          this.gui.backToEquationsK2(); //calls a method in the GUI that causes the screen to change back to the kinematics Pt2 equations page.
     } //end of method
     
}// end of class

