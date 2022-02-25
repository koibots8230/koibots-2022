// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
/*---------------------------------------------------------------------------------
If you are not a coder and want to change settings for the bot this is the file to do so
  ---------------------------------------------------------------------------------*/
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
/*---------------------------------------------------------------------------------
Edit below here
  ---------------------------------------------------------------------------------*/
public final class Constants {
    public static final boolean MOTOR_TEST_ENABLED = true; // Can be true or false. Turn this to false if you'd like to test a motor.
    
    public static final int TEST_MOTOR_PORT_NUMBER = 1; // Each motor controller is labled with an integer ID if it hasn't been labled it hasn't been setup yet.
    public static final MotorType TEST_MOTOR_TYPE = MotorType.kBrushless; // Can be MotorType.kBrushless or MotorType.kBrushed
    public static final double TEST_MOTOR_POWER = 1; // Is a percent value ranging from -1 to 1
    public static final boolean TEST_MOTOR_INVERTED = false; // Can be true or false
    
}
