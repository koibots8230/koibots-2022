package frc.robot.subsystems.driveTrainSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  private final XboxController xBoxController = new XboxController(0);
  private final RightTrainSubsystem rightTrainSubsystem = new RightTrainSubsystem();
  private final LeftTrainSubsystem leftTrainSubsystem = new  LeftTrainSubsystem();

  public DriveTrainSubsystem() {}

  @Override
  public void periodic() {}

  public void updateMotors() {
    rightTrainSubsystem.updateMotors(.1); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kRightY.value)
    leftTrainSubsystem.updateMotors(.1); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kLeftY.value)
  }
}
