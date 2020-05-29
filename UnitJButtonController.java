//UnitJButtonController Class
//Controller class that displays the equation page based on which unit button is clicked

//imports
import javax.swing.*;
import java.awt.event.*;

//class
public class UnitJButtonController extends Object implements ActionListener
{
     //instance variables of model and textfield
     private Physics101GUI theGUI; //instance of view class
     
     //constructor
     public UnitJButtonController(Physics101GUI model)
     {
          this.theGUI = model;
     } //end method
     
     //method that obtains info user entered and displays the corresponding equations page
     public void actionPerformed(ActionEvent e)
     {
          String screenToPaint; //variable to store what's written on the button
          
          screenToPaint = e.getActionCommand(); //gets what is written on the button and store in screenToPaint variable
          
          if(screenToPaint.equals("Kinematics Pt1"))
          {
               this.theGUI.displayK1Eqns(); //display k1 equations page
          } //end else if
          
          else if(screenToPaint.equals("Kinematics Pt2"))
          {
               this.theGUI.displayK2Eqns(); //display k2 equations page
          } //end else if
          
          else if(screenToPaint.equals("Forces & Dynamics"))
          {
               this.theGUI.displayFDEqns(); //display forces and dynamics equations page
          } //end else if
          
          else if(screenToPaint.equals("Conversions"))
          {
               this.theGUI.displayCCUnits(); //display conversions unit page
          } //end else if  
          
     } //end method
     
} //end class



