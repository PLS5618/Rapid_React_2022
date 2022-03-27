// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.*;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Accumulateur extends SubsystemBase {

  /** Creates a new Accumulateur. */
  private WPI_TalonSRX m_shaftavant = new WPI_TalonSRX(kAccumulateurShaftAv);
  private WPI_TalonSRX m_shaftarriere = new WPI_TalonSRX(kAccumulateurShaftAr);
  private DigitalInput m_limitswitchavant = new DigitalInput(kAccumulateurBallonAv);
  private DigitalInput m_limitswitcharriere = new DigitalInput(kAccumulateurBallonAr);


  public void tournerAvant() {
    double spd = SmartDashboard.getNumber("Ballon qui rentre", 0.5);
    m_shaftavant.set(spd);
  }

  public void stopAvant() {
    m_shaftavant.set(0);
  }

  public void tournerArriere() {
    double spd = SmartDashboard.getNumber("Ballon qui rentre", 0.5);
    m_shaftarriere.set(spd);
  }

  public void stopArriere() {
    m_shaftarriere.set(0);
  }

  public boolean ballonAvant(){
   return !m_limitswitchavant.get();
  } 
  public boolean ballonArriere(){
    return !m_limitswitcharriere.get();
  }

  public void stop() {
    m_shaftarriere.set(ControlMode.PercentOutput, 0);
    m_shaftavant.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    SmartDashboard.putBoolean("ballonAvant", ballonAvant());
    SmartDashboard.putBoolean("ballonArriere", ballonArriere());
    // This method will be called once per scheduler run
  }
}