/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public interface RobotMap {

    interface USB {
        int DRIVER_GAMEPAD = 0;
    }

    interface AXES {
        int AXE_GAUCHE = 1;
        int AXE_DROITE = 5;
    }

    interface CAN {
        int MOTEUR_AVANT_DROIT = 0;
        int MOTEUR_AVANT_GAUCHE = 0; 
    }

    interface PWN {
        int MOTEUR_ARRIERE_DROIT = 0;
        int MOTEUR_ARRIERE_GAUCHE = 1;
    }
   
    interface ANALOG {
        int PEDALE_AVANCER = 0;
        int PEDALE_RECULER = 1;
        int VOLANT = 2;        
    }

    interface DIO {
        int SHIFTER_GAUCHE_BOUTON = 0;
        int SHIFTER_DROIT_BOUTON = 1;
    }

    interface PCM {
        int SHIFTERS_FORWARD = 0;
        int SHIFTERS_REVERSE = 1;
    }
}
