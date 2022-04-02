// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  String SelectedAuto = "2taxi";

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
  RelativeEncoder uptakeMotorEncoder;
  RelativeEncoder midtakeMotorEncoder;

  XboxController xboxController;

  int drivetrainModifier;
  int Step = 1;
  double referenceShooterPos;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //start camera
    CameraServer.startAutomaticCapture();
    //assign motors
    frontLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    frontLeftMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    frontRightMotor = new CANSparkMax(3, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);

    shooterMotor = new CANSparkMax(5, MotorType.kBrushless);
    shooterMotor.setInverted(true);
    uptakeMotor = new CANSparkMax(6, MotorType.kBrushless);
    midtakeMotor = new CANSparkMax(7, MotorType.kBrushless);
    midtakeMotor.setInverted(true);
    intakeMotor = new CANSparkMax(8, MotorType.kBrushed);
    intakeMotor.setInverted(true);

    frontLeftMotorEncoder = frontLeftMotor.getEncoder();
    backLeftMotorEncoder = backLeftMotor.getEncoder();
    frontRightMotorEncoder = frontRightMotor.getEncoder();
    backRightMotorEncoder = backRightMotor.getEncoder();

    shooterMotorEncoder = shooterMotor.getEncoder();
    uptakeMotorEncoder = uptakeMotor.getEncoder();
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

  /** This function is called once autonomous is enabled */
  @Override
  public void autonomousInit() {
    setAllEncoders(0);
   shooterMotor.set(.75);
   //commented out to give shootermotor time to spin up uptakeMotor.set(1);
   midtakeMotor.set(1);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

//switch statement for the different kinds of autos

switch(SelectedAuto){
  /*#region 2taxi */
  case("2taxi"):
    switch(Step) {
      case(1):
          if (shooterMotorEncoder.getPosition() > 40) {
              uptakeMotor.set(1);
              midtakeMotor.set(1);
          }
          //move to step 2 after shooting
          if (shooterMotorEncoder.getPosition() > 170) {
      //turn off shooter
          shooterMotor.set(0);
      midtakeMotor.set(0);
      uptakeMotor.set(0);
          Step = 2;
          }
      break;
      case 2:
          //turn
          frontRightMotor.set(.35);
          backRightMotor.set(.35);
      frontLeftMotor.set(.35);
      backLeftMotor.set(.35);
      //turn left motors to start turning after initial movement(?)
      if (backRightMotorEncoder.getPosition() >= 2 && frontRightMotorEncoder.getPosition() >= 2) {
        frontLeftMotor.set(-.35);
        backLeftMotor.set(-.35);
      }
      //stop and go to step 3
          if (backRightMotorEncoder.getPosition() >= 4.8 && frontRightMotorEncoder.getPosition() >= 4.8) {
          frontRightMotor.set(0);
      backRightMotor.set(0);
      backLeftMotor.set(0);
      frontLeftMotor.set(0);
      //reset motor encoders
      frontRightMotorEncoder.setPosition(0);
      backRightMotorEncoder.setPosition(0);
      frontLeftMotorEncoder.setPosition(0);
      backLeftMotorEncoder.setPosition(0);
          intakeMotor.set(1);
          midtakeMotor.set(1);
          Step = 3;
          }
        break;
          //Im assuming that the intake will go down from turning, so there’s no need to //move and stop after this to move forwads
    case 3:
          //moving to pick up ball after shooting
          frontRightMotor.set(.25);
      backRightMotor.set(.25);
      frontLeftMotor.set(.25);
      backLeftMotor.set(.25);
          if (frontLeftMotorEncoder.getPosition() >= 40  && backRightMotorEncoder.getPosition() >= 40 && backLeftMotorEncoder.getPosition() > 40 && frontRightMotorEncoder.getPosition() > 40){
            frontRightMotorEncoder.setPosition(0);
          backRightMotorEncoder.setPosition(0);
          frontLeftMotorEncoder.setPosition(0);
          backLeftMotorEncoder.setPosition(0);
            intakeMotor.set(1);
          Step =4;
          }
      break;
      case 4:
          //go backwards
      frontRightMotor.set(-.25);
      backRightMotor.set(-.25);
      frontLeftMotor.set(-.25);
      backLeftMotor.set(-.25);
          //because we are moving the same amount backwards, this should be about //twice the encoder distance i think? Or we could restart the encoder positions in the previous //step if needed
      if (frontLeftMotorEncoder.getPosition() <= -42 && backRightMotorEncoder.getPosition() <= -42 && backLeftMotorEncoder.getPosition() < -42 && frontRightMotorEncoder.getPosition() < -42){
        frontRightMotor.set(0);
        backRightMotor.set(0);
        frontLeftMotor.set(0);
        backLeftMotor.set(0);
        intakeMotor.set(0);

          //shoot againht6ttttttttttttttttttttttttttttttttttt
          referenceShooterPos = shooterMotorEncoder.getPosition();
          shooterMotor.set(0.7);
          Step = 5;
          }

      break;
      case 5:
      //if greater than 20, basically repeating same as last time, assuming we dont want to //reset the position for shooter encoder
      //giving shootermotor time to speed up again
        if  (shooterMotorEncoder.getPosition() - referenceShooterPos >= 20) {
            uptakeMotor.set(1);
            midtakeMotor.set(1);
        }
      //again, if shooter thing has gotten to the point that it shoots, (we’re using differences //here now to measure the encoder units from our frain of reference, variables here can be //renamed to a much better convention later)
    //then we move out of robot and head to step 6 where it measures our distance to stop
          if (shooterMotorEncoder.getPosition() - referenceShooterPos  >= 155) {
        //UNCOMMENT THIS TO MOVE OUT OF TARMAC!!!!
        //IMPORTANT
        //VERY IMPORTANT
        //IM JUST TYPING MORE COMMENTS TO GET FUTURE ALEXS ATTENTION
        //alex anderson if you do NOT remember this you WILL have caused great dishonour
        //just uncomment these 8 lines of code
        //:)
        frontRightMotor.set(.25);
        backRightMotor.set(.25);
        frontLeftMotor.set(.25);
        backLeftMotor.set(.25);
        frontRightMotorEncoder.setPosition(0);
        backRightMotorEncoder.setPosition(0);
        frontLeftMotorEncoder.setPosition(0);
        backLeftMotorEncoder.setPosition(0);
              shooterMotor.set(0);
              uptakeMotor.set(0);
              midtakeMotor.set(0);
              Step = 6;
      }
      break;
      case 6:
          if (frontLeftMotorEncoder.getPosition() >= 19 && backRightMotorEncoder.getPosition() >= 19 && backLeftMotorEncoder.getPosition() > 19 && frontRightMotorEncoder.getPosition() > 19){
        frontRightMotor.set(0);
        backRightMotor.set(0);
        frontLeftMotor.set(0);
        backLeftMotor.set(0);
        }
      break;

    }
  }
  /* #endregion */
}
  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    drivetrainModifier = 1;
    setAllMotors(0);
  }

  /** This function is called periodically during teleop. */
  @Override
  public void teleopPeriodic() {
    if(xboxController.getRawButtonPressed(8)){
      drivetrainModifier = drivetrainModifier * -1;
    }
    xboxController.getRawButton(8);
    if(xboxController.getBButton() && xboxController.getAButton()){
      frontLeftMotor.set(-0.65);//xboxController.getLeftY() or a double between -1 and 1
      backLeftMotor.set(-0.65);//xboxController.getLeftY() or a double between -1 and 1
      frontRightMotor.set(-0.65);//xboxController.getRightY() or a double between -1 and 1
      backRightMotor.set(-0.65);//xboxController.getRightY() or a double between -1 and 1
    } else {
      frontLeftMotor.set(-0.65 * drivetrainModifier * deadzone(xboxController.getLeftY()));//xboxController.getLeftY() or a double between -1 and 1
      backLeftMotor.set(-0.65 * drivetrainModifier * deadzone(xboxController.getLeftY()));//xboxController.getLeftY() or a double between -1 and 1
      frontRightMotor.set(-0.65 * drivetrainModifier * deadzone(xboxController.getRightY()));//xboxController.getRightY() or a double between -1 and 1
      backRightMotor.set(-0.65 * drivetrainModifier * deadzone(xboxController.getRightY()));//xboxController.getRightY() or a double between -1 and 1
    }
    if(xboxController.getYButton()){
      midtakeMotor.set(-1);
      intakeMotor.set(-1);
    } else {
      if (xboxController.getRightTriggerAxis() > xboxController.getLeftTriggerAxis()){
        midtakeMotor.set(xboxController.getRightTriggerAxis());
      } else {
      midtakeMotor.set(deadzone(xboxController.getLeftTriggerAxis()));
      }
    intakeMotor.set(deadzone(xboxController.getRightTriggerAxis()));
    }

    uptakeMotor.set(xboxController.getLeftTriggerAxis());
    shooterMotor.set(0.75*(xboxController.getLeftTriggerAxis()));
    if((xboxController.getXButton()) && (deadzone(xboxController.getRightTriggerAxis()) == 0)){
      uptakeMotor.set(-1);
      shooterMotor.set(-1);
    }

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    setAllMotors(0);
    setAllEncoders(0);
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

  public void setAllEncoders(double value){
    frontRightMotorEncoder.setPosition(value);
    backRightMotorEncoder.setPosition(value);
    frontLeftMotorEncoder.setPosition(value);
    backLeftMotorEncoder.setPosition(value);

    midtakeMotorEncoder.setPosition(value);

    uptakeMotorEncoder.setPosition(value);
    shooterMotorEncoder.setPosition(value);
  }
}
