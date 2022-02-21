// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevateur extends SubsystemBase {
  /** Creates a new elevateur. */
  private AnalogPotentiometer potentiometreDroit = new AnalogPotentiometer(0);
  private AnalogPotentiometer potentiometreGauche = new AnalogPotentiometer(0);
  //moteur
  private CANSparkMax m_mat1 = new CANSparkMax(0, MotorType.brushless);
private DigitalInput m_limit1 = new DigitalInput(0);
private DigitalInput m_limit2 = new DigitalInput(0);
private DigitalInput m_limit3 = new DigitalInput(0);
private DigitalInput m_limit4 = new DigitalInput(0);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
