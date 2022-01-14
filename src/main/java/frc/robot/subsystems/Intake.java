package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
/*YES
MAYBE
NO */
public class Intake extends SubsystemBase {

  int pcm1 = 0;

  WPI_TalonSRX intakeMotor = new WPI_TalonSRX(11);

  DoubleSolenoid intakeSol = new DoubleSolenoid(pcm1, 6, 1);

  public void intakeIn() {
    intakeMotor.set(0);
    intakeSol.set(Value.kForward);
  }

  public void intakeOut() {
    intakeMotor.set(.5);
    intakeSol.set(Value.kReverse);
  }
}
