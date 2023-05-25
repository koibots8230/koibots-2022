// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  // Driving Constants
  public static final double JOYSTICK_DEADZONE = 0.15;
  public static final double TRIGGER_DEADZONE = 0.15;
  public static final double MAX_DRIVING_SPEED = 0.15;
  public static double DRIVETRAIN_MODIFIER = 1;
  // Shooting Constants
  public static double SHOOTER_POWER_MODIFIER = 0;

  // Motor Ports
  public static final int FRONT_LEFT_DRIVE_MOTOR_PORT = 2;
  public static final int BACK_LEFT_DRIVE_MOTOR_PORT = 1;
  public static final int FRONT_RIGHT_DRIVE_MOTOR_PORT = 3;
  public static final int BACK_RIGHT_DRIVE_MOTOR_PORT = 4;

  public static final int SHOOTER_MOTOR_PORT = 5;
  public static final int UPTAKE_MOTOR_PORT = 6;
  public static final int MIDTAKE_MOTOR_PORT = 7;
  public static final int INTAKE_MOTOR_PORT = 8;
}