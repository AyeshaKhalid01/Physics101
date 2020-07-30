//Kinematics part 1 model class
//Model for kinematics 1 - solves for the unknown variable based on vals from controller and tells gui to update

//imports
import javax.swing.*;
import java.awt.*;
import java.util.*;

//class
public class KinematicsPt1 extends Object
{
     //instance variables
     private double iVelocity;      //initial velocity
     private double fVelocity;      //final velocity
     private double velocity;       //average velocity
     private double displacement;   //displacement
     private double time;           //time
     private double acceleration;   //acceleration
     private String unknown;        //variable to solve 
     private double solution;       //answer to unknown variable
     private String currentEqn;     //the equation the user wishes to use that contains the unknown variable
     
     private Physics101GUI theView; //instance of the GUI 
     
     //constructor to call super class and initialize all instance variables
     public KinematicsPt1()
     {
          super();                  
          this.iVelocity = 0;       
          this.fVelocity = 0.0;
          this.velocity = 0.0;
          this.displacement = 0.0;
          this.time = 0.0;
          this.acceleration = 0;
          this.unknown = null; 
          this.solution = 0; 
     } //end constructor
     
     //method to set the gui connected to the model
     public void setGUI(Physics101GUI currentGUI)
     {
          this.theView = currentGUI;
     } //end method
     
     //method to set current equation user chose 
     public void setEqn (String eqn)
     {
          this.currentEqn = eqn;
     } //end method
     
     //method to get which unknown variable to solve for based on button clicked by user and solve for the unknown variable
     public void solve()
     {
          String variable = this.unknown;
          
          //determine which solve method to call depending on which variable must be solved for 
          switch(variable) 
          {
               case "v1":                      //if variable to solve is v1
                    this.solution = solveV1(); //find the solution
                    this.updateView();         //update the view to display answer
                    break;                     //break out of switch case once completed statements in case
               case "v2":                      //if variable to solve is v2
                    this.solution = solveV2();
                    break;
               case "va":                      //if variable to solve is v
                    this.solution = solveV();
                    this.updateView(); 
                    break;
               case "d":                       //if variable to solve is d
                    this.solution = solveD();
                    this.updateView();
                    break;
               case "t":                       //if variable to solve is t
                    this.solution = solveT();
                    this.updateView();
                    break;
               case "a":                      //if variable to solve is a
                    this.solution = solveA();
                    this.updateView();
                    break;
               default: 
                    this.solution = 0;        //default
          } //end switch case
          
          this.updateView(); 
          
     } //end method
     
     //method to solve for v1
     public double solveV1() 
     {
          double answer = 0.0; 
          
          //variable v1 found in 3 different equations so 3 different ways of calculating
          if(currentEqn.equals("v=(v1+v2)/2"))      //if equation is v=(v1+v2)/2
          {
               answer = (iVelocity + fVelocity)/2;  //solve for answer based on equation
          } //end if 
          else if(currentEqn.equals("a=(v2-v1)/t")) //if equation is a=(v2-v1)/t
          {
               answer = (fVelocity -(acceleration*time));
          } //end else if
          else if(currentEqn.equals("d=[(v1+v2)t]/2")) //if equation is d=[(v1+v2)t]/2
          {
               answer = (((2*displacement)/time)-fVelocity);
          } //end else if
          
          return answer; //return answer to method that called it - solve()
          
     } //end method
     
     //method to solve for v2 after determining which equation it is found in 
     public double solveV2() 
     {
          double answer = 0.0;
          
          //variable v2 found in 3 different equations so 3 different ways of calculating
          if(currentEqn.equals("v=(v1+v2)/2")) //if equation is v=(v1+v2)/2
          {
               answer = ((2*velocity)-iVelocity); //calculate based on equation
          } //end if 
          else if(currentEqn.equals("a=(v2-v1)/t")) //if equation is a=(v2-v1)/t
          {
               answer = ((acceleration*time)+iVelocity);
          } //end else if
          else if(currentEqn.equals("d=[(v1+v2)t]/2")) //if equation is d=[(v1+v2)t]/2
          {
               answer = (((2*displacement)/time)-iVelocity);
          } //end else if
          
          return answer; //return answer
          
     } //end method
     
     //method solves for v - average velocity - after determining which equation is required
     public double solveV() 
     {
          double answer = 0.0;
          //variable v found in 2 equations
          if(this.currentEqn.equals("v=d/t")) //if eqn is v=d/t
          {
               answer = displacement/time;
          } //end if
          else if(this.currentEqn.equals("v=(v1+v2)/2")) //if eqn is v=(v1+v2)/2
          {
               answer = (iVelocity + fVelocity)/2;
          } //end else if
          
          return answer; //return answer to method that called it
          
     } //end method
     
     //method solves for v - average velocity - after determining which equation is required
     public double solveD() 
     {
          double answer = 0.0;
          
          //variable d found in 2 different equations so 2 different ways of calculating
          if(currentEqn.equals("v=d/t")) //v=d/t
          {
               answer = velocity*time;   //calculate
          } //end if
          else if(currentEqn.equals("d=[(v1+v2)t]/2")) //d=[(v1+v2)t]/2
          {
               answer = ((iVelocity+fVelocity)*time)/2;
          } //end else if
          
          return answer; //return answer to method that called it
          
     } //end method
     
     //method to solve for time
     public double solveT() 
     {
          double answer = 0.0;
          
          //variable t found in 3 different equations so 3 different ways of calculating
          if(currentEqn.equals("v=d/t")) //equation is v=d/t
          {
               answer = displacement/velocity; //calculate based on equation
          } //end if
          else if(currentEqn.equals("a=(v2-v1)/t")) //equation is a=(v2-v1)/t
          {
               double tempAns = 0;
               tempAns = fVelocity-iVelocity;
               answer = tempAns/2;
          } //end else if
          else if(currentEqn.equals("d=[(v1+v2)t]/2")) //eqn is d=[(v1+v2)t]/2
          {
               double tempAns2 = 0;
               double tempAns3 = 0;
               tempAns2 = iVelocity+fVelocity;
               tempAns3 = tempAns2*time;
               answer = tempAns3/2;
          } //end else if
          
          return answer;
          
     } //end method
     
     //method to solve for acceleration
     public double solveA() 
     {
          double answer = 0.0;
          
          answer = (fVelocity - iVelocity)/time;
          
          return answer;
     } //end method
     
     //method to set initial velocity - called by controller after getting text from JTextField
     public void setV1(double aV1)  
     {
          this.iVelocity = aV1;     //initializes initial velocity using value passed by controller
     } //end method
     
     //method to set final velocity
     public void setV2(double aV2)  
     {
          this.fVelocity = aV2;     //initializes final velocity using value passed by controller 
     } //end method
     
     //method to set average velocity
     public void setVa(double aV)  
     {
          this.velocity = aV;
     } //end method
     
     //method to set displacement
     public void setDisplacement(double aDispVal) 
     {
          this.displacement = aDispVal;
     } //end method
     
     //method to set time
     public void setTime(double aTime) 
     {
          this.time = aTime;
     } //end method
     
     //method to set acceleration
     public void setAcceleration(double anAVal) 
     {
          this.acceleration = anAVal;
     } //end method
     
     //method to set variable that will be solved for
     public void setUnknown(String aVar) 
     {
          this.unknown = aVar;
     } //end method
     
     //method that returns initial velocity
     public double getV1() 
     {
          return this.iVelocity;
     } //end method
     
     //method that returns final velocity
     public double getV2() 
     {
          return this.fVelocity;
     } //end method
     
     //method to get average velocity
     public double getV() 
     {
          return this.velocity;
     } //end method
     
     //method to get displacement
     public double getDisplacement() 
     {
          return this.displacement;
     } //end method
     
     public double getTime() //method to get time
     {
          return this.time;
     } //end method
     
     //method to get acceleration
     public double getAcceleration() 
     {
          return this.acceleration;
     } //end method
     
     //method to get current unknown variable
     public String getUnknown() 
     {
          return this.unknown;
     } //end method
     
     //method to get equation
     public String getEquation()  
     {
          return this.currentEqn;
     } //end method
     
     //method to round and get answer to the unknown variable
     public double getSolution() 
     {
          double answer = Math.round((this.solution)*10000); //rounds
          answer = answer/10000;
          return answer; //returns rounded answer
     } //end method
     
     //method to take user back to main page
     public void back() 
     {
          this.theView.updateBack(); //call update back in GUI
     } //end method
     
     //method to update the view
     public void updateView() 
     {
          this.theView.updateVarsK1(); //call updateVarsK1 in GUI 
     } //end method
     
} //end class



