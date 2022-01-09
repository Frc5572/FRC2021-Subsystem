package frc.robot;

// import frc.robot.Autonomi.*;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);

  private final Drivetrain tankDrive = new Drivetrain();

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
  }
}
