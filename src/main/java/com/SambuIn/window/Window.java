package com.SambuIn.window;

import com.SambuIn.entity.Driver;
import com.SambuIn.factory.ComponentFactory;
import com.SambuIn.manager.DriverManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {

    private final String TITLE = "Cero Remis";
    private final int WIDTH = 340;
    private final int HEIGHT = 300;
    private final int BORDER = 5;

    JPanel jPanel = null;
    JButton jButton = null;
    JComboBox<Integer> jComboBox = null;
    JTextField jKM = null;

    JLabel jHeaderKM = null;
    JLabel jHeaderID = null;
    JLabel jHeaderName = null;
    JLabel jName = null;

    DriverManager driverManager = new DriverManager();
    Integer[] driversID = driverManager.createDriverIDList().toArray(new Integer[0]);

    public Window() {
        setTitle(TITLE);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        createComponent();
        add(jPanel);
        addComponent(jButton, jComboBox, jName, jKM, jHeaderID, jHeaderName, jHeaderKM);
        setVisible(true);
    }

    public void addListeners(ActionListener actionListener) {
        jComboBox.addActionListener(actionListener);
        jButton.addActionListener(actionListener);
    }

    private void createComponent() {
        ComponentFactory cf = new ComponentFactory();
        jPanel = cf.createPanel();

        jHeaderID = cf.createLabel("ID", BORDER, BORDER,50,15);
        jHeaderName = cf.createLabel("Nombre", BORDER*2+50,BORDER,100,15);
        jHeaderKM =  cf.createLabel("KM", BORDER*3+150,BORDER,50,15);

        jComboBox = cf.createComboBox("select", driversID,BORDER,BORDER*5,50,30);
        jName = cf.createLabel("",BORDER*2+50,BORDER*5,100,30);
        jKM = cf.createTextField("", BORDER*3+150,BORDER*5,50,30);
        jButton = cf.createButton("add", "Agregar",BORDER*4+200,BORDER*5,100,30);
    }

    private void addComponent(JComponent... arg) {
        for (JComponent jComponent : arg) {
            jPanel.add(jComponent);
        }
    }
}
