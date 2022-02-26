package frc.robot.subsystems.driveTrainSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  private final XboxController xBoxController = new XboxController(0);
  private final RightTrainSubsystem rightTrainSubsystem = new RightTrainSubsystem();
  private final LeftTrainSubsystem leftTrainSubsystem = new  LeftTrainSubsystem();

  private final CANSparkMax motorFive = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax motorSix = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax motorSeven = new CANSparkMax(7, MotorType.kBrushless);

  public DriveTrainSubsystem() {
    motorSeven.setInverted(true);
  }

  @Override
  public void periodic() {}

  public void updateMotors() {
    System.out.println(xBoxController.getRawAxis(XboxController.Axis.kRightY.value));
    motorFive.set(.8);
    motorSix.set(.5);
    motorSeven.set(.5);
    //rightTrainSubsystem.updateMotors(.5); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kRightY.value)
    //leftTrainSubsystem.updateMotors(.5); // 1 should be replaced with xBoxController.getRawAxis(XboxController.Axis.kLeftY.value)
  }
}
