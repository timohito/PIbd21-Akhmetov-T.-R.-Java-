package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.File;

public class App {
    public JFrame frame;
    private final JButton up = new JButton();
    private final JButton down = new JButton();
    private final JButton left = new JButton();
    private final JButton right = new JButton();
    private final JButton createButton = new JButton("Create");
    private Bulldozer bulldozer;

    /**
     * Launch the application.
     */
    App() {
        initialize();
    }

    private void initialize() {
        int width = 950;
        int height = 600;
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        DozerPanel panel = new DozerPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED,
                null, null, null, null));
        panel.setBounds(10, 11, width, height);
        frame.getContentPane().add(panel);
        setupButton(up, "strUp", 65, 630);
        setupButton(down, "strBottom", 65, 690);
        setupButton(left, "strLeft", 5, 690);
        setupButton(right, "strRight", 125, 690);
        createButton.addActionListener(e -> {
            bulldozer = new Bulldozer(100, 1000, Color.BLACK, Color.ORANGE, true, true);
            bulldozer.setPosition(10, 10, width, height);
            panel.setBulldozer(bulldozer);
            panel.repaint();
        });
        createButton.setBounds(200, 645, 100, 50);
        frame.getContentPane().add(createButton);
        up.addActionListener(e -> {
            if(bulldozer != null){
                bulldozer.moveTransport(Direction.Up);
                panel.repaint();
            }
        });
        down.addActionListener(e -> {
            if(bulldozer != null){
                bulldozer.moveTransport(Direction.Down);
                panel.repaint();
            }
        });
        left.addActionListener(e -> {
            if(bulldozer != null){
                bulldozer.moveTransport(Direction.Left);
                panel.repaint();
            }
        });
        right.addActionListener(e -> {
            if(bulldozer != null){
                bulldozer.moveTransport(Direction.Right);
                panel.repaint();
            }
        });

        JButton threeRollers = new JButton("5");
        threeRollers.setBounds(310, 645, 50, 50);
        frame.getContentPane().add(threeRollers);
        threeRollers.addActionListener(e -> {
            bulldozer.drawingRollers.setConfig(3);
            panel.repaint();
        });

        JButton fourRollers = new JButton("4");
        fourRollers.setBounds(370, 645, 50, 50);
        frame.getContentPane().add(fourRollers);
        fourRollers.addActionListener(e -> {
            bulldozer.drawingRollers.setConfig(4);
            panel.repaint();
        });

        JButton fiveRollers = new JButton("3");
        fiveRollers.setBounds(430, 645, 50, 50);
        frame.getContentPane().add(fiveRollers);
        fiveRollers.addActionListener(e -> {
            bulldozer.drawingRollers.setConfig(5);
            panel.repaint();
        });
    }

    void setupButton(JButton button, String name, int x, int y) {
        try {
            Image img = ImageIO.read(new File("src/res/" + name + ".png"));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        button.setBounds(x, y, 50, 50);
        frame.getContentPane().add(button);
    }
}
