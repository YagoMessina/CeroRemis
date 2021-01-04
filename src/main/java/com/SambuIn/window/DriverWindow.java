package com.SambuIn.window;

import com.SambuIn.factory.ComponentFactory;

import javax.swing.*;
import java.awt.*;

public class DriverWindow extends JFrame {

    private final String TITLE = "Agregar Chofer";
    private final int WIDTH = 485;
    private final int HEIGHT = 300;
    private final int BORDER = 5;

    private JPanel jPanel = null;

    public DriverWindow() {
        setTitle(TITLE);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        createComponent();
        add(jPanel);
//
//        setJMenuBar(jMenuBar);
//        addMenu(jMenuFile, jMenuDriver);
//        addMenuItem();
//
//        addComponent(jButton, jComboBox, jName, jKM, jCommission, jPricePerKM, jHeaderID, jHeaderName,
//                jHeaderKM, jHeaderComission, jHeaderPricePerKM);

        setVisible(true);
    }

    private void createComponent() {
        ComponentFactory cf = new ComponentFactory();
        jPanel = cf.createPanel();
    }
}
