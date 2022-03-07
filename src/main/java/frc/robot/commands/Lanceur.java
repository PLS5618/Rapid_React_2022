// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;



public class Lanceur extends CommandBase {
  private Lancer m_Lancer;
  /** Creates a new lanceur. */
  public Lanceur(Lanceur lanceur) {
   
    // Use addRequirements() here to declare subsystem dependencies.
    m_lanceur = lanceur;
    addRequirements(m_lanceur);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lanceur.lancer1(0.5);
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
