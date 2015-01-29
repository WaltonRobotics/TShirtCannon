/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Cannon;

/**
 *
 * @author 1009484
 */
public class SafetyLockOn extends CommandBase {

    protected void initialize() {
        //requires(safetyLight); //we need the spinny light for this command
    }

    protected void execute() {
        oi.setSafetyClear(false); //robot is deemed unsafe - it is now unable to shoot
        oi.zeroShotCount(); //shot count set to 0, this is so you have to turn off and on the saftey before you can shoot again
        oi.setRuns(0); //sets runs to 0, so you don't use the timer every time you go through the HoldSafety command
        //safetyLight.stopSpinningLight(); //obvious enough - stop spinning the safety light since it is no longer shooting
        Cannon.openAccumulator();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
