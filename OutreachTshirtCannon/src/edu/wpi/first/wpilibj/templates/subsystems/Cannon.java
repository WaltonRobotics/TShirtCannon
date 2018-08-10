/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.FireShot;

/**
 *
 * @author 1009484
 */
public class Cannon extends Subsystem {

    private static Solenoid fireCannon = new Solenoid(RobotMap.shootSolenoid); //makes the solenoid
    private static Solenoid accumulator = new Solenoid(RobotMap.reloadSolenoid); //makes the solenoid
//    private static boolean filling = false;

    protected void initDefaultCommand() {
        setDefaultCommand(new FireShot());
        accumulator.set(true);
        fireCannon.set(false);
    }

    public static void fire() { //method for when you want to shoot
        System.out.println("cannon");
        closeAccumulator();
        fireCannon.set(true); //theoretically opens the solenoid from the accumulator to the cannon
        Timer.delay(OI.getFiringSeconds()); //gets the seconds from the user(driver station) on how long to hold the fire valve open
        fireCannon.set(false); //theoretically opens the solenoid from the accumulator to the cannon
        openAccumulator();
        Timer.delay(OI.getAccumulatorChargingSeconds()); //gets the seconds from the user(driver station) on how long to hold the charge valve open
        closeAccumulator();
        //
//        if (!filling) { //the cannon must be filled with air pressure before we can shoot
//            accumulator.set(false); //closes the valve to accumulator to make sure that we don't let air escape from the big tank
//            fireCannon.set(true); //solenoid is set to 'true' - this might or might not be right, testing will determine it
//            Timer.delay(.5); //delays 1 second to let all the air out
//            fireCannon.set(false); //closes the solenoid
//        }

    }

    public static void closeAccumulator() {
        accumulator.set(false); //theoretically closes the solenoid from the tank to the accumulator
    }

    public static void openAccumulator() {
        accumulator.set(true); //theoretically opens the solenoid from the tank to the accumulator
    }
//    public static void FillTheAccumulator() { //fills the accumulator with compressed air from the main tank
//        accumulator.set(true);
//        filling = true;
//        Timer.delay(1);
//        accumulator.set(false);
//        filling = false;
//    }
//
//    public static boolean AccumultorIsFilled() {
//        return filling;
//    }
//
//    public static void EMERGENCY_CLOSE_ALL_SOLENOIDS() {
//        fireCannon.set(false);//solenoid is set to 'false' - this might or might not be right, testing will determine it
//        accumulator.set(false);//solenoid is set to 'false' - this might or might not be right, testing will determine it
//    }
//
//    public static void EMERGENCY_OPEN_ALL_SOLENOIDS() {
//        fireCannon.set(true);//solenoid is set to 'true' - this might or might not be right, testing will determine it
//        accumulator.set(true);//solenoid is set to 'true' - this might or might not be right, testing will determine it
//    }
}
