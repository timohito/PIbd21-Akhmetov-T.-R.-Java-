package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Parking<T extends ITransport, SecondUselessParam extends IDrawingRollers> {
    private ArrayList<T> places;
    private int pictureWidth;
    private int pictureHeight;
    private int rows;
    private int _placeSizeWidth = 350;
    private int _placeSizeHeight = 80;

    public Parking(int picWidth, int picHeight) {
        int columns = picWidth / _placeSizeWidth;
        rows = picHeight / _placeSizeHeight;
        places = new ArrayList<>();
        for (int i = 0; i < columns * rows; i++) {
            places.add(null);
        }
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public boolean add(T car) { // +
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) == null) {
                car.setPosition(i / rows * _placeSizeWidth + 15, (i - i / rows * rows) * _placeSizeHeight + 32, pictureWidth, pictureHeight);
                places.set(i, car);
                return true;
            }
        }
        return false;
    }

    public T remove(int index) { // -
        if (index < 0 || index > places.size() - 1) {
            return null;
        }
        T car = places.get(index);
        places.set(index, null);
        return car;
    }

    public boolean equalOrMore(int numCar) { // >=
        return numCar >= countCurNumCar();
    }

    public boolean equalOrLess(int numCar) { // <=
        return numCar <= countCurNumCar();
    }

    public int countCurNumCar(){
        int curNumCar = 0;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null) {
                curNumCar++;
            }
        }
        return curNumCar;
    }

    public void Draw(Graphics g) {
        DrawMarking(g);
        for (T car : places) {
            if (car != null) {
                car.drawTransport(g);
            }
        }
    }

    private void DrawMarking(Graphics g) {
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3.0f));
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++) {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j) {
                g2.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g2.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }
}
