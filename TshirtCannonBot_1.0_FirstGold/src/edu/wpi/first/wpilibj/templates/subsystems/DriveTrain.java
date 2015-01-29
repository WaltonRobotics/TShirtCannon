package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;

public class DriveTrain extends Subsystem {

    /**
     * The physical Jag's of the robot.
     */
    Jaguar motorController1, motorController2;
    /**
     * SpeedControler is the superclass of the Jaguar, and Victor motor
     * controllers This allows the DriveTrain object to be used with any type of
     * speedControler
     */
    private SpeedController SpeedController_1, SpeedController_2;
    /**
     * previous value of speed for left and right used to limit the speed change
     * of the wheels. which reduces the number of chain slips/failures
     */
    double prevLeft, prevRight;
    /**
     * Controls the Overdrive for the left and right side of the robot.
     * Overdrive multiplies the speed of the robot by 4 on that side
     */
    public boolean Overdrive_L, Overdrive_R;

    /**
     * autoMode determines if the driver has control of the robot.
     */
    public DriveTrain() {
        //System.out.println("drive con. 1");
        motorController1 = new Jaguar(RobotMap.leftMotor);
        motorController2 = new Jaguar(RobotMap.rightMotor);
        SpeedController_1 = motorController1;
        SpeedController_2 = motorController2;
        Overdrive_L = false;
        Overdrive_R = false;
        prevLeft = 0;
        prevRight = 0;
        //System.out.println("drive con. 2");
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }

    /**
     * This method is used to manual change the values of the left and right
     * speed controllers on the robots drivetrain
     *
     * @param leftSpeed the left speed of the robot from -1.0 to 1.0
     * @param rightSpeed the right speed of the robot from -1.0 to 1.0
     */
    public void drive(double leftSpeed, double rightSpeed) {
        //System.out.println("drive");
        //if any of the speed Controlers dont exist throw an exception
        if (SpeedController_1 == null || SpeedController_2 == null) {
            throw new NullPointerException("Null motor provided");
        }

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
        SpeedController_1.set(-1 * limit(leftSpeed));
        SpeedController_2.set(limit(rightSpeed));

        //saves the right and left speeds, so they can be compared on the next change of speed
        prevRight = rightSpeed;
        prevLeft = leftSpeed;

    }

    /**
     * finalDrive is used to set the motor speeds without acceleration limiting
     */
    public void finalDrive(double leftSpeed, double rightSpeed) {
        SpeedController_1.set(-1 * limit(leftSpeed));
        SpeedController_2.set(limit(rightSpeed));
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
}