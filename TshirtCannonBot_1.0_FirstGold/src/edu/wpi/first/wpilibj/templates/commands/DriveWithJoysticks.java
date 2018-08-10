package edu.wpi.first.wpilibj.templates.commands;

public class DriveWithJoysticks extends CommandBase {

    public DriveWithJoysticks() {
        requires(drive);
        // System.out.println("DWJcon");
    }

    protected void initialize() {
        // System.out.println("DWJinit");
    }

    protected void execute() {
        //instructions from the driver
        //System.out.println("drive execute");
        double[] wheelSpeeds = getSpeeds();
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

        double left = oi.getLeftY();
        double right = oi.getRightY();

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
