package com.company;

import java.awt.*;

public interface IDrawingRollers {
    void setConfig(int config);
    void drawRollers(Graphics g, Color dopColor, int _startPosX, int _startPosY, boolean kovsh, boolean truba);
}
