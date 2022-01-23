package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends SubsystemBase {
  private final SpeedControllerGroup leftMotors =
    new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(8));
  private final SpeedControllerGroup rightMotors =
    new SpeedControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(2));
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
}
