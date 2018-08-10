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
public class LeftSide extends PIDSubsystem {
    
    public LeftSide(double p, double i, double d, double period){
        super(p,i,d,period);
        enable();
    }

    protected double returnPIDInput() {
        return DriveTrain.getLeftEncoder();
    }

    protected void usePIDOutput(double d) {
        DriveTrain.setLeftPID(d);
    }

    protected void initDefaultCommand() {
    }

}
