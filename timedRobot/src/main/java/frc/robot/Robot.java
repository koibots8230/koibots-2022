// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  CANSparkMax frontLeftMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backRightMotor;

  CANSparkMax shooterMotor;
  CANSparkMax backUptakeMotor;
  CANSparkMax frontUptakeMotor;
  CANSparkMax intakeMotor;

  RelativeEncoder frontLeftMotorEncoder;
  RelativeEncoder backLeftMotorEncoder;
  RelativeEncoder frontRightMotorEncoder;
  RelativeEncoder backRightMotorEncoder;

  RelativeEncoder shooterMotorEncoder;
  RelativeEncoder backUptakeMotorEncorder;
  RelativeEncoder frontUptakeMotorEncoder;

  XboxController xboxController;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    frontLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    frontLeftMotor.setInverted(true);
    backLeftMotor.setInverted(true);
    frontRightMotor = new CANSparkMax(3, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(4, MotorType.kBrushless);

    shooterMotor = new CANSparkMax(5, MotorType.kBrushless);
    shooterMotor.setInverted(true);
    backUptakeMotor = new CANSparkMax(6, MotorType.kBrushless);
    frontUptakeMotor = new CANSparkMax(7, MotorType.kBrushless);
    frontUptakeMotor.setInverted(true);
    intakeMotor = new CANSparkMax(8, MotorType.kBrushed);
    intakeMotor.setInverted(true);

    xboxController = new XboxController(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  public double booleanToInt(boolean booleanArgument){
    if(booleanArgument) return 1;
    else return 0;
  }

  public double unbump(double doubleArgument){
    if(Math.abs(doubleArgument) < .1) return 0;
    else return doubleArgument;
  }

  @Override
  public void robotPeriodic() {}

  /**
   * 
   */
  @Override
  public void autonomousInit() {
    frontLeftMotor.set(0.1);
    backLeftMotor.set(0.1);
    frontRightMotor.set(0.1);
    backRightMotor.set(0.1);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    frontRightMotor.set(0.5*unbump(xboxController.getRightY()));//xboxController.getRightY() or a double between -1 and 1
    backRightMotor.set(0.5*unbump(xboxController.getRightY()));//xboxController.getRightY() or a double between -1 and 1
    frontLeftMotor.set(0.5*unbump(xboxController.getLeftY()));//xboxController.getLeftY() or a double between -1 and 1
    backLeftMotor.set(0.5*unbump(xboxController.getLeftY()));//xboxController.getLeftY() or a double between -1 and 1

    frontUptakeMotor.set(unbump(xboxController.getRightTriggerAxis()));
    intakeMotor.set(unbump(xboxController.getRightTriggerAxis()));
    if((xboxController.getYButton() || xboxController.getXButton()) && (unbump(xboxController.getRightTriggerAxis()) == 0)){
      frontUptakeMotor.set(-1);
      intakeMotor.set(-1);
    }

    backUptakeMotor.set(xboxController.getLeftTriggerAxis());
    shooterMotor.set(xboxController.getLeftTriggerAxis());
    if((xboxController.getXButton() || xboxController.getAButton()) && (unbump(xboxController.getRightTriggerAxis()) == 0)){
      backUptakeMotor.set(-1);
      shooterMotor.set(-1);
    }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
