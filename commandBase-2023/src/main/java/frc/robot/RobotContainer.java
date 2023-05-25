package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Utilities.Controller;
import frc.robot.Utilities.Controller.Axes;
import frc.robot.Utilities.Controller.Buttons;
import frc.robot.Utilities.Controller.ControllerType;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.MidtakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TankDriveSubsystem;

public class RobotContainer {

  Controller xboxController = new Controller(ControllerType.XboxController, 0);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    
    // ================================ Drivetrain ================================
    TankDriveSubsystem.get().setDefaultCommand(TankDriveSubsystem.get().new ManualDrive(
      xboxController.getAxis(Axes.leftY),
      xboxController.getAxis(Axes.rightY)));

    Trigger invertDrivetrain = xboxController.getButton(Buttons.optionsOrStart);
    invertDrivetrain.onTrue(new InstantCommand(() -> Constants.DRIVETRAIN_MODIFIER *= -1));

    // ================================ Shooter ================================

    Trigger lowGoal1 = xboxController.getButton(Buttons.leftBumper);
    Trigger lowGoal2 = xboxController.getButton(Buttons.rightBumper);
    
    lowGoal1.onTrue(ShooterSubsystem.get().new LowGoal())
    .or(lowGoal2.onTrue(ShooterSubsystem.get().new LowGoal()));

    Trigger shootIt = xboxController.getButton(Buttons.leftTrigger);

    shootIt.onTrue(new ParallelCommandGroup(
      new InstantCommand(
        () -> ShooterSubsystem.get().set(
          xboxController.getAxis(Axes.leftTrigger).getAsDouble() * (0.75 + Constants.SHOOTER_POWER_MODIFIER),
          xboxController.getAxis(Axes.leftTrigger).getAsDouble()),
          ShooterSubsystem.get()),
      new InstantCommand(
        () -> MidtakeSubsystem.get().set(
        xboxController.getAxis(Axes.leftTrigger).getAsDouble()), MidtakeSubsystem.get())));

    shootIt.onFalse(new ParallelCommandGroup(
      new InstantCommand(
        () -> ShooterSubsystem.get().set(0, 0), ShooterSubsystem.get()),
      new InstantCommand(
        () -> MidtakeSubsystem.get().set(0), MidtakeSubsystem.get())
    ));

    Trigger reverseShooterAndUptake = xboxController.getButton(Buttons.squareOrX);
    reverseShooterAndUptake.onTrue(ShooterSubsystem.get().new ReverseShooter());

    Trigger increaseShooterPower = xboxController.getButton(Buttons.povUp);
    increaseShooterPower.onTrue(new InstantCommand(() -> Constants.SHOOTER_POWER_MODIFIER += .1));

    Trigger decreaseShooterPower = xboxController.getButton(Buttons.povDown);
    decreaseShooterPower.onTrue(new InstantCommand(() -> Constants.SHOOTER_POWER_MODIFIER -= .1));

    // ================================ Intake ================================

    Trigger intake = xboxController.getButton(Buttons.rightTrigger);
    
    intake.onTrue(new ParallelCommandGroup(
      new InstantCommand(
        () -> MidtakeSubsystem.get().set(xboxController.getAxis(Axes.rightTrigger).getAsDouble()), MidtakeSubsystem.get()),
      new InstantCommand(
        () -> IntakeSubsystem.get().set(xboxController.getAxis(Axes.rightTrigger).getAsDouble()), IntakeSubsystem.get())
    ));

    intake.onFalse(new ParallelCommandGroup(
      new InstantCommand(
        () -> MidtakeSubsystem.get().set(0), MidtakeSubsystem.get()),
      new InstantCommand(
        () -> IntakeSubsystem.get().set(0), IntakeSubsystem.get())
    ));

    Trigger intakeReverse = xboxController.getButton(Buttons.triangleOrY);

    intakeReverse.onTrue(new ParallelCommandGroup(
      new InstantCommand(() -> IntakeSubsystem.get().set(-0.95), IntakeSubsystem.get()),
      new InstantCommand(() -> MidtakeSubsystem.get().set(-0.95), MidtakeSubsystem.get())
    ));

    intakeReverse.onFalse(new ParallelCommandGroup(
      new InstantCommand(() -> IntakeSubsystem.get().set(0), IntakeSubsystem.get()),
      new InstantCommand(() -> MidtakeSubsystem.get().set(0), MidtakeSubsystem.get())
    ));
    
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
