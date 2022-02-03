// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.*;

/**
 * This creats a class that makes a function for the shooter and for the turret.
 */
public class Shooter extends SubsystemBase {
  private final WPI_TalonFX  mshooterLeft = new WPI_TalonFX(14);
  private final CANSparkMax turretMotor =
      new CANSparkMax(13, MotorType.kBrushless);

  public Shooter(){
    mshooterLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 1, 1);
  }
  public void spin() {
    mshooterLeft.set(.8);

    double selSenVel = mshooterLeft.getSelectedSensorVelocity(0);

    double RotPerSec = (double) selSenVel / Constants.kUnitsPerRevolution * 10; /* scale per100ms to perSecond */
		double RotPerMin = RotPerSec * 60.0;

    System.out.println("RPM (Speed): " + RotPerMin);
    System.out.println("Voltage: " + mshooterLeft.getMotorOutputVoltage());
  }

  public void stop() {
    mshooterLeft.set(0);
  }

  public void leftTurret() {
    turretMotor.set(.1);
  }

  public void rightTurret() {
    turretMotor.set(-.1);
  }

  public void leftTurretStop() {
    turretMotor.set(0);
  }

  public void rightTurretStop() {
    turretMotor.set(0);
  }

}
