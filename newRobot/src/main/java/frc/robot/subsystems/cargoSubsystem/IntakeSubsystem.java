package frc.robot.subsystems.cargoSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final CANSparkMax spinyMotor = new CANSparkMax(8, MotorType.kBrushless);

    public IntakeSubsystem(){}
    
    @Override
    public void periodic(){}

    public void updateMotor(double percentValue){
        spinyMotor.set(percentValue);
    }
}
