package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDriveSubsystem extends SubsystemBase {
    private static TankDriveSubsystem tankDriveSubsystem = new TankDriveSubsystem();
    private CANSparkMax frontLeftDriveMotor;
    private CANSparkMax backLeftDriveMotor;
    private CANSparkMax frontRightDriveMotor;
    private CANSparkMax backRightDriveMotor;
    

    public TankDriveSubsystem() {
        frontLeftDriveMotor = new CANSparkMax(Constants.FRONT_LEFT_DRIVE_MOTOR_PORT, MotorType.kBrushless);
        backLeftDriveMotor = new CANSparkMax(Constants.BACK_LEFT_DRIVE_MOTOR_PORT, MotorType.kBrushless);
        backLeftDriveMotor.follow(frontLeftDriveMotor);

        frontRightDriveMotor = new CANSparkMax(Constants.FRONT_RIGHT_DRIVE_MOTOR_PORT, MotorType.kBrushless);
        backRightDriveMotor = new CANSparkMax(Constants.BACK_RIGHT_DRIVE_MOTOR_PORT, MotorType.kBrushless);
        frontRightDriveMotor.setInverted(true);
        backRightDriveMotor.follow(frontLeftDriveMotor);
    }

    public static TankDriveSubsystem get() {
        return tankDriveSubsystem;
    }

    public void setMotors(double leftSpeed, double rightSpeed) {
        frontLeftDriveMotor.set(leftSpeed);
        frontRightDriveMotor.set(rightSpeed);
    }

    public class ManualDrive extends CommandBase {
        DoubleSupplier leftSpeed;
        DoubleSupplier rightSpeed;

        public ManualDrive(DoubleSupplier leftJoystick, DoubleSupplier rightJoystick) {
            leftSpeed = leftJoystick;
            rightSpeed = rightJoystick;
            addRequirements(TankDriveSubsystem.get());
        }

        @Override
        public void execute() {
            TankDriveSubsystem.this.setMotors(
                deadzone(leftSpeed.getAsDouble()),
                deadzone(rightSpeed.getAsDouble()));
        }

        private double deadzone(double value) {
            return Math.abs(value) > Constants.JOYSTICK_DEADZONE ? 
            value * Constants.MAX_DRIVING_SPEED * Constants.DRIVETRAIN_MODIFIER : 0;
        }
    }
}