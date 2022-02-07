package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTrainDefaultCommand extends CommandBase {

  private final DriveTrainSubsystem driveTrainSubsystem;

  public DriveTrainDefaultCommand(DriveTrainSubsystem driveTrainSubsystemArgument) {
    driveTrainSubsystem = driveTrainSubsystemArgument;
    driveTrainSubsystem.updateMotors();
  }
  
}