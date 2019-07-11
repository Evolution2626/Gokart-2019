/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.commands.DrivetrainSetShiftersCommand;
import frc.util.VolantPedaleController;

/**
 * Add your docs here.
 */
public class OI {

    public VolantPedaleController volantPedale = new VolantPedaleController();
    public OI(){
        volantPedale.getShifterDroit().whenPressed(new DrivetrainSetShiftersCommand(Value.kForward));
        volantPedale.getShifterGauche().whenPressed(new DrivetrainSetShiftersCommand(Value.kReverse));
    }
}
