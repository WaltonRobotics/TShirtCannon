/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author 1009484
 */
public class SpinnySafteyLight extends Subsystem {

    //public static Relay light = new Relay(RobotMap.safteyLightRelay); //makes the saftey light, this is assuming that it is using a relay
    protected void initDefaultCommand() {
    }

    public void spinLight() { //spin the light
        //light.set(Relay.Value.kForward); //send power in the 'kForward' direction
    }

    public void stopSpinningLight() { //stop the light
        //light.set(Relay.Value.kOff); //take the power away from the light(- now 'I've got the power!')
    }
}
