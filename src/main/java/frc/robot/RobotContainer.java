package frc.robot;

// import frc.robot.Autonomi.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);

  private final Drivetrain tankDrive = new Drivetrain();
  private final Intake intake = new Intake();
  private final JoystickButton intakeButton = new JoystickButton(operator, XboxController.Button.kB.value);

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
    configureButtonBindings();
  }

  private void configureButtonBindings(){ 
    intakeButton.whileHeld(new IntakeRun(intake));
  }
}
