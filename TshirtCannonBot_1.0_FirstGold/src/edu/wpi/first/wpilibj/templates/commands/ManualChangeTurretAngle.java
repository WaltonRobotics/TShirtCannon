/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author 1009484
 */
public class ManualChangeTurretAngle extends CommandBase {

    private static int turretUpDown;

    public ManualChangeTurretAngle(int a) {
        turretUpDown = a;
    }

    protected void initialize() {
        //requires(cannonAngle);
    }

    protected void execute() {
//        if (turretUpDown > 0) {
//            cannonAngle.angleUp();
//        } else if (turretUpDown < 0) {
//            cannonAngle.angleDown();
//        } else if (turretUpDown == 0) {
//            cannonAngle.stop();
//        } else {
//            System.out.println("ERROR!! ERROR!!");
//        }
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
