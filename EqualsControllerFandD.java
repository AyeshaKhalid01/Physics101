//Class Name:EqualsControllerFandD    class
//Description: sets the values from the text fields as the variables and calls the solution method in the model to solve for an answer

//imports
import javax.swing.*;
import java.awt.event.*;

public class EqualsControllerFandD extends Object implements ActionListener
{
     //instance variables of model and textfield 
     private FandD fandD;          //instance of forces and dynamics model class
     private JTextField d;  //forces and dynamics text field for distance
     private JTextField a;  //forces and dynamics text field for acceleration
     private JTextField fg;  //forces and dynamics text field for fg(gravitational force)
     private JTextField g;  //forces and dynamics text field for acceleration of gravity
     private JTextField ff;  //forces and dynamics text field for frictional force
     private JTextField mu;  //forces and dynamics text field for mu
     private JTextField totalMass; //forces and dynamics text field for total mass
     private JTextField m1;  //forces and dynamics text field for the first mass
     private JTextField m2;  //forces and dynamics text field for second mass
     private JTextField fd;  //forces and dynamics text field for fd
     private JTextField theta;  //forces and dynamics text field for theta
     private JTextField w;  //forces and dynamics text field for work
     private JTextField fn;  //forces and dynamics text field for normal force
     private JTextField fnet;  //forces and dynamics text field for net force
     private JTextField force;  //forces and dynamics text field for total force
     
     
//constructor for EqualsControllerFandD has the current model object and all FD text fields 
     public EqualsControllerFandD(FandD aModel, JTextField dTF, JTextField aTF, JTextField fgTF, JTextField gTF,JTextField ffTF, JTextField muTF, JTextField m1TF, JTextField m2TF, JTextField fdTF, JTextField thetaTF, JTextField wTF, JTextField fnTF,JTextField fnetTF, JTextField forceTF,JTextField totalMassTF)
     {
          //sets the model provided in the constructor as the model instance variable in the controller
          this.fandD = aModel;
          //sets the text fields provided in the constructor as the text field instance variable in the controller
          this.d= dTF;
          this.a= aTF;
          this.fg= fgTF;
          this.g= gTF;
          this.ff= ffTF;
          this.mu= muTF;
          this.m1= m1TF;
          this.m2= m2TF;
          this.fd= fdTF;
          this.theta= thetaTF;
          this.w= wTF;
          this.fn= fnTF;
          this.fnet= fnetTF;
          this.force= forceTF;
          this.totalMass= totalMassTF;
     }//end of EqualsControllerFandD constructor
     
//responds to user input by performing certain methods
     public void actionPerformed(ActionEvent e)
     {
          double totalMassD; //used to store the total mass value entered by the user as a double
          double aD;  //used to store the acceleration value entered by the user as a double
          double fnetD;  //used to store the fnet value entered by the user as a double
          double gD;  //used to store the g value entered by the user as a double
          double dD;  //used to store the distance value entered by the user as a double
          double m1D;  //used to store the mass1 value entered by the user as a double
          double m2D;  //used to store the mass2 value entered by the user as a double
          double ffD;  //used to store the frictional force value entered by the user as a double
          double fnD;  //used to store the normal force value entered by the user as a double
          double muD;  //used to store the mu value entered by the user as a double
          double fgD;  //used to store the fg value entered by the user as a double
          double forceD;  //used to store the force value entered by the user as a double
          double thetaD;  //used to store the mass1 value entered by the user as a double
          double wD;  //used to store the work value entered by the user as a double
          
          //gets the current equation and variable selected by the user by using accessor methods in the FD model class
          String currentfandDequation=this.fandD.getEquation();
          String currentfandDvariable=this.fandD.getVariable();
          
          //checks to see if the fnet equation was selected
          if(currentfandDequation.equalsIgnoreCase("fnet=ma"))
          {
//if the fnet equation is selected then checks to see if the fnet variable is selected
               if(currentfandDvariable.equalsIgnoreCase("fnet"))
               {
                    //stores the value of total mass entered in the text field as a double and uses it as an argument to set total mass in the model  class  
                    totalMassD =Double.parseDouble(this.totalMass.getText());
                    this.fandD.setTotalMass(totalMassD);
//stores the value of acceleration entered in the text field as a double and uses it as an argument to set acceleration in the model  class       
                    aD =Double.parseDouble(this.a.getText());
                    this.fandD.setA(aD);
                    //call the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }//end of fnet if statement
//if the fnet equation is selected then checks to see if the mass variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("m"))
               {
                    //stores the value of fnet entered in the text field as a double and uses it as an argument to set fnet in the model class  
                    fnetD =Double.parseDouble(this.fnet.getText());
                    this.fandD.setFnet(fnetD);
                    //stores the value of acceleration entered in the text field as a double and uses it as an argument to set acceleration in the model class  
                    aD =Double.parseDouble(this.a.getText());
                    this.fandD.setA(aD);
                    //call the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the fnet equation is selected then checks to see if the acceleration variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("a"))
               {
                    //stores the value of fnet entered in the text field as a double and uses it as an argument to set fnet in the model class  
                    fnetD =Double.parseDouble(this.fnet.getText());
                    this.fandD.setFnet(fnetD);
                    //stores the value of total mass entered in the text field as a double and uses it as an argument to set total mass in the model  class  
                    totalMassD =Double.parseDouble(this.totalMass.getText());
                    this.fandD.setTotalMass(totalMassD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
          }//end of fnet if statement
//checks to see if the g equation was selected
          else if(currentfandDequation.equalsIgnoreCase("g=((Gm1)/d)^2"))
          {
//if the g equation is selected then checks to see if the g variable is selected
               if(currentfandDvariable.equalsIgnoreCase("g"))
               {
//stores the value of mass1 entered in the text field as a double and uses it as an argument to set mass1 in the model  class 
                    m1D =Double.parseDouble(this.m1.getText());
                    this.fandD.setM1(m1D);
//stores the value of distance entered in the text field as a double and uses it as an argument to set distance in the model  class 
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the g equation is selected then checks to see if the g variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("m1"))
               {
//stores the value of g entered in the text field as a double and uses it as an argument to set g in the model  class 
                    gD =Double.parseDouble(this.g.getText());
                    this.fandD.setg(gD);
//stores the value of distance entered in the text field as a double and uses it as an argument to set distance in the model  class
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
//if the g equation is selected then checks to see if the g variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("d"))
               {
//stores the value of g entered in the text field as a double and uses it as an argument to set g in the model  class 
                    gD =Double.parseDouble(this.g.getText());
                    this.fandD.setg(gD);
//stores the value of mass1 entered in the text field as a double and uses it as an argument to set mass1 in the model  class 
                    m1D =Double.parseDouble(this.m1.getText());
                    this.fandD.setM1(m1D);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
          }//end of g if statement
//checks to see if the ff equation was selected
          else if(currentfandDequation.equalsIgnoreCase("ff=(mu)(Fn)"))
          {
//if the ff equation is selected then checks to see if the ff variable is selected
               if(currentfandDvariable.equalsIgnoreCase("ff"))
               {
//stores the value of mu entered in the text field as a double and uses it as an argument to set mu in the model  class 
                    muD =Double.parseDouble(this.mu.getText());
                    this.fandD.setMu(muD);
//stores the value of fn entered in the text field as a double and uses it as an argument to set fn in the model  class 
                    fnD =Double.parseDouble(this.fn.getText());
                    this.fandD.setFn(fnD);
                    //calls the solve method in the FD model class to get the final answer
                    
                    this.fandD.solve();
               }
//if the ff equation is selected then checks to see if the mu variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("mu"))
               {
//stores the value of ff entered in the text field as a double and uses it as an argument to set ff in the model  class 
                    ffD =Double.parseDouble(this.ff.getText());
                    this.fandD.setFf(ffD);
//stores the value of fn entered in the text field as a double and uses it as an argument to set fn in the model  class 
                    fnD =Double.parseDouble(this.fn.getText());
                    this.fandD.setFn(fnD);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
//if the ff equation is selected then checks to see if the mu variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("fn"))
               {
//stores the value of ff entered in the text field as a double and uses it as an argument to set ff in the model  class 
                    ffD =Double.parseDouble(this.ff.getText());
                    this.fandD.setFf(ffD);
//stores the value of mu entered in the text field as a double and uses it as an argument to set mu in the model  class 
                    muD =Double.parseDouble(this.mu.getText());
                    this.fandD.setMu(muD);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
          }//end of ff if statement
//checks to see if the fg equation was selected
          else if(currentfandDequation.equalsIgnoreCase("fg=((Gm1m2)/d)^2"))
          {
//if the fg equation is selected then checks to see if the fg variable is selected
               if(currentfandDvariable.equalsIgnoreCase("fg"))
               {
//stores values for M1,M2 and distance and uses them as arguments to set the values for each in the model class
                    m1D =Double.parseDouble(this.m1.getText());
                    this.fandD.setM1(m1D);
                    m2D =Double.parseDouble(this.m2.getText());
                    this.fandD.setM2(m2D);
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the fg equation is selected then checks to see if the m1 variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("m1"))
               {
//stores values for fg,M2 and distance and uses them as arguments to set the values for each in the model class
                    fgD =Double.parseDouble(this.fg.getText());
                    this.fandD.setFg(fgD);
                    m2D =Double.parseDouble(this.m2.getText());
                    this.fandD.setM2(m2D);
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the fg equation is selected then checks to see if the m2 variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("m2"))
               {
//stores values for fg,M1 and distance and uses them as arguments to set the values for each in the model class
                    fgD =Double.parseDouble(this.fg.getText());
                    this.fandD.setFg(fgD);
                    m1D =Double.parseDouble(this.m1.getText());
                    this.fandD.setM1(m1D);
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the fg equation is selected then checks to see if the distance variable is selected
               else if(currentfandDvariable.equalsIgnoreCase("d"))
               {
//stores values for fg,M1 and M2 and uses them as arguments to set the values for each in the model class
                    fgD =Double.parseDouble(this.fg.getText());
                    this.fandD.setFg(fgD);
                    m1D =Double.parseDouble(this.m1.getText());
                    this.fandD.setM1(m1D);
                    m2D =Double.parseDouble(this.m2.getText());
                    this.fandD.setM2(m2D);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
          }//end of fg if statement
//checks to see if the fgMg equation was selected
          else if(currentfandDequation.equalsIgnoreCase("fg=mg"))
          {
               //if the fgMg equation is selected then checks to see if the fg variable is selected   
               if(currentfandDvariable.equalsIgnoreCase("fg"))
               {
//stores values for g and total mass uses them as arguments to set the values for each in the model class
                    totalMassD =Double.parseDouble(this.totalMass.getText());
                    this.fandD.setTotalMass(totalMassD);
                    gD =Double.parseDouble(this.g.getText());
                    this.fandD.setg(gD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the fgMg equation is selected then checks to see if the m variable is selected   
               if(currentfandDvariable.equalsIgnoreCase("m"))
               {
//stores values for fg and g uses them as arguments to set the values for each in the model class
                    fgD =Double.parseDouble(this.fg.getText());
                    this.fandD.setFg(fgD);
                    gD =Double.parseDouble(this.g.getText());
                    this.fandD.setg(gD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the fgMg equation is selected then checks to see if the g variable is selected   
               if(currentfandDvariable.equalsIgnoreCase("g"))
               {
//stores values for fg and total mass uses them as arguments to set the values for each in the model class
                    fgD =Double.parseDouble(this.fg.getText());
                    this.fandD.setFg(fgD);
                    totalMassD =Double.parseDouble(this.totalMass.getText());
                    this.fandD.setTotalMass(totalMassD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
          }//end of fgMg if statement
//checks to see if the work equation was selected
          else if(currentfandDequation.equalsIgnoreCase("w=|f|d|(cos theta)"))
          {
               //if the work equation is selected then checks to see if the w variable is selected   
               if(currentfandDvariable.equalsIgnoreCase("w"))
               {
//stores values for force, distance and theta uses them as arguments to set the values for each in the model class
                    forceD =Double.parseDouble(this.force.getText());
                    this.fandD.setForce(forceD);
                    thetaD =Double.parseDouble(this.theta.getText());
                    this.fandD.setTheta(thetaD);
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the work equation is selected then checks to see if the force variable is selected   
               else if(currentfandDvariable.equalsIgnoreCase("f"))
               {
//stores values for work, distance and theta uses them as arguments to set the values for each in the model class
                    wD =Double.parseDouble(this.w.getText());
                    this.fandD.setWork(wD);
                    thetaD =Double.parseDouble(this.theta.getText());
                    this.fandD.setTheta(thetaD);
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the work equation is selected then checks to see if the distance variable is selected   
               else if(currentfandDvariable.equalsIgnoreCase("d"))
               {
//stores values for work, force and theta uses them as arguments to set the values for each in the model class
                    forceD =Double.parseDouble(this.force.getText());
                    this.fandD.setForce(forceD);
                    thetaD =Double.parseDouble(this.theta.getText());
                    this.fandD.setTheta(thetaD);
                    wD =Double.parseDouble(this.w.getText());
                    this.fandD.setWork(wD);
//calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
               //if the work equation is selected then checks to see if the theta variable is selected   
               else if(currentfandDvariable.equalsIgnoreCase("theta"))
               {
//stores values for work, force and distance uses them as arguments to set the values for each in the model class
                    forceD =Double.parseDouble(this.force.getText());
                    this.fandD.setForce(forceD);
                    wD =Double.parseDouble(this.w.getText());
                    this.fandD.setWork(wD);
                    dD =Double.parseDouble(this.d.getText());
                    this.fandD.setD(dD);
                    //calls the solve method in the FD model class to get the final answer
                    this.fandD.solve();
               }
          }//end of fnet if statement
     }//end of equation if statement
}//end of controller class

