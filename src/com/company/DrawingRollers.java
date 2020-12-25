package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class DrawingRollers {
    private Rollers numRollers = Rollers.Five;

    void setConfig(int config) {
        switch (config) {
            case 3:
                numRollers = Rollers.Three;
                break;
            case 4:
                numRollers = Rollers.Four;
                break;
            case 5:
                numRollers = Rollers.Five;
                break;
            default:
                numRollers = Rollers.Three;
        }
    }

    void drawRollers(Graphics2D g2, Color mainColor, int _startPosX, int _startPosY) {
        g2.setColor(mainColor);
        switch (numRollers) {
            case Three:
                g2.draw(new Ellipse2D.Double(_startPosX + 40, _startPosY + 25, 20, 20));

	        case Four:

	    		g2.draw(new Ellipse2D.Double(_startPosX + 60, _startPosY + 25, 20, 20));


            case Five:

            	g2.draw(new Ellipse2D.Double(_startPosX + 80, _startPosY + 25, 20, 20));


            break;
        }
    }

   

}
