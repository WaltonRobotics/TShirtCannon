package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;

public class DriveTrain extends Subsystem {

    /**
     * The physical Talons of the robot.
     */
    public static Talon rightD1,rightD2,leftD1,leftD2;
    public static Encoder leftEncoder, rightEncoder;
    PIDController left1PID, right1PID;
    
    
    /**
     * previous value of speed for left and right used to limit the speed change
     * of the wheels. which reduces the number of chain slips/failures
     */
    double prevLeft,

    /**
     * previous value of speed for leftEncoder and right used to limit the speed change
 of the wheels.which reduces the number of chain slips/failures
     */

    /**
     * previous value of speed for left and rightEncoder used to limit the speed change
 of the wheels.which reduces the number of chain slips/failures
     */
    prevRight;
    /**
     * Controls the Overdrive for the left and right side of the robot.
     * Overdrive multiplies the speed of the robot by 4 on that side
     */
    public boolean Overdrive_L,

    /**
     * Controls the Overdrive for the leftEncoder and right side of the robot.Overdrive multiplies the speed of the robot by 4 on that side
     */

    /**
     * Controls the Overdrive for the left and rightEncoder side of the robot.Overdrive multiplies the speed of the robot by 4 on that side
     */
    Overdrive_R;

    /**
     * Assigns the talons and their respective channels
     * <p>
     * This constructor does the following: 
     * (1) Talons are assigned their values from robot map
     * (2) leftEncoder and rightEncoder are fed magic numbers
     * (3) The overdrive buttons (joystick triggers) are set to false
     * (4) Starts the encoders
     * </p>
     */
    public DriveTrain() {
        //System.out.println("drive con. 1");
        leftD1 = new Talon(RobotMap.LD1);
        leftD2 = new Talon(RobotMap.LD2);
        rightD1 = new Talon(RobotMap.RD1);
        rightD2 = new Talon(RobotMap.RD2);
        leftEncoder = new Encoder(1,2);
        rightEncoder = new Encoder(3,4);
        Overdrive_L = false;
        Overdrive_R = false;
        prevLeft = 0;
        prevRight = 0;
        leftEncoder.start();
        rightEncoder.start();
        //System.out.println("drive con. 2");
    }
    
    /**
     * Sets the default command to DriveWithJoysticks
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }

    /**
     * This method is used to manual change the values of the left and right
 speed controllers on the robots drivetrain
     *
     * @param leftSpeed the left speed of the robot from -1.0 to 1.0
     * @param rightSpeed the right speed of the robot from -1.0 to 1.0
     */
    public void drive(double leftSpeed, double rightSpeed) {
        /*
         * if the change in speed of the right motor of the robot is greater
         * than a certain tolerance, it limits the speed to the maximum
         * tolerance.
         */
        if (Math.abs(prevRight - rightSpeed) > 0.2) {
            if (prevRight > rightSpeed) //limit the speed on deceleration
            {
                rightSpeed = prevRight - 0.2;
            } else //limit the speed on acceleration
            {
                rightSpeed = prevRight + 0.2;
            }
        }

        if (Math.abs(prevLeft - leftSpeed) > 0.2) {
            if (prevLeft > leftSpeed) {
                leftSpeed = prevLeft - 0.2;//limit the speed on deceleration
            } else {
                leftSpeed = prevLeft + 0.2;//limit the speed on acceleration
            }
        }

        //sets the speeds of the motors to there final values limit() makes
        // sure the values are not greater than 1.0 and -1.0
        leftD1.set(-1 * limit(leftSpeed));
        leftD2.set(-1 * limit(leftSpeed));
        rightD1.set(limit(rightSpeed));
        rightD2.set(limit(leftSpeed));

        //saves the rightEncoder and leftEncoder speeds, so they can be compared on the next change of speed
        prevRight = rightSpeed;
        prevLeft = leftSpeed;

    }

    
    /**
     * finalDrive is used to set the motor speeds without acceleration limiting
     */
    public void finalDrive(double leftSpeed, double rightSpeed) {
        leftD1.set(-1 * limit(leftSpeed));
        leftD2.set(-1 * limit(leftSpeed));
        rightD1.set(limit(rightSpeed));
        rightD2.set(limit(rightSpeed));
    }

    /**
     * bounds the number between -1.0 and 1.0
     *
     * @param num to be limiteds
     * @return number is greater than 1 returns 1.0 if lower than -1 returns
     * -1.0
     */
    private double limit(double num) {
        if (num > 1.0) {
            return 1.0;
        }
        if (num < -1.0) {
            return -1.0;
        }
        return num;
    }
    static public double getLeftEncoder(){
        return leftEncoder.get();
    }
    static public double getRightEncoder(){
        return rightEncoder.get();
    }
    public static void setRightPID(double in){
        leftD1.set(in);
        leftD2.set(in);
    }
    public static void setLeftPID(double in){
        rightD1.set(in);
        rightD2.set(in);
    }
}