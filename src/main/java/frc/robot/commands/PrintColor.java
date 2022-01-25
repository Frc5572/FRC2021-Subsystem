package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.other.ColorSensor;

/**
 * This is PrintColor, it printsColor when a pushed.
 */
public class PrintColor extends CommandBase {
  private final ColorSensor Csensor;

  public PrintColor(ColorSensor subsystem) {
    Csensor = subsystem;
  }

  @Override
  public void execute() {
    Csensor.printA();
  }

  @Override
  public void end(boolean interruptible) {

  }
}
