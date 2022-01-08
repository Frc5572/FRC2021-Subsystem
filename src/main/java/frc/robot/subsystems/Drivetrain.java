package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import static java.lang.Math.abs;
import edu.wpi.first.wpilibj.geometry.Translation2d;


public class Drivetrain extends SubsystemBase {
    private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(8));
    private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(new WPI_TalonSRX(3), new WPI_TalonSRX(2));

    public Drivetrain() {
        rightMotors.setInverted(true);
    }

    public void tankDrive(double yAxis) {
        leftMotors.set(yAxis);
        rightMotors.set(yAxis);

    }

}
