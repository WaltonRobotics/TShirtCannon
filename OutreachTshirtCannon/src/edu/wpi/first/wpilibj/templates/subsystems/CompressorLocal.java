/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * 
 * @author Walton Robotics
 */
public class CompressorLocal extends Subsystem {

    // makes the compressor; parameters are: the pressure swith, the relay
    private static Compressor comp = new Compressor
        (RobotMap.compressorPressureSwitch, RobotMap.compressorRelay);

    protected void initDefaultCommand() {
    }
    
    /**
     * Compresses air so that the loaded T-Shirt actually fires from the cannon
     */
    public static void runCompressor() { 
        comp.start(); //starts the compressor
    }
}
