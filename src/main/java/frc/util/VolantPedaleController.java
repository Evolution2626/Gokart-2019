/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.util;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.RobotMap;
import frc.util.VolantPedaleController.ShifterButton.Direction;

/**
 * Add your docs here.
 */
public class VolantPedaleController {
    
    public AnalogInput pedaleAvancer;
    public AnalogInput pedaleReculer;
    public AnalogInput volant;
    public DigitalInput shifterGauche;
    public DigitalInput shifterDroit;
    
    public VolantPedaleController(){

        pedaleAvancer = new AnalogInput(RobotMap.ANALOG.PEDALE_AVANCER);
        pedaleReculer = new AnalogInput(RobotMap.ANALOG.PEDALE_RECULER);
        volant = new AnalogInput(RobotMap.ANALOG.VOLANT);
        shifterDroit = new DigitalInput(RobotMap.DIO.SHIFTER_DROIT_BOUTON);
        shifterGauche = new DigitalInput(RobotMap.DIO.SHIFTER_GAUCHE_BOUTON);

    }

    public int getPedaleAvancerPotentiometre(){
        return pedaleAvancer.getValue();
    }

    public int getPedaleReculerPotentiometre(){
        return pedaleReculer.getValue();
    }

    public int getVolantPotentiometre(){
        return volant.getValue();
    }

    public double getPedaleAvancer(){
        return MathHelper.map(getPedaleAvancerPotentiometre(), 0, 1023, 0, 1);
    }

    public double getPedaleReculer(){
        return MathHelper.map(getPedaleAvancerPotentiometre(), 0, 1023, 0, 1);
    }

    public double getVolant(){
        return MathHelper.map(getVolantPotentiometre(), 0, 1023, -1, 1);
    }

    public double getSpeed(){
        return getPedaleAvancer() - getPedaleReculer();
    }

    public boolean getRawShifterDroit(){
        return shifterDroit.get();
    }

    public boolean getRawShifterGauche(){
        return shifterGauche.get();
    }

    public ShifterButton getShifterDroit(){
        return new ShifterButton(Direction.droite, this);
    }

    public ShifterButton getShifterGauche(){
        return new ShifterButton(Direction.gauche, this);
    }

    public static class ShifterButton extends Button{

        public static enum Direction {droite, gauche}

        private Direction direction;

        private VolantPedaleController controller;

        public ShifterButton(Direction direction, VolantPedaleController controller){
            this.controller = controller;
            this.direction = direction;
        }

        @Override
        public boolean get() {
            switch(direction){
                case droite:
                    return controller.getRawShifterDroit();
                case gauche:
                    return controller.getRawShifterGauche();
                default:
                    return false;
            }
        }

    }
}
