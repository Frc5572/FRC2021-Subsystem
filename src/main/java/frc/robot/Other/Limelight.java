// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Other;

import frc.robot.subsystems.Drivetrain;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.VisionManager;
/** Add your docs here. */
public class Limelight{
    
    CANSparkMax turretMotor =
    new CANSparkMax(13, MotorType.kBrushless);

    Servo servos = new Servo(1);

   
    VisionManager VisionManager = new VisionManager();
    Constants Constants = new Constants();
    private final Drivetrain Drivetrain = new Drivetrain();

    public void AutoAim(){
        

        double s = (VisionManager.Update()/125) - (Drivetrain.l/90) + (Drivetrain.r/90);

        turretMotor.set(s);
    }
    

    
    public void PositionHood(){
        double sShort = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(1);
        double sLong = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(1);
        double os = SmartDashboard.getNumber("Hood Angle Adjust", Constants.hoodOffset);
        double area = sLong * sShort;
        System.out.println(Constants.CalculateDistance(area) + "inches\n");
        double a1 = java.lang.Math.atan2(Constants.heightdiff, Constants.CalculateDistance(area)) * (180/Constants.pi);
        double a2 = 90 - a1 - os;
        double p = (1 / (Constants.maxAngle - Constants.minAngle))*(a2-Constants.maxAngle) + 1;
        if (p >= .7) {
            p = .7;
        }
        servos.set(p);
        }
    

}

