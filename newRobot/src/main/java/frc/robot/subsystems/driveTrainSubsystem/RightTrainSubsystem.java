package frc.robot.subsystems.driveTrainSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RightTrainSubsystem extends SubsystemBase{
    private final VictorSPX frontMotor = new VictorSPX(12);
    private final VictorSPX backMotor = new VictorSPX(13);

    public RightTrainSubsystem(){
        backMotor.follow(frontMotor);
        backMotor.setInverted(false);
    }

    @Override
    public void periodic() {}

    public void updateMotors(double percentValue){
        frontMotor.set(ControlMode.PercentOutput, percentValue);
    }
}
