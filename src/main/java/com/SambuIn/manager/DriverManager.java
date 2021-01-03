package com.SambuIn.manager;

import com.SambuIn.entity.Driver;

import java.util.ArrayList;

public class DriverManager {

    public DriverManager() {
    }

    public ArrayList<Driver> createDriverList(){
        DriverManager driverManager = new DriverManager();
        return driverManager.getDrivers();
    }

    public ArrayList<Driver> getDrivers(){
        ArrayList<Driver> driverList = new ArrayList<>();
        driverList.add(new Driver(28,"Yago", "Messina"));
        driverList.add(new Driver(42,"Pepe", "Messina"));
        driverList.add(new Driver(33,"Manuelito", "Messina"));
        return driverList;
    }

    public ArrayList<Integer> createDriverIDList(){
        ArrayList<Integer> driversID = new ArrayList<>();
        for(Driver driver : getDrivers()){
            driversID.add(driver.getId());
        }
        return driversID;
    }
    public Driver searchDriver(int id, ArrayList<Driver> driverList){
        for(Driver driver : driverList){
            if(driver.getId() == id){
                return driver;
            }
        }
        return null;
    }
}
