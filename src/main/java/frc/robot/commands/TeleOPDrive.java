package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * I don't know what it creates.
 */
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
    double LeftYAxis = -driver.getRawAxis(XboxController.Axis.kLeftY.value);
    double RightYAxis = -driver.getRawAxis(XboxController.Axis.kRightY.value);
    LeftYAxis = (Math.abs(LeftYAxis) < .01) ? 0 : LeftYAxis;
    RightYAxis = (Math.abs(RightYAxis) < .01) ? 0 : RightYAxis;
    this.tankdrive.tankDrive(LeftYAxis, RightYAxis);
  }
}
