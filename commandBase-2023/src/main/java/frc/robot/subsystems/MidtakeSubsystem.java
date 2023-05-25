package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MidtakeSubsystem extends SubsystemBase {
    private static MidtakeSubsystem midtakeSubsystem = new MidtakeSubsystem();

    private CANSparkMax midtakeMotor;

    public MidtakeSubsystem() {
        midtakeMotor = new CANSparkMax(Constants.MIDTAKE_MOTOR_PORT, MotorType.kBrushless);
        midtakeMotor.setInverted(true);
    }

    public static MidtakeSubsystem get() {
        return midtakeSubsystem;
    }

    public void set(double speed) {
        midtakeMotor.set(speed);
    }
}
