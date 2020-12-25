package com.company;

import javax.swing.*;
import java.awt.*;

public class FormParking {
    public JFrame frame;
    private Parking<ITransport, IDrawingRollers> parking;
    private final JButton parkTransport = new JButton("Припарковать транспорт");
    private final JButton parkDozer = new JButton("Припарковать бульдозер");
    private final int numType = 0;

    /**
     * Launch the application.
     */
    FormParking() {
        initialize();
    }

    private void initialize() {
        int width = 700;
        int height = 400;
        parking = new Parking<>(width, height);
        frame = new JFrame();
        frame.setBounds(100, 100, 1200, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Стоянка");
        ParkingPanel panel = new ParkingPanel(parking);
        panel.setBounds(10, 11, width, height);
        frame.getContentPane().add(panel);
        parkTransport.addActionListener(e -> {
            Color mainColor = JColorChooser.showDialog(frame, "Выберите цвет транспорта", Color.BLUE);
            if (mainColor != null) {
                var car = new Car(100, 1000, mainColor);
                if (parking.add(car)) {
                    panel.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Стоянка переполнена", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            panel.repaint();
        });
        parkTransport.setBounds(width + 20, 20, 200, 50);
        frame.getContentPane().add(parkTransport);
        parkDozer.addActionListener(e -> {
            Color mainColor = JColorChooser.showDialog(frame, "Выберите цвет транспорта", Color.BLUE);
            if (mainColor != null) {
                Color dopColor = JColorChooser.showDialog(frame, "Выберите цвет дополнительный транспорта", Color.BLUE);
                if (dopColor != null) {
                    var dozer = new Dozer(100, 1000, mainColor, dopColor, 320, 60, true, true, 3, numType);
                    if (parking.add(dozer)) {
                        panel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Стоянка переполнена", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            panel.repaint();
        });
        parkDozer.setBounds(width + 20, 80, 200, 50);
        frame.getContentPane().add(parkDozer);
        JPanel groupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        groupPanel.setBorder(BorderFactory.createTitledBorder("Забрать машину"));
        groupPanel.setBounds(width + 20, 200, 200, 100);
        frame.getContentPane().add(groupPanel);
        JLabel placeLabel = new JLabel("Место:");
        groupPanel.add(placeLabel);
        JTextField placeTextField = new JTextField(2);
        placeTextField.setFont(placeTextField.getFont().deriveFont(20f));
        placeTextField.setBounds(20, 10, 100, 20);
        groupPanel.add(placeTextField);
        JButton takeCar = new JButton("Забрать");
        takeCar.addActionListener(e -> {
            if (!placeTextField.getText().equals("")) {
                int numPlace;
                try {
                    numPlace = Integer.parseInt(placeTextField.getText());
                } catch (Exception ex) {
                    return;
                }
                var car = parking.remove(numPlace);
                if (car != null) {
                    EventQueue.invokeLater(() -> {
                        FormCar window;
                        try {
                            window = new FormCar(frame);
                            window.frame.setVisible(true);
                            frame.setVisible(false);
                        } catch (Exception exc) {
                            exc.printStackTrace();
                            return;
                        }
                        window.setTransport(car);
                    });
                }
                panel.repaint();
            }
        });
        takeCar.setBounds(20, 30, 100, 50);
        groupPanel.add(takeCar);
    }
}
