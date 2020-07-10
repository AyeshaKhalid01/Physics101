//EqualsControllerK1 
//Controller class to control the equals/calculate button on the k1 screen

//imports 
import javax.swing.*;
import java.awt.event.*;

//class
public class EqualsControllerK1 extends Object implements ActionListener
{
     //instance variables of model and textfield 
     private KinematicsPt1 k1;        //instance of kinematics 1 model class
     private JTextField velocityA;    //textfield in which user inputs average velocity 
     private JTextField velocity1;    //initial velocity
     private JTextField velocity2;    //final velocity
     private JTextField displacement; //displacement
     private JTextField time;         //time
     private JTextField acceleration; //acceleration
     
     //constructor to initialize all instance variables
     public EqualsControllerK1(KinematicsPt1 aModel, JTextField v1, JTextField v2, JTextField d, JTextField t,JTextField a, JTextField va)
     {
          this.k1 = aModel;
          this.velocityA = va;
          this.velocity1 = v1;
          this.velocity2 = v2;
          this.displacement = d;
          this.time = t;
          this.acceleration = a;
     } //end method
     
     //actionPerformed method to be called when the equals button is clicked 
     public void actionPerformed(ActionEvent e)
     {
          //temporary variables to store text from textfield. Used to data validate and pass values to model. 
          double va; 
          double v1;
          double v2;
          double t;
          double a;
          double d;
          
          //if statement to determine which equation user clicked and get text from corresponding textfields
          if(this.k1.getEquation().equalsIgnoreCase("v=d/t")) //if equation if v = d/t, get text from all texfield related to equation for future calculations
          {
               try //try to get the average velocity the user entered and set as the Va value in the model for calculations
               {
                    va = Double.parseDouble(this.velocityA.getText()); //try to convert value user entered into textfield to a double
                    k1.setVa(va);                                      //if is a double, set as value in model
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocityA.setText("Invalid"); //if not a double, set text in textfield as invalid so user knows to retry
               } //end catch
               
               try //try to get the displacement the user entered and set as the d value in the model for calculations
               {
                    d = Double.parseDouble (this.displacement.getText());
                    k1.setDisplacement(d);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.displacement.setText("Invalid"); //set text in textfield to invalid
               } //end catch
               
               try //try to get time 
               {
                    t = Double.parseDouble(this.time.getText());
                    k1.setTime(t);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.time.setText("Invalid"); //set as invalid
               } //end catch
               
          } //end if
          
          else if(this.k1.getEquation().equalsIgnoreCase("v=(v1+v1)/2"))
          {
               try //try to get the average velocity the user entered and set as the Va value in the model for calculations
               {
                    va = Double.parseDouble(this.velocityA.getText());
                    k1.setVa(va);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocityA.setText("Invalid"); //if not a double, set text in textfield as invalid so user knows to retry
               } //end catch
               
               try //for v1
               {
                    v1 = Double.parseDouble (this.velocity1.getText());
                    k1.setV1(v1);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid"); //set text in textfield to invalid
               } //end catch
               
               try //for v2
               {
                    v2 = Double.parseDouble(this.velocity2.getText());
                    k1.setV2(v2);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocity2.setText("Invalid");
               } //end catch
          } //end else if
          
          else if(this.k1.getEquation().equalsIgnoreCase("a=(v2-v1)/t"))
          {
               try //for acceleration
               {
                    a = Double.parseDouble(this.acceleration.getText());
                    k1.setAcceleration(a);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.acceleration.setText("Invalid"); //if not a double, set text in textfield as invalid so user knows to retry
               } //end catch
               
               try //for v1
               {
                    v1 = Double.parseDouble (this.velocity1.getText());
                    k1.setV1(v1);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid"); //set text in textfield to invalid
               } //end catch
               
               try //for v2
               {
                    v2 = Double.parseDouble(this.velocity2.getText());
                    k1.setV2(v2);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocity2.setText("Invalid");
               } //end catch
               
               try //for t
               {
                    t = Double.parseDouble(this.time.getText());
                    k1.setTime(t);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.time.setText("Invalid");
               } //end catch
          } //end else if
          
          else if(this.k1.getEquation().equalsIgnoreCase("d=[(v1+v2)t]/2"))
          {
               try //for displacement
               {
                    d = Double.parseDouble(this.displacement.getText());
                    k1.setDisplacement(d);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.displacement.setText("Invalid"); //if not a double, set text in textfield as invalid so user knows to retry
               } //end catch
               
               try //for v1
               {
                    v1 = Double.parseDouble (this.velocity1.getText());
                    k1.setV1(v1);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocity1.setText("Invalid"); //set text in textfield to invalid
               } //end catch
               
               try //for v2
               {
                    v2 = Double.parseDouble(this.velocity2.getText());
                    k1.setV2(v2);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.velocity2.setText("Invalid"); //set to invalid
               } //end catch
               
               try //for t
               {
                    t = Double.parseDouble(this.time.getText());
                    k1.setTime(t);
               } //end try
               catch (NumberFormatException ex)
               {
                    this.time.setText("Invalid"); //set to invalid 
               } //end catch  
          } //end else if
          
          this.k1.solve(); //call solve method in k1
          
     } //end actionPerformed method
     
} //end class



