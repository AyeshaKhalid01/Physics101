//VarControllerK1 class
//Created by: Jessie Lin
//Last modified: 1/16/19
//Enables and disables radiobuttons and textfields in the gui based on which radiobutton user clicks

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//class
public class VarControllerK1 extends Object implements ActionListener
{
     private KinematicsPt1 aK1Model; //instance of the model
     private Physics101GUI theView;   //instance of the gui
     
//constructor
     public VarControllerK1(KinematicsPt1 model, Physics101GUI gui)
     {
          //initialize instance variables
          this.aK1Model = model; 
          this.theView = gui;
     } //end constructor
     
//actionPerformed method to be run when a variable is chosen
     public void actionPerformed (ActionEvent e)
     {
          this.aK1Model.setUnknown(e.getActionCommand()); //set unknown variable in model
          this.theView.updateVarsK1(); //display k1 variable page in frame
     } //end actionPerformed
     
} //end class

