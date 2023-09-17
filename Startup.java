/* Classname: JavaTemplate
 * Created By: Kevin Truong
 * Last Modified: enter the date here
 * Description: write a statement describing what the program does here
 * */

import javax.swing.*;

 public class Startup
 {
   
   public static void main (String[] args)
   {       
     // Declare Variables
     Fnak game = new Fnak();
     View view = new View(game);

     //Initialize the Frame
    JFrame f = new JFrame("Five Nights at Kermz");
    f.setSize(1000,500);
    f.setLocation(0,0);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(view);
    f.setVisible(true);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); // Sets fullscreen on startup
    //f.setUndecorated(true);
   }//end of main
 }//end of class