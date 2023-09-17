/* Classname: Model
 * Created By: Jason Chen
 * Last Modified: 06/14/23
 * Description: The model class for FNAK
 * */

  import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Fnak 
{

  // View
  private View gameView;

  // Game states
  private Boolean gameState = false;
  private Boolean preGameScreenState = true;
  private Boolean continueGame;
  Boolean deathScreen = false; //deathscreen after death

  // Power class
  private Power powerClass = new Power(); 

  // Electronics
  private Boolean lDoorUp; //left door
  private Boolean rDoorUp; //right door 
  private Boolean lLightOn; //left lights
  private Boolean rLightOn; //right lights
  private Boolean cameraUp; //camera up

  // Animatronics (COMPUTER AI)
  private Bonnie bonnie = new Bonnie();
  private Chica chica = new Chica();
  private Foxy foxy = new Foxy();
  private Boolean bonnieAtDoor = false;
  private Boolean chicaAtDoor = false;
  private Boolean foxyAtDoor = false;

  //timers
  private int deathTick;
  private int timer=0;

  //bonnie
  private int bonnieDifficulty;
  private int bonnieTick;
  private int bonnieLocation;
  int bonnieJumpFrame;
  private int bonnieDeathTimer;

  //chica
  private int chicaDifficulty;
  private int chicaTick;
  private int chicaLocation;
  int chicaJumpFrame;

  //foxy
  private int foxyDifficulty;
  private int foxyTick;
  private int foxyStage;
  private int foxyLocation;

  //power
  private int power = 360000;
  private int usage = 1;

  // Player
  private Boolean playerAlive = true;
  private Boolean playerWon = false;

  // Camera Rooms
  Boolean showStage;
  private Boolean diningArea;
  private Boolean backstage;
  private Boolean pirateCove;
  private Boolean restrooms;
  private Boolean westHall;
  private Boolean westHallCorner;
  private Boolean kitchen;
  private Boolean eastHall;
  private Boolean eastHallCorner;
  private Boolean supplyCloset;
  public boolean lDoorOn;
  public boolean rDooron;

  public int cutscene;


  public Fnak()
  {
    super();

    // Electronics
    this.lLightOn = false;
    this.rLightOn = false;
    this.lDoorUp = false;
    this.rDoorUp = false;
    this.cameraUp = false;

    // Camera Rooms
    this.showStage = false;
    this.diningArea = false;
    this.backstage = false;
    this.pirateCove = false;
    this.restrooms = false;
    this.westHall = false;
    this.westHallCorner = false;
    this.kitchen = false;
    this.eastHall = false;
    this.eastHallCorner = false;
    this.supplyCloset = false;

    this.bonnieAtDoor = false;
    this.chicaAtDoor = false;
    this.foxyAtDoor = false;

    this.playerAlive = true;
    this.playerWon = false;
  }
  
  //sets the GUI for the game
  public void setGUI(View theGUI)
    {
      this.gameView = theGUI;
    }//end of setGUI()

    public void fileOutput(String gameOutcome, String eliminatedBy)
    {
      try {
            PrintWriter out = new PrintWriter("output.txt");
            out.println("Game Outcome: " + gameOutcome);
            out.println("Eliminated By: " + eliminatedBy);
            out.close();
            System.out.println("Data saved to file successfully.");
        } // end of try
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } // end of catch
    }

    public void preGameScreenStart()
    {
      this.preGameScreenState = false;
    }

    public Boolean preGameScreenState()
    {
      return this.preGameScreenState;
    }

    public void gameStart()
    {
      this.gameState = true;
    }

    public Boolean getGameState()
    {
      return this.gameState;
    }

    public void endGame()
    {
      this.gameState = false;
      this.playerWon = true;
    }

    public Boolean gameOutcome()
    {
      return this.playerWon;
    }


    public void gameWon()
    {
      this.playerWon = true;
    }

    public void exitGame()
    {
      System.exit(0);
    }

    public void continueGame()
    {
      this.continueGame = true;
    }

    public Boolean getContinueDecision()
    {
      return this.continueGame;
    }

      public void threeSeconds()
  {
    try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
  }

  public void gameOver()
    {
      this.gameState = false;
      this.playerAlive = false;
      this.playerWon = false;
    }  

    public Boolean playerStatus()
    {
      return this.playerAlive;
    }

    public int getCutscene()
    {
      return cutscene;
    }

    public int cutsceneTrue()
    {
      return cutscene = 1;
    }

    public int cutsceneFalse()
    {
      return cutscene = 0;
    }
/*------------------------------------------------------------------------------------ */

//BONNIE

  //dificulty of bonnie
  public int bonnieDifficulty()
    {
      bonnieDifficulty = 10;
      return bonnieDifficulty;
    }  
  //internal timer  
  public int bonnieTicks()
    {
      if(gameState == true)
        {
          bonnieTick++;
          return bonnieTick;
        }
      return bonnieTick; 
    }//ticks()

  //generates a location for Bonnie to go to
  public int getBonnieLocation(int difficulty)
    {
      bonnieDifficulty = difficulty;
      //bonnie movement attempt
      if(bonnieTick >= 1200)
        {
          bonnieLocation = bonnie.getLocation(bonnieLocation, difficulty);
          bonnieTick = 0;
          return bonnieLocation;
        } 
      else if(bonnieTick <= 1199)
        {
          bonnieTicks();
          return bonnieLocation;
        }
      return bonnieLocation;
    }//getBonnieLocation()

  public int bonnieLocation()
    {
      return bonnieLocation;
    }//bonnieLocation()    

  //checks if bonnie is at door
  public Boolean bonnieAtDoor(int location)
    {
      //if bonnie is at the door
      if(bonnieLocation >= 5)
        {
          bonnieAtDoor = true;
        }//if
      //if he is not  
      else
        {
          bonnieAtDoor = false;
        }//else  
        return bonnieAtDoor;
    }  //end of bonnieAtDoor()

 //bonnie jumpscare ending
 public int bonnieJumpscare()
   {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    bonnieJumpFrame++;
      System.out.println(bonnieJumpFrame);
      System.out.println("Timer "+ bonnieDeathTimer);
      return bonnieJumpFrame;
   }//bonnieJumpscare()

/*-------------------------------------------------------------------*/

//CHICA
    
    //dificulty of chica
    public int chicaDifficulty()
      {
        chicaDifficulty = 1;
        return chicaDifficulty;
      }//chicaDifficulty()

      //internal timer  
      public int chicaTicks()
      {
        if(gameState == true)
          {
            chicaTick++;
            return chicaTick;
          }
        return chicaTick; 
      }//ticks()

    //generates a location for chica to go to
    public int getChicaLocation(int difficulty)
      {

        chicaDifficulty = difficulty;
        //chica movement attempt
        if(chicaTick >= 2000)
          {
            chicaLocation = chica.getLocation(chicaLocation, difficulty);
            chicaTick = 0;
            return chicaLocation;
          }//if
        else if(chicaTick <= 1999)
          {
            chicaTicks();
            return chicaLocation;
          }//else if  
        return chicaLocation;
      }//getChicaLocation()

    public int chicaLocation()
      {
        return chicaLocation;
      }//chicaLocation()      
      
    //checks if chica is at door
    public Boolean chicaAtDoor(int location)
      {
        //if chica is at the door
        if(chicaLocation <= -5)
          {
            chicaAtDoor = true;
          }//if
        //if she is not  
        else
          {
            chicaAtDoor = false;
          }//else  
          return chicaAtDoor;
      }  //end of chicaAtDoor()  

    //chica jumpscare ending
    public int chicaJumpscare()
      {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        chicaJumpFrame++;
        return chicaJumpFrame;
      }//cahiJumpscare()  
/*------------------------------------------------------------------------------------------------------- */

//FOXY

  //dificulty of foxy
  public int foxyDifficulty()
    {
      foxyDifficulty = 1;
      return foxyDifficulty;
    }  
  //internal timer  
  public int foxyTicks()
    {
      if(gameState == true)
        {
          foxyTick++;
          return foxyTick;
        }
      return foxyTick; 
    }//ticks()

  //generates a stage for foxy to update to
  public int getFoxyStage(int difficulty)
    {
      foxyDifficulty = difficulty;
      //foxy movement attempt
      if(foxyTick >= 700)
        {
          foxyStage = foxy.getStage(foxyStage, difficulty, cameraUp);
          foxyTick = 0;
          return foxyStage;
        } 
      else if(foxyTick <= 699)
        {
          foxyTicks();
          return foxyStage;
        }
      return foxyStage;
    }//getFoxyStage()

  public int foxyStage()
    {
      return foxyStage;
    }//foxyStage()  

  //checks if foxy is at door
  public Boolean foxyAtDoor(int location)
    {
      //if foxy is at the door
      if(foxyStage >= 4)
        {
          if(foxyStage >= 4)
            {
              foxyAtDoor = true;
            }
          else if(foxyStage <= 3)
            {
              foxyAtDoor = false;
            }  
        }//if
      //if he is not  
      else if(foxyStage <= 3)
        {
          foxyAtDoor = false;
        }//else  
        return foxyAtDoor;
    }  //end of foxyAtDoor()

    public int foxyDrain()
      {
        if(foxyStage == 4 && lDoorUp == false) 
          {
            power = power - 1;
          }
        return power;  
      }

  //foxy jumpscare
  public Boolean foxyJumpscare()
    {
      gameState = false;
      return gameState;
    }//foxyJumpscare()
    
/*------------------------------------------------------------------ */ 
//In Game Time

   //In game timer
  public int clock()
    {
      return timer++;
    }

  //when timer hits 6am, game ends  
  public Boolean timeEnd()  
    {
      Boolean timeEnd = getGameState();
        if(timer == 18000)
          {
            endGame();
          }
      return timeEnd;  
    }
/*-------------------------------------------------------------------*/
//POWER

  //How much power is used or drained
  public int powerValue()
    {
      if(foxyAtDoor == true)
        {
          power = power - 1;
        }
       else
        { 
          usage = 1;
          usage =  this.powerClass.powerDrain(usage, lDoorUp, rDoorUp, lLightOn, rLightOn, cameraUp);
          power = power - usage;
        }
      return power;
    }//end of powerValue()
   
  public int getPower()
    {
      return powerValue() / 3600;
    }

      //check if camera is up  
  public boolean cameraState()
  {
    return this.cameraUp;
  }//camera()  
  
//if left door is open  
public boolean leftDoorState()
  {
    return this.lDoorUp;
  }//leftDoor() 
  
//if right door is open  
public boolean rightDoorState()
  {
    return this.rDoorUp;
  }//rightDoor()  
  
//if left light is on  
public boolean leftLightState()
  {
    return this.lLightOn;
  }//leftLight() 
   
//if right light is on  
public boolean rightLightState()
{
  return this.rLightOn;
}//rightLight()

public void allElectronicsOff()
{
  this.lDoorOff();
  this.rDoorOff();
  this.lDoorOff();
  this.rDoorOff();
  this.cameraOff();
}
/*---------------------------------------------------------------------------- */

//CAMERA

  public Boolean showStageState()
  {
    return this.showStage;
  } // end of method

  public Boolean diningAreaState()
  {
    return this.diningArea;
  } // end of method

    public Boolean backstageState()
  {
    return this.backstage;
  } // end of method

    public Boolean pirateCoveState()
  {
    return this.pirateCove;
  } // end of method

    public Boolean westHallState()
  {
    return this.westHall;
  } // end of method

    public Boolean supplyClosetState()
  {
    return this.supplyCloset;
  } // end of method

    public Boolean westHallCornerState()
  {
    return this.westHallCorner;
  } // end of method

    public Boolean restroomsState()
  {
    return this.restrooms;
  } // end of method

    public Boolean kitchenState()
  {
    return this.kitchen;
  } // end of method

    public Boolean eastHallState()
  {
    return this.eastHall;
  } // end of method

    public Boolean eastHallCornerState()
  {
    return this.eastHallCorner;
  } // end of method

  public void cameraOn()
  {
    this.cameraUp = true;
  }

  public void cameraOff()
  {
    this.cameraUp = false;
  }

  public void lDoorOn()
  {
    this.lDoorUp = true;
  }

  public void lDoorOff()
  {
    this.lDoorUp = false;
  }

  public void rDoorOn()
  {
    this.rDoorUp = true;
  }

  public void rDoorOff()
  {
    this.rDoorUp = false;
  }

  public void lLightOn()
  {
    this.lLightOn = true;
  }
   
  public void lLightOff()
  {
    this.lLightOn = false;
  }

  public void rLightOn()
  {
    this.rLightOn = true;
  }

  public void rLightOff()
  {
    this.rLightOn = false;
  }

  /***  CAMERA ROOMS  ***/
  public void showStageOn()
  {
    this.showStage = true;
  }

  public void showStageOff()
  {
    this.showStage = false;
  }

  public void backStageOn()
  {
    this.backstage = true;
  }

  public void backStageOff()
  {
    this.backstage = false;
  }

  public void diningAreaOn()
  {
    this.diningArea = true;
  }

  public void diningAreaOff()
  {
    this.diningArea = false;
  }

  public void pirateCoveOn()
  {
    this.pirateCove = true;
  }
  
  public void pirateCoveOff()
  {
    this.pirateCove = false;
  }

  public void westHallOn()
  {
    this.westHall = true;
  }

  public void westHallOff()
  {
    this.westHall = false;
  }

  public void westHallCornerOn()
  {
    this.westHallCorner = true;
  }

  public void westHallCornerOff()
  {
    this.westHallCorner = false;
  }

  public void eastHallOn()
  {
    this.eastHall = true;
  }

  public void eastHallOff()
  {
    this.eastHall = false;
  }

  public void eastHallCornerOn()
  {
    this.eastHallCorner = true;
  }

  public void eastHallCornerOff()
  {
    this.eastHallCorner = false;
  }

  public void kitchenOn()
  {
    this.kitchen = true;
  }

  public void kitchenOff()
  {
    this.kitchen = false;
  }

  public void restroomsOn()
  {
    this.restrooms = true;
  }

  public void restroomsOff()
  {
    this.restrooms = false;
  }

  public void supplyClosetOn()
  {
    this.supplyCloset = true;
  }

  public void supplyClosetOff()
  {
    this.supplyCloset= false;
  }

/*------------------------------------------------------------------------------------ */

//LOADING SCREENS

//Pre game screen

public void preGameScreen()
  {
    try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
  }
  
  public void resetBonnie()
    {
      bonnieLocation = 0;
    }

  public void resetChica()
    {
      chicaLocation = 0;
    }  

  public void resetFoxy()
    {
      foxyStage = 0;
    }  

  public void resetPower()
    {
      power = 360000;
    }

  public void resetTimer()
    {
      timer = 0;
    }  

  public void resetLDoor()
    {
      lDoorUp = true;
    }

  public void resetRDoor ()
    {
      rDoorUp = true;
    }

  public void resetLLight()
    {
      lLightOn = false;
    }  

  public void resetRLight()
    {
      lLightOn = false;
    }

  public void resetEverything()
    {
      resetBonnie();
      resetChica();
      resetFoxy();
      resetTimer();
      resetPower();
      resetLDoor();
      resetRDoor();
      resetLLight();
      resetRLight();
    }  
  // Update the Game View
  public void updateView()
    {
      gameView.update();
    } // end of updateView()

}//end of model class