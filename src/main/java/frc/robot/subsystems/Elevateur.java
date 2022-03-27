// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Elevateur extends SubsystemBase {
  /** Creates a new elevateur. */
  // potentiometre
  private AnalogPotentiometer potentiometreDroit = new AnalogPotentiometer(kElevateurPotentiometreD);
  private AnalogPotentiometer potentiometreGauche = new AnalogPotentiometer(kElevateurPotentiometreG);
  // moteur
  private CANSparkMax m_matd = new CANSparkMax(kElevateurMoteurd, MotorType.kBrushless);
  private CANSparkMax m_matg = new CANSparkMax(kElevateurMoteurg, MotorType.kBrushless);
  
  // Limit Switch
  private DigitalInput m_limithautd = new DigitalInput(kElevateurlimithautd);
  private DigitalInput m_limithautg = new DigitalInput(kElevateurlimithautg);
  private DigitalInput m_limitbasd = new DigitalInput(kElevateurlimitbasd);
  private DigitalInput m_limitbasg = new DigitalInput(kElevateurlimitbasg);
  
  // function
  public void monteDescendredroit(double vitesse) {
    m_matd.set (vitesse);
  }
  public void monteDescendregauche(double vitesse) {
    m_matg.set (vitesse);
  }
  public boolean hautd(){
    return m_limithautd.get();
  }
  
  public boolean hautg(){
    return m_limithautg.get();
  }

  public boolean basd(){
    return m_limitbasd.get();
  }
  public boolean basg(){
    return m_limitbasg.get();
  }
  public double hauteurg(){
    return m_matg.getEncoder().getPosition();
  }
  public double hauteurd(){
    return m_matd.getEncoder().getPosition();
  }

  public void resetEncodeurd() {
    m_matd.getEncoder().setPosition(0);
  }
  public void resetEncodeurg() {
    m_matg.getEncoder().setPosition(0);
  }


  @Override
  public void periodic() {
    SmartDashboard.putBoolean("limithautd", m_limithautd.get());
    SmartDashboard.putBoolean("limithautg", m_limithautg.get());
    SmartDashboard.putBoolean("limitbasd", m_limitbasd.get());
    SmartDashboard.putBoolean("limitbasg", m_limitbasg.get());
    SmartDashboard.putNumber("hauteur elevateur gauche", hauteurg());
    SmartDashboard.putNumber("hauteur elevateur droit", hauteurd());
    if (basd()) {
      resetEncodeurd();
      
    }
    if (basg()) {
      resetEncodeurg();
    }
    // This method will be called once per scheduler run
  }
}
