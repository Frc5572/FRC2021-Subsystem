package frc.robot;
// import frc.robot.Autonomi.*;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);

  private final JoystickButton deploy = new JoystickButton(driver, XboxController.Button.kY.value);
  private final POVButton rachetMotors = new POVButton(driver, 180);
  private final Drivetrain tankDrive = new Drivetrain();
  private final Climber climb = new Climber();
  private final executeClimb climb2 = new executeClimb(climb);

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    deploy.whenPressed(new InstantCommand(() -> climb2.executeClimberPistons()));
    rachetMotors.whenPressed(new InstantCommand(() -> climb2.executeClimberMotors()));
  }
}
