package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.cargoSubsystem.ShooterSubsystem;

public class ShooterDefaultCommand extends CommandBase{
    private final ShooterSubsystem shooterSubsystem;

    public ShooterDefaultCommand(ShooterSubsystem shooterSubsystemArgument) {
        shooterSubsystem = shooterSubsystemArgument;
        addRequirements(shooterSubsystemArgument);
        shooterSubsystem.updateMotor(1);
      }
    
}
