// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

/**
 * This creats a class that makes a function for the shooter and for the turret.
 */
public class Shooter extends PIDSubsystem {
  private final WPI_TalonFX  mshooterLeft = new WPI_TalonFX(14);
  // private final WPI_TalonFX  mshooterRight  = new WPI_TalonFX(14);
  // private final MotorControllerGroup shootingMotors =
  //     new MotorControllerGroup(mshooterLeft, mshooterRight);
  private final CANSparkMax turretMotor =
      new CANSparkMax(13, MotorType.kBrushless);
  private final SimpleMotorFeedforward shooterFeed =
      new SimpleMotorFeedforward(
          Constants.kSVolts, Constants.kVVoltSecondsPerRotation);

  public Shooter(){
    super(new PIDController(Constants.kP, Constants.kI, Constants.kD));
    mshooterLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 1, 1);
    getController().setTolerance(Constants.kShooterToleranceRPS);
    setSetpoint(Constants.kShooterTargetRPS);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    mshooterLeft.setVoltage(output + shooterFeed.calculate(setpoint));
  }

  @Override
  public double getMeasurement() {
    return mshooterLeft.getSelectedSensorVelocity();
  }

  @Override
  public void periodic() {
    if (m_enabled) {
      useOutput(m_controller.calculate(getMeasurement(), getSetpoint()), getSetpoint());
      double selSenVel = mshooterLeft.getSelectedSensorVelocity(0);

      double RotPerSec = (double) selSenVel / Constants.kUnitsPerRevolution * 10; /* scale per100ms to perSecond */
		  double RotPerMin = RotPerSec * 60.0;

      System.out.println("RPM (Speed): " + RotPerMin);
      System.out.println("Voltage: " + mshooterLeft.getMotorOutputVoltage());
    }
  }

  public boolean atSetpoint() {
    return m_controller.atSetpoint();
  }

  public void spin() {
    mshooterLeft.set(0.7);
  }

  public void stop() {
    mshooterLeft.set(0);
  }
}
