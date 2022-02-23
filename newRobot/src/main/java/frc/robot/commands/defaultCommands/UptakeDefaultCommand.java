package frc.robot.commands.defaultCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.cargoSubsystem.UptakeSubsystem;

public class UptakeDefaultCommand extends CommandBase{
    private final UptakeSubsystem uptakeSubsystem;

    public UptakeDefaultCommand(UptakeSubsystem uptakeSubsystemArgument) {
        uptakeSubsystem = uptakeSubsystemArgument;
        addRequirements(uptakeSubsystemArgument);
        uptakeSubsystem.updateMotor(1);
      }
    
}
