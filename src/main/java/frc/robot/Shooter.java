// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

class Shooter extends SubsystemBase{

  WPI_TalonSRX  mShooterLeft = new WPI_TalonSRX(12);
  WPI_TalonSRX  mShooterRight  = new WPI_TalonSRX(14);
  SpeedControllerGroup shootingMotors = new SpeedControllerGroup(mShooterLeft, mShooterRight);

  public void spin() {
    shootingMotors.set(.7);
  }

  public void stop() {
    shootingMotors.set(0);
  }

}

class ShooterRun extends SubsystemBase{

}
