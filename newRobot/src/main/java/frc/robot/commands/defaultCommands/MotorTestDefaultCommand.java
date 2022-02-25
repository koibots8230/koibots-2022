package frc.robot.commands.defaultCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.MotorTestSubsystem;

public class MotorTestDefaultCommand extends CommandBase{
    private final MotorTestSubsystem motorTestSubsystem;

    public MotorTestDefaultCommand(MotorTestSubsystem motorTestSubsystemArgument) {
        motorTestSubsystem = motorTestSubsystemArgument;
        addRequirements(motorTestSubsystem);
        motorTestSubsystem.updateMotor(Constants.TEST_MOTOR_POWER);
      }
}
