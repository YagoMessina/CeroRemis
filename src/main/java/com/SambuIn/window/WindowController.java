package com.SambuIn.window;

import com.SambuIn.entity.Driver;
import com.SambuIn.manager.DriverManager;
import com.SambuIn.window.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class WindowController implements ActionListener {

    private Window window;
    DriverManager driverManager;
    public WindowController(Window window) {
        this.window = window;
        this.window.addListeners(this);
        driverManager = new DriverManager();
    }

    private void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "add":
                String km = window.jKM.getText();
                String pricePerKm = window.jPricePerKM.getText();
                String commission = window.jCommission.getText();
                String name = window.jName.getText();
                if(name.isEmpty()){
                    showMessage("Seleccione chofer");
                    return;
                }
                if(km.isEmpty()){
                    showMessage("Ingrese KM");
                }else{
                    if(pricePerKm.isEmpty()){
                        showMessage("Ingrese Precio por KM");
                    }else{
                        if(commission.isEmpty()){
                            showMessage("Ingrese % de comision");
                        }else{
                            int nKm = Integer.parseInt(km);
                            int nPricePerKm = Integer.parseInt(pricePerKm);
                            int nCommission = Integer.parseInt(commission);
                            System.out.println("Chofer: " + name + ", Precio: " + nKm*nPricePerKm);
                            System.out.println("Comisión: " + ((nKm*nPricePerKm)*nCommission)/100);
                        }
                    }

                }
                break;
            case "select":
                int selected = (int) window.jComboBox.getSelectedItem();
                if(selected != -1){
                    Driver driver = driverManager.searchDriver(selected, driverManager.createDriverList());
                    if(driver != null){
                        window.jName.setText(" " + driver.getName() + " " + driver.getSurname());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encuentra el chofer");
                    }
                }
                break;
        }
    }
}
