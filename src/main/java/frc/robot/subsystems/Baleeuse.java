// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
public class Baleeuse extends SubsystemBase {
  private CANSparkMax m_Tourneshaft = new CANSparkMax(0, MotorType.kBrushless);
   final DoubleSolenoid  m_pourstartdroit = new DoubleSolenoid(1, 2);
   final DoubleSolenoid  m_pourstartgauche = new DoubleSolenoid(3, 4);
  /** Creates a new baleeuse. */
  public Baleeuse() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
