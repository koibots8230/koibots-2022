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
    System.out.println("test");
    rightTrainSubsystem.updateMotors(0); // 1 should be replaced with xBoxController.getRightY()
    leftTrainSubsystem.updateMotors(0); // 1 should be replaced with xBoxController.getLeftY()
  }
}
