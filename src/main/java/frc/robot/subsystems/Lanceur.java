// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lanceur extends SubsystemBase {
  private TalonSRX m_LancerBallon1 = new TalonSRX(kLancer1);
  private TalonSRX m_LancerBallon2 = new TalonSRX(kLancer2);
  /** Creates a new lanceur. */
  public void lancer(double vitesse ){
    m_LancerBallon1.set (ControlMode.Velocity, vitesse);
    
     
  }

  public void setPID(double p, double i, double d){
    m_LancerBallon1.config_kP(0, p);
    m_LancerBallon1.config_kI(0, i);
    m_LancerBallon1.config_kD(0, d);
    
  }

  public Lanceur() {
    m_LancerBallon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    m_LancerBallon2.follow(m_LancerBallon1);
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }
}
