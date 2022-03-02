// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Accumulateur;

public class Aspirer extends CommandBase {
  Accumulateur m_accumulateur;
  /** Creates a new Aspirer. */
  public Aspirer(Accumulateur accumulateur) {
    accumulateur = m_accumulateur;
    addRequirements(accumulateur);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_accumulateur.ballonAvant()&& m_accumulateur.ballonArriere()) {

    }
    if (!m_accumulateur.ballonAvant()&& !m_accumulateur.ballonArriere()) {
      m_accumulateur.tournerAvant(0.5);
      m_accumulateur.tournerArriere(0.5);
      
    }
    if (m_accumulateur.ballonAvant()&& !m_accumulateur.ballonArriere()) {
      m_accumulateur.tournerAvant(0.5);
      m_accumulateur.tournerAvant(0.5);
      
    }
    if (!m_accumulateur.ballonAvant()&& m_accumulateur.ballonArriere()) {
      m_accumulateur.tournerAvant(0.5);
      
    }
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