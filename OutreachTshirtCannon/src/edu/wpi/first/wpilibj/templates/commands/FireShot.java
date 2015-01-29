/**
 * Controls the firing of the cannon.
 *
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
     * CHECK OVER THIS AGAIN
     * 
     * Checks to see if 
     * 1. The cannon can shoot again 
     * 2. The admin's game pad button 7 is pressed 
     * 3. The admin's game pad button 7 is pressed If all
     * three are true, then the cannon fires, otherwise nothing happens
     */
    protected void execute() {
        if ((oi.guestPad.getMode() > 0)) {
            if (oi.canShootAgain() && oi.adminPad.getRawButton(7) && oi.guestPad.getRawButton(8)){
                //if it hasn't already shot 1 t-shirt then we let him shoot
                cannon.fire(); //FIRE the missile
            }
        } else if (oi.guestPad.getMode() == -1) {
            if (oi.canShootAgain() && oi.adminPad.getRawButton(8)) {
                //if it hasn't already shot 1 t-shirt then we let him shoot
                cannon.fire(); //FIRE the missile
            }
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
