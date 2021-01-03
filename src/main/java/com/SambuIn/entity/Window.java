package com.SambuIn.entity;

import com.SambuIn.factory.ComponentFactory;
import com.SambuIn.manager.DriverManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {

    private final String TITLE = "Cero Remis";
    private final int WIDTH = 300;
    private final int HEIGHT = 300;
    private final int BORDER = 5;

    JPanel jPanel = null;
    JButton jButton = null;
    JComboBox<Integer> jComboBox = null;
    JLabel jHeaderID = null;
    JLabel jHeaderName = null;
    JLabel jName = null;

    DriverManager driverManager = new DriverManager();
    ArrayList<Driver> driverList = driverManager.createDriverList();
    Integer[] driversID = driverManager.createDriverIDList().toArray(new Integer[0]);

    public Window() {
        setTitle(TITLE);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        createComponent();
        add(jPanel);
        addComponent(jButton, jComboBox, jName, jHeaderID, jHeaderName);
        setListeners();
        setVisible(true);
    }

    private void setListeners() {
        jComboBox.addActionListener(e -> {
            int selected = (int) jComboBox.getSelectedItem();
            if(selected != -1){
                Driver driver = driverManager.searchDriver(selected, driverList);
                if(driver != null){
                    jName.setText(driver.getName() + " " + driver.getSurname());
                }else{
                    JOptionPane.showMessageDialog(null, "No se encuentra el conductor");
                }
            }
        });
    }

    private void createComponent() {
        ComponentFactory cf = new ComponentFactory();
        jPanel = cf.createPanel();
        jButton = cf.createButton("", "puto",10,10,10,10);

        jHeaderID = cf.createLabel("ID", 60,20,15,15);
        jHeaderName = cf.createLabel("Nombre", 120,20,50,15);

        jComboBox = cf.createComboBox("", driversID,40,40,50,30);
        jName = cf.createLabel("",100,40,100,30);
    }

    private void addComponent(JComponent... arg) {
        for (JComponent jComponent : arg) {
            jPanel.add(jComponent);
        }
    }
}
