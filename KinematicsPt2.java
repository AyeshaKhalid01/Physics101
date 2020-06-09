//Program name: KinematicsPt2
//Programmed by: Basmala Moumneh
//Date created:  29 12 2018
//Description: Model class for the kinematics Pt2 unit. Solves for the desired variable. contains accessor and set methods for all variable.

//imports 
import java.lang.Math;
import java.util.*; 
import javax.swing.*;
import java.awt.*;

//class
public class KinematicsPt2 extends Object
{
     //variables 
     private Physics101GUI view; //GUI
     private double initialVelocity; // initial velocity
     private double finalVelocity; // final velocity
     private double displacement; // displacement 
     private double time; //  time
     private double acceleration; // acceleration
     private double theta; // angle 
     private String equation; // chosen equation
     private double answer ; // answer to the equation and the variable chosen
     private double velocityX; // horizontal velocity
     private double velocityY;// vertical velocity
     private String variable; // chosen variable 
     
     //constructor 
     public KinematicsPt2()
     {
          super();
//sets the initial values for the instance variables 
          this.finalVelocity = 0;
          this.initialVelocity = 0;
          this.time = 0;
          this.displacement = 0;
          this.velocityY = 0;
          this.velocityX = 0;
          this.acceleration = 0;
          this.theta = 0;
          this.answer = 0;
          this.equation = "";
     }
     
     //connecting the GUI to the model
     public void setGUI( Physics101GUI gui)
     {
          this.view = gui; //setting the gui instance 
     } // end of method
     
     //solves for the desired variable in the desired equation 
     public void solve ()
     {
          //temp variables
          String var = getVar(); //gets the chosen variable 
          
          //checks to see which equation was chosen and the which variable is being solved for 
// when the var is found in the switch case the equation has already been rearranged to solve for that specified variable 
          if(this.equation.equalsIgnoreCase("d = v2t - 0.5at^2"))
          {
               switch(var)
               {
                    case "v2":
                         this.answer = ((this.displacement + (0.5 *this.acceleration * (Math.pow(this.time,2))))/2);
                         break;
                    case "a": 
                         this.answer = ((2*(this.displacement - (this.finalVelocity*this.time)))/ (-(Math.pow(this.time,2))));
                         break;
                    case "t":
                         double discriminant = Math.pow(this.finalVelocity,2) - (4*(0.5*this.acceleration)*(this.displacement));
                         double possible1 = (this.finalVelocity + Math.sqrt(discriminant))/this.acceleration;
                         double possible2= (this.finalVelocity - Math.sqrt(discriminant))/this.acceleration;
                         if(possible1>=0 && possible2>=0)
                         {
                              if(possible1 <possible2)
                              {
                                   this.answer  = possible1;
                              } //end of if statement 2 
                              else
                              {
                                   this.answer  = possible2;
                              } //end of else statement 2 
                         }// end of if statement 
                         else if( possible1<0)
                         {
                              this.answer = possible2;
                         }// end of else if 
                         else 
                         {
                              this.answer = possible1;
                         }// end of else 
                         break;
                    case "d":
                         this.answer = (this.finalVelocity*this.time)  - (0.5*(this.acceleration)*(Math.pow(this.time,2)));
                         break;
                    default: //error - if an error occurs then the answer = 0 
                         this.answer = 0;
               }
          }
          else if (this.equation.equalsIgnoreCase("v2^2 = v1^2 + 2ad"))
          {
               switch(var)
               {
                    case "v1": 
                         this.answer = Math.sqrt(Math.pow(this.finalVelocity,2) - (2*this.acceleration*this.displacement));
                         System.out.println(this.answer);                     
                         break;
                    case "a":
                         this.answer = Math.pow(this.finalVelocity,2) - Math.pow(this.initialVelocity,2) /(2*this.displacement); 
                         break;
                    case "d": 
                         this.answer = Math.pow(this.finalVelocity,2)- Math.pow(this.initialVelocity,2) /(2*this.acceleration); 
                         break;
                    case "v2": 
                         this.answer = Math.sqrt((this.initialVelocity*this.time)  + (2*(this.acceleration)*this.displacement));
                         break;
                    default: //error
                         this.answer = 0;
               }
          }
          else if (this.equation.equalsIgnoreCase("d = v1t + 0.5at^2"))
          {
               switch(var)
               {
                    case "d": 
                         this.answer = (this.initialVelocity*this.time) + (0.5 * (this.acceleration) * (Math.pow(this.time,2)));
                         break;
                    case "a": 
                         this.answer = (2*(this.displacement - (this.time*this.initialVelocity)))/Math.pow(this.time,2); 
                         break;
                    case "v1":
                         this.answer = (this.displacement - (0.5*(this.acceleration)*(Math.pow(this.time,2))))/this.time; 
                         break;
                    case "t": 
                         double discriminant = Math.pow(this.initialVelocity,2) - (4*(0.5*this.acceleration)*(-1)*this.displacement);
                         double possible1 = (-this.initialVelocity + Math.sqrt(discriminant))/this.acceleration;
                         double possible2= (-this.initialVelocity - Math.sqrt(discriminant))/this.acceleration;
                         if(possible1>=0 && possible2>=0)
                         {
                              if(possible1 <possible2)
                              {
                                   this.answer  = possible1;
                              } //end of if statement 2 
                              else
                              {
                                   this.answer  = possible2;
                              } //end of else statement 2 
                         }// end of if statement 
                         else if( possible1<0)
                         {
                              this.answer = possible2;
                         }// end of else if 
                         else 
                         {
                              this.answer = possible1;
                         }// end of else 
                         
                         break;
                    default: //error -  answer = 0 
                         this.answer = 0;
               }
          }
          else if (this.equation.equalsIgnoreCase("v2 = v1 + at"))
          {
               switch(var)
               {
                    case "v2": 
                         this.answer = this.initialVelocity + this.acceleration*this.time;
                         break;
                    case "a": 
                         this.answer = (this.finalVelocity - this.initialVelocity)/this.time;
                         break;
                    case "t": 
                         this.answer = (this.finalVelocity - this.initialVelocity)/this.acceleration;
                    case "v1":
                         this.answer = this.finalVelocity - this.acceleration*this.time;
                         break;
                    default: //error - answer = 0 
                         this.answer = 0;
               }
          }
          else if (this.equation.equalsIgnoreCase("v = d/t"))
          {
               switch(var)
               {
                    case "v1": 
                         this.answer = this.displacement/this.time;
                         break;
                    case "d": 
                         this.answer = this.initialVelocity*this.time;
                         break;
                    case "t": 
                         this.answer = this.displacement/this.initialVelocity;
                         break;
                    default: //error - answer = 0 
                         this.answer = 0;
               }
          }
          else if (this.equation.equalsIgnoreCase("H: vx = v1cos(?)"))
          {
               switch(var)
               {
                    case "vx": 
                         this.answer = Math.cos(theta) * this.initialVelocity;
                         break;
                    case "v1":
                         this.answer = this.velocityX/Math.cos(theta);
                         break;
                    case "Angle": 
                         this.answer = Math.acos(this.velocityX/this.initialVelocity);
                         break;
                    default: //error - answer = 0 
                         this.answer = 0;
               }
               
          }
          else if (this.equation.equalsIgnoreCase("V: vy = v1sin(?)"))
          {
               switch(var)
               {
                    case "vy":
                         this.answer = Math.sin(theta) * this.initialVelocity;
                         break;
                    case "v1": 
                         this.answer = this.velocityY/Math.sin(theta);
                         break;
                    case "Angle": 
                         double num = (this.velocityY/this.initialVelocity);
                         this.answer = Math.asin(num);
                         break;
                    default: //error
                         this.answer = 0;
               }
          }
          
          this.updateView(); //calls the update view method to notify the GUI
     }  
     
//returns the answer that the model solved for rounded to 4 decimal places 
     public double getAnswer()
     { 
//rounding 
          double solution = Math.round((this.answer)*10000);
          solution = solution/10000;
          return solution; //returning the answer 
     }//end of method
     
     //sets the equation chosen by the user
     public void setEquation(String equation)
     {
          this.equation = equation; //setting the instance variable 
     }//end of method
     
//gets the equation chosen 
     public String getEquation()
     {
          return this.equation; //returns the chosen equation 
     }//end of method
     
// gets the chosen var to be solved for 
     public String getVar()
     {
          return this.variable; //returns the chosen variable 
     }//end of method
     
//sets the variable 
     public void setVar(String var)
     {
          this.variable = var; // sets the instance variable 
     }//end of method
     
//sets the value for the  initial velocity 
     public void setV1(double v1)
     {
          this.initialVelocity = v1;// sets the instance variable 
     }//end of method
     
//sets the value for the final velocity 
     public void setV2(double v2)
     {
          this.finalVelocity = v2;// sets the instance variable 
     }//end of method
     
//sets the value for the horizontal velocity 
     public void setVx(double vx)
     {
          this.velocityX = vx;// sets the instance variable 
     }//end of method
     
     
//sets the value for the vertical velocity 
     public void setVy(double vy)
     {
          this.velocityY = vy;// sets the instance variable 
     }//end of method
     
//gets the horizontal velocity
     public double getVx()
     {
          return this.velocityX ; // returns the horizontal velocity
          
     }//end of method
     
// gets the vertical velocity
     public double getVy()
     {
          return this.velocityY ; // returns the vertical velocity
     }//end of method
     
     //sets the value of displacement 
     public void setDisplacement ( double d)
     {
          this.displacement  = d;// sets the instance variable 
     }//end of method
     
     //sets the value of acceleration 
     public void setAcceleration (double a)
     {
          this.acceleration = a;// sets the instance variable 
     }//end of method
     
//sets the value of time 
     public void setTime (double time)
     {
          this.time  = time;// sets the instance variable 
     }//end of method
     
//gets the initial velocity 
     public double getV1 ()
     {
          return this.initialVelocity; //returns the initial velocity 
     }//end of method
     
//gets the final velocity 
     public double getV2()
     {
          return this.finalVelocity; // returns the final velocity 
     }//end of method
     
     // gets the displacement 
     public double getDisplacement()
     {
          return this.displacement; //returns the value of the displacement 
     }//end of method
     
//gets acceleration 
     public double getAcceleration()
     {
          return this.acceleration; //returns the acceleration 
     }//end of method
     
//gets time 
     public double getTime()
     {
          return this.time; //returns time
     }//end of method
     
// sets the value of the angle 
     public void setTheta(double angle)
     {
          double theta = (angle * Math.PI)/180; //changes the angle to radians from degrees 
          this.theta = theta;// sets the instance variable 
     }//end of method
     
// gets the value of the angle 
     public double getTheta()
     { 
          double theta = this.theta*180 /Math.PI; //changes the angle to degrees from radians 
          return theta; //returns the angle  
     }//end of method
     
//used to update the GUI for the user when a change occurs in the class 
     public void updateView()
     {
          this.view.updateVarsK2(); //calls the update method in the view
     }//end of method
     
     
     
}



