/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  public TalonSRX avantDroit;
  public TalonSRX avantGauche;
  public VictorSP arriereDroit;
  public VictorSP arriereGauche;

  public Drivetrain(){


    avantDroit = new TalonSRX(RobotMap.MOTEUR_AVANT_DROIT);
    avantGauche = new TalonSRX(RobotMap.MOTEUR_AVANT_GAUCHE);
    arriereDroit = new VictorSP(RobotMap.MOTEUR_ARRIERE_DROIT);
    arriereGauche = new VictorSP(RobotMap.MOTEUR_ARRIERE_GAUCHE);

    avantDroit.setInverted(false);
    avantGauche.setInverted(false);
    arriereDroit.setInverted(false);
    arriereGauche.setInverted(false);

  }

  public void driveTank(double gauche, double droite){
    avantDroit.set(ControlMode.PercentOutput, droite);
    avantGauche.set(ControlMode.PercentOutput, gauche);
    arriereDroit.set(droite);
    arriereGauche.set(gauche);
  }

  public void drivePedaleVolant(double vitesse, double rotation){
    if (rotation > 0){
      driveTank(vitesse, vitesse - rotation);
    }else{
      driveTank(vitesse + rotation, vitesse);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
