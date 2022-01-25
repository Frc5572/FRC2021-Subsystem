package frc.robot.other;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatch;


/**
 * Java Doc go brrrrrrrrrrr
 */
public class ColorSensor {

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();

  public ColorSensor() { 
    m_colorMatcher.addColorMatch(Color.kGreen);
    m_colorMatcher.addColorMatch(Color.kBlue);
    m_colorMatcher.addColorMatch(Color.kRed);
    m_colorMatcher.addColorMatch(Color.kYellow);
  }

  public String GetColorString() {

    Color detectedColor = colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

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

  public ColorMatchResult GetColor() {

    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    return match;
  }

  public void PrintA() {
    System.out.println("Color Sensor go brrr");
  }
}
