package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.

    public static final int leftMotor = 1;
    public static final int rightMotor = 2;
    public static final int compressorPressureSwitch = 1; //correct number
    public static final int compressorRelay = 1; //correct number
    public static final int reloadSolenoid = 7; //correct for now
    public static final int shootSolenoid = 8; //correct for now
    //public static final int cannonAngleSolenoid = 3; //*******CHANGE THIS WHEN WE KNOW WHICH NUMBER THE SOLENOID IS*********
    //public static final int safteyLightRelay = 10; //*******CHANGE THIS WHEN WE KNOW WHICH NUMBER THE SOLENOID IS*********
    //
    //
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
