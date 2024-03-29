package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Cannon;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain drive = new DriveTrain();
    public static Cannon cannon = new Cannon();
    //public static SpinnySafteyLight safetyLight = new SpinnySafteyLight();
    //public static CannonAngle cannonAngle = new CannonAngle();
    
    /**
    * This MUST be *here. If the OI creates Commands (which it very likely
    * will), constructing it during the construction of CommandBase (from
    * which commands extend), subsystems are not guaranteed to be
    * yet. Thus, their requires() statements may grab null pointers. Bad
    * news. Don't move it.
    */
    public static void init() {
        oi = new OI();
        
        System.out.println("command base init");
        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(drive);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
