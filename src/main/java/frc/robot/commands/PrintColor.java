package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.other.ColorSensor;

/**
 * This is PrintColor, it printsColor when a pushed.
 */
public class PrintColor extends CommandBase {
  private final ColorSensor colorSensor;

  public PrintColor(ColorSensor subsystem) {
    colorSensor = subsystem;
  }

  @Override
  public void execute() {
    colorSensor.printA();
  }

  @Override
  public void end(boolean interruptible) {

  }
}
