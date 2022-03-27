// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Accumulateur;
import frc.robot.subsystems.Lanceur;




public class Lancer extends CommandBase {
  private Lanceur m_lanceur;
  private Accumulateur m_accumulateur;
  /** Creates a new lanceur. */
  public Lancer(Lanceur lanceur, Accumulateur accumulateur){
   
    // Use addRequirements() here to declare subsystem dependencies.
    m_lanceur = lanceur;
    m_accumulateur = accumulateur;
    addRequirements(m_lanceur, m_accumulateur);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_lanceur.setPID(0.25, 0.001, 20);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double vitesse = SmartDashboard.getNumber("Force Lanceur", 1000);
    m_lanceur.lancer(vitesse);
    if (m_lanceur.Vitesse() > vitesse - 500) {
      m_accumulateur.tournerAvant();
      m_accumulateur.tournerArriere();
    } else {
      m_accumulateur.stop();
    }
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lanceur.stop();
    m_accumulateur.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
