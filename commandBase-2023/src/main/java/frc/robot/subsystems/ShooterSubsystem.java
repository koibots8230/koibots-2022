package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    private static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

    CANSparkMax shooterMotor;
    CANSparkMax uptakeMotor;

    public ShooterSubsystem() {
        shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR_PORT, MotorType.kBrushless);
        shooterMotor.setInverted(true);

        uptakeMotor = new CANSparkMax(Constants.UPTAKE_MOTOR_PORT, MotorType.kBrushless);
    }

    public static ShooterSubsystem get() {
        return shooterSubsystem;
    }

    public void set(double shooterSpeed, double uptakeSpeed) {
        shooterMotor.set(shooterSpeed);
        uptakeMotor.set(uptakeSpeed);
    }

    public class LowGoal extends CommandBase {

        public LowGoal() {
            addRequirements(ShooterSubsystem.get());
        }

        @Override
        public void initialize() {
            ShooterSubsystem.get().set(0.35, .95);
        }

        @Override
        public void end(boolean interrupted) {
            ShooterSubsystem.get().set(0, 0);
        }
    }

    public class ReverseShooter extends CommandBase {

        public ReverseShooter() {
            addRequirements(ShooterSubsystem.get());
        }

        @Override
        public void initialize() {
            ShooterSubsystem.get().set(-0.95, -0.95);
        }

        @Override
        public void end(boolean interrupted) {
            ShooterSubsystem.get().set(0, 0);
        }
    }
}
