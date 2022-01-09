package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class executeClimb extends CommandBase {
  private Climber climb;

  public executeClimb(Climber climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  public void executeClimberPistons() {
    this.climb.deployClimber();
  }

  public void executeClimberMotors() {
      this.climb.engageClimber();
  }
}
