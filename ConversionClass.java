//Class Name:Unit conversion class
//Description: Takes user input and converts the provided number from base unit to the specified unit

//imports the needed packages for the code to run
import java.util.*;
import java.awt.*;
import java.lang.Math;
import javax.swing.*;

//class
public class ConversionClass extends Object
{ 
//instance variables needed for class
     private String unitConversion;
     private double converter;
     private double answer;
     private Physics101GUI calcView; 
     
//constructor
     public ConversionClass()
     {
          super();
//sets intial values for instance variables
          this.converter =0;
          this.answer=0;
          this.unitConversion=null;
     } //end of constructor
     
//gets the current GUI being used
     public void setGUI(Physics101GUI currentGUI)
     {
          this.calcView = currentGUI;
     }
     
     //solution method that converts the base value to the specified unit
     public void solution()
     { 
//gets the base value entered by the user and the units they wanted to convert to
          String unit =getUnitConversion();
          double basUnit= getConverter();
          //based on the unit selected it uses the base value to convert to different units
          if(unit.equalsIgnoreCase("kilo"))
          {
               this.answer= solveKilo();
          }
          else if(unit.equalsIgnoreCase("hecto"))
          {
               this.answer= solveHecto();
          }
          else if(unit.equalsIgnoreCase("deca"))
          {
               this.answer= solveDeca();
          }
          else if(unit.equalsIgnoreCase("deci"))
          {
               this.answer= solveDeci();
          }
          else if(unit.equalsIgnoreCase("centi"))
          {
               this.answer= solveCenti();
          }
          else if(unit.equalsIgnoreCase("milli"))
          {
               this.answer= solveMilli();
          }
//updates the GUI
          updateView();
     }
     
     //Conversion methods
//changes base value to kilo
     public double solveKilo()
     {
          double baseValue= getConverter();
          double kiloValue= baseValue*(Math.pow(10,3));
          return kiloValue;
     } //end of method
     
//changes base value to hecto
     public double solveHecto()
     {
          double baseValue= getConverter();
          double hectoValue= baseValue*(Math.pow(10,2));
          return hectoValue;
     } //end of method
     
//changes base value to deca
     public double solveDeca()
     {
          double baseValue= getConverter();
          double decaValue= baseValue*(Math.pow(10,1));
          return decaValue;
     } //end of method
     
//changes base value to deci
     public double solveDeci()
     {
          double baseValue= getConverter();
          double deciValue= baseValue*(Math.pow(10,-1));
          return deciValue;
     } //end of method
     
//changes base value to centi
     public double solveCenti()
     {
          double baseValue= getConverter();
          double centiValue= baseValue*(Math.pow(10,-2));
          return centiValue;
     } //end of method
     
//changes base value to milli
     public double solveMilli()
     {
          double baseValue= getConverter();
          double milliValue= baseValue*(Math.pow(10,-3));
          return milliValue;
     } //end of method
     
     //Accessor methods 
     
     public double getAnswer()
     { 
          return this.answer;
     }//end of method
     
     public String getUnitConversion()
     {
          return this.unitConversion;
     }//end of method
     
     public double getConverter()
     {
          return this.converter;
     }//end of method
     
     //set methods
     public void setUnitConversion(String unit)
     {
          this.unitConversion= unit;
     }//end of method
     
     public void setConverter(double convert)
     {
          this.converter= convert;
     }//end of method
     
     public void updateView()
     {
          this.calcView.updateCC();
     }//end of method
     
     public void back()
     {
          //this.view.updateBack();
     }//end of method
     
}//end of conversion class


