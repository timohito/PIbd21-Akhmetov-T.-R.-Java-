package com.company;

import javax.swing.*;
import java.awt.*;

public class ParkingPanel extends JPanel {
    private final Parking<ITransport, IDrawingRollers> parking;

    ParkingPanel(Parking<ITransport, IDrawingRollers> parking){
        this.parking = parking;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        parking.Draw(g);
    }
}
