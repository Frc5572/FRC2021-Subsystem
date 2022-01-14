// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import frc.robot.Autonomi.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;


import frc.robot.commands.*;
import frc.robot.subsystems.*;

/** Add your docs here. */
public class RobotContainer {
    Joystick driver = new Joystick(0);
    Joystick operator = new Joystick(1);

    private final JoystickButton rightTurret = new JoystickButton(driver, XboxController.Button.kBumperRight.value);
    private final JoystickButton leftTurret = new JoystickButton(driver, XboxController.Button.kBumperLeft.value);
    private final Shooter shooter = new Shooter();

    private void configureButtonBindings() {
        rightTurret.whenPressed(new RightTurretMove(shooter));
        leftTurret.whenPressed(new LeftTurretMove(shooter));

}
}