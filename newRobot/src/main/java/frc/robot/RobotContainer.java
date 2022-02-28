// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.defaultCommands.DriveTrainDefaultCommand;
import frc.robot.commands.defaultCommands.ShooterOnPressCommand;
import frc.robot.commands.defaultCommands.ShooterOnReleaseCommand;
import frc.robot.subsystems.cargoSubsystem.ShooterSubsystem;
import frc.robot.subsystems.driveTrainSubsystem.DriveTrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Controller Stuff
  private final XboxController xboxController = new XboxController(0);
  //private final JoystickButton aButton = new JoystickButton(xboxController, XboxController.Button.kA.value);
  //SubSystems
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  //Button Commands
  private final ShooterOnPressCommand shooterOnPressCommand = new ShooterOnPressCommand(shooterSubsystem);
  private final ShooterOnReleaseCommand shooterOnReleaseCommand = new ShooterOnReleaseCommand(shooterSubsystem);
  //Default Commands
  private final DriveTrainDefaultCommand driveTrainDefaultCommand = new DriveTrainDefaultCommand(driveTrainSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Default Command Binding
    driveTrainSubsystem.setDefaultCommand(driveTrainDefaultCommand);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Trigger Command Binding
    new JoystickButton(xboxController, XboxController.Button.kA.value)
      .whenPressed(new ShooterOnPressCommand(shooterSubsystem))
      .whenReleased(new ShooterOnReleaseCommand(shooterSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}
