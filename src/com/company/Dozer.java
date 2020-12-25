package com.company;

import java.awt.*;

public class Dozer extends Car {

    private Color dopColor;
    private boolean kovsh;
    private boolean truba;
    private IDrawingRollers drawingRollers;

    Dozer(int maxSpeed,
          float weight,
          Color mainColor,
          Color dopColor,
          int carWidth,
          int carHeight,
          boolean kovsh,
          boolean truba,
          int numRollers,
          int type) {
        super(maxSpeed, weight, mainColor, carWidth, carHeight);
        this.dopColor = dopColor;
        this.kovsh = kovsh;
        this.truba = truba;
        this.drawingRollers = setDrawingRollers(type);
        drawingRollers.setConfig(numRollers);
    }

    private IDrawingRollers setDrawingRollers(int numType) {
        switch (numType) {
            case 2:
                return new DrawingSqRollers();
            case 3:
                return new DrawingTrRollers();
            default:
                return new DrawingRollers();
        }
    }

    public void setNumRollers(int numRollers) {
        drawingRollers.setConfig(numRollers);
    }

    @Override
    public void drawTransport(Graphics g) {
        super.drawTransport(g);
        if (kovsh) {
            g.setColor(dopColor);
            g.drawLine( _startPosX + 100, _startPosY + 10, _startPosX + 120, _startPosY + 25);
            g.drawLine( _startPosX + 120, _startPosY + 25, _startPosX + 120, _startPosY + 45);
            g.drawLine(_startPosX + 120, _startPosY + 45, _startPosX + 150, _startPosY + 45);
            g.drawLine(_startPosX + 150, _startPosY + 45, _startPosX + 120, _startPosY + 25);
        }

        if (truba) {
            g.setColor(mainColor);
            g.fillRect(_startPosX + 80, _startPosY - 15, 5, 15);
        }

        drawingRollers.drawRollers(g, dopColor, _startPosX, _startPosY, kovsh, truba);
    }
}

