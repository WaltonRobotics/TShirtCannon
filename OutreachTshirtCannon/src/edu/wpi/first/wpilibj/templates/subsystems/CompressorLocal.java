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
 * @author 1009484
 */
public class CompressorLocal extends Subsystem {

    // makes the compressor; parameters are: the pressure swith, the relay
    private static Compressor comp = new Compressor(RobotMap.compressorPressureSwitch, RobotMap.compressorRelay);

    protected void initDefaultCommand() {
    }

    public static void runCompressor() { //it compresses the air so the t-shirt actually comes out of the cannon
        comp.start(); //starts the compressor
    }
}
