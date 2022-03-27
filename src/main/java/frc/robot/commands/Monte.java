// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevateur;

public class Monte extends CommandBase {
  public enum Barre{
    kBarre1, kBarre2
  }
  private Elevateur m_elevateur; 
  private Barre m_barre;

  /** Creates a new Reculer. */
  public Monte(Elevateur elevateur, Barre barre) {
    m_elevateur=elevateur;
    m_barre = barre;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevateur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double hauteur = 0;
    if(m_barre == Barre.kBarre1)
      hauteur = SmartDashboard.getNumber("position barre1", 0);
    else if (m_barre == Barre.kBarre2)
      hauteur = SmartDashboard.getNumber("position barre2", 0);

    if(m_elevateur.hauteurd() <= hauteur && !m_elevateur.hautd()) 
      m_elevateur.monteDescendredroit(SmartDashboard.getNumber("Force Monter gauche", 0.1));
    else 
      m_elevateur.monteDescendredroit(0);
    
    if (m_elevateur.hauteurg() <= hauteur && !m_elevateur.hautg())
      m_elevateur.monteDescendregauche(SmartDashboard.getNumber("Force Monter droit", 0.1));
    else
      m_elevateur.monteDescendregauche(0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevateur.monteDescendredroit(0);
    m_elevateur.monteDescendregauche(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double hauteur = 0;
    if(m_barre == Barre.kBarre1)
      hauteur = SmartDashboard.getNumber("position barre1", 0);
    else if (m_barre == Barre.kBarre2)
      hauteur = SmartDashboard.getNumber("position barre2", 0);
    return (m_elevateur.hautd() || m_elevateur.hauteurd() > hauteur) && (m_elevateur.hautg() || m_elevateur.hauteurg() > hauteur);
  }
}
