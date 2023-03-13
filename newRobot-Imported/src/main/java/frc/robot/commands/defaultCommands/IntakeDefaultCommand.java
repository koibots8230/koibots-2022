package frc.robot.commands.defaultCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.cargoSubsystem.IntakeSubsystem;

public class IntakeDefaultCommand extends CommandBase {
  private final IntakeSubsystem IntakeSubsystem;

  public IntakeDefaultCommand(IntakeSubsystem IntakeSubsystemArgument) {
    IntakeSubsystem = IntakeSubsystemArgument;
    addRequirements(IntakeSubsystemArgument);
    IntakeSubsystem.updateMotor(1);
  }
}
