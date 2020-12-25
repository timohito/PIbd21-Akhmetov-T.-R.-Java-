package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Bulldozer {
	private int _startPosX;
    private int _startPosY;
    private int _pictureWidth;
    private int _pictureHeight;
    private final int carWidth = 100;
    private final int carHeight = 60;

    private int maxSpeed;
    private float weight;
    private Color mainColor;
    private Color dopColor;
    private boolean kovsh;
    private boolean truba;
    DrawingRollers drawingRollers = new DrawingRollers();

    Bulldozer(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean kovsh, boolean truba) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.kovsh = kovsh;
        this.truba = truba;
    }

    void setPosition(int x, int y, int width, int height) {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    void moveTransport(Direction direction) {
        float step = maxSpeed * 100 / weight;
        switch (direction) {
            // ������
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth) {
                    _startPosX += step;
                }
                break;
            //�����
            case Left:
                if (_startPosX - step > 0) {
                    _startPosX -= step;
                }
                break;
            //�����
            case Up:
                if (_startPosY - step > 0) {
                    _startPosY -= step;
                }
                break;
            //����
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight) {
                    _startPosY += step;
                }
                break;
        }
    }

    void drawTransport(Graphics g) {
    	Graphics2D g2 = (Graphics2D)g;
    	
		g.drawRect(_startPosX, _startPosY, 100, 45);
		g.drawRect(_startPosX + 20, _startPosY - 30, 30, 30);
		g.setColor(Color.black);
		g.fillRect(_startPosX + 20, _startPosY - 30, 30, 30);
		g.setColor(Color.yellow);
		g.fillRect(_startPosX, _startPosY, 100, 25);
		
		g.setColor(mainColor);
		
		g2.draw(new Ellipse2D.Double(_startPosX, _startPosY + 25, 100, 20));
		g2.draw(new Ellipse2D.Double( _startPosX, _startPosY + 25, 20, 20));
		g2.draw(new Ellipse2D.Double(_startPosX + 20, _startPosY + 25, 20, 20));
        if (truba) {
        	g.setColor(mainColor);
            g.fillRect(_startPosX + 80, _startPosY - 15, 5, 15);    
        }
        
        if(kovsh) {
        	g.setColor(dopColor);
			g.drawLine( _startPosX + 100, _startPosY + 10, _startPosX + 120, _startPosY + 25);
			g.drawLine( _startPosX + 120, _startPosY + 25, _startPosX + 120, _startPosY + 45);
			g.drawLine(_startPosX + 120, _startPosY + 45, _startPosX + 150, _startPosY + 45);
			g.drawLine(_startPosX + 150, _startPosY + 45, _startPosX + 120, _startPosY + 25);
        }
        drawingRollers.drawRollers(g2, mainColor, _startPosX, _startPosY);
    }
}
