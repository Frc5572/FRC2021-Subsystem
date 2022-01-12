package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class IntakeRun extends CommandBase {

  private final Intake intake;
  
  public IntakeRun(Intake subsystem){
   

    intake = subsystem;

    
    addRequirements(intake);

  }

  public void intakeOut(){
    intake.intakeOut();
  }

  public void intakeIn(){
    intake.intakeIn();
  }

  

}
