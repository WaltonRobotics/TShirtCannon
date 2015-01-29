/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author 1009484
 */
public class FireShot extends CommandBase {
    
    public FireShot() {
        requires(cannon); //obvious enough, it needs to use the cannon
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
        if (oi.canShootAgain() && oi.leftStick.getRawButton(3) && oi.rightStick.getRawButton(3)) { //if it hasn't already shot 1 t-shirt then we let him shoot
            cannon.fire(); //FIRE the missile
        }
        
    }
    
    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
