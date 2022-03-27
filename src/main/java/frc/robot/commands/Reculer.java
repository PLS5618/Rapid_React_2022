// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class Reculer extends CommandBase {

  private DriveTrain m_driveTrain;

 
  public Reculer(DriveTrain driveTrain) {
    m_driveTrain = driveTrain;
  addRequirements(m_driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveTrain.Reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.Drive(SmartDashboard.getNumber("vitesse auto", -0.3), 0);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.Drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_driveTrain.Distance() < SmartDashboard.getNumber("Distance auto", 0);
  }
}
