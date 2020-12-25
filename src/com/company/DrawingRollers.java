package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawingRollers implements IDrawingRollers{
    private Rollers numRollers = Rollers.Five;

    @Override
    public void setConfig(int config) {
        switch (config) {
            case 5:
                numRollers = Rollers.Five;
                break;
            case 4:
                numRollers = Rollers.Four;
                break;
            case 3:
                numRollers = Rollers.Three;
                break;
            default:
                numRollers = Rollers.Five;
        }
    }

    @Override
    public void drawRollers(Graphics g, Color dopColor, int _startPosX, int _startPosY, boolean kovsh, boolean truba) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(dopColor);
        switch (numRollers) {
            case Five:
                g2.draw(new Ellipse2D.Double(_startPosX + 40, _startPosY + 25, 20, 20));

            case Four:
                g2.draw(new Ellipse2D.Double(_startPosX + 60, _startPosY + 25, 20, 20));

            case Three:
                g2.draw(new Ellipse2D.Double(_startPosX + 80, _startPosY + 25, 20, 20));

            default:
                g2.draw(new Ellipse2D.Double(_startPosX, _startPosY + 25, 20, 20));
                g2.draw(new Ellipse2D.Double(_startPosX + 20, _startPosY + 25, 20, 20));
                break;
        }
    }
}
