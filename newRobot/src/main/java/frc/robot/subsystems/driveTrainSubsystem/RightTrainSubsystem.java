package frc.robot.subsystems.driveTrainSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RightTrainSubsystem extends SubsystemBase{
    private final CANSparkMax frontMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax backMotor = new CANSparkMax(0, MotorType.kBrushless);

    public RightTrainSubsystem(){
        backMotor.follow(frontMotor);
        backMotor.setInverted(false);
    }

    @Override
    public void periodic() {}

    public void updateMotors(double percentValue){
        frontMotor.set(percentValue);
    }
}
