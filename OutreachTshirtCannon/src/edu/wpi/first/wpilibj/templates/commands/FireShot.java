/**
 * Controls the firing of the cannon.
 * @author Walton Robotics Team
 */
package edu.wpi.first.wpilibj.templates.commands;

public class FireShot extends CommandBase {
    
    /**
     * Default constructor for this class. Requires the cannon subsystem to be
     * free.
     */
    public FireShot() {
        requires(cannon);
    }
    
    /*
    *   Unused
    */
    protected void initialize() {
    }
    
    /**
     * Checks to see if 
     * 1. The cannon can shoot again
     * 2. The left joystick's button 3 is pressed
     * 3. The right joystick's button 3 is pressed
     * If all three are true, then the cannon fires, otherwise nothing happens
     */
    protected void execute() {
        if (oi.canShootAgain() && oi.leftStick.getRawButton(3) && oi.rightStick.getRawButton(3)) { //if it hasn't already shot 1 t-shirt then we let him shoot
            cannon.fire(); //FIRE the missile
        }
        
    }
    
    /*
    * Mandatory. Nothing big here
    */
    protected boolean isFinished() {
        return true;
    }
    
    /*
      Needed code. No biggy. Just ignore.
    */
    protected void end() {
    }
    
    /*
    Also here because it needs to be.
    */
    protected void interrupted() {
    }
}
