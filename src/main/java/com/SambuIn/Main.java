package com.SambuIn;

import com.SambuIn.window.MainWindow;
import com.SambuIn.window.WindowController;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        MainWindow window = new MainWindow();
        WindowController windowController = new WindowController(window);
    }
}
