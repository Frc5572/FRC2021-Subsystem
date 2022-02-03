// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


/**
 * This creats a class that makes a function for the shooter and for the turret.
 */
public class Shooter extends SubsystemBase {
  private final WPI_TalonSRX  mshooterLeft = new WPI_TalonSRX(12);
  private final WPI_TalonSRX  mshooterRight  = new WPI_TalonSRX(14);
  private final MotorControllerGroup shootingMotors =
      new MotorControllerGroup(mshooterLeft, mshooterRight);
 

  public void spin() {
    shootingMotors.set(.7);
  }

  public void stop() {
    shootingMotors.set(0);
  }

  
    
}
