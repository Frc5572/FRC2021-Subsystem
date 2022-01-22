package frc.robot.Other;

import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class ColorSensor {

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();

  public ColorSensor() { }

  public String GetColor() {

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

  public void PrintA() {
    System.out.println("Color Sensor go brrr");
  }
}
