package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  private final XboxController xBoxController = new XboxController(0);
  private final VictorSPX frontRightMotor = new VictorSPX(0);
  private final VictorSPX backRightMotor = new VictorSPX(0);
  private final VictorSPX frontLeftMotor = new VictorSPX(0);
  private final VictorSPX backLeftMotor = new VictorSPX(0);

  /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {
    backRightMotor.follow(frontRightMotor);
    backRightMotor.setInverted(false);
    backLeftMotor.follow(frontLeftMotor);
    backLeftMotor.setInverted(false);
  }

  @Override
  public void periodic() {
    
  }

  public void updateMotors() {
    frontLeftMotor.set(ControlMode.PercentOutput, xBoxController.getRawAxis(XboxController.Axis.kLeftY.value));
    frontRightMotor.set(ControlMode.PercentOutput, xBoxController.getRawAxis(XboxController.Axis.kRightY.value));
  }
}
