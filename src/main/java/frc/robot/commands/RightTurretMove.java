// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.Other.Limelight;
/**
 * It creates a class that moves the turret to the right when it's executed.
 */
public class RightTurretMove extends CommandBase {
  /** Creates a new LeftTurretMove. */
  private Shooter shooter;
  private Limelight limelight;

  /**
   * This adds requirements from the shooter.java
   */
  public RightTurretMove(Shooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    addRequirements(shooter);

    this.limelight = limelight;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.shooter.rightTurret();


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.limelight.AutoAim();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
