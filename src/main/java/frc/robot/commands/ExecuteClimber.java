package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

/**
* Returns a Command to run the climber
*/
public class ExecuteClimber extends CommandBase {
  private Climber climb;

  public ExecuteClimber(Climber climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  public void executeClimberPistons() {
    this.climb.deployClimber();
  }

  public void executeClimberMotors() {
    this.climb.engageClimber();
  }

  public void stopClimberMotors() {
    this.climb.disengageClimber();
  }
}
