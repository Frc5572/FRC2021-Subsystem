package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Climber extends SubsystemBase {
    int PCM1 = 0;
    int PCM2 = 1;

    private final DoubleSolenoid climberSol1 = new DoubleSolenoid(PCM2, 4, 3);
    private final DoubleSolenoid climberSol2 = new DoubleSolenoid(PCM1, 7, 0);
    private final CANSparkMax m_Climber1 = new CANSparkMax(16, MotorType.kBrushless);
    private final CANSparkMax m_Climber2 = new CANSparkMax(15, MotorType.kBrushless);
    private final Compressor compressor = new Compressor();

    public Climber() {
        compressor.setClosedLoopControl(true);
        compressor.start();
        climberSol1.set(Value.kReverse);
        climberSol2.set(Value.kReverse);
        m_Climber1.setInverted(true);
    }

    public void climb(){
        climberSol2.set(Value.kForward);
        climberSol1.set(Value.kForward);
    }
}
