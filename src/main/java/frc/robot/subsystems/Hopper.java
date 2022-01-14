// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


/**
 *
 */
public class Hopper extends SubsystemBase {

  final SpeedControllerGroup hopper = new SpeedControllerGroup(new WPI_TalonSRX(9), new WPI_TalonSRX(10));

    public Hopper() {
        // Intializing Motors & Objects
        WPI_TalonSRX m_hopperLeft = new WPI_TalonSRX(9);
        WPI_TalonSRX m_hopperRight = new WPI_TalonSRX(10);


        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public void start() {
      hopper.set(.5);

    }

    public void stop() {
      hopper.set(0);
    }


}
