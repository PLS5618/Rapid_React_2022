// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import static frc.robot.Constants.*;


import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Accumulateur extends SubsystemBase {

  /** Creates a new Accumulateur. */
  private TalonSRX m_shaftavant = new TalonSRX(kAccumulateurShaftAv);
  private TalonSRX m_shaftarriere = new TalonSRX(kAccumulateurShaftAr);
  private DigitalInput m_limitswitchavantG = new DigitalInput(kAccumulateurBallonAv);
  private DigitalInput m_limitswitcharriereG = new DigitalInput(kAccumulateurBallonAr);
  private DigitalInput m_limitswitchavantD = new DigitalInput();
  private DigitalInput m_limitswitcharriereD = new DigitalInput();
  public void tournerAvant(double vitesse) {
    m_shaftavant.set (ControlMode.PercentOutput, vitesse);
  }
  public void tournerArriere(double vitesse) {
    m_shaftarriere.set (ControlMode.PercentOutput,vitesse);
  }
  public boolean ballonAvant(){
   return m_limitswitchavant.get();
  } 
  public boolean ballonArriere(){
    return m_limitswitcharriere.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
