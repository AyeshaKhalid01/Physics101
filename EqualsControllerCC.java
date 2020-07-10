//Class Name:EqualsControllerCC   class
//Description: sets the values from the text fields as the variables and calls the solution method in the model to solve for an answer

//imports
import javax.swing.*;
import java.awt.event.*;

//class 
public class EqualsControllerCC extends Object implements ActionListener
{
     //instance variables of model and textfield 
     private ConversionClass ccModel;         //instance of forces and dynamics model class
     private JTextField baseValue;       //instance of forces and dynamics base value text field
     
     //constructor for EqualsControllerCC has the current model object and all CC text fields 
     public EqualsControllerCC(ConversionClass aModel, JTextField bV)
     {
          //sets the values of instance variables to the arguments provided in the constructor
          this.ccModel = aModel;
          this.baseValue = bV;
     }//end of constructor
     
     public void actionPerformed(ActionEvent e)
     {
//takes user input and sets it in model class
          double userInput;
          userInput=Double.parseDouble(this.baseValue.getText());
          this.ccModel.setConverter(userInput);
//calls the solution method in the CC model to solve for an answer
          this.ccModel.solution();
     }//end of actionPerformed
}//end of EqualsControllerCC class

