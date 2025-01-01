/* Classname: Power
 * Created By: Jason Chen
 * Last Modified: 06/14/23
 * Description: Controls how much power is being used
 * */

public class Power 
{
    public int powerDrain(int usage, Boolean lDoorUp, Boolean rDoorUp, Boolean lLightOn, Boolean rLightOn, Boolean cameraUp)
        {
            if(lDoorUp == true)
             {
                usage++;
             }
            if(rDoorUp == true)
             {
                usage++;
             } 
            if(lLightOn == true)
             {
                usage++;
             }
            if(rLightOn == true)
             {
                usage++;
             } 
            if(cameraUp == true)
             {
                usage++;
             } 
            return usage;
        }
}