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
    m_elevateur.monteDescendre(SmartDashboard.getNumber("Force Monter", 0.5));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevateur.monteDescendre(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double hauteur = 0;
    if(m_barre == Barre.kBarre1)
      hauteur = SmartDashboard.getNumber("position barre1", 0);
    else if (m_barre == Barre.kBarre2)
      hauteur = SmartDashboard.getNumber("position barre2", 0);
    return m_elevateur.haut() || m_elevateur.hauteur() > hauteur;
  }
}
