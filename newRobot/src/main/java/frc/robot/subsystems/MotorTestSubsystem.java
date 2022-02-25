package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorTestSubsystem extends SubsystemBase{
    private final CANSparkMax testMotor = new CANSparkMax(Constants.TEST_MOTOR_PORT_NUMBER, Constants.TEST_MOTOR_TYPE);
    
    public MotorTestSubsystem(){
        testMotor.setInverted(Constants.TEST_MOTOR_INVERTED);
    }

    @Override
    public void periodic() {}

    public void updateMotor(double percentValue){
        testMotor.set(percentValue);
    }
}
