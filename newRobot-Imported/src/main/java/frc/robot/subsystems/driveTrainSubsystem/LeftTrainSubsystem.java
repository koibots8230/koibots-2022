package frc.robot.subsystems.driveTrainSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LeftTrainSubsystem extends SubsystemBase{
    private CANSparkMax frontMotor = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax backMotor = new CANSparkMax(1, MotorType.kBrushless);

    public LeftTrainSubsystem(){}

    @Override
    public void periodic() {}

    public void updateMotors(double percentValue){
        frontMotor.set(percentValue);
        backMotor.set(percentValue);
    }
}
