// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


/**
 *
 */
public class Hopper extends SubsystemBase {

  int pcm1 = 0;
  int pcm2 = 1;
  final SpeedControllerGroup hopper = new SpeedControllerGroup(new WPI_TalonSRX(9), new WPI_TalonSRX(10));
  DoubleSolenoid hopperSol = new DoubleSolenoid(pcm1, 5, 2);


    public Hopper() {
        // Intializing Motors & Object
    }

    public void up() {
      hopper.set(.5);
      hopperSol.set(Value.kForward);

    }
    public void down() {
      hopper.set(-.5);

    }
    public void stop() {
      hopper.set(0);
      hopperSol.set(Value.kReverse);
    }


}