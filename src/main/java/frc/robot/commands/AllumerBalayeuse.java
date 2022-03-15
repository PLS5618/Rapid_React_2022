// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AllumerBalayeuse extends CommandBase {
  private BalayeuseTourner balayeusetourner;
  /** Creates a new AllumerBalaeuse. */
  public AllumerBalayeuse(BalayeuseTourner balayeuseTourner) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_balayeusetourner = balayeusetourner;
    addRequirements( m_balayeusetourner);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
