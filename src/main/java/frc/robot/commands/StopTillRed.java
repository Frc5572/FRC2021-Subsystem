package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.other.ColorSensor;

/**
 * I don't know what it creates.
 */
public class StopTillRed extends CommandBase {
  private Drivetrain tankdrive;

  public StopTillRed(Drivetrain drive) {
    this.tankdrive = drive;
    addRequirements(drive);
  }

  @Override
  public void execute() {
    tankdrive.moveStraight(.3);
  }

  @Override
  public boolean isFinished() {
    
    return false;
  }

  @Override
  public void end(boolean interruptible) {
    tankdrive.stop();
  }
}
