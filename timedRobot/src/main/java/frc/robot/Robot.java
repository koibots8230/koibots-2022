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
  CANSparkMax uptakeMotor;
  CANSparkMax midtakeMotor;
  CANSparkMax intakeMotor;

  RelativeEncoder frontLeftMotorEncoder;
  RelativeEncoder backLeftMotorEncoder;
  RelativeEncoder frontRightMotorEncoder;
  RelativeEncoder backRightMotorEncoder;

  RelativeEncoder shooterMotorEncoder;
  RelativeEncoder uptakeMotorEncorder;
  RelativeEncoder midtakeMotorEncoder;

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
    uptakeMotor = new CANSparkMax(6, MotorType.kBrushless);
    midtakeMotor = new CANSparkMax(7, MotorType.kBrushless);
    midtakeMotor.setInverted(true);
    intakeMotor = new CANSparkMax(8, MotorType.kBrushed);
    intakeMotor.setInverted(true);

    frontLeftMotorEncoder = frontLeftMotor.getEncoder();
    backLeftMotorEncoder = backLeftMotor.getEncoder();
    frontLeftMotorEncoder.setInverted(true);
    backLeftMotorEncoder.setInverted(true);
    frontRightMotorEncoder = frontRightMotor.getEncoder();
    backRightMotorEncoder = backRightMotor.getEncoder();

    shooterMotorEncoder = shooterMotor.getEncoder();
    uptakeMotorEncorder = uptakeMotor.getEncoder();
    midtakeMotorEncoder = midtakeMotor.getEncoder();

    frontLeftMotorEncoder.setPosition(0);
    backLeftMotorEncoder.setPosition(0);
    frontRightMotorEncoder.setPosition(0);
    backRightMotorEncoder.setPosition(0);
    
    xboxController = new XboxController(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousInit() {
    frontLeftMotorEncoder.setPosition(0);
    backLeftMotorEncoder.setPosition(0);
    frontRightMotorEncoder.setPosition(0);
    backRightMotorEncoder.setPosition(0);
    frontLeftMotor.set(.5);
    backLeftMotor.set(.5);
    frontRightMotor.set(-.5);
    backRightMotor.set(-.5);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if(frontLeftMotorEncoder.getPosition() > 40){
      frontLeftMotor.set(0);
    }
    if(backLeftMotorEncoder.getPosition() > 40){
      backLeftMotor.set(0);
    }
    if(frontRightMotorEncoder.getPosition() > 40){
      frontRightMotor.set(0);
    }
    if(backRightMotorEncoder.getPosition() > 40){
      backRightMotor.set(0);
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    setAllMotors(0);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    if(xboxController.getBButton() && xboxController.getAButton()){
      frontLeftMotor.set(0.75);//xboxController.getLeftY() or a double between -1 and 1
      backLeftMotor.set(0.75);//xboxController.getLeftY() or a double between -1 and 1
      frontRightMotor.set(0.75);//xboxController.getRightY() or a double between -1 and 1
      backRightMotor.set(0.75);//xboxController.getRightY() or a double between -1 and 1
    } else {
      frontLeftMotor.set(0.5*deadzone(xboxController.getLeftY()));//xboxController.getLeftY() or a double between -1 and 1
      backLeftMotor.set(0.5*deadzone(xboxController.getLeftY()));//xboxController.getLeftY() or a double between -1 and 1
      frontRightMotor.set(0.5*deadzone(xboxController.getRightY()));//xboxController.getRightY() or a double between -1 and 1
      backRightMotor.set(0.5*deadzone(xboxController.getRightY()));//xboxController.getRightY() or a double between -1 and 1
    }

    midtakeMotor.set(deadzone(xboxController.getRightTriggerAxis()));
    intakeMotor.set(deadzone(xboxController.getRightTriggerAxis()));
    if((xboxController.getYButton() || xboxController.getXButton()) && (deadzone(xboxController.getRightTriggerAxis()) == 0)){
      midtakeMotor.set(-1);
      intakeMotor.set(-1);
    }

    uptakeMotor.set(xboxController.getLeftTriggerAxis());
    shooterMotor.set(0.73*(xboxController.getLeftTriggerAxis()));
    if((xboxController.getXButton()) && (deadzone(xboxController.getRightTriggerAxis()) == 0)){
      uptakeMotor.set(-1);
      shooterMotor.set(-1);
    }

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    setAllMotors(0);
    frontLeftMotorEncoder.setPosition(0);
    backLeftMotorEncoder.setPosition(0);
    frontRightMotorEncoder.setPosition(0);
    backRightMotorEncoder.setPosition(0);
  }

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

  public double booleanToInt(boolean booleanArgument){
    if(booleanArgument) return 1;
    else return 0;
  }

  public double deadzone(double doubleArgument){
    if(Math.abs(doubleArgument) < .15) return 0;
    else return doubleArgument;
  }

  public void setAllMotors(double percentValue){
    frontRightMotor.set(percentValue);
    backRightMotor.set(percentValue);
    frontLeftMotor.set(percentValue);
    backLeftMotor.set(percentValue);

    midtakeMotor.set(percentValue);
    intakeMotor.set(percentValue);

    uptakeMotor.set(percentValue);
    shooterMotor.set(percentValue);
  }
}
