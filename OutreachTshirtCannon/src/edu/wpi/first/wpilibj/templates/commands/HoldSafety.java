/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.Cannon;

/**
 * 
 * @author Walton Robotics
 */
public class HoldSafety extends CommandBase {

    private static int secondsHeld = 0;
    private Timer c;
    
    /**
     * Assigns secs to a private variable and sets a timer
     * @param secs the number of seconds to hold the safety button
     */
    public HoldSafety(int secs) {
        secondsHeld = secs; 
        //requires(safetyLight);
        c = new Timer();
    }

    protected void initialize() {
    }
    
    /**
     * Does two primary things.
     * 1. When this is first called, it resets and starts the timer
     *  a. Waits until the timer reaches secondsHeld, as specified in the 
     *     constructor
     *  b. If the left joystick's button 3 is released during this time,
     */
    protected void execute() {
        Cannon.closeAccumulator();
        /*
        Why is this if block here? What's the point of it? If we only use the
        timer once, and it becomes negated if you let go of the button 3, what
        is its use? Can someone explain this to me?
        */
        if (oi.getCycles() == 0) { //check for first run through so you dont use the timer after the 1st time
            c.reset(); //sets time to 0 so we start from a constant
            c.start(); //starts the timer
            while (c.get() < secondsHeld) { //waits for the timer to get to the 'secondsHeld' value
                //safetyLight.spinLight(); //obvious enough but it spins the light while the button is held and timer is going
                if (!oi.leftStick.getRawButton(3)) { //tests for the user releasing the button in the middle of the timer
                    break; //breaks out of while if the user releases the button
                }
            }
            oi.setCycles(1); //total runs set to 1 so it wont keep waiting on the timer
            c.stop(); //stops the timer
        }
        // safetyLight.spinLight(); //obvious enough - it spins the light
        if (oi.leftStick.getRawButton(3)) { //if the button is still held then you are safe to shoot
            oi.setSafetyClear(true); //sets saftey true so the rest of the program knows it can shoot
        } else {
            oi.setSafetyClear(false); //sets saftey false so the rest of the program knows it CANNOT shoot
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
