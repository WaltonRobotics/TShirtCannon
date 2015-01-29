
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.FireShot;
import edu.wpi.first.wpilibj.templates.commands.HoldSafety;
import edu.wpi.first.wpilibj.templates.commands.SafetyLockOn;

/**
 * This is the Output/Input class. All buttons and joysticks. Mark I
 * @author Walton Robotics Team
 */
public class OI {

    public Joystick leftStick = new Joystick(1);
    //unable to use tiggers with kickerbot since triggers are overdrive
    //Button leftButton2 = new JoystickButton(leftStick, 2);  No occurances
    Button leftButton3 = new JoystickButton(leftStick, 3); // Safety Button
    //Button leftButton4 = new JoystickButton(leftStick, 4);  No occurances
    //Button leftButton5 = new JoystickButton(leftStick, 5);  No occurances
    //Button leftButton6 = new JoystickButton(leftStick, 6);  No occurances
    //Button leftButton7 = new JoystickButton(leftStick, 7);  No occurances
    //Button leftButton10 = new JoystickButton(leftStick, 10); No occurances
    //Button leftButton11 = new JoystickButton(leftStick, 11); No occurances
    //Button leftButton12 = new JoystickButton(leftStick, 12); No occurances
    public Joystick rightStick = new Joystick(2);
    //unable to use tiggers with kickerbot since triggers are overdrive
    //Button rightButton2 = new JoystickButton(rightStick, 2); No occurances
    Button rightButton3 = new JoystickButton(rightStick, 3); // Fire button
    //Button rightButton4 = new JoystickButton(rightStick, 4); No occurances
    //Button rightButton5 = new JoystickButton(rightStick, 5); No occurances
    //Button rightButton6 = new JoystickButton(rightStick, 6); No occurances
    //Button rightButton7 = new JoystickButton(rightStick, 7); No occurances
    //Button rightButton8 = new JoystickButton(rightStick, 8); No occurances
    //Button rightButton10 = new JoystickButton(rightStick, 10); No occurances
    //Button rightButton11 = new JoystickButton(rightStick, 11); No occurances
    //Button rightButton12 = new JoystickButton(rightStick, 12); No occurances
    public static DriverStation ds = DriverStation.getInstance();
    public static boolean clearToShoot = false; //false means safety is enabled
    public static int shots = 0, cycles = 0;
    public OI() {
        System.out.println("oi");
        leftButton3.whileHeld(new HoldSafety(1)); /*sets this button held's 
                command to 'HoldSafety' with a 1 second safety delay*/
        leftButton3.whenReleased(new SafetyLockOn()); /*sets this button 
                released to 'SafetyLightOn' to turn on the saftey thus making 
                the robot unable to shoot*/
        rightButton3.whenPressed(new FireShot()); /*sets this button to 
                'FireShot' - this wont shoot unless the saftey sequences approve 
                of the shot*/

//        rightButton3.whenPressed(new ManualChangeTurretAngle(1)); //make turret angle up
//        rightButton3.whenReleased(new ManualChangeTurretAngle(0)); //make turret stop changing
//        rightButton2.whenPressed(new ManualChangeTurretAngle(-1)); //make turret angle down
//        rightButton2.whenReleased(new ManualChangeTurretAngle(0)); //make turret stop changing
    }
    /**
     * **FACT CHECK THIS** Returns the inverted value of Joystick.getY() method. This is due to 
     * how T-Shirt cannon's left motors face the rear of the bot
     * @return The negative Y-axis value of the left joystick
     */
    public double getLeftY() {
        return -leftStick.getY();
    }

    public double getRightY() {
        return -rightStick.getY();
    }

    public double getLeftX() {
        return leftStick.getX();
    }

    public double getRightX() {
        return rightStick.getX();
    }
    
    /**
     * Sets the safety on or off. A false value means you cannot shoot and a 
     * true value means the opposite
     * @param state The desired state for the safety
     */
    public void setSafetyClear(boolean state) { 
        clearToShoot = state;
    }
    /**
     * Gets the safety to decide if you can shoot
     * @return True if you're clear to shoot, False if otherwise
     */
    public boolean getSafety() { 
        return clearToShoot;
    }
    
    /**
     * Sees if the cannon can shoot again
     * @return True if shots have been zeroed, false if otherwise
     */
    public boolean canShootAgain() {
        return shots == 0;
    }
    
    /**
     * Sets shots to zero 
     */
    public void zeroShotCount() {
        shots = 0;
    }
    
    /**
     * 
     * @return the number of runs (0 or 1) that the safety button has been held
     * This is to prevent using the timer every time
     * 
     */
    public double getCycles() { //
        return cycles; //returns the runs
    }
    
    /**
     * Sets the number of cycles to the desired integer
     * @param runs the number of "runs" that have elapsed
     */
    public void setCycles(int runs) {
        cycles = runs;
    }
    
    /**
     * Retrieves the value designated for firing seconds, as defined on the
     * driver station
     * @return the value set on the driver station's 1st ANALOG INPUT slot
     */
    public static double getFiringSeconds() {
        return ds.getAnalogIn(1);
    }
    
    /**
     * Retrieves the number of seconds for the accumulator to charge as defined
     * by the second analog input slot on the driver station.
     * @return The number of seconds that the accumulator needs to charge
     */
    public static double getAccumulatorChargingSeconds() {
        return ds.getAnalogIn(2);
    }
    
}
