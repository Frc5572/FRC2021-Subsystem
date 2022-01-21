package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final MotorControllerGroup leftMotors =
      new MotorControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(8));
  private final MotorControllerGroup rightMotors =
      new MotorControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(2));

  public Drivetrain() {
    rightMotors.setInverted(true);
  }

  public void tankDrive(double yAxis, double yAxis2) {
    leftMotors.set(yAxis);
    rightMotors.set(yAxis2);
  }
}
