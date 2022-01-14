package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

/**
* Returns a Command to run the climber.
*/
public class DeployClimber extends CommandBase {
  private Climber climb;

  public DeployClimber(Climber climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  @Override
  public void execute() {
    this.climb.deployClimber();
  }


}
