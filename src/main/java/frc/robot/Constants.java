package frc.robot;

import com.revrobotics.ColorMatch;
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

  private final ColorMatch colorMatcher1 = new ColorMatch();

  private final Color blueTarget1 = ColorMatch.makeColor(0, 0, 1);
  private final Color greenTarget1 = ColorMatch.makeColor(0, 1, 0);
  private final Color redTarget1 = ColorMatch.makeColor(1, 0, 0);
  private final Color yellowTarget1 = ColorMatch.makeColor(.5, 1, 0);
}
