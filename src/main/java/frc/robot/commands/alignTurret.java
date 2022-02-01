// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Turret;

public class alignTurret extends CommandBase {
  Turret turret;;
  XboxController driver;
  /** Creates a new alignTurret. */
  public alignTurret(Turret turret, XboxController driver){
    this.driver = driver;
    this.turret = turret;
    addRequirements(turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(driver.getLeftBumper()){
      turret.leftTurret();
    } else if (driver.getRightBumper()){
      turret.rightTurret();
    } else {
      turret.align();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
