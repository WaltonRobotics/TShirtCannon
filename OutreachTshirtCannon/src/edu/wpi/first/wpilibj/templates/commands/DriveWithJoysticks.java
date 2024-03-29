package edu.wpi.first.wpilibj.templates.commands;

/**
 * Allows the connected joysticks to drive the robot.
 *
 * @author Walton Robotics
 */
public class DriveWithJoysticks extends CommandBase {

    public DriveWithJoysticks() {
        requires(drive);
        // System.out.println("DWJcon");
    }

    protected void initialize() {
        // System.out.println("DWJinit");
    }

    /**
     * This is where joystick input meets motor output
     * <p>
     * Assigns the left joystick's input to wheelSpeeds[0] and the right
     * joystick's input to wheelSpeeds[1], which are then used as parameters for
     * drive.
     * </p>
     */
    protected void execute() {
        //instructions from the driver
        //System.out.println("drive execute");
        double[] wheelSpeeds = new double[2];
        if (oi.guestPad.getMode() == -1) {
            wheelSpeeds = getSpeeds();
        } else if (oi.guestPad.getMode() == 1) {
            wheelSpeeds = getSpeeds();
            wheelSpeeds[0] *= .5;
            wheelSpeeds[1] *= .5;
        } else if (oi.guestPad.getMode() == 2) {
            wheelSpeeds = getSpeeds();
            wheelSpeeds[0] *= (2 / 3);
            wheelSpeeds[1] *= (2 / 3);
        } else if (oi.guestPad.getMode() == 3) {
            wheelSpeeds = getSpeeds();
            wheelSpeeds[0] *= .8;
            wheelSpeeds[1] *= .8;
        }
        // System.out.println(wheelSpeeds[0] + "speeds 0" + wheelSpeeds[1] + "speeds 1");
        drive.drive(wheelSpeeds[0], wheelSpeeds[1]);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

    public double[] getSpeeds() {
        double left = 0, right = 0;
        if (oi.guestPad.getMode() == -1) {
            left = oi.getAdminLeftY();
            right = oi.getAdminRightY();
        } else {
            int guestMode = oi.guestPad.getMode();
            if (guestMode == 1 || guestMode == 2 || guestMode == 3) {
                left = oi.getGuestLeftY();
                right = oi.getGuestRightY();
            }
        }

        double[] instructions = new double[2];

        //hold button 4, this is to divide to get reduced speeds of the wheels
//        if (oi.rightStick.getRawButton(4)) {//COULD VERY POSSIBLY BE WRONG
//            left /= 4;
//            right /= 4;
//        }
        instructions[0] = left;
        instructions[1] = right;

        return instructions;
    }
}
