package com.SambuIn.window;

import com.SambuIn.entity.Driver;
import com.SambuIn.manager.DriverManager;
import com.SambuIn.window.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowController implements ActionListener {

    private Window window;
    DriverManager driverManager;
    public WindowController(Window window) {
        this.window = window;
        this.window.addListeners(this);
        driverManager = new DriverManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "add":
                String text = window.jKM.getText();
                String name = window.jName.getText();
                if(name.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Seleccione chofer");
                    return;
                }
                if(!text.isEmpty()){
                    int n = Integer.parseInt(text);
                    System.out.println("Chofer: " + name + ", Precio: " + n*5);
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese KM");
                }
                break;
            case "select":
                int selected = (int) window.jComboBox.getSelectedItem();
                if(selected != -1){
                    Driver driver = driverManager.searchDriver(selected, driverManager.createDriverList());
                    if(driver != null){
                        window.jName.setText(driver.getName() + " " + driver.getSurname());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encuentra el chofer");
                    }
                }
                break;
        }
    }
}
