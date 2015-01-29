package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.FireShot;
import edu.wpi.first.wpilibj.templates.commands.HoldSafety;
import edu.wpi.first.wpilibj.templates.commands.SafetyLockOn;

public class OI {

    public Joystick leftStick = new Joystick(1);
    //unable to use tiggers with kickerbot since triggers are overdrive
    Button leftButton2 = new JoystickButton(leftStick, 2);
    Button leftButton3 = new JoystickButton(leftStick, 3);
    Button leftButton4 = new JoystickButton(leftStick, 4);
    Button leftButton5 = new JoystickButton(leftStick, 5);
    Button leftButton6 = new JoystickButton(leftStick, 6);
    Button leftButton7 = new JoystickButton(leftStick, 7);
    Button leftButton10 = new JoystickButton(leftStick, 10);
    Button leftButton11 = new JoystickButton(leftStick, 11);
    Button leftButton12 = new JoystickButton(leftStick, 12);
    public Joystick rightStick = new Joystick(2);
    //unable to use tiggers with kickerbot since triggers are overdrive
    Button rightButton2 = new JoystickButton(rightStick, 2);
    Button rightButton3 = new JoystickButton(rightStick, 3);
    Button rightButton4 = new JoystickButton(rightStick, 4);
    Button rightButton5 = new JoystickButton(rightStick, 5);
    Button rightButton6 = new JoystickButton(rightStick, 6);
    Button rightButton7 = new JoystickButton(rightStick, 7);
    Button rightButton8 = new JoystickButton(rightStick, 8);
    Button rightButton10 = new JoystickButton(rightStick, 10);
    Button rightButton11 = new JoystickButton(rightStick, 11);
    Button rightButton12 = new JoystickButton(rightStick, 12);
    static DriverStation ds = DriverStation.getInstance();
    public static boolean clearToShoot = false; //false means that you can't shoot
    public static int shots = 0, runThroughs = 0;

    public OI() {
        System.out.println("oi");
        leftButton3.whileHeld(new HoldSafety(1)); //sets this button held's command to 'HoldSafety' with a 1 second safety delay
        leftButton3.whenReleased(new SafetyLockOn()); //sets this button released to 'SafetyLightOn' to turn on the saftey thus making the robot unable to shoot

        rightButton3.whenPressed(new FireShot()); //sets this button to 'FireShot' - this wont shoot unless the saftey sequences approve of the shot

//        rightButton3.whenPressed(new ManualChangeTurretAngle(1)); //make turret angle up
//        rightButton3.whenReleased(new ManualChangeTurretAngle(0)); //make turret stop changing
//        rightButton2.whenPressed(new ManualChangeTurretAngle(-1)); //make turret angle down
//        rightButton2.whenReleased(new ManualChangeTurretAngle(0)); //make turret stop changing
    }

    public double getLeftY() {
        return -leftStick.getY();
    }

    public double getRightY() {
        return -rightStick.getY();
    }

    public double getLeftX() {
        return leftStick.getX();
    }

    public double getRightX() {
        return rightStick.getX();
    }

    public void setSafetyClear(boolean a) { //sets the safety on or off, false = you can't shoot and true = you can shoot
        clearToShoot = a; //sets the actual variable to true or false
    }

    public boolean getSafety() { //gets the safety to decide if you can shoot, false = you can't shoot and true = you can shoot
        return clearToShoot; //returns boolean if it safe or not to shoot
    }

    public boolean canShootAgain() { //sees if you can shoot again
        return shots == 0; //if you have shot once then you can shoot, but if you have already shot once then you cant shoot again
    }

    public void zeroShotCount() { //zeros shot count
        shots = 0; //set shots to 0
    }

    public double getRuns() { //returns the runs(either 0 or 1) that you have held the safety button(this is so you dont use the timer every time
        return runThroughs; //returns the runs
    }

    public void setRuns(int runs) { //sets runs
        runThroughs = runs; //runThroughs is set to the number in runs
    }

    public static double getFiringSeconds() {
        return ds.getAnalogIn(1);
    }

    public static double getAccumulatorChargingSeconds() {
        return ds.getAnalogIn(2);
    }
}
