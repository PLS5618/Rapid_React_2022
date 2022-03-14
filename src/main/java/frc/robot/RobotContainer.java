// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Aspirer;
import frc.robot.commands.BalayeuseTourner;
import frc.robot.commands.ButtonY;
import frc.robot.commands.DecentBalayeuse;
import frc.robot.commands.Descend;
import frc.robot.commands.Lancer;
import frc.robot.commands.Monte;
import frc.robot.commands.MonteBalayeuse;
import frc.robot.subsystems.Accumulateur;
import frc.robot.subsystems.Balayeuse;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevateur;
import frc.robot.subsystems.Lanceur;
import frc.robot.commands.ButtonY;




/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" par adigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer { 
  // The robot's subsystems and commands are defined here...
  private XboxController m_Controller = new XboxController(0);
//subsystems
  private DriveTrain m_DriveTrain = new DriveTrain();
  private Elevateur m_Elevateur = new Elevateur();
  private Lanceur m_Lanceur = new Lanceur();
  private Accumulateur m_Accumulateur = new Accumulateur();
  private Balayeuse m_Balayeuse = new Balayeuse();  
//command
  private Monte m_Monte = new Monte(m_Elevateur);
  private Aspirer m_Aspirer = new Aspirer(m_Accumulateur);
  private BalayeuseTourner m_BalayeuseTourner = new BalayeuseTourner(m_Balayeuse);
  private DecentBalayeuse m_DecentBalayeuse = new DecentBalayeuse(m_Balayeuse);
  private Descend m_Descend = new Descend(m_Elevateur);
  private Lancer m_Lancer = new Lancer(m_Lanceur);
  private MonteBalayeuse m_MonteBalayeuse = new MonteBalayeuse(m_Balayeuse);
  private ButtonY m_ButtonY = new ButtonY(m_Balayeuse, m_Accumulateur);

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_Elevateur.setDefaultCommand(m_Descend);
    

    m_DriveTrain.setDefaultCommand(
      new RunCommand(
        new Runnable() {
          @Override
          public void run() {
            m_DriveTrain.Drive(m_Controller.getLeftY(), m_Controller.getLeftX());
          }
        }, m_DriveTrain)
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    JoystickButton buttonA = new JoystickButton(m_Controller, XboxController.Button.kA.value);
    buttonA.whenPressed(m_Monte);
    JoystickButton buttonB = new JoystickButton(m_Controller, XboxController.Button.kA.value);
    buttonB.whenPressed(m_MonteBalayeuse);
    JoystickButton buttonX = new JoystickButton(m_Controller, XboxController.Button.kA.value);
    buttonX.whenPressed(m_Lancer);
    JoystickButton buttonY = new JoystickButton(m_Controller, XboxController.Button.kA.value);
    buttonY.whenPressed(m_ButtonY);   

  } 

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
