package frc.robot.subsystems.driveTrainSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  private final XboxController xBoxController = new XboxController(0);
  //private final Joystick joystick = new Joystick(0);
  private RightTrainSubsystem rightTrainSubsystem = new RightTrainSubsystem();
  private LeftTrainSubsystem leftTrainSubsystem = new  LeftTrainSubsystem();

  public DriveTrainSubsystem() {}

  @Override
  public void periodic() {}

  public void updateMotors() {
    rightTrainSubsystem.updateMotors(xBoxController.getRightY()); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kRightY.value)
    leftTrainSubsystem.updateMotors(xBoxController.getLeftY()); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kLeftY.value)
  }
}
