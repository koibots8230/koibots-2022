package frc.robot.subsystems.driveTrainSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  private final XboxController xBoxController = new XboxController(0);
  private final RightTrainSubsystem rightTrainSubsystem = new RightTrainSubsystem();
  private final LeftTrainSubsystem leftTrainSubsystem = new  LeftTrainSubsystem();
  private final VictorSPX frontRightMotor = new VictorSPX(12);
  private final VictorSPX backRightMotor = new VictorSPX(13);
  private final VictorSPX frontLeftMotor = new VictorSPX(14);
  private final VictorSPX backLeftMotor = new VictorSPX(15);

  public DriveTrainSubsystem() {
    backRightMotor.follow(frontRightMotor);
    backRightMotor.setInverted(false);
    backLeftMotor.follow(frontLeftMotor);
    backLeftMotor.setInverted(false);
  }

  @Override
  public void periodic() {}

  public void updateMotors() {
    rightTrainSubsystem.updateMotors(1); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kRightY.value)
    leftTrainSubsystem.updateMotors(1); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kLeftY.value)
  }
}
