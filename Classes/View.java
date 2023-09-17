/* Classname: View
 * Created By: Kevin Truong & Jason Chen
 * Last Modified: May 31, 2023
 * Description: The view class of our FNAK game
 * */

import java.awt.*;
import javax.swing.*;

public class View extends JPanel
{
    // Instance Variables
    private Fnak game; // The game Model

    // Start screen
    private JButton startButton = new JButton();
    private ImageIcon start = new ImageIcon(".//Resources//start.png");
    private JLabel titleLabel;

    // Default background
    private ImageIcon bg = new ImageIcon(".//Resources//black.png");

    // Left side Buttons
    private JButton leftLightSwitch = new JButton();
    private ImageIcon leftLightIcon = new ImageIcon(".//Resources//leftLightOn.png");
    private JButton leftDoorSwitch = new JButton();
    private ImageIcon leftDoorIcon = new ImageIcon(".//Resources//leftDoorOn.png");
    private JPanel leftButtons = new JPanel();

    // Right side Buttons
    private JButton rightLightSwitch = new JButton();
    private ImageIcon rightLightIcon = new ImageIcon(".//Resources//rightLightOn.png");
    private JButton rightDoorSwitch = new JButton();
    private ImageIcon rightDoorIcon = new ImageIcon(".//Resources//rightDoorOn.png");
    private JPanel rightButtons = new JPanel();

    // Holds all light/door buttons
    private JPanel allButtons = new JPanel();

    // Camera Components
    private JButton cameraButton = new JButton();
    private ImageIcon cameraIcon = new ImageIcon(".//Resources//cameraButton.png");

    // Panels to hold camera buttons
    private JPanel northButtons = new JPanel();
    private JPanel eastButtons = new JPanel();
    private JPanel westButtons = new JPanel();
    private JPanel southButtons = new JPanel();

    private JLabel northLabel = new JLabel();

    //End game button
    private JButton pause = new JButton("End Game");

    /***  CAMERA LAYOUT BUTTONS  ***/

    // North Buttons
    private JButton showStage = new JButton("Show Stage");
    private JButton diningArea = new JButton("Dining Area");

    // Center Buttons
    private JButton backstage = new JButton("Backstage");
    private JButton pirateCove = new JButton("Pirate Cove");
    private JButton restrooms = new JButton("Restrooms");

    // South Buttons
    private JButton westHall = new JButton("West Hall");
    private JButton supplyCloset = new JButton("Supply Closet");
    private JButton westHallCorner = new JButton("West Hall Corner");
    private JButton kitchen = new JButton("Kitchen");
    private JButton eastHall = new JButton("East Hall");
    private JButton eastHallCorner = new JButton("East Hall Corner");

    // Clock
    private ImageIcon clock;

    // Power Buttons
    private ImageIcon powerBar;
    private ImageIcon powerValue;

    // End screen
    private JButton continueGame = new JButton("Continue Game");
    private JButton exitGame = new JButton("Exit Game");

    // Constructor for the GUI
    public View(Fnak newGame)
    {
        super();
        this.game = newGame;
        this.game.setGUI(this);
        this.layoutView();
        this.registerControllers();
        this.update();
    } // end of constructor

    private void layoutView()
    {
        // Set border layout of the main panel
        this.setLayout(new BorderLayout());

        // Start menu buttons
        startButton.setIcon(start);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);

        // Start menu labels
        titleLabel = new JLabel(new ImageIcon(".//Resources//kermit.png"));
        titleLabel.setLayout(new BorderLayout());
        titleLabel.add(startButton, BorderLayout.SOUTH);
        this.add(titleLabel);

        // Left light switch
        leftLightSwitch.setIcon(leftLightIcon);
        leftLightSwitch.setContentAreaFilled(false);
        leftLightSwitch.setBorderPainted(false);

        // Left door switch
        leftDoorSwitch.setIcon(leftDoorIcon);
        leftDoorSwitch.setContentAreaFilled(false);
        leftDoorSwitch.setBorderPainted(false);

        // Right light switch
        rightLightSwitch.setIcon(rightLightIcon);
        rightLightSwitch.setContentAreaFilled(false);
        rightLightSwitch.setBorderPainted(false);

        // Right door switch
        rightDoorSwitch.setIcon(rightDoorIcon);
        rightDoorSwitch.setContentAreaFilled(false);
        rightDoorSwitch.setBorderPainted(false);

        // Camera button
        cameraButton.setIcon(cameraIcon);
        cameraButton.setContentAreaFilled(false);
        cameraButton.setBorderPainted(false);

        // Panel to hold left buttons
        leftButtons.add(leftLightSwitch);
        leftButtons.add(leftDoorSwitch);
        leftButtons.add(pause);
        leftButtons.setBackground(Color.BLACK);

        // Panel to hold right buttons
        rightButtons.add(rightLightSwitch);
        rightButtons.add(rightDoorSwitch);
        rightButtons.setBackground(Color.BLACK);

        // Panel holding all the light/door buttons
        allButtons.setLayout(new BorderLayout());
        allButtons.setBackground(Color.BLACK);
        allButtons.add(leftButtons, BorderLayout.WEST);
        allButtons.add(rightButtons, BorderLayout.EAST);

        // Camera
        cameraButton.setIcon(cameraIcon);
        allButtons.add(cameraButton, BorderLayout.CENTER);

        // Add north side buttons
        northButtons.add(backstage);
        northButtons.add(showStage);
        northButtons.add(diningArea);
        northButtons.setBackground(Color.BLACK);

        // Add east side buttons
        eastButtons.add(restrooms);
        eastButtons.add(kitchen);
        eastButtons.setBackground(Color.BLACK);

        // Add west side buttons
        westButtons.add(pirateCove);
        westButtons.add(supplyCloset);
        westButtons.setBackground(Color.BLACK);

        // Add south side buttons
        southButtons.add(westHall);
        southButtons.add(westHallCorner);
        southButtons.add(eastHall);
        southButtons.add(eastHallCorner);
        southButtons.setBackground(Color.BLACK);

        // Set invisible and add to panel
        allButtons.setVisible(false);
        this.add(allButtons, BorderLayout.SOUTH);
        
        // Add the camera buttons to the panel
        this.add(northButtons, BorderLayout.NORTH);
        this.add(eastButtons, BorderLayout.EAST);
        this.add(westButtons, BorderLayout.WEST);
        allButtons.add(southButtons, BorderLayout.NORTH);

        // Make the camera buttons invisible by default
        northButtons.setVisible(false);
        eastButtons.setVisible(false);
        westButtons.setVisible(false);
        southButtons.setVisible(false);

        // End screen

    } // end of layoutView()

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // The title background
        this.setBackground(Color.BLACK);

/*         if(this.getGameState() == false)
        {
            if(this.game.getContinueDecision() == true)
            {
                this.remove(continueGame);
                this.remove(exitGame);
                bg  = new ImageIcon(".//Resourcess//officeDefault.png");
                allButtons.add(leftButtons);
                allButtons.add(rightButtons);
                allButtons.add(cameraButton);
                leftButtons.setVisible(true);
                rightButtons.setVisible(true);
                cameraButton.setVisible(true);
            }
        } */

        if(this.game.getGameState() == true)
            {
                this.game.powerValue();
                this.game.clock();
                this.game.timeEnd();
                this.game.getFoxyStage(this.game.foxyDifficulty());
                this.game.foxyAtDoor(this.game.foxyStage());
                allButtons.remove(continueGame);
                allButtons.remove(exitGame);
                cameraButton.setVisible(true);

                // Initialize the default game screen
                this.remove(titleLabel);
                allButtons.setVisible(true); // Set visible
                this.add(northLabel);
                bg.paintIcon(this, g, 0, 0);

                /***  CLOCK  ***/
                
                if(this.game.clock() < 15000)
                {
                    clock = new ImageIcon(".//Resources//12am.png");
                    clock.paintIcon(this, g, 1800, 10);
                } // end of if

                if(this.game.clock() >= 15000)
                {
                    clock = new ImageIcon(".//Resources//1am.png");
                    clock.paintIcon(this, g, 1800, 10);
                } // end of if

                if(this.game.clock() >= 30000)
                {
                    clock = new ImageIcon(".//Resources//2am.png");
                    clock.paintIcon(this, g, 1800, 10);
                } // end of if
                
                if(this.game.clock() >= 45000)
                {
                    clock = new ImageIcon(".//Resources//3am.png");
                    clock.paintIcon(this, g, 1800, 10);
                } // end of if

                if(this.game.clock() >= 60000)
                {
                    clock = new ImageIcon(".//Resources//4am.png");
                    clock.paintIcon(this, g, 1800, 10);
                } // end of if

                if(this.game.clock() >= 75000)
                {
                    clock = new ImageIcon(".//Resources//5am.png");
                    clock.paintIcon(this, g, 1800, 10);
                } // end of if

                if(this.game.clock() >= 90000)
                {
                    clock = new ImageIcon(".//Resources//6am.png");
                    clock.paintIcon(this, g, 1800, 10);
                    this.game.endGame();
                } // end of if

                /***  POWER BAR IMAGE  ***/
                // > 80 POWER
                if(this.game.getPower() > 80)
                {
                    // The power bar
                    powerBar = new ImageIcon(".//Resources//power100.png");
                    powerBar.paintIcon(this, g, 10, 850);

                    // The number value
                    powerValue = new ImageIcon(".//Resources//onehundred.png");
                    powerValue.paintIcon(this, g, 35, 820);
                } // end of if

                // > 60 POWER
                if(this.game.getPower() > 60 && this.game.getPower() <= 80)
                {
                    // The power bar
                    powerBar = new ImageIcon(".//Resources//power80.png");
                    powerBar.paintIcon(this, g, 10, 850);

                    // The number value
                    powerValue = new ImageIcon(".//Resources//eighty.png");
                    powerValue.paintIcon(this, g, 35, 820);
                } // end of if

                // > 40 POWER
                if(this.game.getPower() > 40 && this.game.getPower() <= 60)
                {
                    // The power bar
                    powerBar = new ImageIcon(".//Resources//power60.png");
                    powerBar.paintIcon(this, g, 10, 850);

                    // The number value
                    powerValue = new ImageIcon(".//Resources//sixty.png");
                    powerValue.paintIcon(this, g, 35, 820);
                } // end of if

                // > 20 POWER
                if(this.game.getPower() > 20 && this.game.getPower() <= 40)
                {
                    // The power bar
                    powerBar = new ImageIcon(".//Resources//power40.png");
                    powerBar.paintIcon(this, g, 10, 850);

                    // The power value
                    powerValue = new ImageIcon(".//Resources//forty.png");
                    powerValue.paintIcon(this, g, 35, 820);
                } // end of if

                // > 0 POWER
                if(this.game.getPower() > 0 && this.game.getPower() <= 20)
                {
                    powerBar = new ImageIcon(".//Resources//power20.png");
                    powerBar.paintIcon(this, g, 10, 850);

                    powerValue = new ImageIcon(".//Resources//twenty.png");
                    powerValue.paintIcon(this, g, 35, 820);
                } // end of if

                if(this.game.getPower() <= 0)
                {
                    allButtons.setVisible(false);
                    this.game.allElectronicsOff();
                    bg = new ImageIcon(".//Resources//powerOutage.png");
                    this.game.gameOver();
                    this.game.fileOutput("Lost", "Loss of Power");
                }


                else if(this.game.leftDoorState() == true && this.game.rightDoorState() == false)
                {
                    //if left light is on------------------------------------------------------------------------------------------------
                    if(this.game.leftLightState() == true && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorLeftLightBonnie.png");
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorLeftLight.png");
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorLeftLight.png");
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorLeftLightBonnie.png");
                                }//else if                    
                    } // end of if
        
                    //if right light is on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorRightLight.png");
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorRightLight.png");
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorRightLightChica.png");
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorChica.png");
                                }//else if                    
                    } // end of else if
        
                    //if none of the lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorDown.png");
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorDown.png");
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorDown.png");
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorDown.png");
                                }//else if                    
                    } // end of else if
        
                    //if all lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == true && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                bg = new ImageIcon(".//Resources//officeLeftDoorBothLightBonnie.png"); 
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorBothLights.png"); 
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorBothLightChica.png"); 
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftDoorBonnieChica.png"); 
                                }//else if                    
                    } // end of else if
                }//end of if
        
        /*------------------------------------------------------------------------------------------*/
        
                //if right door is down
                else if(this.game.leftDoorState() == false && this.game.rightDoorState() == true && this.game.cameraState() == false)
                {
                    //if left light is on------------------------------------------------------------------------------------------------
                    if(this.game.leftLightState() == true && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorBonnie.png"); 
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorLeftLight.png"); 
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorLeftLight.png"); 
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorBonnie.png"); 
                                }//else if                    
                    } // end of if
                    //if right light is on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorRightLight.png"); 
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorRightLight.png"); 
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorChica.png"); 
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorChica.png"); 
                                }//else if                    
                    } // end of else if
                    //if none of the lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorDown.png"); 
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorDown.png"); 
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorDown.png"); 
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorDown.png"); 
                                }//else if                    
                    } // end of else if
                    //if all lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == true && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorBothLightBonnie.png"); 
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorBothLights.png"); 
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorBothLightChica.png"); 
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightDoorBonnieChica.png"); 
                                }//else if                    
                    } // end of else if
                }//end of else if
        
        /*------------------------------------------------------------------------------------------*/
        
                //if none of the doors are down
                else if(this.game.leftDoorState() == false && this.game.rightDoorState() == false && this.game.cameraState() == false)
                {
                    //if left light is on------------------------------------------------------------------------------------------------
                    if(this.game.leftLightState() == true && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeBonnie.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftLight.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeLeftLight.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBonnie.png");  
                                }//else if                    
                    } // end of if

                    //if right light is on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeRightLight.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeRightLight.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeChicaAtDoor.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeChicaAtDoor.png");  
                                }//else if                    
                    } // end of else if

                    //if none of the lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeDefault.png");
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeDefault.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeDefault.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeDefault.png");  
                                }//else if                    
                    } // end of else if

                    //if all lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == true && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeBothLightsBonnie.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothLights.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothLightChica.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBonnieChica.png");  
                                }//else if                    
                    } // end of else if
                }//end of else if    
        
                /*------------------------------------------------------------------------------------------*/
        
                //if both of the doors are down
                else if(this.game.leftDoorState() == true && this.game.rightDoorState() == true && this.game.cameraState() == false)
                {
                    //if left light is on------------------------------------------------------------------------------------------------
                    if(this.game.leftLightState() == true && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorBonnie.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorLeftLight.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorLeftLight.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorBonnie.png");  
                                }//else if                    
                    } // end of if

                    //if right light is on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorRightLight.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorRightLight.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorChica.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorChica.png");  
                                }//else if                    
                    } // end of else if

                    //if none of the lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == false && this.game.rightLightState() == false)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorDown.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorDown.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorDown.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorDown.png");  
                                }//else if                    
                    } // end of else if

                    //if all lights are on---------------------------------------------------------------------------------------------
                    else if(this.game.leftLightState() == true && this.game.rightLightState() == true)
                    {
                            //if bonnie is at the door
                            if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorBothLightBonnie.png");  
                                }//if
                            //if both are not at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == false)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorBothLights.png");  
                                }//else if
                            //if chica is at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == false && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorBothLightChica.png");  
                                }//else if   
                            //if both are at the door    
                            else if(this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true)   
                                {
                                    bg = new ImageIcon(".//Resources//officeBothDoorBonnieChica.png");  
                                }//else if                    
                    } // end of else if
                }//end of if
        /*------------------------------------------------------------------------------------------------------ */
        
        //CAMERA

        if(this.game.showStage == true && this.game.cameraState() == true)
                {
                   bg = new ImageIcon(".//Resources//stageBonnieChica.png");   
                }
        
        /*------------------------------------------------------------------------------------------------------ */       
        
        /************************************************************************  JUMP SCARES  **************************************************************************/
        
        //Bonnie
        if((this.game.bonnieAtDoor(this.game.getBonnieLocation(this.game.bonnieDifficulty())) == true && this.game.leftDoorState() == false && this.game.cameraState() == true)) 
                {
                    this.game.cameraOff();
                    this.game.gameOver();
                    this.game.bonnieJumpscare();
                    bg = new ImageIcon(".//Resources//bonnieJumpscare13.png");
                    this.game.fileOutput("Lost", "Bonnie");
                }//if
        //Chica        
        if((this.game.chicaAtDoor(this.game.getChicaLocation(this.game.chicaDifficulty())) == true && this.game.rightDoorState()== false && this.game.cameraState() == true))
                {
                    this.game.cameraOff();
                    this.game.gameOver();
                    this.game.bonnieJumpscare();
                    bg = new ImageIcon(".//Resources//chicaJumpscare14.png");
                    this.game.fileOutput("Lost", "Chica");
                }//if   
        if((this.game.foxyAtDoor(this.game.foxyStage()) == true && this.game.leftDoorState() == false && this.game.leftDoorState() != true))
                {
                    this.game.cameraOff();
                    this.game.gameOver();
                    this.game.foxyJumpscare();
                    bg = new ImageIcon(".//Resources//foxyJumpscare.png");
                    this.game.fileOutput("Lost", "Foxy");
                }                

        /*******************************************************  CAMERA FUNCTIONS  ***********************************************************************/

        if(this.game.cameraState() == true)
            {
                // Set camera background as black
                this.setBackground(Color.BLACK);
                bg = new ImageIcon(".//Resources//cameraFuzz.png");
                bg.paintIcon(this, g, 0, 0);

                // Turn the light/door buttons off
                this.leftButtons.setVisible(false);
                this.rightButtons.setVisible(false);
                    
                // Set camera buttons as visible
                northButtons.setVisible(true);
                eastButtons.setVisible(true);
                westButtons.setVisible(true);
                southButtons.setVisible(true);
        

                /***  SHOW STAGE ***/
                if(this.game.showStageState() == true)
                {
                    // Paint the correlated room onto the panel
                    bg = new ImageIcon(".//Resources//stage.png");
                    bg.paintIcon(this, g, 100, 0);

                    if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 0 && this.game.getChicaLocation(this.game.chicaDifficulty()) != 0)
                    {
                        bg = new ImageIcon(".//Resources//stage.png");
                        bg.paintIcon(this, g, 100, 0);
                    }
                    

                    if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 0 && this.game.getChicaLocation(this.game.chicaDifficulty()) != 0)
                    {
                        bg = new ImageIcon(".//Resources//stageBonnie.png");
                        bg.paintIcon(this, g, 100, 0);
                    }
                    
                    else if(this.game.getChicaLocation(this.game.chicaDifficulty()) == 0 && this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 0)
                    {
                        bg = new ImageIcon(".//Resources//stageChica.png");
                        bg.paintIcon(this, g, 100, 0);
                    }

                    else if((this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 0) && (this.game.getChicaLocation(this.game.chicaDifficulty()) == 0))
                    {
                        bg = new ImageIcon(".//Resources//stageBonnieChica.png");
                        bg.paintIcon(this, g, 100, 0);
                    }


                } // end of if

                /***  DINING AREA ***/
                if(this.game.diningAreaState() == true)
                {
                    bg = new ImageIcon(".//Resources//dining.png");
                    bg.paintIcon(this, g, 0, 0);

                    if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 1 && this.game.getChicaLocation(this.game.chicaDifficulty()) != -1)
                    {
                        bg = new ImageIcon(".//Resources//dining.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 1 && this.game.getChicaLocation(this.game.chicaDifficulty()) != -1)
                    {
                        bg = new ImageIcon(".//Resources//diningBonnie.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getChicaLocation(this.game.chicaDifficulty()) == -1 && this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 1)
                    {
                        bg = new ImageIcon(".//Resources//diningChica.png");
                        bg.paintIcon(this, g, 0, 0);
                    }

                    else if((this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 1) && (this.game.getChicaLocation(this.game.chicaDifficulty()) == -1))
                    {
                        bg = new ImageIcon(".//Resources//diningBonnieChica.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  BACKSTAGE ***/
                if(this.game.backstageState() == true)
                {
                    bg = new ImageIcon(".//Resources//backstage.png");
                    bg.paintIcon(this, g, 0, 0);

                    if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 2)
                    {
                        bg = new ImageIcon(".//Resources//backstage.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 2)
                    {
                        bg = new ImageIcon(".//Resources//backstageBonnie.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if
                
                  /***  PIRATE COVE ***/
                if(this.game.pirateCoveState() == true)
                {

                    if(this.game.getFoxyStage(this.game.foxyDifficulty()) == 0)
                    {
                        bg = new ImageIcon(".//Resources//pirateCove.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    else if(this.game.getFoxyStage(this.game.foxyDifficulty()) == 1)
                    {
                        bg = new ImageIcon(".//Resources//pirateCove1.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    else if(this.game.getFoxyStage(this.game.foxyDifficulty()) == 2)
                    {
                        bg = new ImageIcon(".//Resources//pirateCove2.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    else if(this.game.getFoxyStage(this.game.foxyDifficulty()) == 3 || this.game.getFoxyStage(this.game.foxyDifficulty()) == 4)
                    {
                        bg = new ImageIcon(".//Resources//pirateCove3.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  WEST HALL ***/
                if(this.game.westHallState() == true)
                {
                    bg = new ImageIcon(".//Resources//westHall.png");
                    bg.paintIcon(this, g, 0, 0);

                     if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 4)
                    {
                        bg = new ImageIcon(".//Resources//westHall.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 4)
                    {
                        bg = new ImageIcon(".//Resources//westHallBonnie.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if
                
                /***  SUPPLY CLOSET  ***/
                if(this.game.supplyClosetState() == true)
                {
                    bg = new ImageIcon(".//Resources//supplyCloset.png");
                    bg.paintIcon(this, g, 0, 0);

                     if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 3)
                    {
                        bg = new ImageIcon(".//Resources//supplyCloset.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 3)
                    {
                        bg = new ImageIcon(".//Resources//supplyClosetBonnie.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  WEST HALL CORNER  ***/
                if(this.game.westHallCornerState() == true)
                {
                    bg = new ImageIcon(".//Resources//westHallCorner.png");
                    bg.paintIcon(this, g, 0, 0);

                     if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) != 5)
                    {
                        bg = new ImageIcon(".//Resources//westHallCorner.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getBonnieLocation(this.game.bonnieDifficulty()) == 5)
                    {
                        bg = new ImageIcon(".//Resources//westHallCornerBonnie.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  RESTROOMS  ***/
                if(this.game.restroomsState() == true)
                {
                    bg = new ImageIcon(".//Resources//restrooms.png");
                    bg.paintIcon(this, g, 0, 0);

                    if(this.game.getChicaLocation(this.game.chicaDifficulty()) != -3)
                    {
                        bg = new ImageIcon(".//Resources//restrooms.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getChicaLocation(this.game.chicaDifficulty()) == -3)
                    {
                        bg = new ImageIcon(".//Resources//restroomsChica.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  KITCHEN  ***/
                if(this.game.kitchenState() == true)
                {
                    bg = new ImageIcon(".//Resources//black.png");
                    bg.paintIcon(this, g, 0, 0);

                    if(this.game.getChicaLocation(this.game.chicaDifficulty()) != -2)
                    {
                        bg = new ImageIcon(".//Resources//black.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getChicaLocation(this.game.chicaDifficulty()) == -2)
                    {
                        bg = new ImageIcon(".//Resources//black.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  EAST HALL  ***/
                if(this.game.eastHallState() == true)
                {
                    bg = new ImageIcon(".//Resources//eastHall.png");
                    bg.paintIcon(this, g, 0, 0);

                    if(this.game.getChicaLocation(this.game.chicaDifficulty()) != -4)
                    {
                        bg = new ImageIcon(".//Resources//eastHall.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getChicaLocation(this.game.chicaDifficulty()) == -4)
                    {
                        bg = new ImageIcon(".//Resources//eastHallChica.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

                /***  EAST HALL CORNER  ***/
                if(this.game.eastHallCornerState() == true)
                {
                    bg = new ImageIcon(".//Resources//eastHallCorner.png");
                    bg.paintIcon(this, g, 0, 0);

                    if(this.game.getChicaLocation(this.game.chicaDifficulty()) != -5)
                    {
                        bg = new ImageIcon(".//Resources//eastHallCorner.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                    
                    else if(this.game.getChicaLocation(this.game.chicaDifficulty()) == -5)
                    {
                        bg = new ImageIcon(".//Resources//eastHallCornerChica.png");
                        bg.paintIcon(this, g, 0, 0);
                    }
                } // end of if

            } // end of if

            else if(this.game.cameraState() == false)
            {
                // Turn the camera layout off
                northButtons.setVisible(false);
                eastButtons.setVisible(false);
                westButtons.setVisible(false);
                southButtons.setVisible(false);

                // Turn the light/door buttons back on
                this.leftButtons.setVisible(true);
                this.rightButtons.setVisible(true);

                //reset everything
                //this.game.resetEverything();

            } // end of else if

    } // end of if

    else if(this.game.getGameState() == false)
        {
            bg.paintIcon(this, g, 0, 0);

            if(this.game.playerStatus() == false)
            {
                leftButtons.setVisible(false);
                rightButtons.setVisible(false);
                cameraButton.setVisible(false);

                this.game.threeSeconds();
                this.remove(leftButtons);
                this.remove(rightButtons);
                this.remove(cameraButton);
                allButtons.add(continueGame, BorderLayout.NORTH);
                allButtons.add(exitGame, BorderLayout.SOUTH);
                bg = new ImageIcon(".//Resources//deathScreen.png");
            }

            if(this.game.gameOutcome() == true)
            {               
                leftButtons.setVisible(false);
                rightButtons.setVisible(false);
                cameraButton.setVisible(false);

                this.game.threeSeconds();
                this.remove(leftButtons);
                this.remove(rightButtons);
                this.remove(cameraButton); 
                allButtons.add(continueGame, BorderLayout.NORTH);
                allButtons.add(exitGame, BorderLayout.SOUTH);
                bg = new ImageIcon(".//Resources//winScreen.png");
            }
        } // end of else if

        // Repaint the GUI
        this.repaint();
    }//end of paint component

    // Update the GUI
    public void update()
    {

    }

    // Register the action controllers
    public void registerControllers() {

        // For start button
        ButtonController startController = new ButtonController(this.game, this.startButton);
        this.startButton.addActionListener(startController);
        startButton.setActionCommand("Start");

        // For left light switch
        ButtonController lLightController = new ButtonController(this.game, this.leftLightSwitch);
        this.leftLightSwitch.addActionListener(lLightController);
        leftLightSwitch.setActionCommand("Left Light");
        
        // For left door switch
        ButtonController lDoorController = new ButtonController(this.game, this.leftDoorSwitch);
        this.leftDoorSwitch.addActionListener(lDoorController);
        leftDoorSwitch.setActionCommand("Left Door");
    
        // For right light switch
        ButtonController rLightController = new ButtonController(this.game, this.rightLightSwitch);
        this.rightLightSwitch.addActionListener(rLightController);
        rightLightSwitch.setActionCommand("Right Light");
    
        // For right door switch
        ButtonController rDoorController = new ButtonController(this.game, this.rightDoorSwitch);
        this.rightDoorSwitch.addActionListener(rDoorController);
        rightDoorSwitch.setActionCommand("Right Door");

        // For Camera
        ButtonController cameraController = new ButtonController(this.game, this.cameraButton);
        this.cameraButton.addActionListener(cameraController);
        cameraButton.setActionCommand("Camera");

        // For stage
        ButtonController showStageController = new ButtonController(this.game, this.showStage);
        this.showStage.addActionListener(showStageController);
        showStage.setActionCommand("Show Stage");

        // For dining room
        ButtonController diningAreaController = new ButtonController(this.game, this.diningArea);
        this.diningArea.addActionListener(diningAreaController);
        diningArea.setActionCommand("Dining Area");

        // For backstage
        ButtonController backstageController = new ButtonController(this.game, this.backstage);
        this.backstage.addActionListener(backstageController);
        backstage.setActionCommand("Backstage");

        // For cove
        ButtonController pirateCoveController = new ButtonController(this.game, this.pirateCove);
        this.pirateCove.addActionListener(pirateCoveController);
        pirateCove.setActionCommand("Pirate Cove");

        // For restrooms
        ButtonController restroomsController = new ButtonController(this.game, this.restrooms);
        this.restrooms.addActionListener(restroomsController);
        restrooms.setActionCommand("Restrooms");

        // For west hall
        ButtonController westHallController = new ButtonController(this.game, this.westHall);
        this.westHall.addActionListener(westHallController);
        westHall.setActionCommand("West Hall");

        // For west hall corner
        ButtonController westHallCornerController = new ButtonController(this.game, this.westHallCorner);
        this.westHallCorner.addActionListener(westHallCornerController);
        westHallCorner.setActionCommand("West Hall Corner");

        // For kitchen
        ButtonController kitchenController = new ButtonController(this.game, this.kitchen);
        this.kitchen.addActionListener(kitchenController);
        kitchen.setActionCommand("Kitchen");

        // For east hall
        ButtonController eastHallController = new ButtonController(this.game, this.eastHall);
        this.eastHall.addActionListener(eastHallController);
        eastHall.setActionCommand("East Hall");

        // For east hall corner
        ButtonController eastHallCornerController = new ButtonController(this.game, this.eastHallCorner);
        this.eastHallCorner.addActionListener(eastHallCornerController);
        eastHallCorner.setActionCommand("East Hall Corner");

        // For supply closet
        ButtonController supplyClosetController = new ButtonController(this.game, this.supplyCloset);
        this.supplyCloset.addActionListener(supplyClosetController);
        supplyCloset.setActionCommand("Supply Closet");

        // For continue game
        ButtonController continueGameController = new ButtonController(this.game, this.continueGame);
        this.continueGame.addActionListener(continueGameController);
        continueGame.setActionCommand("Continue Game");

        // For exit game
        ButtonController exitGameController = new ButtonController(this.game, this.exitGame);
        this.exitGame.addActionListener(exitGameController);
        exitGame.setActionCommand("Exit Game");

        // For end game
        ButtonController pauseController = new ButtonController(this.game, this.pause);
        this.pause.addActionListener(pauseController);
        pause.setActionCommand("Pause");

    }
    

}//end of view program