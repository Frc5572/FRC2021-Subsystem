package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

//Climb
public class ExecuteClimber extends CommandBase {
  private Climber climb;

  public ExecuteClimber(Climber climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  public void ExecuteClimberPistons() {
    this.climb.deployClimber();
  }

  public void ExecuteClimberMotors() {
    this.climb.engageClimber();
  }

  public void stopClimberMotors() {
    this.climb.disengageClimber();
  }

}
