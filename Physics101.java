//Physics101
//Description: Startup class to link model and gui and display gui in a frame

//imports
import javax.swing.*;
import java.awt.Color;
//class
public class Physics101   
{
     //main
     public static void main (String [ ] args)    
     {
          //instance variable declaration and initialization
          KinematicsPt1 kin1 = new KinematicsPt1(); //kinematics 1 model
          KinematicsPt2 kin2 = new KinematicsPt2(); //kinematics 2 model
          FandD fd = new FandD();                             //forces and dynamics model
          ConversionClass conversionC = new ConversionClass();                   //conversion class
          //DisplacementTimeGraph dtGraph = new DisplacementTimeGraph(); //graphing class
          Physics101GUI mainScreen = new Physics101GUI(kin2, kin1, fd, conversionC); //gui class with all models passed as parameters
          mainScreen.setBackground(Color.CYAN);
//display the gui in a frame 
          JFrame f = new JFrame("PHYSICS101");
          f.setContentPane(mainScreen);
          f.getContentPane().setBackground(Color.CYAN);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          f.setSize(700,700);
          f.setBackground(Color.RED);
          f.setVisible(true);
     } //end main
}  //end class



