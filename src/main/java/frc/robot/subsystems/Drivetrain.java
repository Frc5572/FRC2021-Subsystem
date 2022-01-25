package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends SubsystemBase {
  private final MotorControllerGroup leftMotors =
    new MotorControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(8));
  private final MotorControllerGroup rightMotors =
    new MotorControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(2));
  private final Encoder leftEncoder =
    new Encoder(4, 8);
  private final Encoder rightEncoder =
    new Encoder(3, 2);

  public Drivetrain() {
    rightMotors.setInverted(true);

    leftEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);
    rightEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);

  }

  public void tankDrive(double yAxis, double yAxis2) {
    leftMotors.set(yAxis);
    rightMotors.set(yAxis2);
  }

  public void moveStraight(double speed) {
    leftMotors.set(speed);
    rightMotors.set(speed);
  }

  public void stop() {
    leftMotors.set(0);
    rightMotors.set(0);
  }
}
