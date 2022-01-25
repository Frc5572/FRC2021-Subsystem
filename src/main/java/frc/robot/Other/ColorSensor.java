package frc.robot.other;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.util.Color;


/**
 * This is the public class ColorSensor.
 */
public class ColorSensor {

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();

  /**
   * This is ColorSensor.
   */
  public ColorSensor() { 
    colorMatcher.addColorMatch(Color.kGreen);
    colorMatcher.addColorMatch(Color.kBlue);
    colorMatcher.addColorMatch(Color.kRed);
    colorMatcher.addColorMatch(Color.kYellow);
  }
  /**
   * This is GetColorString.
   */
  public String getColorString() {

    Color detectedColor = colorSensor.getColor();
    String colorString;
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);

    if (match.color == Color.kBlue) {
      colorString = "Blue";
    } else if (match.color == Color.kRed) {
      colorString = "Red";
    } else if (match.color == Color.kGreen) {
      colorString = "Green";
    } else if (match.color == Color.kYellow) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    return colorString;
  }

  /**
   * This is ColorMatchResult, it returns the color matched by ColorMatch.
   */
  public ColorMatchResult getColor() {

    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
    return match;
  }

  public void printA() {
    System.out.println("Color Sensor go brrr");
  }
}
