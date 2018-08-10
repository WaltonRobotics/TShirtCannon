package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.FireShot;
import edu.wpi.first.wpilibj.templates.commands.HoldSafety;
import edu.wpi.first.wpilibj.templates.commands.SafetyLockOn;
import edu.wpi.first.wpilibj.templates.commands.SetController;

/**
 * This is the Output/Input class. All buttons and joysticks. Mark III
 *
 * @author Walton Robotics Team
 */
public class OI {

    public Joystick adminPad = new ModeController(1, 0);
    //Button leftButton2 = new JoystickButton(adminPad, 2);  No occurances
    Button admin1 = new JoystickButton(adminPad, 1); // Sets guest mode to 1
    Button admin2 = new JoystickButton(adminPad, 2); // Sets Guest mode to 2
    Button admin3 = new JoystickButton(adminPad, 3); // Sets guest mode to 3
    Button admin4 = new JoystickButton(adminPad, 4); // Sets guest mode to -1 
    Button admin7 = new JoystickButton(adminPad, 7); // Set to SAFETY
    Button admin8 = new JoystickButton(adminPad, 8); // FIRE!
    Button admin9 = new JoystickButton(adminPad, 9); // Sets firing to Indoor
    Button admin10 = new JoystickButton(adminPad,10); // Sets firing to Outdoor
    //Button leftButton7 = new JoystickButton(adminPad, 7);  No occurances
    //Button leftButton10 = new JoystickButton(adminPad, 10); No occurances
    //Button leftButton11 = new JoystickButton(adminPad, 11); No occurances
    //Button leftButton12 = new JoystickButton(adminPad, 12); No occurances
    //Button rightButton2 = new JoystickButton(adminRightStick, 2); No occurances
    //Button rightButton5 = new JoystickButton(adminRightStick, 5); No occurances
    //Button rightButton6 = new JoystickButton(adminRightStick, 6); No occurances
    //Button rightButton7 = new JoystickButton(adminRightStick, 7); No occurances
    //Button rightButton8 = new JoystickButton(adminRightStick, 8); No occurances
    //Button rightButton10 = new JoystickButton(adminRightStick, 10); No occurances
    //Button rightButton11 = new JoystickButton(adminRightStick, 11); No occurances
    //Button rightButton12 = new JoystickButton(adminRightStick, 12); No occurances
    public ModeController guestPad = new ModeController(2);
    Button guest8 = new JoystickButton(guestPad, 8);

    public static DriverStation ds = DriverStation.getInstance();
    public static boolean clearToShoot = false; //false means safety is enabled
    public static int shots = 0, cycles = 0;

    public OI() {
        System.out.println("oi");
        admin7.whileHeld(new HoldSafety(1)); /*sets this button held's 
         command to 'HoldSafety' with a 1 second safety delay*/

        admin7.whenReleased(new SafetyLockOn()); /*sets this button 
         released to 'SafetyLightOn' to turn on the saftey thus making 
         the robot unable to shoot*/

        admin8.whenPressed(new FireShot()); /*sets this button to 
         'FireShot' - this wont shoot unless the saftey sequences approve 
         of the shot*/

        admin1.whenPressed(new SetController(guestPad, 1));
        admin2.whenPressed(new SetController(guestPad, 2));
        admin3.whenPressed(new SetController(guestPad, 3));
        admin4.whenPressed(new SetController(guestPad, -1));
        //Sets the modes of the guests to the proper setting

//        adminRight3.whenPressed(new ManualChangeTurretAngle(1)); //make turret angle up
//        adminRight3.whenReleased(new ManualChangeTurretAngle(0)); //make turret stop changing
//        rightButton2.whenPressed(new ManualChangeTurretAngle(-1)); //make turret angle down
//        rightButton2.whenReleased(new ManualChangeTurretAngle(0)); //make turret stop changing
    }

    /**
     * Returns the inverted value of Joystick.getY()
     * method. This is due to how T-Shirt cannon's left motors face the rear of
     * the bot
     *
     * @return The negative Y-axis value (-1 to 1) of the admin's left joystick
     */
    public double getAdminLeftY() {
        return -adminPad.getRawAxis(RobotMap.leftYAxis);
    }
    
    /**
     * Returns the inverted value of Joystick.getY()
     * method. This is due to how T-Shirt cannon's left motors face the rear of
     * the bot
     *
     * @return The negative Y-axis value (-1 to 1) of the admin's right joystick
     */
    public double getAdminRightY() {
        return -adminPad.getRawAxis(RobotMap.rightYAxis);
    }
    
    /**
     * Retrieves the administrator's game pad's left joystick's value 
     * @return The admin's game pad's left joystick's value for X (-1 to 1).
     */
    public double getAdminLeftX() {
        return adminPad.getRawAxis(RobotMap.leftXAxis);
    }
    
    /**
     * Retrieves the guest's game pad's left joystick's value 
     * @return The admin's game pad's left joystick's value for X (-1 to 1).
     */
    public double getAdminRightX() {
        return adminPad.getRawAxis(RobotMap.rightXAxis);
    }
    
    /**
     * Returns the inverted value of Joystick.getY()
     * method. This is due to how T-Shirt cannon's left motors face the rear of
     * the bot
     *
     * @return The negative Y-axis value (-1 to 1) of the guest's left joystick
     */
    public double getGuestLeftY() {
        return -guestPad.getRawAxis(RobotMap.leftYAxis);
    }
    
    
    /**
     * Returns the inverted value of Joystick.getY()
     * method. This is due to how T-Shirt cannon's left motors face the rear of
     * the bot
     *
     * @return The negative Y-axis value (-1 to 1) of the guest's left joystick
     */
    public double getGuestRightY() {
        return -guestPad.getRawAxis(RobotMap.rightYAxis);
    }
    
    /**
     * Retrieves the guest's game pad's left joystick's value 
     * @return The guest game pad's left joystick's value for X (-1 to 1).
     */
    public double getGuestLeftX() {
        return guestPad.getRawAxis(RobotMap.leftXAxis);
    }
    
    /**
     * Retrieves the guest's game pad's left joystick's value 
     * @return The guest game pad's left joystick's value for X (-1 to 1).
     */
    public double getGuestRightX() {
        return guestPad.getRawAxis(RobotMap.rightXAxis);
    }

    /**
     * Sets the safety on or off. A false value means you cannot shoot and a
     * true value means the opposite
     *
     * @param state The desired state for the safety
     */
    public void setSafetyClear(boolean state) {
        clearToShoot = state;
    }

    /**
     * Gets the safety to decide if you can shoot
     *
     * @return True if you're clear to shoot, False if otherwise
     */
    public boolean getSafety() {
        return clearToShoot;
    }

    /**
     * Sees if the cannon can shoot again
     *
     * @return True if shots have been zeroed, false if otherwise
     */
    public boolean canShootAgain() {
        return shots == 0;
    }

    /**
     * Sets shots to zero
     */
    public void zeroShotCount() {
        shots = 0;
    }

    /**
     *
     * @return the number of runs (0 or 1) that the safety button has been held
     * This is to prevent using the timer every time
     *
     */
    public double getCycles() { //
        return cycles; //returns the runs
    }

    /**
     * Sets the number of cycles to the desired integer
     *
     * @param runs the number of "runs" that have elapsed
     */
    public void setCycles(int runs) {
        cycles = runs;
    }

    /**
     * Retrieves the value designated for firing seconds, as defined on the
     * driver station
     *
     * @return the value set on the driver station's 1st ANALOG INPUT slot
     */
    public static double getFiringSeconds() {
        return ds.getAnalogIn(1);
    }

    /**
     * Retrieves the number of seconds for the accumulator to charge as defined
     * by the second analog input slot on the driver station.
     *
     * @return The number of seconds that the accumulator needs to charge
     */
    public static double getAccumulatorChargingSeconds() {
        return ds.getAnalogIn(2);
    }

}