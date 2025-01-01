/* Classname: FoxyClass
 * Created By: Jason Chen
 * Last Modified: 06/12/23
 * Description: Controls hows Foxy Behaves
 * */

 public class Foxy
 {
     // Instance Variables
   
     //generates bonnies location
     public int getStage(int stage, int difficulty, Boolean camera)
         {
             int n = (int) (Math.random() * 20 + 1); //generates a random number between 1-20
             //if generated number is greater or equal to than the ai difficulty
             if (n <= difficulty && camera == false)
                 {
                     if (stage <= 3)
                         {
                             stage++;
                             return stage;
                         }//if  
                     else if(stage >= 4)
                         {
                             stage = 0;
                             return stage;
                         }//else if
                 }//if
             //if generated number is less than the ai difficulty   
             else if(n <= difficulty)
                 {
                     return stage;
                 }//else if
             return stage;
         }//getLocation()
     
     //gets bonnies location    
     public int stageGet(int stage, int difficulty)    
         {
             return stage;
         }//locationGet()
  
 }//end of class
 
  