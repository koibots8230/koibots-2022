// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.defaultCommands.DriveTrainDefaultCommand;
import frc.robot.commands.defaultCommands.ShooterDefaultCommand;
import frc.robot.commands.defaultCommands.UptakeDefaultCommand;
import frc.robot.subsystems.cargoSubsystem.ShooterSubsystem;
import frc.robot.subsystems.cargoSubsystem.UptakeSubsystem;
import frc.robot.subsystems.driveTrainSubsystem.DriveTrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  private final DriveTrainDefaultCommand driveTrainDefaultCommand = new DriveTrainDefaultCommand(driveTrainSubsystem);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShooterDefaultCommand shooterDefaultCommand = new ShooterDefaultCommand(shooterSubsystem);
  private final UptakeSubsystem uptakeSubsystem = new UptakeSubsystem();
  private final UptakeDefaultCommand uptakeDefaultCommand = new UptakeDefaultCommand(uptakeSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrainSubsystem.setDefaultCommand(driveTrainDefaultCommand);
    shooterSubsystem.setDefaultCommand(shooterDefaultCommand); // This should not be the default command long term. This is only to test.
    uptakeSubsystem.setDefaultCommand(uptakeDefaultCommand); // This should not be the default command long term. This is only to test.
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

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
