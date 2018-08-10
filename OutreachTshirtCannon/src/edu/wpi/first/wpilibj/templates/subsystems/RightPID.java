/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Michael
 */
public class RightPID extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public RightPID(double p, double i, double d, double period){
        super(p,i,d,period);
        enable();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        return DriveTrain.rightEncoder.get();
    }

    protected void usePIDOutput(double d) {
        DriveTrain.setRightPID(d);
    }
}
