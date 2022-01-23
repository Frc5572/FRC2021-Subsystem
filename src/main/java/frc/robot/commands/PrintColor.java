package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.other.ColorSensor;

public class PrintColor extends CommandBase {
  private final ColorSensor CSensor;

  public PrintColor(ColorSensor subsystem) {
    CSensor = subsystem;
  }

  @Override
  public void execute() {
    CSensor.PrintA();
  }

  @Override
  public void end(boolean interruptible) {

  }
}
