// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevateur;

public class Monte extends CommandBase {

  private Elevateur m_elevateur; 

  /** Creates a new Reculer. */
  public Monte(Elevateur elevateur) {
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
    m_elevateur.monteDescendre(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_elevateur.haut();
  }
}