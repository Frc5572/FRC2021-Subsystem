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

  private final Color blueTarget1 = Color.kBlue;
  private final Color greenTarget1 = Color.kGreen;
  private final Color redTarget1 = Color.kRed;
  private final Color yellowTarget1 = Color.kYellow;

  public static final double maxSpeed = 4; //meters per second
  public static final double maxAngularVelocity = 2;

  public static final int kEncoderCPR = 2048;
    public static final double kWheelDiameterMeters = 0.1524;
    public static final double kEncoderDistancePerPulse =
        (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;
}
