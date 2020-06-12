//Program name: VariableControllerK2
//Description: Controller for the variable buttons. Sets the variable in the kinematics pt2 model and updates the gui.

//imports 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//class
public class VariableControllerK2 extends Object implements ActionListener
{
     //variables 
     private KinematicsPt2 kinematicsModel; //kinematics pt2 model
     private Physics101GUI theGUI; // GUI
     
     public VariableControllerK2 ( KinematicsPt2 model, Physics101GUI gui)
     {
          this.kinematicsModel = model; // setting the model
          this.theGUI = gui; // setting the GUI
     } //end of method
     
//runs when an even occurs 
     public void actionPerformed (ActionEvent e)
     {
          this.kinematicsModel.setVar(e.getActionCommand()); //sets the variabel by getting the text on the button
          this.theGUI.updateVarsK2(); //calls the GUI to update the interface 
     }//end of method 
     
     
}//end of class

