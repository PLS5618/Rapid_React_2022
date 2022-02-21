// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Accumulateur extends SubsystemBase {
  private
  /** Creates a new Accumulateur. */
  private CANSparkMax m_shaftavant = new CANSparkMax(0, MotorType.kBrushless);
  private CANSparkMax m_shaftarriere = new CANSparkMax (0, MotorType.kBrushless);
  
  

  {
    
  }
    {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
