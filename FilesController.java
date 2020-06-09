//Program name: FilesController
//Programmed by: Basmala Moumneh
//Date created: 03 01 2019
//Description: Controller for the files button - opens a jfileschooser that allows the user to open a specific file
//http://www.java2s.com/Tutorials/Java/Swing_How_to/JFileChooser/Open_Selected_file_with_default_application_in_JFileChooser.htm code from this website was utilized 

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;  
import javax.swing.JFileChooser;  
import java.io.File;

//class
public class FilesController extends Object implements ActionListener 
{
     //variables
     private Physics101GUI gui; //GUI
     
     //constructor 
     public  FilesController(Physics101GUI model)
     {
          this.gui = model; //sets the GUI
     } // end of method 
     
//runs when a method occurs 
     public void actionPerformed (ActionEvent e)
     {
          
          JFileChooser fileChooser=new JFileChooser();  //creates a JFileChooser object
          
          //File chooser will appear in no windows parent  
          int a=fileChooser.showOpenDialog(null);  //opens the file chooser
          
          //Action that will take when user click open button  
          if(a==JFileChooser.APPROVE_OPTION)  
          {  
               //Get file that want to open  
               File fileToOpen=fileChooser.getSelectedFile();  
               
               try  
               {  
                    Desktop.getDesktop().open(fileToOpen);  //attempts to open the file 
               }  
               catch(Exception exception)  
               {  
                    System.out.println("A problem occurred. ");  //throws and exception if there's an error 
               }  
               
          } //end of if statement 
          
     }// end of method 
     
}// end of class

