package com.personal.webscrapper.models;

import java.time.LocalDate;

public class CityFuelPrice {
    private String cityName;
    private String stateName;
    private double petrolRate;
    private double dieselRate;
    private LocalDate currDate;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setPetrolRate(double petrolRate) {
        this.petrolRate = petrolRate;
    }

    public void setDieselRate(double dieselRate) {
        this.dieselRate = dieselRate;
    }

    public void setCurrDate(LocalDate currDate) {
        this.currDate = currDate;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public double getPetrolRate() {
        return petrolRate;
    }

    public double getDieselRate() {
        return dieselRate;
    }

    public LocalDate getCurrDate() {
        return currDate;
    }

    @Override
    public String toString() {
        return cityName + "," + stateName + "," + petrolRate +
                "," + dieselRate + "," + currDate;
    }
}
