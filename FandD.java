//Class Name: FandD 
//Programmed by: Ayesha Khalid 
//Description: Calculates answers using the formulas within the forces and dynamics unit 

import java.util.*; 
import java.awt.*; 
import java.lang.Math; 
import javax.swing.*; 

public class FandD extends Object 
{ 
     private Physics101GUI view;       //current gui
     private final double GRAVITY= 9.81;      //constant value for gravity
     public static final double UNIGFORCE=6.67*(Math.pow(10,4));   //constant value for gravity
     private double normForce;        //double value for normal force
     private double fieldStrength;       //double value for field strength
     private double netForce;        //double value for net force
     private double frictionalForce;       //double value for net force
     private double gravForce;        //double value for gravitational force
     private double mass1;        //double value for mass1
     private double totalMass;        //double value for total mass
     private double mass2;        //double value for mass2
     private double acceleration;        //double value for acceleration
     private double distance ;        //double value for distance
     private double mu;         //double value for mu
     private String equation;        //string for storing equation
     private String variable;        //string for storing variable
     private double answer;        //double value for answer
     private double force;        //double value for force
     private double work;         //double value for work
     private double theta;        //double value for theta
     private double g;         //double value for g
     
     //constructor
     public FandD() 
     { 
          super(); 
//set the initial value of instant variables 
          this.normForce=0; 
          this.fieldStrength=0; 
          this.netForce=0; 
          this.frictionalForce=0; 
          this.gravForce=0; 
          this.mass1=0; 
          this.mass2=0; 
          this.totalMass=0; 
          this.acceleration=0; 
          this.distance=0 ; 
          this.mu=0; 
          this.g=0; 
          this.answer=0; 
          this.equation=null; 
     } //end of constructor
     
//solves for the final answer from all equations
     public void solve() 
     {  
//gets the variable selected by the user
          String var=getVariable(); 
          
//checks to see fnet was the equation that was selected
          if(this.equation.equalsIgnoreCase("fnet=ma")) 
          { 
               //checks to see which variable was chosen and based on that calls the specific solve method for fnet variables
               if (var.equalsIgnoreCase("fnet")) 
               { 
                    this.answer=solveFnet(); 
               } 
               else if (var.equalsIgnoreCase("m")) 
               { 
                    this.answer=solveFnetMass(); 
               } 
               else if (var.equalsIgnoreCase("a")) 
               { 
                    this.answer=solveFnetAcceleration(); 
               } 
          } //end of inner if statement 
          
//checks to see if g was the equation that was selected
          else if(this.equation.equalsIgnoreCase("g=((Gm1)/d)^2")) 
          { 
               //checks to see which variable was chosen and based on that calls the specific solve method for g variables
               if (var.equalsIgnoreCase("g")) 
               { 
                    this.answer=solveg(); 
               } 
               else if (var.equalsIgnoreCase("m1")) 
               { 
                    this.answer = solveGravitionalFieldMass(); 
               } 
               else if (var.equalsIgnoreCase("d")) 
               { 
                    this.answer = solveGravitionalFieldDistance(); 
               } 
          } //end of inner if/else statement
          
          //checks to see if ff was the equation that was selected
          else if(this.equation.equalsIgnoreCase("ff=(mu)(Fn)")) 
          { 
               //checks to see which variable was chosen and based on that calls the specific solve method for ff variables
               if (var.equalsIgnoreCase("ff")) 
               { 
                    this.answer=solveFf(); 
               } 
               else if (var.equalsIgnoreCase("mu")) 
               { 
                    this.answer = solveFfMu(); 
               } 
               else if (var.equalsIgnoreCase("fn")) 
               { 
                    this.answer = solveFfNormForce(); 
               } 
          } //end of inner if statement 
          
          //checks to see if fg was the equation that was selected
          else if(this.equation.equalsIgnoreCase("fg=((Gm1m2)/d)^2")) 
          { 
               //checks to see which variable was chosen and based on that calls the specific solve method for fg variables
               if (var.equalsIgnoreCase("fg")) 
               { 
                    this.answer=solveGravForce(); 
               } 
               else if (var.equalsIgnoreCase("m1")) 
               { 
                    this.answer = solveGravForceMass1(); 
               } 
               else if (var.equalsIgnoreCase("m2")) 
               { 
                    this.answer = solveGravForceMass2(); 
               } 
               else if (var.equalsIgnoreCase("d")) 
               { 
                    this.answer = solveGravForceDistance(); 
               } 
          } //end of inner if statement 
          
          //checks to see if fgMg was the equation that was selected
          else if(this.equation.equalsIgnoreCase("fg=mg")) 
          { 
//checks to see which variable was chosen and based on that calls the specific solve method for fgMg variables
               if (var.equalsIgnoreCase("fg")) 
               { 
                    this.answer=solvegravForceMG(); 
               } 
               else if (var.equalsIgnoreCase("m")) 
               { 
                    this.answer = solvegravForceMGMass(); 
               } 
               else if (var.equalsIgnoreCase("g")) 
               { 
                    this.answer = solvegravForceMGg(); 
               } 
          } //end of inner if statement 
          
          //checks to see if work was the equation that was selected
          else if(this.equation.equalsIgnoreCase("w=|f|d|(cos theta)")) 
          { 
//checks to see which variable was chosen and based on that calls the specific solve method for work variables
               if (var.equalsIgnoreCase("w")) 
               { 
                    this.answer=solveWork(); 
               } 
               else if (var.equalsIgnoreCase("f")) 
               { 
                    this.answer = solveWorkForce(); 
               } 
               else if (var.equalsIgnoreCase("d")) 
               { 
                    this.answer = solveWorkDistance(); 
               } 
               else if (var.equalsIgnoreCase("theta")) 
               { 
                    this.answer = solveWorkTheta(); 
               } 
          } //end of inner if statement ;
//calls the method in the gui to update the gui
          this.view.updateFandD(); 
     } //end of if/else satatement
     
     
     //Equation 1 modifications for all variables 
     public double solveFnet() 
     { 
          mass1=getM1(); 
          acceleration= getAcceleration(); 
          double fNet= totalMass*acceleration; 
          return fNet; 
     } //end of method
     
     public double solveFnetMass() 
     { 
          netForce=getNetForce(); 
          acceleration= getAcceleration(); 
          totalMass= netForce/acceleration; 
          return totalMass; 
     }  //end of method
     
     public double solveFnetAcceleration() 
     { 
          netForce=getNetForce(); 
          totalMass=getTotalMass(); 
          acceleration= netForce/totalMass; 
          return acceleration; 
     }  //end of method
     
     //Equation 2 modifications for all variables 
     
     public double solveg() 
     { 
          mass1=getM1(); 
          distance=getDistance(); 
          double g=Math.pow((UNIGFORCE*mass1)/distance,2); 
          return g; 
     }  //end of method
     
     public double solveGravitionalFieldMass() 
     { 
          fieldStrength=getg(); 
          distance=getDistance(); 
          double mass=(Math.sqrt(fieldStrength)*distance)/UNIGFORCE; 
          return mass; 
     }  //end of method
     
     public double solveGravitionalFieldDistance() 
     { 
          fieldStrength=getg(); 
          mass1=getM1(); 
          double distance=(UNIGFORCE*mass1)/(Math.sqrt(fieldStrength)); 
          return distance; 
     }  //end of method
     
     //Equation 3 modifications for all variables 
     public double solveFf() 
     { 
          mu=getMu(); 
          normForce= getFn(); 
          double Ff= mu*normForce; 
          return Ff; 
     }  //end of method
     
     public double solveFfMu() 
     { 
          frictionalForce=getFriction(); 
          normForce= getFn(); 
          mu= frictionalForce/normForce; 
          return mu; 
     }  //end of method
     
     public double solveFfNormForce() 
     { 
          frictionalForce=getFriction(); 
          mu=getMu(); 
          normForce= frictionalForce/mu; 
          return normForce; 
     }  //end of method
     
     //Equation 4 modifications for all variables 
     public double solveGravForce() 
     { 
          mass1=getM1(); 
          mass2=getM2(); 
          distance=getDistance(); 
          gravForce=Math.pow((UNIGFORCE*mass1*mass2)/distance,2); 
          return gravForce; 
     }  //end of method
     
     public double solveGravForceMass1() 
     { 
          gravForce=getGravForce(); 
          mass2=getM2(); 
          distance=getDistance(); 
          mass1=(Math.sqrt(gravForce)*distance)/(UNIGFORCE*mass2); 
          return mass1; 
     }  //end of method
     
     public double solveGravForceMass2() 
     { 
          gravForce=getGravForce(); 
          mass1=getM1(); 
          distance=getDistance(); 
          mass2=(Math.sqrt(gravForce)*distance)/(UNIGFORCE*mass1); 
          return mass2; 
     }  //end of method
     
     public double solveGravForceDistance() 
     { 
          gravForce=getGravForce(); 
          mass1=getM1(); 
          mass2=getM2(); 
          distance=(UNIGFORCE*mass1*mass2)/(Math.sqrt(gravForce)); 
          return distance; 
     }  //end of method
     
//Equation 5 modifications for all variables 
     public double solvegravForceMG() 
     { 
          totalMass=getTotalMass(); 
          fieldStrength=getg(); 
          gravForce=totalMass*fieldStrength; 
          return gravForce; 
     }  //end of method
     
     public double solvegravForceMGMass() 
     { 
          gravForce=getGravForce(); 
          fieldStrength=getg(); 
          totalMass=gravForce/fieldStrength; 
          return totalMass; 
     }  //end of method
     
     public double solvegravForceMGg() 
     { 
          gravForce=getGravForce(); 
          totalMass=getTotalMass(); 
          fieldStrength=gravForce/totalMass; 
          return fieldStrength; 
     }  //end of method
     
     //Equation 6 modifications for all variables 
     public double solveWork() 
     { 
          force=Math.abs(getForce()); 
          distance=Math.abs(getDistance()); 
          theta=this.getTheta(); 
          work=force*distance*(Math.cos(theta)); 
          return work; 
     }  //end of method
     
     public double solveWorkForce() 
     { 
          work=getWork(); 
          distance=Math.abs(getDistance()); 
          theta=this.getTheta(); 
          force=work/(distance*(Math.cos(theta))); 
          return force; 
     }  //end of method
     
     public double solveWorkDistance() 
     { 
          work=getWork(); 
          force=Math.abs(getForce()); 
          theta=this.getTheta(); 
          distance=work/(force*(Math.cos(theta))); 
          return distance; 
     }  //end of method
     
     public double solveWorkTheta() 
     { 
          work=getWork(); 
          force=Math.abs(getForce()); 
          distance=Math.abs(getDistance()); 
          theta=Math.acos(work/(force*distance)); 
          return theta; 
     }  //end of method
     
     
     //Accessor Methods for all instance variables
     
     public double getFieldStrength() 
     { 
          return gravForce; 
     }  //end of method
     
     public double getNetForce() 
     { 
          return this.netForce; 
     }  //end of method
     
     public double getM1() 
     { 
          return this.mass1; 
     }  //end of method
     
     public double getTotalMass() 
     { 
          return this.totalMass; 
     }  //end of method
     
     public double getFn() 
     { 
          return this.normForce; 
     }  //end of method
     
     public double getMu() 
     { 
          return this.mu; 
     }  //end of method
     
     public double getAcceleration() 
     { 
          return this.acceleration; 
     }  //end of method
     
     public double getM2() 
     { 
          return this.mass2; 
     }  //end of method
     
     public double getFriction() 
     { 
          return this.frictionalForce; 
     }  //end of method
     
     public double getGravForce() 
     { 
          return this.gravForce; 
     }  //end of method
     
     public double getDistance() 
     { 
          return this.distance; 
     } 
     
     public double getg() 
     { 
          return this.g; 
     }  //end of method
     
     public double getWork() 
     { 
          return this.work; 
     }  //end of method
     
     public double getForce() 
     { 
          return this.force; 
     }  //end of method
     
     public double getTheta() 
     { 
          return this.theta; 
     }  //end of method
     
     public String getVariable() 
     { 
          return this.variable; 
     }  //end of method
     
//gets the answer and rounds it to 4 decimal places
     public double getAnswer() 
     {  
          double solution = Math.round((this.answer)*10000); 
          solution = solution/10000; 
          return solution; 
     }  //end of method
     
     public String getEquation() 
     {  
          return this.equation; 
     }  //end of method
     
     //set methods for all instance variables
     public void setFn(double fn) 
     { 
          this.normForce= fn; 
     }  //end of method
     
     public void setg(double fs) 
     { 
          this.g= fs; 
     }  //end of method
     
     public void setFnet(double fnet) 
     { 
          this.netForce= fnet; 
     }  //end of method
     
     public void setFf(double ff) 
     { 
          this.frictionalForce= ff; 
     }  //end of method
     
     public void setFg(double fg) 
     { 
          this.gravForce= fg; 
     }  //end of method
     
     public void setM1(double m1) 
     { 
          this.mass1= m1; 
     }  //end of method
     
     public void setTotalMass(double m1) 
     { 
          this.totalMass= m1; 
     } 
     
     public void setM2(double m2) 
     { 
          this.mass2= m2; 
     }  //end of method
     
     public void setA(double a) 
     { 
          this.acceleration= a; 
     }  //end of method
     
     public void setD(double d) 
     { 
          this.distance= d; 
     }  //end of method
     
     public void setWork(double w) 
     { 
          this.work= w; 
     }  //end of method
     
     public void setForce(double f) 
     { 
          this.force= f; 
     }  //end of method
     
     public void setTheta(double t) 
     { 
          this.theta= t; 
     }  //end of method
     
     public void setMu(double mu) 
     { 
          this.mu= mu; 
     }  //end of method
     
     public void setEquation(String equation) 
     { 
          this.equation= equation; 
     }  //end of method
     
     public void setVariable(String var) 
     { 
          this.variable= var; 
     }  //end of method
     
     
     public void updateView() 
     { 
          this.view.updateFandD(); 
     }  //end of method
     
     public void setGUI( Physics101GUI gui) 
     { 
          this.view = gui; 
     }  //end of method
     
     public void setAnswer(double answer) 
     { 
          this.answer = answer; 
     }  //end of method
}//end of FandD class 

