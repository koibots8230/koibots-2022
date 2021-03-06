package frc.robot.commands.defaultCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.cargoSubsystem.ShooterSubsystem;

public class ShooterOnPressCommand extends CommandBase{
    private final ShooterSubsystem shooterSubsystem;

    public ShooterOnPressCommand(ShooterSubsystem shooterSubsystemArgument) {
      shooterSubsystem = shooterSubsystemArgument;
      addRequirements(shooterSubsystemArgument);
      shooterSubsystem.updateMotor(1);
    }
}
