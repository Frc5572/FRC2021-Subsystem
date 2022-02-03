package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

/**
* Create Constants.
*/
public final class Constants {
  final double x1 = -0.0000000025291;
  final double x2 = 0.0000334240538;
  final double x3 = -0.1545379987062;
  final double b1 = 315.5170993015826;
  final double heightOfShooter = 38;
  final double heightOfTower = 98;
  final double heightdiff = heightOfTower - heightOfShooter;
  final double minAngle = 25;
  final double maxAngle = 65;
  final double maxPosition = 0;
  final double minPosition = 1;
  final double m1 = -(maxPosition - minPosition) / (maxAngle - minAngle);
  final double b2 = -.625;
  final double limitTurret = 20;
  final double limitServo = .7;
  final double hoodOffset = 30;
  final double pi = 3.14159265358979323846;

  public static final boolean kEncoderReversed = false;
  public static final int kEncoderCPR = 1024;
  public static final double kEncoderDistancePerPulse = 1.0 / (double) kEncoderCPR;

  public static final double kP = 1;
  public static final double kI = 0;
  public static final double kD = 0;

  public static final double kShooterFreeRPS = 4000;
  public static final double kShooterTargetRPS = 2000;
  public static final double kShooterToleranceRPS = 50;

  public static final int kUnitsPerRevolution = 2048;
  public static final double kSVolts = 0.572;
  public static final double kVVoltSecondsPerRotation = (0.002 / 60) / kShooterFreeRPS;
}
