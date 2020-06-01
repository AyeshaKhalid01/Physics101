//Class Name:BackToEqnsFDController  class
//Programmed by: Ayesha Khalid
//Last Modified: December 29th 2018
//Description: calls appropriate methods when the back to FD equations is clicked 

import javax.swing.*; 
import java.awt.event.*; 

//class 
public class BackToEqnsFDController implements ActionListener 
{ 
     //instance variables of gui
     private Physics101GUI gui; 
     
     // constructor 
     public  BackToEqnsFDController(Physics101GUI gui) 
     { 
          this.gui = gui; //sets the GUI 
     } // end of method  
     
     public void actionPerformed (ActionEvent e) 
     { 
          this.gui.backToEquationsFandD(); //calls a method in the GUI that causes the screen to change back to the kinematics Pt2 equations page. 
          this.gui.displayFDEqns();  
     } //end of method 
     
}// end of class 
