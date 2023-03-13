package frc.robot.subsystems.cargoSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class UptakeSubsystem extends SubsystemBase{
    private final CANSparkMax lowerUptakeMotor = new CANSparkMax(7, MotorType.kBrushless);
    private final CANSparkMax upperUptakeMotor = new CANSparkMax(6, MotorType.kBrushless);

    public UptakeSubsystem(){}

    @Override
    public void periodic() {}

    public void updateMotor(double percentValue){
        lowerUptakeMotor.set(percentValue);
        upperUptakeMotor.set(percentValue); //uncomment this to make it work
    }
}
