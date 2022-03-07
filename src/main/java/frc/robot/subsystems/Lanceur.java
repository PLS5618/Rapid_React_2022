// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lanceur extends SubsystemBase {
  private TalonSRX m_Lancer1 = new TalonSRX(kLancer1);
  private TalonSRX m_Lancer2 = new TalonSRX(kLancer2);
  /** Creates a new lanceur. */
  public void lancer(double vitesse ){
    m_Lancer1.set (ControlMode.PercentOutput, vitesse);
    m_Lancer2.set (ControlMode.PercentOutput, vitesse);
     
  }
  public Lanceur() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
