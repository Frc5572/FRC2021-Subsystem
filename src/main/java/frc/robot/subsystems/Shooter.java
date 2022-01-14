// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
  

public class Shooter extends SubsystemBase {
    private final WPI_TalonSRX  mShooterLeft = new WPI_TalonSRX(12);
    private final WPI_TalonSRX  mShooterRight  = new WPI_TalonSRX(14);
    private final SpeedControllerGroup shootingMotors = new SpeedControllerGroup(mShooterLeft, mShooterRight);
    private final CANSparkMax m_turretMotor = new CANSparkMax(13, MotorType.kBrushless);

    public void spin() {
      shootingMotors.set(.7);
      }

    public void stop() {
      shootingMotors.set(0);
      }
    public void leftTurret() {
      m_turretMotor.set(.1);
      }
  
    public void rightTurret() {
      m_turretMotor.set(-.1);
      }
    public void leftTurretStop() {
      m_turretMotor.set(0);
      }
    
    public void rightTurretStop() {
      m_turretMotor.set(0);
      }
    
}
