package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.autos.Auto;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class RobotContainer {
  Joystick driver = new Joystick(0);
  Joystick operator = new Joystick(1);

  private final Drivetrain tankDrive = new Drivetrain();
  private TreeMap<String, Command> autos = new TreeMap<String, Command>();
  private ArrayList<String> autoNames;
  private int cA1 = 0;
  private int lengthOfList;

  public RobotContainer() {
    tankDrive.setDefaultCommand(new TeleOPDrive(tankDrive, driver));
  }

  public Command getAutonomousCommand() {
    return autos.get(autoNames.get(cA1));
  }
}
