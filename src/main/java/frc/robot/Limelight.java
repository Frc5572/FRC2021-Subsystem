// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import java.sql.Driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import java.lang.Math;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/** Add your docs here. */
public class Limelight{
    WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(4);
    WPI_TalonSRX m_backLeft = new WPI_TalonSRX(8);
    MotorControllerGroup leftDriveMotors = new MotorControllerGroup(m_frontLeft, m_backLeft);

    WPI_TalonSRX m_frontRight = new WPI_TalonSRX(3);
    WPI_TalonSRX m_backRight = new WPI_TalonSRX(2);
    MotorControllerGroup rightDriveMotors = new MotorControllerGroup(m_frontRight, m_backRight);

    CANSparkMax turretMotor =
    new CANSparkMax(13, MotorType.kBrushless);

    Servo servos = new Servo(1);

    final double x1 = -0.0000000025291;
    final double x2 = 0.0000334240538;
    final double x3 = -0.1545379987062;
    final double b = 315.5170993015826;
    final double heightOfShooter = 38;
    final double heightOfTower = 98;
    final double heightdiff = heightOfTower - heightOfShooter;
    final double minAngle = 25;
    final double maxAngle = 65;
    final double maxPosition = 0;
    final double minPosition = 1;
    final double m1 = -(maxPosition - minPosition) / (maxAngle - minAngle);
    final double b1 = -.625;
    final double limitTurret = 20;
    final double limitServo = .7;
    final double hoodOffset = 30;
    final double pi = 3.14159265358979323846;
    VisionManager VisionManager = new VisionManager();

    private final Drivetrain tankDrive = new Drivetrain();

    public void AutoAim(){
        double l = leftDriveMotors.get();
        
        double r = rightDriveMotors.get();

        double s = (VisionManager.Update()/125) - (l/90) + (r/90);

        turretMotor.set(s);
    }
    
    double CalculateDistance(double area){
        double r = x1*java.lang.Math.pow(area, 3) + x2*java.lang.Math.pow(area, 2) +x3*area + b;
        return r;
    }
    void PositionHood(){
        double sShort = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(1);
        double sLong = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(1);
        double os = SmartDashboard.getNumber("Hood Angle Adjust", hoodOffset);
        double area = sLong * sShort;
        // std::cout << "Total area: " << area << "\n";
            System.out.println(CalculateDistance(area) + "inches\n");
            double a1 = java.lang.Math.atan2(heightdiff, CalculateDistance(area)) * (180/pi);
            // std::cout << "a1 " << a1 << "\n";
            double a2 = 90 - a1 - os;
            // std::cout << "a2 " << a2 << "\n";
            double p = (1 / (maxAngle - minAngle))*(a2-maxAngle) + 1;
            // std::cout << "servo position" << p << "\n";
            if (p >= .7) {
                p = .7;
            }
            servos.set(p);;
        }
    
        double CalculateAngle(double distance){
            double t = java.lang.Math.atan2(heightdiff , distance);
            double d = t * (180 / pi);
            double corrected_d = (90 - d - 25);
            double r = m1 * corrected_d  + b1;
            if (corrected_d > 64) {
                r = limitServo;
            } else if (corrected_d < 26) {
                r = 0;
            }
            return r;
        }        

}

