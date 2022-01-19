package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

/**
 * This is a command.
 */
public class HopperDown extends CommandBase {
  private Hopper hopper;

  public HopperDown(Hopper hopper) {
    this.hopper = hopper;
  }

  @Override
  public void execute() {
    hopper.down();
  }

  @Override
  public void end(boolean interrupted) {
    hopper.stop();
  }
}
