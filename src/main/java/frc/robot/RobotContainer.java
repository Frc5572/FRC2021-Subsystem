// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.autos.TrajAuto;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);

  private Command autoCommand;

  private final SendableChooser<String> autoChooser = new SendableChooser<>();

  private static final String TrajAuto = "Trajectory Auto";

  private final JoystickButton deploy = new JoystickButton(driver, XboxController.Button.kY.value);
  private final POVButton rachetMotors = new POVButton(driver, 180);
  private final POVButton hopperIn = new POVButton(operator, 0);
  private final POVButton hopperOut = new POVButton(operator, 180);
  private final Drivetrain tankDrive = new Drivetrain();

  private final Intake intake = new Intake();
  private final Climber climb = new Climber();
  private final Hopper hopper = new Hopper();
  //Values
  private final JoystickButton intakeButton =
      new JoystickButton(operator, XboxController.Button.kB.value);
  private final JoystickButton rightTurret =
      new JoystickButton(operator, XboxController.Button.kRightBumper.value);
  private final JoystickButton leftTurret =
      new JoystickButton(operator, XboxController.Button.kLeftBumper.value);
  private final Button shooterMotor =
      new Button(() -> Math.abs(operator.getRawAxis(XboxController.Axis.kRightTrigger.value)) > .4);
  private final Shooter shooter = new Shooter();

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
    configureButtonBindings();

    autoChooser.setDefaultOption("Trajectory Auto", TrajAuto);
    SmartDashboard.putData("Choose Auto: ", autoChooser);
  }

  private void configureButtonBindings() {
    deploy.whenPressed(new DeployClimber(climb));
    rachetMotors.whileHeld(new ExecuteClimber(climb));
    hopperIn.whileHeld(new HopperUp(hopper));
    hopperOut.whileHeld(new HopperDown(hopper));
    intakeButton.whileHeld(new IntakeRun(intake));
    rightTurret.whileHeld(new RightTurretMove(shooter));
    leftTurret.whileHeld(new LeftTurretMove(shooter));
    shooterMotor.whenHeld(new ExecuteShooter(shooter));
  }

  public Command getAutonomousCommand() {
    if(autoChooser.getSelected() == "Trajectory Auto"){
      autoCommand = new TrajAuto(tankDrive);
    }
    return autoCommand;
  }
}
