package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;




public class Intake extends SubsystemBase {

    int PCM1 = 0;

    WPI_TalonSRX intakeMotor = new WPI_TalonSRX(11);

    DoubleSolenoid intakeSol = new DoubleSolenoid(PCM1, 6, 1);


    public void intakeIn() {
        intakeMotor.set(0);
        intakeSol.set(Value.kForward);
    }

    public void intakeOut() {
        intakeMotor.set(.5);
        intakeSol.set(Value.kReverse);
    }

    
}
