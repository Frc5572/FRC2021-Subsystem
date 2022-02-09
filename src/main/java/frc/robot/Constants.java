package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

/**
* Create Constants.
*/
public final class Constants {
  public final double x1 = -0.0000000025291;
  public final double x2 = 0.0000334240538;
  public final double x3 = -0.1545379987062;
  public final double b1 = 315.5170993015826;
  public final double heightOfShooter = 38;
  public final double heightOfTower = 98;
  public final double heightdiff = heightOfTower - heightOfShooter;
  public final double maxPosition = 0;
  public final double minPosition = 1;
  public final double b2 = -.625;
  public final double limitTurret = 20;
  public final double limitServo = .7;
  public final double hoodOffset = 30;
  public final double pi = 3.14159265358979323846;

  private final Color blueTarget1 = Color.kBlue;
  private final Color greenTarget1 = Color.kGreen;
  private final Color redTarget1 = Color.kRed;
  private final Color yellowTarget1 = Color.kYellow;

  public static final class VisionConstants {
    public static final double deadPocket = 0.4;
    public static final double limelightHeight = 38;
    public static final double targetHeight = 98;
    public static final double limelightAngle = 20;
    public static final double minAngle = 25;
    public static final double maxAngle = 65;
}

  
}