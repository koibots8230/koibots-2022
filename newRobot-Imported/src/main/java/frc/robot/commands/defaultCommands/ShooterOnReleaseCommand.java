package frc.robot.commands.defaultCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.cargoSubsystem.ShooterSubsystem;

public class ShooterOnReleaseCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;

  public ShooterOnReleaseCommand(ShooterSubsystem shooterSubsystemArgument) {
    shooterSubsystem = shooterSubsystemArgument;
    addRequirements(shooterSubsystemArgument);
    shooterSubsystem.updateMotor(0);
  }
}
