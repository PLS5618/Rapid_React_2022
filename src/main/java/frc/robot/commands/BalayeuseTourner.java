// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Balayeuse;

public class BalayeuseTourner extends CommandBase {

  private Balayeuse m_balayeuse;

  /** Creates a new BalayeuseTourner. */
  public BalayeuseTourner(Balayeuse balayeuse) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_balayeuse = balayeuse;
    addRequirements(m_balayeuse);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_balayeuse.tourneshaft(SmartDashboard.getNumber("Shaft Tourne", 0.5));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_balayeuse.tourneshaft(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
