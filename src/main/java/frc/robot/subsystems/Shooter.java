// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;

/**
 * This creats a class that makes a function for the shooter and for the turret.
 */
public class Shooter extends PIDSubsystem {
  private final WPI_TalonFX  mshooterLeft = new WPI_TalonFX(12);
  private final WPI_TalonFX  mshooterRight  = new WPI_TalonFX(14);
  private final MotorControllerGroup shootingMotors =
      new MotorControllerGroup(mshooterLeft, mshooterRight);
  private final CANSparkMax turretMotor =
      new CANSparkMax(13, MotorType.kBrushless);
  private final SimpleMotorFeedforward shooterFeed =
      new SimpleMotorFeedforward(
          Constants.kSVolts, Constants.kVVoltSecondsPerRotation);

  public Shooter(){
    mshooterLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_PRIMARY, Constants.kTimeoutMs);
    mshooterRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.)
    super(new PIDController(Constants.kP, Constants.kI, Constants.kD));
    getController().setTolerance(Constants.kShooterToleranceRPS);
    shooterEncoders.setDistancePerPulse(Constants.kEncoderDistancePerPulse);
    setSetpoint(Constants.kShooterTargetRPS);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    mshooterLeft.setVoltage(output + shooterFeed.calculate(setpoint));
  }

  @Override
  public double getMeasurement() {
    return shooterEncoders.getRate();
  }

  public boolean atSetpoint() {
    return m_controller.atSetpoint();
  }

  public void spin() {
    // shootingMotors.set(.7);
    double selSenVel = mshooterLeft.getSelectedSensorVelocity(0);

    double RotPerSec = (double) selSenVel / Constants.kUnitsPerRevolution * 10; /* scale per100ms to perSecond */
		double RotPerMin = RotPerSec * 60.0;

    System.out.println("Vel-RPM: " + RotPerMin);
  }

  public void stop() {
    shootingMotors.set(0);
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
