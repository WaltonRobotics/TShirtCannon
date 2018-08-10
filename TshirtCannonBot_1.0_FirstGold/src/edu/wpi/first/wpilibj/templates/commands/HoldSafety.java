/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.Cannon;

/**
 *
 * @author 1009484
 */
public class HoldSafety extends CommandBase {

    private static int secondsHeld = 0;
    private Timer c;

    public HoldSafety(int secs) {
        secondsHeld = secs; //seconds you are required to hold the safety down for
        //requires(safetyLight); //requires the spinny light thingy so we can use it
        c = new Timer(); //makes a new timer
    }

    protected void initialize() {
    }

    protected void execute() {
        Cannon.closeAccumulator();
        if (oi.getRuns() == 0) { //check for first run through so you dont use the timer after the 1st time
            c.reset(); //sets time to 0 so we start from a constant
            c.start(); //starts the timer
            while (c.get() < secondsHeld) { //waits for the timer to get to the 'secondsHeld' value
                //safetyLight.spinLight(); //obvious enough but it spins the light while the button is held and timer is going
                if (!oi.leftStick.getRawButton(3)) { //tests for the user releasing the button in the middle of the timer
                    break; //breaks out of while if the user releases the button
                }
            }
            oi.setRuns(1); //total runs set to 1 so it wont keep waiting on the timer
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
