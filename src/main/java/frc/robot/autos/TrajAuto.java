package frc.robot.autos;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

import java.util.List;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;

/**
* Trajectory Autonomous file.
*/

public class TrajAuto extends SequentialCommandGroup{
  public TrajAuto(Drivetrain drive){
    System.out.println("Trajectory Autonomous");
    TrajectoryConfig config = new TrajectoryConfig(Constants.maxSpeed, Constants.maxAngularVelocity);

    Trajectory moveFoward = TrajectoryGenerator.generateTrajectory(
    new Pose2d(0, 0, new Rotation2d(0)),
    List.of(new Translation2d(1, 0)),
    new Pose2d(1, .3, new Rotation2d(0)),
    config);
  }
}
