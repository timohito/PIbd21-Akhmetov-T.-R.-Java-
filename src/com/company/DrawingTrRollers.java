package com.company;

import java.awt.*;

public class DrawingTrRollers implements IDrawingRollers{
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
        g.setColor(dopColor);
        switch (numRollers) {
            case Five:
                g.drawPolygon(new int[] {_startPosX + 40, _startPosX + 50, _startPosX + 60}, new int[] {_startPosY + 45, _startPosY + 25, _startPosY + 45}, 3);

            case Four:
                g.drawPolygon(new int[] {_startPosX + 60, _startPosX + 70, _startPosX + 80}, new int[] {_startPosY + 45, _startPosY + 25, _startPosY + 45}, 3);

            case Three:
                g.drawPolygon(new int[] {_startPosX + 80, _startPosX + 90, _startPosX + 100}, new int[] {_startPosY + 45, _startPosY + 25, _startPosY + 45}, 3);

            default:
				g.drawPolygon(new int[] {_startPosX, _startPosX + 10, _startPosX + 20}, new int[] {_startPosY + 45, _startPosY + 25, _startPosY + 45}, 3);
                g.drawPolygon(new int[] {_startPosX + 20, _startPosX + 30, _startPosX + 40}, new int[] {_startPosY + 45, _startPosY + 25, _startPosY + 45}, 3);
                break;
        }
    }
}
