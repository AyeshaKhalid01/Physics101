//Program name: EqualsControllerK2
//Description: Controller for the 'calculate button - calls the solve method in the kinematics pt2 model

//imports
import java.lang.Math;
import java.util.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//class
public class EqualsControllerK2 extends Object implements ActionListener
{
     //instance variables of model and textfield //instance of model class
     private KinematicsPt2 k2; //instance of kinematics 2 model class   
     private JTextField time; // instance of time
     private JTextField acceleration;// instance of acceleration
     private JTextField velocity1;// instance of initial velocity
     private JTextField velocity2;// instance of final velocity
     private JTextField velocityX;// instance of velocityX
     private JTextField velocityY;// instance of velocityY
     private JTextField displacement;// instance of displacement
     private JTextField angle;// instance of angle
     
     
     // constructor
     public EqualsControllerK2(KinematicsPt2 aModel,JTextField vx, JTextField vy, JTextField v1, JTextField v2, JTextField d, JTextField t,JTextField a, JTextField theta)
     {
//Sets the values for the instance variable - data from arguments 
          this.k2 = aModel;
          this.time = t;
          this.acceleration = a;
          this.velocity1 = v1;
          this.velocity2 = v2;
          this.velocityX = vx;
          this.velocityY = vy;
          this.displacement = d;
          this.angle = theta;
     } //end method
     //runs when a method occurs 
     public void actionPerformed(ActionEvent e)
     {
          //temp/method variables
          double time; // time
          double acceleration; // acceleration
          double displacement; //displacement
          double v1; // initial velocity
          double v2; // final velocity 
          double vx; // velocity in the x direction 
          double vy; //velocity in the y direction
          double theta; // angle
          
          //checks which equation was chosen and data validates the different information entered into each JTextField
//every value that is entered is validated 
          if(this.k2.getEquation().equalsIgnoreCase("d = v2t - 0.5at^2"))
          {
               
               try
               {
                    time =Double.parseDouble(this.time.getText()); //changes the string to a double
                    k2.setTime(time); //sets the value in the model 
               }
               catch (NumberFormatException ex) //throws and exception if the data entered is not a number 
               {
                    this.time.setText("Invalid"); // informs the user that the data entered is invalid 
               }
               
               try
               {
                    acceleration =Double.parseDouble(this.acceleration.getText()); //changes the string to a double
                    k2.setAcceleration(acceleration);//sets the value in the model 
               }
               catch (NumberFormatException ex)//throws and exception if the data entered is not a number 
               {
                    this.acceleration.setText("Invalid"); // informs the user that the data entered is invalid 
                    
               }
               
               try
               {
                    displacement =Double.parseDouble(this.displacement.getText());
                    k2.setDisplacement(displacement);
               }
               catch (NumberFormatException ex)
               {
                    this.displacement.setText("Invalid");
               }
               
               try
               {
                    v2 =Double.parseDouble(this.velocity2.getText());
                    k2.setV2(v2);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity2.setText("Invalid");
               }
               
          } // end of if statement 
          
          else if(this.k2.getEquation().equalsIgnoreCase("v2^2 = v1^2 + 2ad"))
          {
               try
               {
                    v1 =Double.parseDouble(this.velocity1.getText());
                    k2.setV1(v1);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid");
               }
               
               try
               {
                    v2 =Double.parseDouble(this.velocity2.getText());
                    k2.setV2(v2);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity2.setText("Invalid");
               }
               
               try
               {
                    acceleration =Double.parseDouble(this.acceleration.getText());
                    k2.setAcceleration(acceleration);
               }
               catch (NumberFormatException ex)
               {
                    this.acceleration.setText("Invalid");
               }
               
               try
               {
                    displacement =Double.parseDouble(this.displacement.getText());
                    k2.setDisplacement(displacement);
               }
               catch (NumberFormatException ex)
               {
                    this.displacement.setText("Invalid");
               }
          } // end of if statement 
          
          else if(this.k2.getEquation().equalsIgnoreCase("d = v1t + 0.5at^2"))
          {
               try
               {
                    acceleration =Double.parseDouble(this.acceleration.getText());
                    k2.setAcceleration(acceleration);
               }
               catch (NumberFormatException ex)
               {
                    this.acceleration.setText("Invalid");
               }
               
               try
               {
                    displacement =Double.parseDouble(this.displacement.getText());
                    k2.setDisplacement(displacement);
               }
               catch (NumberFormatException ex)
               {
                    this.displacement.setText("Invalid");
               }
               
               try
               {
                    v1 =Double.parseDouble(this.velocity1.getText());
                    k2.setV1(v1);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid");
               }
               
               try
               {
                    time =Double.parseDouble(this.time.getText());
                    k2.setTime(time);
               }
               catch (NumberFormatException ex)
               {
                    this.time.setText("Invalid");
               }
          } // end of if statement 
          
          else if(this.k2.getEquation().equalsIgnoreCase("v2 = v1 + at"))
          {
               try
               {
                    v1 =Double.parseDouble(this.velocity1.getText());
                    k2.setV1(v1);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid");
               }
               
               try
               {
                    time =Double.parseDouble(this.time.getText());
                    k2.setTime(time);
               }
               catch (NumberFormatException ex)
               {
                    this.time.setText("Invalid");
               }
               
               try
               {
                    acceleration =Double.parseDouble(this.acceleration.getText());
                    k2.setAcceleration(acceleration);
               }
               catch (NumberFormatException ex)
               {
                    this.acceleration.setText("Invalid");
               }
               try
               {
                    v2 =Double.parseDouble(this.velocity2.getText());
                    k2.setV2(v2);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity2.setText("Invalid");
               }
          } // end of if statement 
          
          else if(this.k2.getEquation().equalsIgnoreCase("v = d/t"))
          {
               try
               {
                    v1 =Double.parseDouble(this.velocity1.getText());
                    k2.setV1(v1);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid");
               }
               
               try
               {
                    time =Double.parseDouble(this.time.getText());
                    k2.setTime(time);
               }
               catch (NumberFormatException ex)
               {
                    this.time.setText("Invalid");
               }
               try
               {
                    displacement =Double.parseDouble(this.displacement.getText());
                    k2.setDisplacement(displacement);
               }
               catch (NumberFormatException ex)
               {
                    this.displacement.setText("Invalid");
               }
          } // end of if statement 
          
          else if(this.k2.getEquation().equalsIgnoreCase("H: vx = v1cos(?)"))
          {
               try
               {
                    v1 =Double.parseDouble(this.velocity1.getText());
                    k2.setV1(v1);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid");
               }
               
               try
               {
                    vx =Double.parseDouble(this.velocityX.getText());
                    k2.setVx(vx);
               }
               catch (NumberFormatException ex)
               {
                    this.velocityX.setText("Invalid");
               }
               
               try
               {
                    theta =Double.parseDouble(this.angle.getText());
                    k2.setTheta(theta);
               }
               catch (NumberFormatException ex)
               {
                    this.angle.setText("Invalid");
               }
          } // end of if statement 
          
          else if(this.k2.getEquation().equalsIgnoreCase("V: vy = v1sin(?)"))
          {
               try
               {
                    v1 =Double.parseDouble(this.velocity1.getText());
                    k2.setV1(v1);
               }
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid");
               }
               
               try
               {
                    vy =Double.parseDouble(this.velocityY.getText());
                    k2.setVy(vy);
               }
               catch (NumberFormatException ex)
               {
                    this.velocityY.setText("Invalid");
               }
               
               try
               {
                    theta =Double.parseDouble(this.angle.getText());
                    k2.setTheta(theta);
               }
               catch (NumberFormatException ex)
               {
                    this.angle.setText("Invalid");
               }
               
          } // end of if statement 
          
          this.k2.solve(); //calls the kinematics Pt2 model and solves for the variable set previously
          
     }//end of method
     
}// end of class

