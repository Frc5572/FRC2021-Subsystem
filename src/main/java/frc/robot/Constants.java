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
  public final double minAngle = 25;
  public final double maxAngle = 65;
  public final double maxPosition = 0;
  public final double minPosition = 1;
  public final double m1 = -(maxPosition - minPosition) / (maxAngle - minAngle);
  public final double b2 = -.625;
  public final double limitTurret = 20;
  public final double limitServo = .7;
  public final double hoodOffset = 30;
  public final double pi = 3.14159265358979323846;

  private final Color blueTarget1 = Color.kBlue;
  private final Color greenTarget1 = Color.kGreen;
  private final Color redTarget1 = Color.kRed;
  private final Color yellowTarget1 = Color.kYellow;

  public final double CalculateDistance(double area){
    double r = x1*java.lang.Math.pow(area, 3) + x2*java.lang.Math.pow(area, 2) +x3*area + b1;
    return r;}

  public final double CalculateAngle(double distance){
    double t = java.lang.Math.atan2(heightdiff , distance);
    double d = t * (180 / pi);
    double corrected_d = (90 - d - 25);
     double r = m1 * corrected_d  + b1;
    if (corrected_d > 64) {
        r = limitServo;
    } else if (corrected_d < 26) {
        r = 0;
    }
    return r;
}
}