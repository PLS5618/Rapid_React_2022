// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Balayeuse;

public class MonteBalayeuse extends InstantCommand {

  private Balayeuse m_balayeuse;

  /** Creates a new MonteBalayeuse. */
  public MonteBalayeuse(Balayeuse balayeuse) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_balayeuse = balayeuse;
    addRequirements(m_balayeuse);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_balayeuse.monter();
  }

}
