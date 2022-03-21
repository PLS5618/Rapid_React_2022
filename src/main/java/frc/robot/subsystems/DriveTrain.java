// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  private CANSparkMax m_avantdroit = new CANSparkMax(kDriveTrainAvDr, MotorType.kBrushless);
  private CANSparkMax m_avantgauche = new CANSparkMax(kDriveTrainAvGa, MotorType.kBrushless);
  private CANSparkMax m_arrieredroit = new CANSparkMax(kDriveTrainArDr, MotorType.kBrushless);
  private CANSparkMax m_arrieregauche = new CANSparkMax(kDriveTrainArGa, MotorType.kBrushless);

  private MotorControllerGroup m_droit = new MotorControllerGroup(m_avantdroit, m_arrieredroit);
  private MotorControllerGroup m_gauche = new MotorControllerGroup(m_avantgauche, m_arrieregauche);

  private DifferentialDrive m_drive = new DifferentialDrive(m_gauche, m_droit);

  public void Drive(double xSpeed, double zRotation) {
    m_drive.arcadeDrive(xSpeed, zRotation);
  }

  public double Distance() {
    return (m_avantdroit.getEncoder().getPosition()
    + m_avantgauche.getEncoder().getPosition()
    + m_arrieredroit.getEncoder().getPosition()
    + m_arrieregauche.getEncoder().getPosition()) / 4;
  } 

  public void Reset() {
    m_avantgauche.getEncoder().setPosition(0);
    m_avantdroit.getEncoder().setPosition(0);
    m_arrieregauche.getEncoder().setPosition(0);
    m_arrieredroit.getEncoder().setPosition(0);
  }

  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Distance", 0.5);
    // This method will be called once per scheduler run
  }




}
