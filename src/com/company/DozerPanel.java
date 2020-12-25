package com.company;

import javax.swing.*;
import java.awt.*;

public class DozerPanel extends JPanel {
    private Bulldozer bulldozer;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (bulldozer != null)
            bulldozer.drawTransport(g);
    }

    public void setBulldozer(Bulldozer bulldozer) {
        this.bulldozer = bulldozer;
    }
}
