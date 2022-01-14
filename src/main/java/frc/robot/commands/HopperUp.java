package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
/** 
*Creates Hopper up command which allows to hopper to move up.
*/
public class HopperUp extends CommandBase {
  private Hopper hopper;

  public HopperUp(Hopper hopper) {
    this.hopper = hopper;
  }

  @Override
  public void execute() {
    hopper.up();
  }

  @Override
  public void end(boolean interrupted) {
    hopper.stop();
  }
}
