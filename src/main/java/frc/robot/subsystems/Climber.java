package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
* Returns a Climber object that runs the motors and pistons.
*/
public class Climber extends SubsystemBase {
  int pcm1 = 0;
  int pcm2 = 1;

  private final DoubleSolenoid climberSol1 = new DoubleSolenoid(pcm2, 4, 3);
  private final DoubleSolenoid climberSol2 = new DoubleSolenoid(pcm1, 7, 0);
  private final CANSparkMax climber1 = new CANSparkMax(16, MotorType.kBrushless);
  private final CANSparkMax climber2 = new CANSparkMax(15, MotorType.kBrushless);
  private final SpeedControllerGroup climberMotors =
      new SpeedControllerGroup(climber1, climber2);

  public Climber() {
    climber1.setInverted(true);
  }

  public void initialize() {
    climberSol1.set(Value.kReverse);
    climberSol2.set(Value.kReverse);
  }

  public void deployClimber() {
    climberSol2.set(Value.kForward);
    climberSol1.set(Value.kForward);
  }

  public void engageClimber() {
    climberMotors.set(.6);
  }

  public void disengageClimber() {
    climberMotors.set(0);
  }
}
