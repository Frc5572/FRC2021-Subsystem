// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.subsystems.Vision;
import edu.wpi.first.wpilibj.Servo;



public class Turret extends SubsystemBase {
  private final CANSparkMax turretMotor = new CANSparkMax(13, MotorType.kBrushless);
  private Vision vision = new Vision();
  Servo servos = new Servo(1);
  Servo smartServo = new Servo(0);

    public void leftTurret() {
      // turretMotor.set(-.1);
      smartServo.set(2);
    }
      
    public void rightTurret() {
      turretMotor.set(.1);
    }
    public void align(){
      System.out.println(vision.getDistance());
      turretMotor.set(-vision.getAimValue() / 2);
      servos.set(-vision.getServoValues());
      // smartServo.set(-vision.getServoValues());
      System.out.println(vision.getServoValues());
    }
    public void zerServos(){
      servos.set(0);
    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}