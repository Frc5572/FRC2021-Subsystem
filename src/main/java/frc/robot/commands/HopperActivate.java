package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class HopperActivate extends CommandBase {
private Hopper hopper;

  @Override
  public void execute() {
    hopper.up();
  }

  @Override
  public void end(boolean interrupted){
    hopper.stop();
  }
}
