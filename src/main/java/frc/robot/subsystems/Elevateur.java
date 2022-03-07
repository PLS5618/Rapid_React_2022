// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Elevateur extends SubsystemBase {
  /** Creates a new elevateur. */
  // potentiometre
  private AnalogPotentiometer potentiometreDroit = new AnalogPotentiometer(kElevateurPotentiometreD);
  private AnalogPotentiometer potentiometreGauche = new AnalogPotentiometer(kElevateurPotentiometreG);
  // moteur
  private CANSparkMax m_mat1 = new CANSparkMax(kElevateurMoteur1, MotorType.kBrushless);
  private CANSparkMax m_mat2 = new CANSparkMax(kElevateurMoteur2, MotorType.kBrushless);
  
  // Limit Switch
  private DigitalInput m_limithautd = new DigitalInput(kElevateurlimithautd);
  private DigitalInput m_limithautg = new DigitalInput(kElevateurlimithautg);
  private DigitalInput m_limitbasd = new DigitalInput(kElevateurlimitbasd);
  private DigitalInput m_limitbasg = new DigitalInput(kElevateurlimitbasg);
  
  // function
  public void monteDescendre(double vitesse) {
    m_mat1.set (vitesse);
    m_mat2.set (vitesse);
  }
  public boolean haut(){
    return m_limithautd.get() ||  m_limithautg.get();
  }

  public boolean bas(){
    return m_limitbasd.get() || m_limitbasg.get();
  }
  public double hateur(){
  return (potentiometreDroit.get () + potentiometreGauche.get())/2;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
