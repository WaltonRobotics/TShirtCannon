/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author 1009484
 */
public class CannonAngle extends Subsystem {

    //public static Solenoid cannonUp = new Solenoid(RobotMap.cannonAngleSolenoid,4); //makes the up part of the solenoid
    //public static Solenoid cannonDown = new Solenoid(RobotMap.cannonAngleSolenoid,5); //makes the up part of the solenoid
    protected void initDefaultCommand() {
    }

    public void angleDown() { //method for when you want to angle up
        //cannonDown.set(true); //solenoid is set to 'true' - this might or might not be right, testing will determine it
    }

    public void angleUp() { //method for when you want to angle up
        //cannonUp.set(true); //solenoid is set to 'true' - this might or might not be right, testing will determine it
    }

    public void stop() {
        //cannonDown.set(false); //stops changing the angle
        //cannonUp.set(false);
    }

    public static void blah() {
        //cannonAngle.
    }
}
