package com.SambuIn.factory;

import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;

public class ComponentFactory {

    public ComponentFactory() {
    }

    public JPanel createPanel(){
        JPanel jPanel = new JPanel();
        jPanel.setBackground(null);
        jPanel.setLayout(null);
        jPanel.setBorder(null);
        return jPanel;
    }

    public JButton createButton(String actionCommand, String name, int x, int y, int width, int height) {
        JButton jButton = new JButton(name);
        jButton.setBounds(x, y, width, height);
        jButton.setActionCommand(actionCommand);
        return jButton;
    }

    public JComboBox<Integer> createComboBox(String actionCommand, Integer[] numbers, int x, int y, int width, int height){
        JComboBox<Integer> jComboBox = new JComboBox<>(numbers);
        jComboBox.setBounds(x,y,width,height);
        jComboBox.setActionCommand(actionCommand);
        return jComboBox;
    }

    public JLabel createLabel(String text, int x, int y, int width, int height){
        JLabel jLabel = new JLabel(text);
        jLabel.setBounds(x,y,width,height);
        jLabel.setOpaque(true);
        jLabel.setForeground(Color.WHITE);
        jLabel.setBackground(Color.BLACK);
        return jLabel;
    }
}
