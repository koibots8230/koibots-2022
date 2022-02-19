package frc.robot.subsystems.cargoSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private final CANSparkMax shooterMotor = new CANSparkMax(5, MotorType.kBrushless);

    public ShooterSubsystem(){}

    @Override
    public void periodic() {}

    public void updateMotor(double percentValue){
        shooterMotor.set(percentValue); //uncomment this to make it work
    }
}
