// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import static frc.robot.Constants.*;



public class Balayeuse extends SubsystemBase {
  private WPI_TalonSRX m_Tourneshaft = new WPI_TalonSRX(kShaftBalayeuse);
  private DoubleSolenoid  m_pourstart = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, kBalayeusePistonhaut, kBalayeusePistonbas);
  /** Creates a new baleeuse. */
  public void tourneshaft(double vitesse) {
    m_Tourneshaft.set (ControlMode.PercentOutput, vitesse);
  }
  public void monter() {
    m_pourstart.set(Value.kReverse);
    
  }
  public void decendre() {
    m_pourstart.set(Value.kForward);

  }
  public Balayeuse() {
    monter();
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
