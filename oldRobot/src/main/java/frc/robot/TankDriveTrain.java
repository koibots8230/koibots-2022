package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class TankDriveTrain {
    public VictorSPX frontLeftMotor;
    public VictorSPX frontRightMotor;
    public VictorSPX backLeftMotor;
    public VictorSPX backRightMotor;

    public TankDriveTrain(int frontLeft, int frontRight, int backLeft, int backRight){
        frontLeftMotor = new VictorSPX(frontLeft);
        frontRightMotor = new VictorSPX(frontRight);
        backLeftMotor = new VictorSPX(backLeft);
        backRightMotor = new VictorSPX(backRight);

        backLeftMotor.follow(frontLeftMotor);
        backLeftMotor.setInverted(false);
        backRightMotor.follow(frontRightMotor);
        backRightMotor.setInverted(false);
    }

    public void driveRobot(double axisOne, double axisTwo){
        frontLeftMotor.set(ControlMode.PercentOutput, axisOne);
        frontRightMotor.set(ControlMode.PercentOutput, axisTwo);
    }

    public void driveRobot(double stickOneYAxis, double stickOneXAxis, double stickTwoYAxis, double stickTwoXAxis){
        frontLeftMotor.set(ControlMode.PercentOutput, stickOneYAxis + stickOneXAxis);
        frontRightMotor.set(ControlMode.PercentOutput, stickTwoYAxis + stickTwoXAxis);
    }
}
