package frc.robot.commands;

import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.other.ColorSensor;

/**
 * I don't know what it creates.
 */
public class StopAtRed extends CommandBase {
  private Shooter shooter;
  private ColorSensor color;
  private boolean finish;

  public StopAtRed(Shooter shoot, ColorSensor color) {
    this.shooter = shoot;
    addRequirements(shoot);
    this.color = color;
  }

  @Override
  public void execute() {
    shooter.spin();
  }
  
  @Override
  public boolean isFinished() {
    ColorMatchResult detectedcolor = color.GetColor();
    return detectedcolor.color == Color.kRed && detectedcolor.confidence > .50;
  }

  @Override
  public void end(boolean interruptible) {
    shooter.stop();
  }
}
