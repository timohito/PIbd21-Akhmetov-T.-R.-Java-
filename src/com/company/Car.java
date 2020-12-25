package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Car extends Vehicle {
    protected int carWidth = 90;
    protected int carHeight = 50;

    public Car(int maxSpeed, float weight, Color mainColor)
    {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
    }

    protected Car(int maxSpeed, float weight, Color mainColor, int carWidth, int carHeight)
    {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
    }

    @Override
    public void moveTransport(Direction direction)
    {
        float step = maxSpeed * 100 / weight;
        switch (direction) {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth) {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0) {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0) {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight) {
                    _startPosY += step;
                }
                break;
        }
    }

    @Override
    public void drawTransport(Graphics g)
    {
        g.setColor(mainColor); // cusov
        g.drawRect(_startPosX, _startPosY, 100, 45);
        g.drawRect(_startPosX + 20, _startPosY - 30, 30, 30);

        Graphics2D g2 = (Graphics2D)g;
        g2.draw(new Ellipse2D.Double(_startPosX, _startPosY + 25, 100, 20));

    }
}
