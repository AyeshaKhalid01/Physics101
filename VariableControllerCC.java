//Controller Name: VariableControllerCC 
//Programmed by: Ayesha Khalid
//Last Modified: December 29th 2018
//Description: Gets user input for the unit the user wants to solve for 

//imports the packages required for the class
import javax.swing.*;
import java.awt.event.*;

//creates a VariableControllerCC class as a controller
public class VariableControllerCC extends Object implements ActionListener
{
//instantiates the conversion class model and view class in the contoller
     private ConversionClass aCCModel;
     private Physics101GUI aCCGUI;
     
//constructor for variable controller includes the model and gui
     public VariableControllerCC (ConversionClass model,Physics101GUI gui)
     {
//sets the model and gui to the instantiated variables
          this.aCCModel = model;
          this.aCCGUI = gui;
     }//end VariableControllerCC constructor
     
     public void actionPerformed (ActionEvent e)
     {
          this.aCCModel.setUnitConversion(e.getActionCommand());
          this.aCCGUI.displayCCTextFields();
     }
} // variable controller end 

