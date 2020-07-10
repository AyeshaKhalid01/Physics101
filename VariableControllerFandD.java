//Controller Name: VariableControllerFandD 
//Description: Gets user input for variable and calls methods in the FD model and view class

//imports the packages required for the class
import javax.swing.*;
import java.awt.event.*;

//creates a VariableControllerFandD class as a controller
public class VariableControllerFandD extends Object implements ActionListener
{
//instantiates the forces and dynamics model and view class in the contoller
     private FandD aFandDModel;
     private Physics101GUI aFandDGUI;
     
//constructor for variable controller includes the model and gui
     public VariableControllerFandD ( FandD model,Physics101GUI gui)
     {
//sets the model and gui to the instantiated variables
          this.aFandDModel = model;
          this.aFandDGUI = gui;
     }//end VariableControllerFandD constructor
     
     public void actionPerformed (ActionEvent e)
     {
//calls the set variable method in the model class and sends the selected variable as an argument
          this.aFandDModel.setVariable(e.getActionCommand());
//calls the displayFDTextFields in the gui(view class) to display the appropriate textfields 
          this.aFandDGUI.displayFDTextFields();
     }
} //end VariableControllerFandD class 

