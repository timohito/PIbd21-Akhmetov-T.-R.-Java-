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
    private final JButton createTransportButton = new JButton("Create Transport");
    private final JButton createDozerButton = new JButton("Create Dozer");
    private ITransport transport;
    private int numType = 1;

    /**
     * Launch the application.
     */
    App() {
        initialize();
    }

    private void initialize() {
        int width = 950;
        int height = 400;
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        CarPanel panel = new CarPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED,
                null, null, null, null));
        panel.setBounds(10, 11, width, height);
        frame.getContentPane().add(panel);
        setupButton(up, "up", 65, height + 30);
        setupButton(down, "down", 65, height + 90);
        setupButton(left, "left", 5, height + 90);
        setupButton(right, "right", 125, height + 90);
        createTransportButton.addActionListener(e -> {
            transport = new Car(100, 1000, Color.BLUE);
            transport.setPosition(10, 10, width, height);
            panel.setTransport(transport);
            panel.repaint();
        });
        createTransportButton.setBounds(200, height + 45, 100, 50);
        frame.getContentPane().add(createTransportButton);
        createDozerButton.addActionListener(e -> {
            transport = new Dozer(100, 1000, Color.BLUE, Color.green, 90, 50, true, true, 3, numType);
            transport.setPosition(10, 10, width, height);
            panel.setTransport(transport);
            panel.repaint();
        });
        createDozerButton.setBounds(500, height + 45, 100, 50);
        frame.getContentPane().add(createDozerButton);
        up.addActionListener(e -> {
            if (transport != null) {
                transport.moveTransport(Direction.Up);
                panel.repaint();
            }
        });
        down.addActionListener(e -> {
            if (transport != null) {
                transport.moveTransport(Direction.Down);
                panel.repaint();
            }
        });
        left.addActionListener(e -> {
            if (transport != null) {
                transport.moveTransport(Direction.Left);
                panel.repaint();
            }
        });
        right.addActionListener(e -> {
            if (transport != null) {
                transport.moveTransport(Direction.Right);
                panel.repaint();
            }
        });

        JButton threeRollers = new JButton("3");
        threeRollers.setBounds(310, height + 45, 50, 50);
        frame.getContentPane().add(threeRollers);
        threeRollers.addActionListener(e -> {
            if (transport != null && transport.getClass() == Dozer.class) {
                Dozer dozer = (Dozer) transport;
                dozer.setNumRollers(3);
            }
            panel.repaint();
        });

        JButton fourRollers = new JButton("4");
        fourRollers.setBounds(370, height + 45, 50, 50);
        frame.getContentPane().add(fourRollers);
        fourRollers.addActionListener(e -> {

            if (transport != null && transport.getClass() == Dozer.class) {
                Dozer dozer = (Dozer) transport;
                dozer.setNumRollers(4);
            }
            panel.repaint();
        });

        JButton fiveRollers = new JButton("5");
        fiveRollers.setBounds(430, height + 45, 50, 50);
        frame.getContentPane().add(fiveRollers);
        fiveRollers.addActionListener(e -> {
            if (transport != null && transport.getClass() == Dozer.class) {
                Dozer dozer = (Dozer) transport;
                dozer.setNumRollers(5);
            }
            panel.repaint();
        });

        JButton standardRollers = new JButton("Standard Rollers");
        standardRollers.setBounds(310, height + 100, 200, 50);
        frame.getContentPane().add(standardRollers);
        standardRollers.addActionListener(e -> {
            numType = 1;
        });

        JButton squareRollers = new JButton("Square Rollers");
        squareRollers.setBounds(310, height + 160, 200, 50);
        frame.getContentPane().add(squareRollers);
        squareRollers.addActionListener(e -> {
            numType = 2;
        });

        JButton TriangleRollers = new JButton("Triangle Rollers");
        TriangleRollers.setBounds(310, height + 220, 200, 50);
        frame.getContentPane().add(TriangleRollers);
        TriangleRollers.addActionListener(e -> {
            numType = 3;
        });

    }

    void setupButton(JButton button, String name, int x, int y) {
        try {
            Image img = ImageIO.read(new File("src/res/" + name + ".png"));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        button.setBounds(x, y, 50, 50);
        frame.getContentPane().add(button);
    }
}
