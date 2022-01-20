package frc.robot;

// import frc.robot.Autonomi.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Other.ColorSensor;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);

  private final JoystickButton deploy = new JoystickButton(driver, XboxController.Button.kY.value);
  private final POVButton rachetMotors = new POVButton(driver, 180);
  private final Drivetrain tankDrive = new Drivetrain();
  private final Intake intake = new Intake();
  private final ColorSensor color = new ColorSensor();
  private final JoystickButton intakeButton =
        new JoystickButton(operator, XboxController.Button.kB.value);
  private final Climber climb = new Climber();
  private final JoystickButton colorButton =
        new JoystickButton(driver, XboxController.Button.kA.value);

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    deploy.whenPressed(new DeployClimber(climb));
    rachetMotors.whileHeld(new ExecuteClimber(climb));
    intakeButton.whileHeld(new IntakeRun(intake));
    colorButton.whileHeld(new PrintColor(color));
  }


}
