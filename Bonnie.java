/* Classname: BonnieClass
 * Created By: Jason Chen
 * Last Modified: 05/31/23
 * Description: Controls hows Bonnie Behaves
 * */

public class Bonnie
{
    // Instance Variables

    //generates bonnies location
    public int getLocation(int location, int difficulty)
        {
            int n = (int) (Math.random() * 20 + 1); //generates a random number between 1-20
            //if generated number is greater or equal to than the ai difficulty
            if (n <= difficulty)
                {
                    if(location <= 5)
                        {
                            location++;
                            return location;
                        }//if
                    else if (location >= 6)
                        {
                            location = 0;
                            return location;
                        }//else if      
                }//if
            //if location if greater than 5, reset    
            else if (n <= difficulty)
                {
                    return location;
                }//else if  
            return location;
        }//getLocation()
    
    //gets bonnies location    
    public int locationGet(int location, int difficulty)    
        {
            return location;
        }//locationGet()
 
}//end of class

