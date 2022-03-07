// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;



public class Lancer extends CommandBase {
  private Lancer m_lancer;
  /** Creates a new lanceur. */
  public Lancer(Lancer lanceur) {
   
    // Use addRequirements() here to declare subsystem dependencies.
    m_lancer = lanceur;
    addRequirements(m_lancer);
  }
  
  private void addRequirements(Lancer m_lancer2) {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lancer.LancerBallon1(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
