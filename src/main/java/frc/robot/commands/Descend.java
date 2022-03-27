// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevateur;


public class Descend extends CommandBase {

  private Elevateur m_elevateur; 

  /** Creates a new Descend. */
  public Descend(Elevateur elevateur) {
    m_elevateur=elevateur;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevateur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!m_elevateur.bas())
      m_elevateur.monteDescendre(SmartDashboard.getNumber("Force Descendre", -0.2));
    else 
      m_elevateur.monteDescendre(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevateur.monteDescendre(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
