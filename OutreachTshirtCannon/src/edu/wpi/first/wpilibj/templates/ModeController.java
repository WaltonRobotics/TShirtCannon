/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 * A standard Joystick controller with different mode options.
 * Typically the following will be true.
 * -1 means that the controller is disabled
 * 0 means that it's an admin using the controller
 * 1 means that a child is using the controller
 * 2 means that an adult is using the controller
 * 3 means that a sponsor representative is using the controller
 * @author Walton Robotics
 */
public class ModeController extends Joystick{
    private int mode = 0;
    
    public ModeController(int port){
        super(port);
    }
    
    public ModeController(int port, int mode){
        super(port);
        mode = this.mode;
    }
    
    public void setMode(int in){
        mode = in;
    }
    
    public int getMode(){
        return mode;
    }
}
