package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  //CHECKSTYLE:OFF
  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(8));
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(2));
  //CHECKSTYLE:ON

  public Drivetrain() {
    rightMotors.setInverted(true);
  }

  public void tankDrive(double yAxis, double yAxis2) {
    leftMotors.set(yAxis);
    rightMotors.set(yAxis2);
  }
}
