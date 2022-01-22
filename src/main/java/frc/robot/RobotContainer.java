// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.autos.Auto;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Other.ColorSensor;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import java.util.ArrayList;
import java.util.TreeMap;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);


  private final JoystickButton deploy = new JoystickButton(driver, XboxController.Button.kY.value);
  private final POVButton rachetMotors = new POVButton(driver, 180);
  private final POVButton hopperIn = new POVButton(operator, 0);
  private final POVButton hopperOut = new POVButton(operator, 180);
  private final Drivetrain tankDrive = new Drivetrain();
  private TreeMap<String, Command> autos = new TreeMap<String, Command>();
  private ArrayList<String> autoNames;
  private int cauto = 0;
  private int lengthOfList;
  private final Intake intake = new Intake();
  private final ColorSensor color = new ColorSensor();
  private final JoystickButton intakeButton =
      new JoystickButton(operator, XboxController.Button.kB.value);
  private final Climber climb = new Climber();
  private final JoystickButton colorButton =
        new JoystickButton(driver, XboxController.Button.kA.value);
  private final Hopper hopper = new Hopper();
  private final JoystickButton rightTurret =
      new JoystickButton(driver, XboxController.Button.kRightBumper.value);
  private final JoystickButton leftTurret =
      new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
  private final Button shooterMotor =
      new Button(() -> Math.abs(driver.getRawAxis(XboxController.Axis.kRightTrigger.value)) > .4);
  private final Shooter shooter = new Shooter();
  

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
    configureButtonBindings();
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
    colorButton.whileHeld(new PrintColor(color));
  }

  public Command getAutonomousCommand() {
    return autos.get(autoNames.get(cauto));
  }
}
