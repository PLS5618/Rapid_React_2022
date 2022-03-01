// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import static frc.robot.Constants.*;



public class Balayeuse extends SubsystemBase {
private TalonSRX m_Tourneshaft = new TalonSRX(kShaftBalayeuse);
   private DoubleSolenoid  m_pourstartdroit = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kBalayeusePiston1, kBalayeusePiston2);
   private DoubleSolenoid  m_pourstartgauche = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kBalayeusePiston3, kBalayeusePiston4);
  /** Creates a new baleeuse. */
  public void tourneshaft(double vitesse) {
    m_Tourneshaft.set (ControlMode.PercentOutput, vitesse);
  }
  public void monter() {
    m_pourstartdroit.set(Value.kReverse);
    m_pourstartgauche.set(Value.kReverse);
    
  }
  public void decendre() {
    m_pourstartdroit.set(Value.kForward);
    m_pourstartgauche.set(Value.kForward);
  }
  public Balayeuse() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
