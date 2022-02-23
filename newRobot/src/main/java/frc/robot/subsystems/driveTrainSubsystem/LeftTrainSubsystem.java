package frc.robot.subsystems.driveTrainSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LeftTrainSubsystem extends SubsystemBase{
    private final CANSparkMax frontMotor = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax backMotor = new CANSparkMax(1, MotorType.kBrushless);

    public LeftTrainSubsystem(){    
        //backMotor.follow(frontMotor);
    }

    @Override
    public void periodic() {}

    public void updateMotors(double percentValue){
        //frontMotor.set(percentValue);
        backMotor.set(percentValue);
    }
}
