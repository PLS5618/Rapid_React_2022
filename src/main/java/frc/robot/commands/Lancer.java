// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lanceur;




public class Lancer extends CommandBase {
  private Lanceur m_lanceur;
  /** Creates a new lanceur. */
  public Lancer(Lanceur lanceur) {
   
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
    m_lanceur.lancer(SmartDashboard.getNumber("Force Lanceur", 0.5));
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
