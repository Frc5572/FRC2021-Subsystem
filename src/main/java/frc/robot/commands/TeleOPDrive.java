package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleOPDrive extends CommandBase {
  private Joystick driver;
  private Drivetrain tankdrive;

  public TeleOPDrive(Drivetrain tankdrive, Joystick controller) {
    this.driver = controller;
    this.tankdrive = tankdrive;
    addRequirements(tankdrive);
  }

  @Override
  public void execute() {
    double yAxis = -driver.getRawAxis(1);
    yAxis = (Math.abs(yAxis) < .01) ? 0 : yAxis;
    this.tankdrive.tankDrive(yAxis);
  }
}
