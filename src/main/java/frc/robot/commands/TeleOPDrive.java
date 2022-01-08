package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleOPDrive extends CommandBase {
  private int translationAxis;
  private XboxController driver;
  private Drivetrain tankdrive;

  public TeleOPDrive(Drivetrain tankdrive, XboxController controller, int translationAxis) {
    this.translationAxis = translationAxis;
    this.driver = controller;
    this.tankdrive = tankdrive;
    addRequirements(tankdrive);
  }

  @Override
  public void execute() {
    double yAxis = -driver.getRawAxis(this.translationAxis);
    yAxis = (Math.abs(yAxis) < .01) ? 0 : yAxis;
    this.tankdrive.tankDrive(yAxis);
  }
}
