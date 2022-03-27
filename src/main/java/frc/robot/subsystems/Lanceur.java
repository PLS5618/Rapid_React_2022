// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lanceur extends SubsystemBase {
  private WPI_TalonSRX m_LancerBallon1 = new WPI_TalonSRX(kLancer1);
  private WPI_TalonSRX m_LancerBallon2 = new WPI_TalonSRX(kLancer2);
  /** Creates a new lanceur. */
  public void lancer(double vitesse ){
    m_LancerBallon1.set (ControlMode.Velocity, vitesse); 
  }

  public void stop() {
    m_LancerBallon1.set(ControlMode.PercentOutput, 0);
  }

  public void setPID(double p, double i, double d){
    //m_LancerBallon1.config_kP(0, p);
    //m_LancerBallon1.config_kI(0, i);
    //m_LancerBallon1.config_kD(0, d);
    
  }

  public double Vitesse() {
    return m_LancerBallon1.getSelectedSensorVelocity(0);
  }

  public Lanceur() {
    m_LancerBallon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    m_LancerBallon1.setSensorPhase(true);
    m_LancerBallon1.setInverted(true);
    m_LancerBallon2.setInverted(true);
    m_LancerBallon2.follow(m_LancerBallon1);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("vitesse lanceur", Vitesse());
    // This method will be called once per scheduler run
  }
}
