/* Classname: Controller
 * Created By: Kevin Truong & Jason Chen
 * Last Modified: enter the date here
 * Description: write a statement describing what the program does here
 * */

import javax.swing.*;
import java.awt.event.*;

public class ButtonController implements ActionListener
{
  private Fnak game;
  private JButton button;
  
  public ButtonController (Fnak aGame, JButton aButton)
  {
    this.game = aGame;
    this.button = aButton;
  } // end of 

  public void actionPerformed (ActionEvent e) 
  {
    // Testing purposes
    //System.out.println("input");
    //System.out.println(this.game.leftDoorState());
    //System.out.println(this.game.leftLightState());

    // Start the game when the start button is pressed
    if(this.button.getActionCommand() == "Start") 
    {
      this.game.gameStart();
    } // end of if

    // Turn the left light on
    if(this.button.getActionCommand() == "Left Light" && this.game.leftLightState() == false)
    {
      this.game.lLightOn();
    } // end of if

    // Turn the left light off
    else if(this.button.getActionCommand() == "Left Light" && this.game.leftLightState() == true) 
    {
      this.game.lLightOff();
    } // end of else if

    // Turn the right light on
    if(this.button.getActionCommand() == "Right Light" && this.game.rightLightState() == false) 
    {
      this.game.rLightOn();
    } // end of if

    // Turn the right light off
    else if(this.button.getActionCommand() == "Right Light" && this.game.rightLightState() == true) 
    {
      this.game.rLightOff();
    } // end of else if

    // Turn the left door on
    if((this.button.getActionCommand() == "Left Door" && this.game.leftDoorState() == false))
    {
      this.game.lDoorOn();
    } // end of if

    // Turn the left door off
    else if((this.button.getActionCommand() == "Left Door" && this.game.leftDoorState() == true))
    {
      this.game.lDoorOff();
    } //end of else if

    // Turn the right door on
    if(this.button.getActionCommand() == "Right Door" && this.game.rightDoorState() == false)
    {
      this.game.rDoorOn();
    } // end of if

    // Turn the right door off
    else if((this.button.getActionCommand() == "Right Door" && this.game.rightDoorState() == true))
    {
      this.game.rDoorOff();
    } //end of else if

    // Turn camera off
    if(this.button.getActionCommand() == "Camera" && this.game.cameraState() == true)
    {
      this.game.cameraOff();
    } //end of if

    // Turn camera on
    else if(this.button.getActionCommand() == "Camera" && this.game.cameraState() == false)
    {
      this.game.cameraOn();
    } //end of else if

    if(this.button.getActionCommand() == "Show Stage")
    {
      this.game.showStageOn();
      
      // Turn everything else off
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }
    
    if(this.button.getActionCommand() == "Dining Area")
    {
      this.game.diningAreaOn();
      
      // Turn everything else off
      this.game.showStageOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "Backstage")
    {
      this.game.backStageOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "Pirate Cove")
    {
      this.game.pirateCoveOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "West Hall")
    {
      this.game.westHallOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "Supply Closet")
    {
      this.game.supplyClosetOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "West Hall Corner")
    {
      this.game.westHallCornerOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "Restrooms")
    {
      this.game.restroomsOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "Kitchen")
    {
      this.game.kitchenOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.eastHallOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "East Hall")
    {
      this.game.eastHallOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallCornerOff();
    }

    if(this.button.getActionCommand() == "East Hall Corner")
    {
      this.game.eastHallCornerOn();

      // Turn everything else off
      this.game.showStageOff();
      this.game.diningAreaOff();
      this.game.backStageOff();
      this.game.pirateCoveOff();
      this.game.westHallOff();
      this.game.supplyClosetOff();
      this.game.westHallCornerOff();
      this.game.restroomsOff();
      this.game.kitchenOff();
      this.game.eastHallOff();
    }

    if(this.button.getActionCommand() == "Exit Game")
    {
      this.game.exitGame();
    }

    if(this.button.getActionCommand() == "Continue Game")
    {
      this.game.gameStart();
    }

    if(this.button.getActionCommand() == "Pause")
    {
      this.game.gameOver();
    }

  } // end of paintComponent

}//end of class
