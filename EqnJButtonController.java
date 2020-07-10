//EqnJButtonController
//Controller class that controls JButtons for chosing equations and sets equation in models 

//imports
import javax.swing.*;
import java.awt.event.*;

//class
public class EqnJButtonController extends Object implements ActionListener
{
     //instance variables declaration 
     private KinematicsPt1 k1 = null; //instance of k1 model class
     private KinematicsPt2 k2 = null; //instance of k2 model class
     private FandD fd = null;         //instance of fd model class      
     private Physics101GUI gui;
     
     //constructors for each of the model classes
     
     //kinematics 1 
     public EqnJButtonController(KinematicsPt1 aModel, Physics101GUI gui)
     {
          this.k1 = aModel;
          this.gui = gui;
     } //end method
     
     //kinematics 2
     public EqnJButtonController(KinematicsPt2 aModel,Physics101GUI gui)
     {
          this.k2 = aModel;
          this.gui = gui;
     } //end method
     
     //forces and dynamics
     public EqnJButtonController(FandD aModel, Physics101GUI gui)
     {
          this.fd = aModel;
          this.gui = gui;
     }
     
     //actionPerformed method called when a unit button clicked 
     public void actionPerformed(ActionEvent e)
     {
          String eqnOnButton;                 //stores the equation on the button
          eqnOnButton = e.getActionCommand(); //gets what is written on the button and stores it
          
          /*check which model user currently using by checking if each of model set to null. 
           * If null, not being used. 
           * If not null, model being used and call methods to set the equation and display variables in the gui*/
          
          if(k1!=null) //check if k1 is null. If not, current equation in model. Run code in if statement. 
          {
               this.k1.setEqn(eqnOnButton); //set equation in model
               this.gui.displayVarsK1();    //display corresponding variable page in gui
          } //end if
          
          else if(k2!=null) //if k2 eqn, set equation and display corresponding variable page
          {
               this.k2.setEquation(eqnOnButton);
               this.gui.displayVarsK2();
          } //end if
          
          else if(fd!=null)//if fd eqn, set eqn and display corresponding variable page
          {
               this.fd.setEquation(eqnOnButton);
               this.gui.displayFDVariables();
          } //end else if
          
     } //end method
     
} //end class




