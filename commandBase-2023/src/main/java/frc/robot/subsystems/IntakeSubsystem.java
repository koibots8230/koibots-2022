package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private CANSparkMax intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_PORT, MotorType.kBrushless);
        intakeMotor.setInverted(true);
    }

    public static IntakeSubsystem get() {
        return intakeSubsystem;
    }

    public void set(double speed) {
        intakeMotor.set(speed);
    }
}
