package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class executeClimb extends CommandBase {
  private Climber climb;

  public executeClimb(Climber climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  @Override
  public void execute() {
    int DPadDown = 180;
    this.climb.climb();
  }
}
